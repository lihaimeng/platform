//为详情弹出框头部添加样式
$('#btn_tabMsg7')[0].style.backgroundColor = '#1ab394';
$("#tab8").css("display", 'none');
$("#tab9").css("display", 'none');
$(document).ready(function () {
    $('#btn_edit').off("click").on("click", function () {
        if ($('.selected').length == 1) {
            $('#btn_tabMsg7').click();
            var data = $("#companyTable").bootstrapTable('getSelections')[0];
            var qyid = data.qyid;//企业id
            var qybm = data.qybm;//企业编码
            var dwmc = data.qymc;//企业名称
            var gxdw = data.gxdwmc;//管辖单位
            // var dwlx = data.hylb;//单位类型
            var frxm = data.frdb;//法人姓名
            var frzjhm = data.frdbzjhm;//法人证件号
            var yyzzbh = data.yyzzbh;//营业执照编码
            var lxfs = data.lxdh;//联系方式
            var dwdz = data.jydz;//单位地址
            var jyfw = data.jyfwzy;//经营范围主营
            $('#tableId').val(qyid);
            $('#companyIdMsg').html(qybm);
            $('#companyNameMsg').html(dwmc);
            $('#dominionMsg').html(gxdw);
            //$('#companyTypeMsg').html(dwlx);
            $('#lawPersonNameMsg').html(frxm);
            $('#lawPersonIdMsg').html(frzjhm);
            $('#businessNumberMsg').html(yyzzbh);
            $('#phoneMsg').html(lxfs);
            $('#companyAddressMsg').html(dwdz);
            $('#businessScopeMsg').html(jyfw);
            selectBaryxxMsg(qyid);
            selectJfsbxxMsg(qyid);
            selectJksbxxMsg(qyid);
        } else {
            warnningMsg("请选择一条数据！");
            return false;
        }
    })
});

//查询保安信息
function selectBaryxxMsg(qyid) {
    $.ajax({
        url: '../../baryxx/selectByQyid',
        type: 'GET',
        dataType: "json",
        data: {"qyid": qyid},
        success: function (data) {
            $("#securityTableMsg").bootstrapTable('destroy');
            $("#securityTableMsg").bootstrapTable({
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
function selectJksbxxMsg(qyid) {
    $.ajax({
        url: '../../bldsjksb/selectBldsjksb',
        type: 'GET',
        dataType: "json",
        data: {"qyid": qyid},
        success: function (data) {
            $("#monitoringTableMsg").bootstrapTable('destroy');
            $("#monitoringTableMsg").bootstrapTable({
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
function selectJfsbxxMsg(qyid) {
    $.ajax({
        url: '../../jfsbxx/selectJfsbxx',
        type: 'GET',
        dataType: "json",
        data: {"qyid": qyid},
        success: function (data) {
            $("#technicalTableMsg").bootstrapTable('destroy');
            $("#technicalTableMsg").bootstrapTable({
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