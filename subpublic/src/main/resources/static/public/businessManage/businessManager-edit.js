//为修改弹出框头部添加样式
$('#btn_tabMsg4').css("background", "#1ab394");
$("#tab5").css("display", 'none');
$("#tab6").css("display", 'none');
var dominionFlag = true;
$('#dominionEdit').on('chosen:showing_dropdown', function () {
    if (dominionFlag) {
        dominionFlag = false;
        //获取管辖单位下拉列表
        $.ajax({
            url: "../../qyjbxx/getDominion",
            type: 'GET',
            success: function (data) {
                var dominionValue = $('#dominionEdit').val();
                $('#dominionEdit').val("");
                for (var i = 0; i < data.length; i++) {
                    if (dominionValue != data[i].brevitycode) {
                        $('#dominionEdit').append("<option value=" + data[i].brevitycode + ">" + data[i].name + "</option>");
                    }
                }
                $('#dominionEdit').trigger('chosen:updated');
            },
            error: function (data) {
                dangerMsg(data);
            }
        });
    }
});
var companyTypeFlag = true;
/*$('#companyTypeEdit').focus(function () {
    if (companyTypeFlag) {
        companyTypeFlag = false;
        $.ajax({
            url: "../../dictionary/getBussinessType",
            type: 'GET',
            success: function (data) {
                var companyValue = $('#companyTypeEdit').val();
                $('#companyTypeEdit').val("");
                for (var i = 0; i < data.length; i++) {
                    if (companyValue != data[i].dicCode) {
                        $('#companyTypeEdit').append("<option value=" + data[i].dicCode + ">" + data[i].dicName + "</option>");
                    }
                }
            },
            error: function (data) {
                dangerMsg(data);
            }
        });
    }
});*/
var balxFlag = true;
$('#securityPersonTypeEditMsg').click(function () {
    if (balxFlag) {
        balxFlag = false;
        $.ajax({
            url: "../../dictionary/getAbxx",
            type: 'GET',
            success: function (data) {
                var value = $('#securityPersonTypeEditMsg').val();
                $('#securityPersonTypeEditMsg').append("");
                for (var i = 0; i < data.baxxs.length; i++) {
                    if (value != data.baxxs[i].dicCode) {
                        $('#securityPersonTypeEditMsg').append("<option value=" + data.baxxs[i].dicCode + ">" + data.baxxs[i].dicName + "</option>");
                    }
                }
            },
            error: function (data) {
                dangerMsg(data);
            }
        });
    }
});
/**
 * 修改
 */
$('#editButton').off("click").on("click", function () {
    var data = $("#companyTable").bootstrapTable('getSelections')[0];
    if (typeof(data) != 'undefined') {
        $('#btn_tabMsg1').click();
        var qyid = data.qyid;//企业id
        var dwmc = data.qymc;//企业名称
        var gxdwbm = data.gxdwbm;//管辖单位编码
        var gxdwmc = data.gxdwmc;//管辖单位
        // var hylbdm = data.hylbdm;//单位类型编码
        // var hylb = data.hylb;//单位类型
        var frxm = data.frdb;//法人姓名
        var frzjhm = data.frdbzjhm;//法人证件号
        var yyzzbh = data.yyzzbh;//营业执照编码
        var lxfs = data.lxdh;//联系方式
        var dwdz = data.jydz;//单位地址
        var jyfw = data.jyfwzy;//经营范围主营
        $('#qyidEdit').val(qyid);
        $('#companyNameEdit').val(dwmc);
        $("#dominionEdit").empty();
        $('#dominionEdit').append("<option value=" + gxdwbm + ">" + gxdwmc + "</option>");
        $('#dominionEdit').trigger('chosen:updated');
        //$("#companyTypeEdit").empty();
        //$('#companyTypeEdit').append("<option value=" + hylbdm + ">" + hylb + "</option>");
        $('#lawPersonNameEdit').val(frxm);
        $('#lawPersonIDEdit').val(frzjhm);
        $('#businessNumberEdit').val(yyzzbh);
        $('#phoneEdit').val(lxfs);
        $('#companyAddressEdit').val(dwdz);
        $('#businessScopeEdit').val(jyfw);
        selectJksbxxEdit(qyid);
        selectJfsbxxEdit(qyid);
        selectBaryxxEdit(qyid);
        selectFileMsg(qyid);
        $('#editCompanySubmit').off("click").on("click", function () {
            submitCompany(qyid);
        });
    } else {
        warnningMsg("请选择一条数据！");
        return false;
    }
});
//关闭修改框
$('#closeEdit').off("click").on("click", function () {
    $('#companyTable').bootstrapTable('refresh', {
        url: '../../qyjbxx/selectQyjbxxByqyzt'
    });
});
//修改安保人员信息
$('#editAbryxx').off("click").on("click", function () {
    var data = $('#securityTableEdit').bootstrapTable('getSelections')[0];
    if (typeof(data) == 'undefined') {
        warnningMsg("请选择一条数据！");
        return false;
    } else {
        $("#editSecurityFormMsg")[0].reset();
        $('#securityPersonNameEditMsg').val(data.xm);
        $('#securityPersonIdEditMsg').val(data.gmsfhm);
        $('#securityJGEditMsg').val(data.jg);
        $('#securityPersonPhoneEditMsg').val(data.lxfs);
        $('#securityTCBEditMsg').val(data.fzjg);
        $("#securityPersonTypeEditMsg").empty();
        $('#securityPersonTypeEditMsg').append("<option value=" + data.balxbm + ">" + data.balx + "</option>");
        $('#securityPersonDateEditMsg').val(data.sgrq);
        $('#securityPersonAddressEditMsg').val(data.hjdxz);
    }
    $('#editSecuritySubmitMsg').off("click").on("click", function () {
        if ($('#addSecurityForm').valid()) {
            var securityPersonName = $('#securityPersonNameEditMsg').val().trim();
            var securityPersonId = $('#securityPersonIdEditMsg').val().trim();
            var securityJG = $('#securityJGEditMsg').val().trim();
            var securityPersonPhone = $('#securityPersonPhoneEditMsg').val().trim();
            var securityTCB = $('#securityTCBEditMsg').val().trim();
            var securityPersonType = $('#securityPersonTypeEditMsg').val().trim();
            var securityPersonDate = $('#securityPersonDateEditMsg').val().trim();
            var securityPersonAddress = $('#securityPersonAddressEditMsg').val().trim();
            console.log(data.baryid);
            $.ajax({
                url: '../../baryxx/updateBaryxx',
                type: 'POST',
                contentType: 'application/json;charset=UTF-8',
                data: JSON.stringify({
                    'baryid': data.baryid,
                    'xm': securityPersonName,
                    'gmsfhm': securityPersonId,
                    'jg': securityJG,
                    'fzjg': securityTCB,
                    'balx': securityPersonType,
                    'sgrq': securityPersonDate,
                    'hjdxz': securityPersonAddress,
                    'lxfs': securityPersonPhone
                }),
                success: function (result) {
                    successMsg("修改成功");
                    $('#closeSecurityEditMsg').click();
                    $("#securityTableEdit").bootstrapTable('refresh', {
                        url: '../../baryxx/selectByQyid?qyid=' + data.qyid
                    });
                },
                error: function (data) {
                    dangerMsg(data);
                }
            })
        }
    });
});
//删除安保人员信息
$('#deleteAbryxx').off("click").on("click", function () {
    var data = $('#securityTableEdit').bootstrapTable('getSelections')[0];
    if (typeof(data) == 'undefined') {
        warnningMsg("请选择一条数据！");
        return false;
    } else {
        var qyid = data.qyid;//企业id
        var baryid = data.baryid;//保安人员id
        var zt = '1';//保安人员状态
        $.ajax({
            url: '../../baryxx/updateBaryxx',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({
                'qyid': qyid,
                'baryid': baryid,
                'zt': zt
            }),
            success: function (data) {
                successMsg("保安人员删除成功");
                $("#securityTableEdit").bootstrapTable('refresh', {
                    url: '../../baryxx/selectByQyid?qyid=' + qyid,
                });
            },
            error: function (data) {
                dangerMsg(data);
            }
        });
    }
});
//修改监控设备信息
$('#editJksbxx').off("click").on("click", function () {
    var data = $('#monitoringTableEdit').bootstrapTable('getSelections')[0];
    if (typeof(data) == 'undefined') {
        warnningMsg("请选择一条数据！");
        return false;
    } else {
        $("#editMonitoringFormMsg")[0].reset();
        $('#monitoringNameEditMsg').val(data.sbmc);
        $('#monitoringManufacturerEditMsg').val(data.sccsmc);
        $('#monitoringModelEditMsg').val(data.ggxh);
        $('#monitoringDetectionNameEditMsg').val(data.sbjcjgmc);
        $('#monitoringNetworkTypeEditMsg').val(data.wlcslxmc);
        $('#monitoringNumberEditMsg').val(data.azsl);
        $('#isVideoEditMsg').val(data.sflx);
        $('#IPAddressEditMsg').val(data.ipdz);
    }
    $('#editMonitoringSubmitMsg').off("click").on("click", function () {
        var monitoringName = $('#monitoringNameEditMsg').val().trim();
        var monitoringManufacturer = $('#monitoringManufacturerEditMsg').val().trim();
        var monitoringModel = $('#monitoringModelEditMsg').val().trim();
        var monitoringDetectionName = $('#monitoringDetectionNameEditMsg').val().trim();
        var monitoringNetworkType = $('#monitoringNetworkTypeEditMsg').val().trim();
        var monitoringNumber = $('#monitoringNumberEditMsg').val().trim();
        var isVideo = $('#isVideoEditMsg').val().trim();
        var IPAddress = $('#IPAddressEditMsg').val().trim();
        $.ajax({
            url: '../../bldsjksb/updateBldsjksb',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({
                'bldsjksbid': data.bldsjksbid,
                'wlcslxmc': monitoringNetworkType,
                'sbmc': monitoringName,
                'sccsmc': monitoringManufacturer,
                'ggxh': monitoringModel,
                'sbjcjgmc': monitoringDetectionName,
                'azsl': monitoringNumber,
                'sflx': isVideo,
                'ipdz': IPAddress
            }),
            success: function (result) {
                successMsg("修改成功");
                $('#closeMonitoringEditMsg').click();
                $("#monitoringTableEdit").bootstrapTable('refresh', {
                    url: '../../bldsjksb/selectBldsjksb?qyid=' + data.qyid
                });
            },
            error: function (data) {
                dangerMsg(data);
            }
        });
    });
});
//删除监控设备信息
$('#deleteJksbxx').off("click").on("click", function () {
    var data = $('#monitoringTableEdit').bootstrapTable('getSelections')[0];
    if (typeof(data) == 'undefined') {
        warnningMsg("请选择一条数据！");
        return false;
    } else {
        var qyid = data.qyid;//企业id
        var bldsjksbid = data.bldsjksbid;//保安人员id
        var zt = '1';//保安人员状态
        $.ajax({
            url: '../../bldsjksb/updateBldsjksb',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({
                'qyid': qyid,
                'bldsjksbid': bldsjksbid,
                'zt': zt
            }),
            success: function (data) {
                successMsg("监控设备删除成功");
                $("#monitoringTableEdit").bootstrapTable('refresh', {
                    url: '../../bldsjksb/selectBldsjksb?qyid=' + qyid,
                });
            },
            error: function (data) {
                dangerMsg(data);
            }
        });
    }
});
//修改技防设备信息
$('#editJfsbxx').off("click").on("click", function () {
    var data = $('#technicalTableEdit').bootstrapTable('getSelections')[0];
    if (typeof(data) == 'undefined') {
        warnningMsg("请选择一条数据！");
        return false;
    } else {
        $("#editTechnicalFormMsg")[0].reset();
        $('#technicalNameEditMsg').val(data.sbmc);
        $('#technicalModelEditMsg').val(data.ggxh);
        $('#technicalTypeEditMsg').val(data.zl);
        $('#technicalNumberEditMsg').val(data.sl);
    }
    $('#editTechnicalSubmitMsg').off("click").on("click", function () {
        var technicalName = $('#technicalNameEditMsg').val().trim();
        var technicalModel = $('#technicalModelEditMsg').val().trim();
        var technicalType = $('#technicalTypeEditMsg').val().trim();
        var technicalNumber = $('#technicalNumberEditMsg').val().trim();
        $.ajax({
            url: '../../jfsbxx/updateJfsbxx',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({
                'jfsbxxid': data.jfsbxxid,
                'sbmc': technicalName,
                'ggxh': technicalModel,
                'zl': technicalType,
                'sl': technicalNumber
            }),
            success: function (result) {
                successMsg("修改成功");
                $('#closeTechnicalEditMsg').click();
                $("#technicalTableEdit").bootstrapTable('refresh', {
                    url: '../../jfsbxx/selectJfsbxx?qyid=' + data.qyid
                });
            },
            error: function (data) {
                dangerMsg(data);
            }
        });
    });
});
//删除技防设备信息
$('#deleteJfsbxx').off("click").on("click", function () {
    var data = $('#technicalTableEdit').bootstrapTable('getSelections')[0];
    if (typeof(data) == 'undefined') {
        warnningMsg("请选择一条数据！");
        return false;
    } else {
        var qyid = data.qyid;//企业id
        var jfsbxxid = data.jfsbxxid;//保安人员id
        var zt = '1';//保安人员状态
        $.ajax({
            url: '../../jfsbxx/updateJfsbxx',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({
                'qyid': qyid,
                'jfsbxxid': jfsbxxid,
                'zt': zt
            }),
            success: function (data) {
                successMsg("技防设备删除成功");
                $("#technicalTableEdit").bootstrapTable('refresh', {
                    url: '../../jfsbxx/selectJfsbxx?qyid=' + qyid,
                });
            },
            error: function (data) {
                dangerMsg(data);
            }
        });
    }
});

//修改时新增安保人员信息表单重置
$('#addAbryxx').off("click").on("click", function () {
    $("#editSecurityForm")[0].reset();
});
//修改时新增监控设备信息表单重置
$('#addJksbxx').off("click").on("click", function () {
    $("#editMonitoringForm")[0].reset();
});
//修改时新增技防设备信息表单重置
$('#addJfsbxx').off("click").on("click", function () {
    $("#editTechnicalForm")[0].reset();
});

/**
 * 提交修改信息
 * @param qyid：企业id
 */
function submitCompany(qyid) {
    if ($('#companyFormForEdit').valid()) {
        var companyName = $('#companyNameEdit').val().trim();
        var dominionCode = $('#dominionEdit').val().trim();
        var dominion = $('#dominionEdit').find("option:selected").text();
        //var companyType = $('#companyTypeEdit').val().trim();
        var lawPersonName = $('#lawPersonNameEdit').val().trim();
        var lawPersonID = $('#lawPersonIDEdit').val().trim();
        var businessNumber = $('#businessNumberEdit').val().trim();
        var phone = $('#phoneEdit').val().trim();
        var companyAddress = $('#companyAddressEdit').val().trim();
        var businessScope = $('#businessScopeEdit').val().trim();
        $.ajax({
            url: '../../qyjbxx/updateQyjbxx',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({
                'qyid': qyid,
                'qymc': companyName,
                'gxdwmc': dominion,
                'gxdwbm': dominionCode,
                // 'hylb': companyType,
                'frdb': lawPersonName,
                'frdbzjhm': lawPersonID,
                'yyzzbh': businessNumber,
                'lxdh': phone,
                'jydz': companyAddress,
                'jyfwzy': businessScope
            }),
            success: function (data) {
                if (data == 1) {
                    successMsg("企业信息修改成功！");
                }
                $('#btn_tabMsg5').click();
            },
            error: function (data) {
                dangerMsg(data);
            }
        });
    }
}

//查询保安信息
function selectBaryxxEdit(qyid) {
    $.ajax({
        url: '../../baryxx/selectByQyid',
        type: 'GET',
        dataType: "json",
        data: {"qyid": qyid},
        success: function (data) {
            $("#securityTableEdit").bootstrapTable('destroy');
            $("#securityTableEdit").bootstrapTable({
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
                        field: 'balxbm',
                        title: '保安类型编码',
                        visible: false
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

$(document).ready(function () {
    //新增安保人员信息
    $('#editSecuritySubmit').off("click").on("click", function () {
        var qyid = $('#qyidEdit').val().trim();
        var securityPersonName = $('#securityPersonNameEdit').val().trim();
        var securityPersonId = $('#securityPersonIdEdit').val().trim();
        var securityJG = $('#securityJGEdit').val().trim();
        var securityPersonPhone = $('#securityPersonPhoneEdit').val().trim();
        var securityTCB = $('#securityTCBEdit').val().trim();
        var securityPersonTypeNum = $('#securityPersonTypeEdit').val().trim();
        var securityPersonType = $('#securityPersonTypeEdit').find("option:selected").text();
        var securityPersonDate = $('#securityPersonDateEdit').val().trim();
        var securityPersonAddress = $('#securityPersonAddressEdit').val().trim();
        $.ajax({
            url: '../../baryxx/insertBaryxx',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({
                'qyid': qyid,
                'xm': securityPersonName,
                'gmsfhm': securityPersonId,
                'jg': securityJG,
                'fzjg': securityTCB,
                'balx': securityPersonType,
                'balxbm': securityPersonTypeNum,
                'sgrq': securityPersonDate,
                'hjdxz': securityPersonAddress,
                'lxfs': securityPersonPhone,
                'zt': '0'
            }),
            success: function (data) {
                successMsg("添加成功");
                $('#closeSecurityEdit').click();
                selectBaryxxEdit(qyid);
            },
            error: function (data) {
                dangerMsg(data);
            }
        });
    });
    //新增监控设备信息
    $('#editMonitoringSubmit').off("click").on("click", function () {
        var qyid = $('#qyidEdit').val().trim();
        var monitoringName = $('#monitoringNameEdit').val().trim();
        var monitoringManufacturer = $('#monitoringManufacturerEdit').val().trim();
        var monitoringModel = $('#monitoringModelEdit').val().trim();
        var monitoringDetectionName = $('#monitoringDetectionNameEdit').val().trim();
        var monitoringNetworkType = $('#monitoringNetworkTypeEdit').val().trim();
        var monitoringNumber = $('#monitoringNumberEdit').val().trim();
        var isVideo = $('#isVideoEdit').val().trim();
        var IPAddress = $('#IPAddressEdit').val().trim();
        $.ajax({
            url: '../../bldsjksb/insertBldsjksb',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({
                'qyid': qyid,
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
                $('#closeMonitoringEdit').click();
                selectJksbxxEdit(qyid);
            },
            error: function (data) {
                dangerMsg(data);
            }
        });
    });
    //新增技防设备信息
    $('#editTechnicalSubmit').off("click").on("click", function () {
        var qyid = $('#qyidEdit').val().trim();
        var technicalName = $('#technicalNameEdit').val().trim();
        var technicalModel = $('#technicalModelEdit').val().trim();
        var technicalType = $('#technicalTypeEdit').val().trim();
        var technicalNumber = $('#technicalNumberEdit').val().trim();
        $.ajax({
            url: '../../jfsbxx/insertJfsbxx',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({
                'qyid': qyid,
                'sbmc': technicalName,
                'ggxh': technicalModel,
                'zl': technicalType,
                'sl': technicalNumber,
                'zt': '0'
            }),
            success: function (data) {
                successMsg("添加成功");
                $('#closeTechnicalEdit').click();
                selectJfsbxxEdit(qyid);
            },
            error: function (data) {
                dangerMsg(data);
            }
        });
    });
    //关闭修改
    /*$('#closeEdit').click(function () {
        location.href = "businessManage-select.html";
    });*/
});

//查询监控设备信息
function selectJksbxxEdit(qyid) {
    $.ajax({
        url: '../../bldsjksb/selectBldsjksb',
        type: 'GET',
        dataType: "json",
        data: {"qyid": qyid},
        success: function (data) {
            $("#monitoringTableEdit").bootstrapTable('destroy');
            $("#monitoringTableEdit").bootstrapTable({
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
function selectJfsbxxEdit(qyid) {
    $.ajax({
        url: '../../jfsbxx/selectJfsbxx',
        type: 'GET',
        dataType: "json",
        data: {"qyid": qyid},
        success: function (data) {
            $("#technicalTableEdit").bootstrapTable('destroy');
            $("#technicalTableEdit").bootstrapTable({
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