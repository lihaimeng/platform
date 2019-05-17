(function () {

    userInit = localStorage.getItem('user');
    user = JSON.parse(userInit);
    var organizationId = user.organizationId;
    zongzhiUrl = JSON.parse(localStorage.getItem('zongzhi_url'));
    var typeArray = [];//定义一个类型数组
    function initTypeArray(name) {
        this.name = name;
    }

    typeArray.push(new initTypeArray("印章类型"));
    typeArray.push(new initTypeArray("印章材料"));
    typeArray.push(new initTypeArray("印章规格"));
    typeArray.push(new initTypeArray("印章中心图案"));
    typeArray.push(new initTypeArray("印章形状"));

    for (var i = 0; i < typeArray.length; i++) {
        var initSelectOption = localStorage.getItem(typeArray[i].name);
        initSelectOption = JSON.parse(initSelectOption);
        if (initSelectOption != null || initSelectOption != "") {
            initSelectOption.forEach(function (item, index) {
                if (typeArray[i].name == "印章类型") {
                    $('#sealType').append("<option value=" + item.name + ">" + item.name + "</option>");
                }
                if (typeArray[i].name == "印章材料") {
                    $('#sealData').append("<option value=" + item.name + ">" + item.name + "</option>");
                }
                if (typeArray[i].name == "印章规格") {
                    $('#sealSpec').append("<option value=" + item.name + ">" + item.name + "</option>");

                }
                if (typeArray[i].name == "印章中心图案") {
                    $('#sealCenterPicture').append("<option value=" + item.name + ">" + item.name + "</option>");
                }
                if (typeArray[i].name == "印章形状") {
                    $('#sealShape').append("<option value=" + item.name + ">" + item.name + "</option>");
                }

            })

        }
    }

    var sydwmc = $('#useCompanyName').val().trim();//使用单位名称
    var yzbm = $('#sealNum').val().trim();//印章编码
    var yzlx = $('#sealType').val().trim();//印章类型
    var yzxz = $('#sealShape').val().trim();//印章形状
    var yzgg = $('#sealSpec').val().trim();//印章规格
    var yzcl = $('#sealData').val().trim();//印章材料
    var zxta = $('#sealCenterPicture').val().trim();//中心图案
    var initRegisterTimeStart = $('#registerTimeStart').val().trim();
    var initRegisterTimeEnd = $('#registerTimeEnd').val().trim();

    $.ajax({
        url: '..//sub/seal/sealxx/detialsList',
        type: 'POST',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify({
            'sydwmc': sydwmc,
            'yzbm': yzbm,
            'yzlx': yzlx,
            'yzxz': yzxz,
            'yzgg': yzgg,
            'yzcl': yzcl,
            'zxta': zxta,
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
        $('#sealxxTable').bootstrapTable('destroy');
        $('#sealxxTable').bootstrapTable({
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
                    field: 'yzbm',
                    title: '印章编码'
                }, {
                    field: 'yzlx',
                    title: '印章类型'
                }, {
                    field: 'yzxz',
                    title: '印章形状'
                }, {
                    field: 'yzcl',
                    title: '印章材料'
                }, {
                    field: 'yzgg',
                    title: '印章规格'
                }, {
                    field: 'zxta',
                    title: '中心图案'
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

        var sydwmc = $('#useCompanyName').val().trim();//使用单位名称
        var yzbm = $('#sealNum').val().trim();//印章编码
        var yzlx = $('#sealType').val().trim();//印章类型
        var yzxz = $('#sealShape').val().trim();//印章形状
        var yzgg = $('#sealSpec').val().trim();//印章规格
        var yzcl = $('#sealData').val().trim();//印章材料
        var zxta = $('#sealCenterPicture').val().trim();//中心图案
        var registerTimeStart = $('#registerTimeStart').val().trim();
        var registerTimeEnd = $('#registerTimeEnd').val().trim();

        if (Date.parse(registerTimeEnd) < Date.parse(registerTimeStart)) {
            warnningMsg("结束时间必须大于开始时间！");
            return false;
        }

        $.ajax({
            url: '..//sub/seal/sealxx/detialsList',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({
                'sydwmc': sydwmc,
                'yzbm': yzbm,
                'yzlx': yzlx,
                'yzxz': yzxz,
                'yzgg': yzgg,
                'yzcl': yzcl,
                'zxta': zxta,
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
     * 详情验证选中数据
     */
    $("#btn_details").click(function () {
        var data = $("#sealxxTable").bootstrapTable('getSelections')[0];
        if (typeof(data) != 'undefined') {
            $("#form1SealNo").html(data.yzbm);
            $("#form1Details").html(data.yznr);
            $("#form1Details").attr("title", data.yznr);
            $("#form1CompanyName").html(data.sydwmc);
            $("#form1CompanyNo").html(data.sydwbh);
            //     $("#form1CompanyName").html(data.dominion);
            $("#form1SealType").html(data.yzlx);
            $("#form1SealShape").html(data.yzxz);
            $("#form1SealSpec").html(data.yzgg);
            $("#form1CenterPicture").html(data.zxta);
            $("#form1SealData").html(data.yzcl);
            $("#form1Price").html(data.jg);

            $("#ldImage").click(function () {
                var http = zongzhiUrl + "/sub/seal/sealxx/images?id=" + data.id;
                $("#showImage").attr("src", http);
            });

            $("#form1FlowerTime").html(date('Y-m-d H:i:s', data.djsj / 1000));
            $("#form2CompanyName").html(data.badwmc);
            $("#form2CompanyNo").html(data.badwbh);
            $("#form2UserName").html(data.bar);
            $("#form2Time").html(date('Y-m-d H:i:s', data.basj / 1000));
            $("#form3CompanyName").html(data.zzdwmc);
            $("#form3CompanyNo").html(data.zzdwbm);
            $("#form3UserName").html(data.zzr);
        } else {
            warnningMsg("请选择一条数据！");
            return false;
        }
    });
    /**
     * 导入数据
     */
    $("#btn_download").click(function () {
        $("#sealxxTable tr").find('td:eq("1"),th:eq("1")').hide();
        var allTableData = $("#sealxxTable").bootstrapTable('getData');
        if (typeof(allTableData) != 'undefined' && allTableData.length > 0) {
            $('#sealxxTable').tableExport({type: 'excel', escape: 'false'})
        } else {
            warnningMsg("表格没有可用数据！");
            return false;
        }
        $("#sealxxTable tr").find('td:eq("1"),th:eq("1")').show();
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