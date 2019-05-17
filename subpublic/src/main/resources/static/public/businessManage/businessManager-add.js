//为新增弹出框头部添加样式
$('#btn_tabMsg1').css("background", "#1ab394");
$("#tab2").css("display", 'none');
$("#tab3").css("display", 'none');
//管辖单位下拉列表选中事件
$('#dominionAdd').change(function () {
    var dominionValue = $("#dominionAdd").val();
    $("#dominionAdd option[value=dominionValue]").attr("selected", true);
});
$(document).ready(function () {
    //获取管辖单位下拉列表
    $.ajax({
        url: "../../qyjbxx/getDominion",
        type: 'GET',
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                $('#dominionAdd').append("<option value=" + data[i].code + ">" + data[i].name + "</option>");
            }
            $('#dominionAdd').trigger('chosen:updated');
        },
        error: function (data) {
            dangerMsg(data);
        }
    });
    //获取行业类型下拉列表
     $.ajax({
         url: "../../dictionary/getBussinessType",
         type: 'POST',
         success: function (data) {
             for (var i = 0; i < data.length; i++) {
                 $('#companyTypeAdd').append("<option value=" + data[i].dicCode + ">" + data[i].dicName + "</option>");
             }
         },
         error: function (data) {
             dangerMsg(data);
         }
     });

    $('#companyTypeAdd').change(function () {
        var companyTypeValue = $("#companyTypeAdd").val();
        $("#companyTypeAdd option[value=companyTypeValue]").attr("selected", true);
    });
    //点击新增按钮时，重置新增模态框Form
    $('.addRole').off("click").on("click", function () {
        $("#companyFormForAdd")[0].reset();
        $("#roleFormForAdd")[0].reset();
    });
    //点击修改按钮时，重置修改模态框Form
    $('#editButton').off("click").on("click", function () {
        $("#companyFormForEdit")[0].reset();
        $("#roleFormForEdit")[0].reset();
    });

    //添加企业基本信息
    $('#addCompanySubmit').off("click").on("click", function () {
        if ($('#companyFormForAdd').valid()) {
            var companyName = $('#companyNameAdd').val().trim();
            var dominionNum = $('#dominionAdd').val().trim();
            var dominion = $('#dominionAdd').find("option:selected").text();
            if (dominionNum == null || dominionNum == "") {
                dangerMsg("请选择管辖单位！");
                return false;
            }
            if (dominion == "组织结构") {
                dangerMsg("不能选择组织结构！");
                return false;
            }
            //var companyType = $('#companyTypeAdd').find("option:selected").text();
            // var companyTypeNum = $('#companyTypeAdd').val().trim();
            /* if (companyTypeNum == null || companyTypeNum == "") {
                 dangerMsg("请选择行业类型！");
             }*/
            var lawPersonName = $('#lawPersonNameAdd').val().trim();
            var lawPersonID = $('#lawPersonIDAdd').val().trim();
            var businessNumber = $('#businessNumberAdd').val().trim();
            var phone = $('#phoneAdd').val().trim();
            var companyAddress = $('#companyAddressAdd').val().trim();
            var businessScope = $('#businessScopeAdd').val().trim();
            $.ajax({
                url: '../../qyjbxx/insertQyjbxx',
                type: 'POST',
                contentType: 'application/json;charset=UTF-8',
                data: JSON.stringify({
                    'qymc': companyName,
                    'gxdwbm': dominionNum,
                    'gxdwmc': dominion,
                    // 'hylbdm': companyTypeNum,
                    // 'hylb': companyType,
                    'hylbdm': '01803',
                    'hylb': '典当行业',
                    'frdb': lawPersonName,
                    'frdbzjhm': lawPersonID,
                    'yyzzbh': businessNumber,
                    'lxdh': phone,
                    'jydz': companyAddress,
                    'jyfwzy': businessScope,
                    'zt': '0'
                }),
                success: function (data) {
                    if (data.result == 0) {
                        successMsg("企业信息添加成功");
                        var id = data.qyid;
                        $('#qyid').val(id);
                        changeMsg2();
                        addAbxx(id);
                    } else if (data.result == 3) {
                        dangerMsg("该企业信息已存在！");
                    } else {
                        dangerMsg("企业信息添加失败！");
                    }
                },
                error: function (data) {
                    dangerMsg(data);
                }
            })

        }
    });
    //判断是否有企业信息
    $('#addSecurity').off("click").on("click", function () {
        var companyName = $('#companyNameAdd').val().trim();
        var lawPersonName = $('#lawPersonNameAdd').val().trim();
        if (companyName == null || companyName == '' || lawPersonName == null || lawPersonName == '') {
            warnningMsg("企业信息未添加，不能进行该操作！");
            $('#btn_tabMsg1').click();
            return false;
        } else {
            $("#addSecurityForm")[0].reset();
        }
    });
    $('#addMonitoring').off("click").on("click", function () {
        var companyName = $('#companyNameAdd').val().trim();
        var lawPersonName = $('#lawPersonNameAdd').val().trim();
        if (companyName == null || companyName == '' || lawPersonName == null || lawPersonName == '') {
            warnningMsg("企业信息未添加，不能进行该操作！");
            $('#btn_tabMsg1').click();
            return false;
        } else {
            $("#addmonitoringForm")[0].reset();
        }
    });
    $('#addTechnical').off("click").on("click", function () {
        var companyName = $('#companyNameAdd').val().trim();
        var lawPersonName = $('#lawPersonNameAdd').val().trim();
        if (companyName == null || companyName == '' || lawPersonName == null || lawPersonName == '') {
            warnningMsg("企业信息未添加，不能进行该操作！");
            $('#btn_tabMsg1').click();
            return false;
        } else {
            $("#addTechnicalForm")[0].reset();
        }
    });
    $('#closeMsg').off("click").on("click", function () {
        /*        var qyid = $('#qyid').val().trim();
                if (qyid == null || qyid == '') {
                    return true;
                } else {
                    var businessLicense = $('#businessLicense').val();
                    var lawPersonId = $('#lawPersonId').val();
                    if (businessLicense == null || businessLicense == '' || lawPersonId == null || lawPersonId == '') {
                        warnningMsg("资料信息未添加！");
                        $('#btn_tabMsg3').click();
                        return false;
                    }
                }*/
        return true;
    });
});

//添加安保信息
function addAbxx(id) {
    //安保人员添加
    $('#addSecuritySubmit').off("click").on("click", function () {
        if ($('#addSecurityForm').valid()) {
            var securityPersonName = $('#securityPersonName').val().trim();
            var securityPersonId = $('#securityPersonId').val().trim();
            var securityJG = $('#securityJG').val().trim();
            var securityPersonPhone = $('#securityPersonPhone').val().trim();
            var securityTCB = $('#securityTCB').val().trim();
            var securityPersonTypeNum = $('#securityPersonType').val().trim();
            var securityPersonType = $("#securityPersonType").find("option:selected").text();
            var securityPersonDate = $('#securityPersonDate').val().trim();
            var securityPersonAddress = $('#securityPersonAddress').val().trim();
            $.ajax({
                url: '../../baryxx/insertBaryxx',
                type: 'POST',
                contentType: 'application/json;charset=UTF-8',
                data: JSON.stringify({
                    'qyid': id,
                    'xm': securityPersonName,
                    'gmsfhm': securityPersonId,
                    'jg': securityJG,
                    'fzjg': securityTCB,
                    'balxbm': securityPersonTypeNum,
                    'balx': securityPersonType,
                    'sgrq': securityPersonDate,
                    'hjdxz': securityPersonAddress,
                    'lxfs': securityPersonPhone,
                    'zt': '0'
                }),
                success: function (data) {
                    successMsg("添加成功");
                    $('#closeSecurity').click();
                    selectBaryxx(id);
                },
                error: function (data) {
                    dangerMsg(data);
                }
            });
        }
    });
    //监控设备添加
    $('#addMonitoringSubmit').off("click").on("click", function () {
        if ($('#addmonitoringForm').valid()) {
            var monitoringName = $('#monitoringName').val().trim();
            var monitoringManufacturer = $('#monitoringManufacturer').val().trim();
            var monitoringModel = $('#monitoringModel').val().trim();
            var monitoringDetectionName = $('#monitoringDetectionName').val().trim();
            var monitoringNetworkType = $('#monitoringNetworkType').val().trim();
            var monitoringNumber = $('#monitoringNumber').val().trim();
            var isVideo = $('#isVideo').val().trim();
            var IPAddress = $('#IPAddress').val().trim();
            $.ajax({
                url: '../../bldsjksb/insertBldsjksb',
                type: 'POST',
                contentType: 'application/json;charset=UTF-8',
                data: JSON.stringify({
                    'qyid': id,
                    'wlcslxmc': monitoringNetworkType,
                    'sbmc': monitoringName,
                    'sccsmc': monitoringManufacturer,
                    'ggxh': monitoringModel,
                    'sbjcjgmc': monitoringDetectionName,
                    'azsl': monitoringNumber,
                    'sflx': isVideo,
                    'ipdz': IPAddress,
                    'zt': '0'
                }),
                success: function (data) {
                    successMsg("添加成功");
                    $('#closeMonitoring').click();
                    selectJksbxx(id);
                },
                error: function (data) {
                    dangerMsg(data);
                }
            });
        }
    });
    //技防设备添加
    $('#addTechnicalSubmit').off("click").on("click", function () {
        if ($('#addTechnicalForm').valid()) {
            var technicalName = $('#technicalName').val().trim();
            var technicalModel = $('#technicalModel').val().trim();
            var technicalType = $('#technicalType').val().trim();
            var technicalNumber = $('#technicalNumber').val().trim();
            $.ajax({
                url: '../../jfsbxx/insertJfsbxx',
                type: 'POST',
                contentType: 'application/json;charset=UTF-8',
                data: JSON.stringify({
                    'qyid': id,
                    'sbmc': technicalName,
                    'ggxh': technicalModel,
                    'zl': technicalType,
                    'sl': technicalNumber,
                    'zt': '0'
                }),
                success: function (data) {
                    successMsg("添加成功");
                    $('#closeTechnical').click();
                    selectJfsbxx(id);
                },
                error: function (data) {
                    dangerMsg(data);
                }
            });
        }
    });
}

//查询保安信息
function selectBaryxx(qyid) {
    $.ajax({
        url: '../../baryxx/selectByQyid',
        type: 'GET',
        dataType: "json",
        data: {"qyid": qyid},
        success: function (data) {
            $("#securityTable").bootstrapTable('destroy');
            $("#securityTable").bootstrapTable({
                pagination: true,//设置为 true 会在表格底部显示分页条
                pageNumber: 1,
                pageSize: 15,								//如果设置了分页，页面数据条数
                pageList: [15, 30, 45, 60],				//如果设置了分页，设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录。
                clickToSelect: true,
                singleSelect: true,
                data: data,
                sortable: true,
                columns: [
                    {
                        field: 'state',
                        checkbox: true
                    }, {
                        field: 'xm',
                        title: '姓名'
                    }, {
                        field: 'gmsfhm',
                        title: '证件号'
                    }, {
                        field: 'jg',
                        title: '户籍所在地'
                    }, {
                        field: 'sgrq',
                        title: '上岗日期'
                    }, {
                        field: 'balx',
                        title: '保安类型'
                    }, {
                        field: 'qyid',
                        title: '企业id',
                        visible: false
                    }, {
                        field: 'baryid',
                        title: '保安人员id',
                        visible: false
                    }, {
                        field: 'fzjg',
                        title: '发证机构',
                        visible: false
                    }, {
                        field: 'lxfs',
                        title: '联系方式',
                        visible: false
                    }, {
                        field: 'hjdxz',
                        title: '地址',
                        visible: false
                    }
                ]
            });
        },
        error: function (data) {
            dangerMsg(data);
        }
    });
}

//查询监控设备信息
function selectJksbxx(qyid) {
    $.ajax({
        url: '../../bldsjksb/selectBldsjksb',
        type: 'GET',
        dataType: "json",
        data: {"qyid": qyid},
        success: function (data) {
            $("#monitoringTable").bootstrapTable('destroy');
            $("#monitoringTable").bootstrapTable({
                pagination: true,//设置为 true 会在表格底部显示分页条
                pageNumber: 1,
                pageSize: 15,								//如果设置了分页，页面数据条数
                pageList: [15, 30, 45, 60],				//如果设置了分页，设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录。
                clickToSelect: true,
                singleSelect: true,
                data: data,
                sortable: true,
                columns: [
                    {
                        field: 'state',
                        checkbox: true
                    }, {
                        field: 'sbmc',
                        title: '设备名称'
                    }, {
                        field: 'sccsmc',
                        title: '生产厂商'
                    }, {
                        field: 'ggxh',
                        title: '规格型号'
                    }, {
                        field: 'sbjcjgmc',
                        title: '检测机构名称'
                    }, {
                        field: 'wlcslxmc',
                        title: '网络传输类型'
                    }, {
                        field: 'qyid',
                        title: '企业id',
                        visible: false
                    }, {
                        field: 'bldsjksbid',
                        title: '监控设备id',
                        visible: false
                    }, {
                        field: 'ipdz',
                        title: 'IP地址',
                        visible: false
                    }, {
                        field: 'sflx',
                        title: '是否录像',
                        visible: false
                    }, {
                        field: 'azsl',
                        title: '设备数量',
                        visible: false
                    }
                ]
            });
        },
        error: function (data) {
            dangerMsg(data);
        }
    })

}

//查询技防设备信息
function selectJfsbxx(qyid) {
    $.ajax({
        url: '../../jfsbxx/selectJfsbxx',
        type: 'GET',
        dataType: "json",
        data: {"qyid": qyid},
        success: function (data) {
            $("#technicalTable").bootstrapTable('destroy');
            $("#technicalTable").bootstrapTable({
                pagination: true,//设置为 true 会在表格底部显示分页条
                pageNumber: 1,
                pageSize: 15,								//如果设置了分页，页面数据条数
                pageList: [15, 30, 45, 60],				//如果设置了分页，设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录。
                clickToSelect: true,
                singleSelect: true,
                data: data,
                sortable: true,
                columns: [
                    {
                        field: 'state',
                        checkbox: true
                    }, {
                        field: 'sbmc',
                        title: '设备名称'
                    }, {
                        field: 'ggxh',
                        title: '规格型号'
                    }, {
                        field: 'zl',
                        title: '技防设备种类'
                    }, {
                        field: 'sl',
                        title: '数量'
                    }, {
                        field: 'qyid',
                        title: '企业id',
                        visible: false
                    }
                ]
            });
        },
        error: function (data) {
            dangerMsg(data);
        }
    })
}