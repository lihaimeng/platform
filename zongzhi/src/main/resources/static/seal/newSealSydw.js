(function () {

    userInit = localStorage.getItem('user');
    user = JSON.parse(userInit);
    var organizationId = user.organizationId;
    zongzhiUrl = JSON.parse(localStorage.getItem('zongzhi_url'))
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

    var initDominion = $('#dominion').val().trim();
    if (initDominion == '0') {
        initDominion = "";
    }
    var dwmc = $('#companyName').val().trim();//单位名称
    var gxdw = initDominion;//管辖单位编号
    var frxm = $('#businessName').val().trim();//法人姓名
    var frzjhm = $('#businessICard').val().trim();//法人证件号码
    var yyzzbh = $('#businessNum').val().trim();//营业执照编号
    var initRegisterTimeStart = $('#registerTimeStart').val().trim();
    var initRegisterTimeEnd = $('#registerTimeEnd').val().trim();

    $.ajax({
        url: '..//sub/seal/sydw/list',
        type: 'POST',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify({
            'dwmc': dwmc,
            'dwbh': "",
            'gxdw': gxdw,
            'frxm': frxm,
            'frzjhm': frzjhm,
            'yyzzbh': yyzzbh,
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
        $('#sealSydwTable').bootstrapTable('destroy');
        $('#sealSydwTable').bootstrapTable({
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
                    field: 'dwmc',
                    title: '单位名称'
                }, {
                    field: 'dwbh',
                    title: '单位编号'
                }, {
                    field: 'yyzzbh',
                    title: '营业执照编号'
                }, {
                    field: 'frxm',
                    title: '法人姓名'
                }, {
                    field: 'frzjhm',
                    title: '法人证件号码'
                }, {
                    field: 'dwdz',
                    title: '单位地址'
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
        var searchDominion = $('#dominion').val().trim();
        if (searchDominion == '0') {
            searchDominion = "";
        }
        var dwmc = $('#companyName').val().trim();//单位名称
        var gxdw = searchDominion;//管辖单位编号
        var frxm = $('#businessName').val().trim();//法人姓名
        var frzjhm = $('#businessICard').val().trim();//法人证件号码
        var yyzzbh = $('#businessNum').val().trim();//营业执照编号
        var initRegisterTimeStart = $('#registerTimeStart').val().trim();
        var initRegisterTimeEnd = $('#registerTimeEnd').val().trim();

        if (Date.parse(registerTimeEnd) < Date.parse(registerTimeStart)) {
            warnningMsg("结束时间必须大于开始时间！");
            return false;
        }

        $.ajax({
            url: '..//sub/seal/sydw/list',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({
                'dwmc': dwmc,
                'dwbh': "",
                'gxdw': gxdw,
                'frxm': frxm,
                'frzjhm': frzjhm,
                'yyzzbh': yyzzbh,
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
        })
    });

    /**
     * 详情验证选中数据
     */
    $("#btn_details").click(function () {
        var data = $("#sealSydwTable").bootstrapTable('getSelections')[0];
        if (typeof(data) != 'undefined') {
            $("#form1CompanyNo").html(data.dwbh);
            $("#form1CompanyName").html(data.dwbh);
            $("#form1CompanyType").html(data.dwlx);
            $("#form1BussinessNo").html(data.yyzzbh);
            $("#yyzpImage").click(function () {
                var name = "yy" + data.id;
                var http = zongzhiUrl + "/sub/seal/sydw/images?name=" + name;
                $("#showImage").attr("src", http);
            })
            var showGxdwName = data.gxdw;
            for (var i = 0; i < organizationList.length; i++) {
                if (organizationList[i].brevitycode == showGxdwName) {
                     $("#form1DominionMsg").html(organizationList[i].name);
                }
            }
            $("#form1ConmanyPhone").html(data.dwdh);
            $("#form1RegisterTime").html(date('Y-m-d H:i:s', data.djsj / 1000));
            //        $("#form1Application").html(data.companyAddress);
            $("#form1companyAddr").html(data.dwdz);
            $("#form1companyAddr").attr("title", data.dwdz);
            $("#form2UserName").html(data.frxm);
            $("#form2IdType").html(data.frzjlx);
            $("#form2IDCard").html(data.frzjhm);
            $("#form2IDCard").attr("title", data.frzjhm);
            $("#frImage").click(function () {
                var name = "fr" + data.id;
                var http = zongzhiUrl + "/sub/seal/sydw/images?name=" + name;
                $("#showImage").attr("src", http);
            })
            $("#form2BussinessHomeAddr").html(data.frhjdz);
        } else {
            warnningMsg("请选择一条数据！");
            return false;
        }
    });

    /**
     * 导入数据
     */
    $("#btn_download").click(function () {
        $("#sealSydwTable tr").find('td:eq("1"),th:eq("1")').hide();
        var allTableData = $("#sealSydwTable").bootstrapTable('getData');
        if (typeof(allTableData) != 'undefined' && allTableData.length > 0) {
            $('#sealSydwTable').tableExport({type: 'excel', escape: 'false'})
        } else {
            warnningMsg("表格没有可用数据！");
            return false;
        }
        $("#sealSydwTable tr").find('td:eq("1"),th:eq("1")').show();
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

/*
$(".list").delegate("td","mouseover",function(){
    $("table").css("table-layout","automatic");
    $(this).css({"white-space":"pre-wrap","overflow":"visible"});
});

$(".list").delegate("td","mouseout",function(){
    $("table").css("table-layout","fixed");
    $(this).css({"text-overflow":"ellipsis","white-space":"nowrap","overflow":"hidden"});
});*/
