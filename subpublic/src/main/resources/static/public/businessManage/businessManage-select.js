$(function () {
    //企业管理新增
    $('#myModal5').load('businessManager-add.html');
    //企业管理修改
    $('#myModal6').load('businessManager-edit.html');
    //企业管理详情
    $('#myModal7').load('businessManager-msg.html');

    //获取安保信息下拉列表数据
    $.ajax({
        url: '../../dictionary/getAbxx',
        type: 'GET',
        success: function (data) {
            for (var i = 0; i < data.baxxs.length; i++) {
                $('#securityPersonType').append("<option value=" + data.baxxs[i].dicCode + ">" + data.baxxs[i].dicName + "</option>");
                $('#securityPersonTypeEdit').append("<option value=" + data.baxxs[i].dicCode + ">" + data.baxxs[i].dicName + "</option>");
                $('#securityPersonTypeEditMsg').append("<option value=" + data.baxxs[i].dicCode + ">" + data.baxxs[i].dicName + "</option>");
            }
            /*for(var i=1;i<data.jfsbzls.length;i++){
                $('#technicalTypeEditMsg').append("<option value=" + data.jfsbzls[i].dicCode + ">" + data.jfsbzls[i].dicName + "</option>");
                $('#technicalType').append("<option value=" + data.jfsbzls[i].dicCode + ">" + data.jfsbzls[i].dicName + "</option>");
                $('#technicalTypeEdit').append("<option value=" + data.jfsbzls[i].dicCode + ">" + data.jfsbzls[i].dicName + "</option>");
            }*/
            for (var i = 0; i < data.sflxs.length; i++) {
                $('#isVideoEditMsg').append("<option value=" + data.sflxs[i].dicCode + ">" + data.sflxs[i].dicName + "</option>");
                $('#isVideo').append("<option value=" + data.sflxs[i].dicCode + ">" + data.sflxs[i].dicName + "</option>");
                $('#isVideoEdit').append("<option value=" + data.sflxs[i].dicCode + ">" + data.sflxs[i].dicName + "</option>");
            }
        }
    });

    //查询企业信息
    $.ajax({
        url: '../../qyjbxx/selectQyjbxxByqyzt',
        type: 'GET',
        success: function (data) {
            getDataList(data);
        }
    });
    $('#search').off("click").on("click", function () {
        var companyNumber = $('#companyNumber').val().trim();
        var companyName = $('#companyName').val().trim();
        var businessNumber = $('#businessNumber').val().trim();
        var lawPersonName = $('#lawPersonName').val().trim();
        var lawPersonCard = $('#lawPersonCard').val().trim();
        var hylbdm = "";
        var gxdwbm = "";
        $.ajax({
            url: '../../qyjbxx/selectByCondition',
            type: 'POST',
            data: JSON.stringify({
                'frdbzjhm': lawPersonCard,
                'frdb': lawPersonName,
                'qybm': companyNumber,
                'qymc': companyName,
                'yyzzbh': businessNumber
            }),
            contentType: "application/json; charset=UTF-8",
            success: function (data) {
                getDataList(data);
            },
            error: function (data) {
                dangerMsg(data);
            }

        });
    });
    //删除企业信息
    $('#deleteCompanyBtn').off("click").on("click", function () {
        if ($('.selected').length == 1) {
            var data = $("#companyTable").bootstrapTable('getSelections')[0];
            var qyid = data.qyid;//企业id
            var zt = '1';//企业状态
            $.smkConfirm({
                text: "您确认要删除所选数据吗？",
                accept: '确定',
                cancel: '取消'
            }, function (res) {
                if (res) {
                    $.ajax({
                        url: '../../qyjbxx/updateQyjbxx',
                        type: 'POST',
                        contentType: 'application/json;charset=UTF-8',
                        data: JSON.stringify({
                            'qyid': qyid,
                            'zt': zt
                        }),
                        success: function (data) {
                            if (data == -1) {
                                warnningMsg("该企业下有员工信息，不能进行删除操作！");
                            } else if (data > 0) {
                                successMsg("企业删除成功");
                                $('#companyTable').bootstrapTable('refresh', {
                                    url: '../../qyjbxx/selectQyjbxxByqyzt'
                                });
                            } else {
                                dangerMsg("删除失败！");
                            }
                        },
                        error: function (data) {
                            dangerMsg(data);
                        }
                    })
                }
            })
        } else {
            warnningMsg("请选择一条数据！");
            return false;
        }
    });
});

function go() {
    location.href = "businessManage-select.html";
}

/**
 *获取表格数据
 */
function getDataList(data) {
    $('#companyTable').bootstrapTable('destroy');
    $('#companyTable').bootstrapTable({
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
                field: 'qyxh',
                title: '序号',
                align: 'center',
                width: 20,
                formatter: function (value, row, index) {
                    return index + 1;
                }
            }, {
                field: 'state',
                checkbox: true
            }, {
                field: 'qybm',
                title: '企业编号',
            }, {
                field: 'hylbdm',
                title: '行业类别代码',
                visible: false
            }, {
                field: 'hylb',
                title: '行业类别',
                visible: false
            }, {
                field: 'qyid',
                title: '企业id',
                visible: false
            }, {
                field: 'qymc',
                title: '企业名称',
            }, {
                field: 'qyqp',
                title: '企业全拼',
                visible: false
            }, {
                field: 'qyjp',
                title: '企业简拼',
                visible: false
            }, {
                field: 'qyzflbm',
                title: '企业主分类编码',
                visible: false
            }, {
                field: 'qyzflmc',
                title: '企业主分类名称',
                visible: false
            }, {
                field: 'qyfflbm',
                title: '企业副分类编码',
                visible: false
            }, {
                field: 'qyfflmc',
                title: '企业副分类名称',
                visible: false
            }, {
                field: 'gxdwbm',
                title: '管辖单位编码',
                visible: false
            }, {
                field: 'gxdwmc',
                title: '管辖单位名称',
            }, {
                field: 'ssdxjgajgdm',
                title: '所属地县级公安机关机构代码',
                visible: false
            }, {
                field: 'ssdxjgajgmc',
                title: '所属地县级公安机关名称',
                visible: false
            }, {
                field: 'ssddsjgdm',
                title: '所属地地市机构代码',
                visible: false
            }, {
                field: 'ssddsjgmc',
                title: '所属地地市机构名称',
                visible: false
            }, {
                field: 'qyzzjgdm',
                title: '企业组织机构代码',
                visible: false
            }, {
                field: 'lxdh',
                title: '联系电话',
                visible: false
            }, {
                field: 'yzbm',
                title: '邮政编码',
                visible: false
            }, {
                field: 'chzh',
                title: '传真',
                visible: false
            }, {
                field: 'jwdzb',
                title: '经纬度坐标',
                visible: false
            }, {
                field: 'jjlxbm',
                title: '经济类型编码',
                visible: false
            }, {
                field: 'jjlxmc',
                title: '经济类型名称',
                visible: false
            }, {
                field: 'jyfwzy',
                title: '经营范围（主营）',
                visible: false
            }, {
                field: 'jyfwjy',
                title: '经营范围（兼营）',
                visible: false
            }, {
                field: 'zczj',
                title: '注册资金',
                visible: false
            }, {
                field: 'jymj',
                title: '经营面积',
                visible: false
            }, {
                field: 'zabdm',
                title: '治安级别代码',
                visible: false
            }, {
                field: 'zajbmc',
                title: '治安级别名称',
                visible: false
            }, {
                field: 'yyzzbh',
                title: '营业执照编号',
            }, {
                field: 'yyztdm',
                title: '营业状态代码',
                visible: false
            }, {
                field: 'yyztmc',
                title: '营业状态名称',
                visible: false
            }, {
                field: 'frdb',
                title: '法人名称',
            }, {
                field: 'frdbzjlb',
                title: '法人代表证件类别',
                visible: false
            }, {
                field: 'frdbzjhm',
                title: '法人身份证号',
            }, {
                field: 'frdblxfs',
                title: '法人代表联系方式',
                visible: false
            }, {
                field: 'kyrq',
                title: '开业日期',
                visible: false
            }, {
                field: 'yysj',
                title: '营业时间',
                visible: false
            }, {
                field: 'babh',
                title: '备案编号',
                visible: false
            }, {
                field: 'barq',
                title: '备案日期',
                visible: false
            }, {
                field: 'tyrq',
                title: '停业日期',
                visible: false
            }, {
                field: 'jyfs',
                title: '经营方式',
                visible: false
            }, {
                field: 'jydz',
                title: '经营地址',
                visible: false
            }, {
                field: 'dwfzrzjlb',
                title: '单位负责人证件类别',
                visible: false
            }, {
                field: 'dwfzrzjhm',
                title: '单位负责人证件号码',
                visible: false
            }, {
                field: 'dwfzr',
                title: '单位负责人',
                visible: false
            }, {
                field: 'dwfzrlxfs',
                title: '单位负责人联系方式',
                visible: false
            }, {
                field: 'xfshdw',
                title: '消防审核单位',
                visible: false
            }, {
                field: 'xfhgzh',
                title: '消防合格证号',
                visible: false
            }, {
                field: 'hcdw',
                title: '核查单位',
                visible: false
            }, {
                field: 'hcr',
                title: '核查人',
                visible: false
            }, {
                field: 'hcsj',
                title: '核查时间',
                visible: false
            }, {
                field: 'gdxx',
                title: '股东信息',
                visible: false
            }, {
                field: 'zrs',
                title: '总人数',
                visible: false
            }, {
                field: 'hdrs',
                title: '核定人数',
                visible: false
            }, {
                field: 'bagsmc',
                title: '保安公司名称',
                visible: false
            }
        ]
    });
}

function changeMsg1() {
    $("#tab1").css("display", 'block');
    $("#tab2").css("display", 'none');
    $("#tab3").css("display", 'none');
    $("#btn_tabMsg1").css("background-color", 'rgb(26, 179, 148)');
    $("#btn_tabMsg2").css("background-color", '');
    $("#btn_tabMsg3").css("background-color", '');
}

function changeMsg2() {
    $("#tab2").css("display", 'block');
    $("#tab1").css("display", 'none');
    $("#tab3").css("display", 'none');
    $("#btn_tabMsg2").css("background-color", 'rgb(26, 179, 148)');
    $("#btn_tabMsg1").css("background-color", '');
    $("#btn_tabMsg3").css("background-color", '');
}

function changeMsg3() {
    $("#tab3").css("display", 'block');
    $("#tab1").css("display", 'none');
    $("#tab2").css("display", 'none');
    $("#btn_tabMsg3").css("background-color", 'rgb(26, 179, 148)');
    $("#btn_tabMsg2").css("background-color", '');
    $("#btn_tabMsg1").css("background-color", '');
}

function changeMsg4() {
    $("#tab4").css("display", 'block');
    $("#tab5").css("display", 'none');
    $("#tab6").css("display", 'none');
    $("#btn_tabMsg4").css("background-color", 'rgb(26, 179, 148)');
    $("#btn_tabMsg5").css("background-color", '');
    $("#btn_tabMsg6").css("background-color", '');
}

function changeMsg5() {
    $("#tab5").css("display", 'block');
    $("#tab4").css("display", 'none');
    $("#tab6").css("display", 'none');
    $("#btn_tabMsg5").css("background-color", 'rgb(26, 179, 148)');
    $("#btn_tabMsg4").css("background-color", '');
    $("#btn_tabMsg6").css("background-color", '');
}

function changeMsg6() {
    $("#tab6").css("display", 'block');
    $("#tab4").css("display", 'none');
    $("#tab5").css("display", 'none');
    $("#btn_tabMsg6").css("background-color", 'rgb(26, 179, 148)');
    $("#btn_tabMsg4").css("background-color", '');
    $("#btn_tabMsg5").css("background-color", '');
}

function changeMsg7() {
    $("#tab7").css("display", 'block');
    $("#tab8").css("display", 'none');
    $("#tab9").css("display", 'none');
    $("#btn_tabMsg7").css("background-color", 'rgb(26, 179, 148)');
    $("#btn_tabMsg8").css("background-color", '');
    $("#btn_tabMsg9").css("background-color", '');
}

function changeMsg8() {
    $("#tab8").css("display", 'block');
    $("#tab7").css("display", 'none');
    $("#tab9").css("display", 'none');
    $("#btn_tabMsg8").css("background-color", 'rgb(26, 179, 148)');
    $("#btn_tabMsg7").css("background-color", '');
    $("#btn_tabMsg9").css("background-color", '');
}

function changeMsg9() {
    $("#tab9").css("display", 'block');
    $("#tab7").css("display", 'none');
    $("#tab8").css("display", 'none');
    $("#btn_tabMsg9").css("background-color", 'rgb(26, 179, 148)');
    $("#btn_tabMsg7").css("background-color", '');
    $("#btn_tabMsg8").css("background-color", '');
}

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
        time: 1
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