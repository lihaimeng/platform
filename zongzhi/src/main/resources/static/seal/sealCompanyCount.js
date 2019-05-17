$(document).ready(function () {
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

    /*$('#btn_companyMsg1')[0].style.backgroundColor = '#1ab394';
    $("#company2").css("display", 'none');*/
    var dominion = $('#dominion').val().trim();
    if (dominion == '0') {
        dominion = "";
    }
    var companyName = $('#companyName').val().trim();
    var registerTimeStart = $('#registerTimeStart').val().trim();
    var registerTimeEnd = $('#registerTimeEnd').val().trim();
    $.ajax({
        url: '../seal/selectSealInfoByParams',
        type: 'POST',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify({
            'company': companyName,
            'dominionCode': dominion,
            'registerDateStart': registerTimeStart,
            'registerDateEnd': registerTimeEnd
        }),
        success: function (data) {
            getTableData(data);
        },
        error: function (data) {
            dangerMsg(data);
        }
    });
    /**
     * 详情验证选中数据
     */
    $("#btn_Msg").click(function () {
        var data = $("#sealCompanyTable").bootstrapTable('getSelections')[0];
        if (typeof(data) != 'undefined') {
            $("#companyNumMsg").html(data.companyId);
            $("#companyNameMsg").html(data.company);
            $("#dominionMsg").html(data.dominion);
            $("#companyTypeMsg").html(data.companyType);
            $("#lawPersonNameMsg").html(data.lawPerson);
            $("#lawPersonIdTypeMsg").html(data.lawPersonCardType);
            $("#lawPersonIdMsg").html(data.lawPersonCard);
            $("#phoneMsg").html(data.lawPersonPhone);
            $("#registTime").html(data.registerDate);
            $("#addressMsg").html(data.companyAddress);
        } else {
            warnningMsg("请选择一条数据！");
            return false;
        }
    });

    $('#search_btn').click(function () {
        var dominion = $('#dominion').val().trim();
        if (dominion == '0') {
            dominion = "";
        }
        var companyName = $('#companyName').val().trim();
        var registerTimeStart = $('#registerTimeStart').val().trim();
        var registerTimeEnd = $('#registerTimeEnd').val().trim();

        if (Date.parse(registerTimeEnd) < Date.parse(registerTimeStart)) {
            warnningMsg("结束时间必须大于开始时间！");
            return false;
        }

        $.ajax({
            url: '../seal/selectSealInfoByParams',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({
                'company': companyName,
                'dominionCode': dominion,
                'registerDateStart': registerTimeStart,
                'registerDateEnd': registerTimeEnd
            }),
            success: function (data) {
                getTableData(data);
            },
            error: function (data) {
                dangerMsg(data);
            }
        })
    })

});
//管辖单位下拉列表选中事件
$('#dominion').change(function () {
    var dominionValue = $("#dominion").val();
    $("#dominion option[value=dominionValue]").attr("selected", true);
});

//获取表格数据
function getTableData(data) {
    for (var i = 0; i < data.length; i++) {
        if (data[i].operatorCardType == "01201") {
            data[i].operatorCardType = "身份证";
        } else if (data[i].operatorCardType == "01202") {
            data[i].operatorCardType = "户口簿";
        } else if (data[i].operatorCardType == "01203") {
            data[i].operatorCardType = "军官证";
        } else if (data[i].operatorCardType == "01204") {
            data[i].operatorCardType = "警官证";
        } else if (data[i].operatorCardType == "01205") {
            data[i].operatorCardType = "士兵证";
        } else if (data[i].operatorCardType == "01206") {
            data[i].operatorCardType = "护照";
        } else if (data[i].operatorCardType == "01299") {
            data[i].operatorCardType = "其他";
        }
        if (data[i].lawPersonCardType == "01201") {
            data[i].lawPersonCardType = "身份证";
        } else if (data[i].lawPersonCardType == "01202") {
            data[i].lawPersonCardType = "户口簿";
        } else if (data[i].lawPersonCardType == "01203") {
            data[i].lawPersonCardType = "军官证";
        } else if (data[i].lawPersonCardType == "01204") {
            data[i].lawPersonCardType = "警官证";
        } else if (data[i].lawPersonCardType == "01205") {
            data[i].lawPersonCardType = "士兵证";
        } else if (data[i].lawPersonCardType == "01206") {
            data[i].lawPersonCardType = "护照";
        } else if (data[i].lawPersonCardType == "01299") {
            data[i].lawPersonCardType = "其他";
        }
        if (data[i].companyType == "01101") {
            data[i].companyType = "使用单位";
        } else if (data[i].companyType == "01102") {
            data[i].companyType = "制作单位";
        }
    }
    $('#sealCompanyTable').bootstrapTable('destroy');
    $('#sealCompanyTable').bootstrapTable({
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
                field: 'companyId',
                title: '单位编号',
            }, {
                field: 'company',
                title: '单位名称',
            }, {
                field: 'dominion',
                title: '管辖单位',
            }, {
                field: 'markCompany',
                title: '制作单位名称',
                visible: false
            }, {
                field: 'lawPerson',
                title: '法人姓名',
            },
            {
                field: 'lawPersonCard',
                title: '法人证件号',
            }, {
                field: 'sealId',
                title: '印章编码',
                visible: false
            }, {
                field: 'sealType',
                title: '印章类型',
                visible: false
            }, {
                field: 'lawPersonPhone',
                title: '联系方式'
            },
            {
                field: 'registerDate',
                title: '登记时间',
            }, {
                field: 'id',
                title: 'subSealInfo对象id',
                visible: false
            }, {
                field: 'sealName',
                title: '印章名称',
                visible: false
            }, {
                field: 'state',
                title: '印章状态',
                visible: false
            }, {
                field: 'sealShape',
                title: '印章形状',
                visible: false
            }, {
                field: 'sealModel',
                title: '印章规格',
                visible: false
            }, {
                field: 'sealMaterial',
                title: '印章材质',
                visible: false
            }, {
                field: 'sealPattern',
                title: '印章中心图案',
                visible: false
            }, {
                field: 'operator',
                title: '经办人',
                visible: false
            }, {
                field: 'operatorCard',
                title: '经办人证件号码',
                visible: false
            }, {
                field: 'operatorCardType',
                title: '经办人证件类型',
                visible: false
            }, {
                field: 'operatorPhone',
                title: '经办人联系方式',
                visible: false
            }, {
                field: 'companyType',
                title: '使用单位类型',
                visible: false
            }, {
                field: 'companyAddress',
                title: '使用单位地址',
                visible: false
            }, {
                field: 'lawPersonCardType',
                title: '法人证件类型',
                visible: false
            }, {
                field: 'markCompanyAddress',
                title: '制作单位地址',
                visible: false
            }
        ]
    });
}

//统计
/*$('#count_btn').click(function () {
    var countType = $('#countType').val();
    if (countType == '扇形图') {
        location.href = "echarts-sealCompany-pie.html";
    } else if (countType == '折线图') {
        location.href = "echarts-sealCompany-line.html";
    } else if (countType == '柱形图') {
        location.href = "echarts-sealCompany-bar.html";
    }
});*/
/*
function changeMsg1() {
    $("#company1").css("display", 'block');
    $("#company2").css("display", 'none');
    $("#btn_companyMsg1").css("background-color", 'rgb(26, 179, 148)');
    $("#btn_companyMsg2").css("background-color", '');
}

function changeMsg2() {
    $("#company2").css("display", 'block');
    $("#company1").css("display", 'none');
    $("#btn_companyMsg2").css("background-color", 'rgb(26, 179, 148)');
    $("#btn_companyMsg1").css("background-color", '');
}*/

/*function changeformMsg() {
    $("#formMsg").css("display", 'none');
    $("#Msg").css("display", 'block');
}*/

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