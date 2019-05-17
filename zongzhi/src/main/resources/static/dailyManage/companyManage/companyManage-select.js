$(function () {
    httpipInit = localStorage.getItem('pawn_url');
    httpip = httpipInit.substring(1, (httpipInit.length - 1));
    httpip = JSON.parse(httpipInit);
    userInit = localStorage.getItem('user');
    user = JSON.parse(userInit);
    var organizationId = user.organizationId;
    console.info(organizationId);
    //为详情弹出框头部添加样式
    /*$('#btn_tabMsg7')[0].style.backgroundColor='#1ab394';
    $("#tab8").css("display",'none');
    $("#tab9").css("display",'none');*/

    //查询企业信息
    $.ajax({
        url: httpip + '/qyjbxx/selectQyjbxxByqyzt_zh',
        type: 'GET',
        data: {
            'organizationId': organizationId
        },
        success: function (data) {
            getDataList(data);
        }
    });
});
$('#search_btn').click(function () {
    userInit = localStorage.getItem('user');
    user = JSON.parse(userInit);
    var organizationId = user.organizationId;
    console.info(organizationId);
    var businessType = $('#businessType').val().trim();
    var dominion = $('#dominion').val().trim();
    if (dominion == null || dominion == "") {
        dominion = '';
    }
    var companyName = $('#companyName').val().trim();
    var businessNumber = $('#businessNumber').val().trim();
    var lawPersonName = $('#lawPersonName').val().trim();
    var lawPersonCard = $('#lawPersonCard').val().trim();
    var companyNumber = $('#companyNumber').val().trim();
    $.ajax({
        /*http://1.194.229.66:8081/pawn/qyjbxx/selectByCondition4zz*/
        url: httpip + '/qyjbxx/selectByConditionZong',
        type: 'POST',
        data: JSON.stringify({
            'hylbdm': businessType,
            'gxdwbm': dominion,
            'yyzzbh': businessNumber,
            'qybm': companyNumber,
            'frdb': lawPersonName,
            'frdbzjhm': lawPersonCard,
            'qymc': companyName,
            'organizationId': organizationId
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
$('#btn_edit').click(function () {
    var data = $("#companyTable").bootstrapTable('getSelections')[0];
    console.info(data);
    if (typeof(data) != 'undefined') {
        $('#btn_tabMsg7').click();
        var qybm = data.qybm;//企业编号
        var dwmc = data.gxdwmc;//企业名称
        var gxdw = data.gxdwbm;//管辖单位
        var dwlx = data.hylb;//单位类型
        var frxm = data.frdb;//法人姓名
        var frzjhm = data.frdbzjhm;//法人证件号
        var yyzzbh = data.yyzzbh;//营业执照编码
        var lxfs = data.lxdh;//联系方式
        var dwdz = data.dwdz;//单位地址
        $('#companyIdMsg').html(qybm);
        $('#companyNameMsg').html(dwmc);
        $('#dominionMsg').html(gxdw);
        $('#companyTypeMsg').html(dwlx);
        $('#lawPersonNameMsg').html(frxm);
        $('#lawPersonIdMsg').html(frzjhm);
        $('#businessNumberMsg').html(yyzzbh);
        $('#phoneMsg').html(lxfs);
        $('#companyAddressMsg').html(dwdz);
        /*$('#businessScopeMsg').html(jyfw);*/
        /*selectBaryxxMsg(qyid);
        selectJfsbxxMsg(qyid);
        selectJksbxxMsg(qyid);*/
    } else {
        warnningMsg("请选择一条数据！");
        return false;
    }
});

/**
 *获取表格数据
 */
function getDataList(data) {
    $('#companyTable').bootstrapTable('destroy');
    $('#companyTable').bootstrapTable({
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,
        pageSize: 15,								//如果设置了分页，页面数据条数
        pageList: [15, 30],				//如果设置了分页，设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录。
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
                visible: false
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
        time: 0.5
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