
(function () {

    userInit = localStorage.getItem('user');
    user = JSON.parse(userInit);
    var organizationId = user.organizationId;
    zongzhiUrl = JSON.parse(localStorage.getItem('zongzhi_url'));
    /**
     * 获取管辖单位
     */
    var josnOrganization = localStorage.getItem("organization");
    var organizationList = JSON.parse(josnOrganization);
    for (var i = 0; i < organizationList.length; i++) {
        if (organizationList[i].code != "") {
            $('#dominion').append("<option value=" + organizationList[i].brevitycode + ">" + organizationList[i].name + "</option>");
        }
    }

    $('#dominion').trigger('chosen:updated');
    //管辖单位下拉列表选中事件
    $('#dominion').change(function () {
        var dominionValue = $("#dominion").val();
        $("#dominion option[value=dominionValue]").attr("selected", true);
    });

    var initCompanyNum = $('#companyNum').val().trim();
    var initCompanyName = $('#companyName').val().trim();//使用单位名称
    var initDominion = $('#dominion').val().trim();
    if (initDominion == '0') {
        initDominion = "";
    }

    var initMarkCompanyName = $('#markCompanyName').val().trim();//制作单位名称
    var initMarkUerName = $('#markUerName').val().trim();//经办人姓名
    var initRegisterTimeStart = $('#registerTimeStart').val().trim();
    var initRegisterTimeEnd = $('#registerTimeEnd').val().trim();

    $.ajax({
        url: '..//sub/seal/order/list',
        type: 'POST',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify({
            'sydwmc': initCompanyName,
            'sydwbh': initCompanyNum,
            'gxdw': initDominion,
            'zzdwmc': initMarkCompanyName,
            'jbrxm': initMarkUerName,
            'registerTimeStart': initRegisterTimeStart,
            'registerTimeEnd': initRegisterTimeEnd,
            'organizationId': organizationId
        }),
        success: function (data) {
            getDataList(data);
        },
        error: function (data) {
            dangerMsg(data);
        }
    });

    function getDataList(data) {
        $('#sealOrderTable').bootstrapTable('destroy');
        $('#sealOrderTable').bootstrapTable({
            pageNumber: 1, //初始化加载第一页，默认第一页
            pagination: true,//是否分页
            data: data,
            pageSize: 15,//单页记录数
            pageList: [15, 30],//分页步进值
            clickToSelect: true,
            singleSelect: true,
            columns: [
                {
                    field: 'number',
                    title: '序号',
                    align: 'center',
                    width: 20,
                    formatter: function (value, row, index) {
                        return index + 1;
                    }
                }, {
                    field: 'checkState',
                    checkbox: true
                }, {
                    field: 'sydwmc',
                    title: '使用单位名称'
                }, {
                    field: 'sydwbh',
                    title: '使用单位编号'
                }, {
                    field: 'jbrxm',
                    title: '经办人姓名'
                }, {
                    field: 'zzdwmc',
                    title: '制作单位名称'
                }, {
                    field: 'gxdw',
                    title: '管辖单位',
                    formatter: function (value, row, index) {
                        for (var i = 0; i < organizationList.length; i++) {
                            if (organizationList[i].brevitycode == value) {
                                return organizationList[i].name;
                            }
                        }
                    }
                }, {
                    field: 'djsj',
                    title: '登记时间',
                    formatter: function (value, row, index) {
                        if (value != "") {
                            var time = value / 1000;
                            return date('Y-m-d H:i:s', time);
                        }
                    }
                }
            ]
        });
    }


    $('#search_btn').click(function () {
        var companyNum = $('#companyNum').val().trim();
        var companyName = $('#companyName').val().trim();//使用单位名称
        var dominion = $('#dominion').val().trim();
        if (dominion == '0') {
            dominion = "";
        }

        var markCompanyName = $('#markCompanyName').val().trim();//制作单位名称
        var markUerName = $('#markUerName').val().trim();//经办人姓名
        var registerTimeStart = $('#registerTimeStart').val().trim();
        var registerTimeEnd = $('#registerTimeEnd').val().trim();

        if (Date.parse(registerTimeEnd) < Date.parse(registerTimeStart)) {
            warnningMsg("结束时间必须大于开始时间！");
            return false;
        }
        $.ajax({
            url: '..//sub/seal/order/list',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({
                'sydwmc': companyName,
                'sydwbh': companyNum,
                'gxdw': dominion,
                'zzdwmc': markCompanyName,
                'jbrxm': markUerName,
                'registerTimeStart': registerTimeStart,
                'registerTimeEnd': registerTimeEnd,
                'organizationId': organizationId
            }),
            success: function (data) {
                getDataList(data);
            },
            error: function (data) {
                dangerMsg(data);
            }
        })
    });


    /**
     * 详情表格显示数据
     */
    function getSealDetailsDataList(data) {
        $('#sealDetailsTable').bootstrapTable('destroy');
        $('#sealDetailsTable').bootstrapTable({
            pageNumber: 1, //初始化加载第一页，默认第一页
            pagination: true,//是否分页
            data: data,
            pageSize: 15,//单页记录数
            pageList: [15, 30],//分页步进值
            clickToSelect: true,
            singleSelect: true,
            columns: [
                {
                    field: 'yzbm',
                    title: '印章编码',
                    formatter: function (value, row, index) {
                        if (value != "") {
                            var div = "<div style='width:50px;' title='" + value + " '>" + value + "</div>";
                            return div;
                        }
                    }
                }, {
                    field: 'yznr',
                    title: '印章内容',
                    formatter: function (value, row, index) {
                        if (value != "") {
                            var div = "<div style='width:100px;' title='" + value + " '>" + value + "</div>";
                            return div;
                        }
                    }
                }, {
                    field: 'yzlx',
                    title: '印章类型',
                    formatter: function (value, row, index) {
                        if (value != "") {
                            var div = "<div style='width:50px;' title='" + value + " '>" + value + "</div>";
                            return div;
                        }
                    }
                }, {
                    field: 'yzxz',
                    title: '印章形状',
                    formatter: function (value, row, index) {
                        if (value != "") {
                            var div = "<div style='width:50px;' title='" + value + " '>" + value + "</div>";
                            return div;
                        }
                    }
                }, {
                    field: 'yzgg',
                    title: '印章规格',
                    formatter: function (value, row, index) {
                        if (value != "") {
                            var div = "<div style='width:50px;' title='" + value + " '>" + value + "</div>";
                            return div;
                        }
                    }
                }, {
                    field: 'yzcl',
                    title: '印章材料',
                    formatter: function (value, row, index) {
                        if (value != "") {
                            var div = "<div style='width:50px;' title='" + value + " '>" + value + "</div>";
                            return div;
                        }
                    }
                }, {
                    field: 'zxta',
                    title: '中心图案',
                    formatter: function (value, row, index) {
                        if (value != "") {
                            var div = "<div style='width:50px;' title='" + value + " '>" + value + "</div>";
                            return div;
                        }
                    }
                }, {
                    field: 'ymldzp',
                    title: '印模留档照片',
                    formatter: function (value, row, index) {
                        if (value != "") {
                            var name = "<div data-toggle='modal'  data-target='#myModal'>" + "<a id='listImage'>" + "<p style='width:50px;overflow: hidden;text-overflow:ellipsis;white-space: nowrap;'" +
                                "title='" + '图片预览' + " '>" + '图片预览' + "</p>" + "</a>" + "</div>";
                            return name;
                        }
                    },
                    events: {
                        'click #listImage': function (e, value, row, index) {
                            var http = zongzhiUrl + "/sub/seal/sealxx/images?id=" + row.id;
                            $("#showImage").attr("src", http);
                        }
                    },
                }, {
                    field: 'djsj',
                    title: '登记时间',
                    formatter: function (value, row, index) {
                        if (value != "") {
                            var time = value / 1000;
                            var div = "<div style='width:100px;' title='" + date('Y-m-d H:i:s', time) + " '>" + date('Y-m-d H:i:s', time) + "</div>";
                            return div;
                        }
                    }
                }
            ]
        });
    }

    /**
     * 详情验证选中数据
     */

    $("#btn_details").click(function () {
        var data = $("#sealOrderTable").bootstrapTable('getSelections')[0];
        if (typeof(data) != 'undefined') {
            $("#form1CompanyNo").html(data.sydwbh);
            $("#form1CompanyName").html(data.sydwmc);
            $("#form1CompanyType").html(data.sydwlx);
            $("#form1CompanyPhone").html(data.sydwdh);
            $("#Form1CompanyAddr").html(data.sydwdz);
            $("#Form1CompanyAddr").attr("title", data.sydwdz);
            $("#form2UserName").html(data.jbrxm);
            $("#form2CardType").html(data.jbrzjlx);

            $("#form2CardNo").html(data.jbrzjh);
            $("#form2CardNo").attr("title", data.jbrzjh);

            $("#form2TransactorImage").html(data.jbrzp);
            $("#form2TransactorImage").attr("title", data.jbrzp);

            $("#form2Phone").html(data.jbrlxdh);
            $("#Form3CompanyNo").html(data.zzdwbm);
            $("#Form3CompanyName").html(data.zzdwmc);

            var showGxdwName = data.gxdw;
            for (var i = 0; i < organizationList.length; i++) {
                if (organizationList[i].brevitycode == showGxdwName) {
                    $("#Form3Dominion").attr("title", organizationList[i].name);
                    $("#Form3Dominion").html(organizationList[i].name);
                }
            }

            $("#Form3Phone").html(data.zzdwdh);
            $("#Form3CompanyAddr").html(data.zzdwdz);
            $("#Form3CompanyAddr").attr("title", data.zzdwdz);

            // var http=zongzhiUrl+"/sub/seal/order/images?id="+data.id;
            // $(".jbrzpImage").data('href',http);
            $("#jbrzpImage").click(function () {
                var http = zongzhiUrl + "/sub/seal/order/images?id=" + data.id;
                $("#showImage").attr("src", http);
            });
            $.ajax({
                url: '../sub/seal/order/sealxxList?ddh=' + data.ddh,
                type: 'POST',
                contentType: 'application/json;charset=UTF-8',
                success: function (data) {
                    getSealDetailsDataList(data);
                },
                error: function (data) {
                    dangerMsg(data);
                }
            })
        } else {
            warnningMsg("请选择一条数据！");
            return false;
        }
    });

    /**
     * 导入数据
     */
    $("#btn_download").click(function () {
        $("#sealOrderTable tr").find('td:eq("1"),th:eq("1")').hide();
        var allTableData = $("#sealOrderTable").bootstrapTable('getData');
        if (typeof(allTableData) != 'undefined' && allTableData.length > 0) {
            $('#sealOrderTable').tableExport({type: 'excel', escape: 'false'})
        } else {
            warnningMsg("表格没有可用数据！");
            return false;
        }
        $("#sealOrderTable tr").find('td:eq("1"),th:eq("1")').show();
    });

})();


/**
 * 成功提示信息
 * @param data 信息
 * @returns
 */
function successMsg(data) {
    $.smkAlert({
        text: data,
        type: 'success',
        position: 'top-center',
        time: 2
    });
}

/**
 * 警告提示信息
 * @param data 信息
 * @returns
 */
function warnningMsg(data) {
    $.smkAlert({
        text: data,
        type: 'warning',
        position: 'top-center',
        time: 2
    });
}

/**
 * 错误提示信息
 * @param data 信息
 * @returns
 */
function dangerMsg(data) {
    $.smkAlert({
        text: data,
        type: 'danger',
        position: 'top-center',
        time: 2
    });
}

/**
 * 正常提示信息
 * @param data 信息
 * @returns
 */
function infoMsg(data) {
    $.smkAlert({
        text: data,
        type: 'info',
        position: 'top-center',
        time: 2
    });
}