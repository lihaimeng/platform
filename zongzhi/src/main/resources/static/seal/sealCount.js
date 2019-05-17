$(document).ready(function () {
    /**
     * 获取管辖单位
     */
    var josnOrganization = localStorage.getItem("organization");
    var organizationList = JSON.parse(josnOrganization);
    for (var i = 0; i < organizationList.length; i++) {
        if (organizationList[i].code != "") {
            console.info(organizationList[i]);
            $('#dominion').append("<option value=" + organizationList[i].brevitycode + ">" + organizationList[i].name + "</option>");
        }
    }
    $('#dominion').trigger('chosen:updated');
    //管辖单位下拉列表选中事件
    $('#dominion').change(function () {
        var dominionValue = $("#dominion").val();
        $("#dominion option[value=dominionValue]").attr("selected", true);
    });


    var typeArray = [];//定义一个类型数组
    function initTypeArray(name) {
        this.name = name;
    }

    typeArray.push(new initTypeArray("印章类型"));
    typeArray.push(new initTypeArray("印章材料"));
    typeArray.push(new initTypeArray("印章规格"));
    for (var i = 0; i < typeArray.length; i++) {
        var initSelectOption = localStorage.getItem(typeArray[i].name);
        initSelectOption = JSON.parse(initSelectOption);
        if (initSelectOption != null || initSelectOption != "") {
            initSelectOption.forEach(function (item, index) {
                if (typeArray[i].name == "印章类型") {
                    $('#sealType').append("<option value=" + item.name + ">" + item.name + "</option>");
                }
                if (typeArray[i].name == "印章材料") {
                    $('#sealMaterial').append("<option value=" + item.name + ">" + item.name + "</option>");
                }
                if (typeArray[i].name == "印章规格") {
                    $('#sealModel').append("<option value=" + item.name + ">" + item.name + "</option>");

                }
            })

        }
    }
    /*$('#btn_companyMsg1')[0].style.backgroundColor = '#1ab394';
    $("#company2").css("display", 'none');*/
    var companyName = $('#companyName').val().trim();
    var dominion = $('#dominion').val().trim();
    var sealMaterial = $('#sealMaterial').val().trim();
    var sealModel = $('#sealModel').val().trim();
    var sealType = $('#sealType').val().trim();
    var registerTimeStart = $('#registerTimeStart').val().trim();
    var registerTimeEnd = $('#registerTimeEnd').val().trim();
    $.ajax({
        url: '../seal/selectSealInfoByParams',
        type: 'post',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify({
            /*  'companyId': companyNum,*/
            'company': companyName,
            'sealMaterial': sealMaterial,
            'sealModel': sealModel,
            'sealType': sealType,
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
        var data = $("#sealTable").bootstrapTable('getSelections')[0];
        if (typeof(data) != 'undefined') {
            $("#companyNumMsg").html(data.companyId);
            $("#companyNameMsg").html(data.company);
            $("#sealNumMsg").html(data.sealId);
            $("#sealTypeMsg").html(data.sealType);
            $("#sealModelMsg").html(data.sealModel);
            $("#sealMaterialMsg").html(data.sealMaterial);
            $("#sealShapeMsg").html(data.sealShape);
            $("#centerPatternMsg").html(data.sealPattern);
            $("#registerTime").html(data.registerDate);
        } else {
            warnningMsg("请选择一条数据！");
            return false;
        }
    });
});

//管辖单位下拉列表选中事件
$('#dominion').change(function () {
    var dominionValue = $("#dominion").val();
    $("#dominion option[value=dominionValue]").attr("selected", true);
});
//查询
$('#search_btn').click(function () {
    /*var companyNum = $('#companyNum').val().trim();*/
    var companyName = $('#companyName').val().trim();
    var dominion = $('#dominion').val().trim();
    var sealMaterial = $('#sealMaterial').val().trim();
    var sealModel = $('#sealModel').val().trim();
    var sealType = $('#sealType').val().trim();
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
            /*'companyId': companyNum,*/
            'company': companyName,
            'sealMaterial': sealMaterial,
            'sealModel': sealModel,
            'sealType': sealType,
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
});

//统计
/*$('#count_btn').click(function () {
    var countType = $('#countType').val();
    if (countType == '扇形图') {
        location.href = "echarts-seal-pie.html";
    } else if (countType == '折线图') {
        location.href = "echarts-seal-line.html";
    } else if (countType == '柱形图') {
        location.href = "echarts-seal-bar.html";
    }
});*/

//获取表格数据
function getTableData(data) {
    for (var i = 0; i < data.length; i++) {
        if (data[i].sealModel == "00901") {
            data[i].sealModel = "30*40";
        } else if (data[i].sealModel == "00902") {
            data[i].sealModel = "38";
        } else if (data[i].sealModel == "00903") {
            data[i].sealModel = "18*18";
        } else if (data[i].sealModel == "00904") {
            data[i].sealModel = "20*20";
        } else if (data[i].sealModel == "00905") {
            data[i].sealModel = "45*30";
        } else if (data[i].sealModel == "00906") {
            data[i].sealModel = "45";
        } else if (data[i].sealModel == "00907") {
            data[i].sealModel = "42";
        } else if (data[i].sealModel == "00908") {
            data[i].sealModel = "40";
        } else if (data[i].sealModel == "00909") {
            data[i].sealModel = "20*14";
        }
        if (data[i].sealMaterial == "00801") {
            data[i].sealMaterial = "铜质章";
        } else if (data[i].sealMaterial == "00802") {
            data[i].sealMaterial = "橡塑合成章";
        } else if (data[i].sealMaterial == "00803") {
            data[i].sealMaterial = "牛角";
        } else if (data[i].sealMaterial == "00804") {
            data[i].sealMaterial = "有机玻璃";
        } else if (data[i].sealMaterial == "00805") {
            data[i].sealMaterial = "光敏章";
        } else if (data[i].sealMaterial == "00806") {
            data[i].sealMaterial = "回墨印";
        }
        if (data[i].sealShape == "00701") {
            data[i].sealShape = "五角星";
        } else if (data[i].sealShape == "00702") {
            data[i].sealShape = "圆形";
        } else if (data[i].sealShape == "00703") {
            data[i].sealShape = "椭圆形";
        } else if (data[i].sealShape == "00704") {
            data[i].sealShape = "长方形";
        } else if (data[i].sealShape == "00705") {
            data[i].sealShape = "正方形";
        } else if (data[i].sealShape == "00799") {
            data[i].sealShape = "其他";
        }
        if (data[i].sealPattern == "00601") {
            data[i].sealPattern = "五角星";
        } else if (data[i].sealPattern == "00602") {
            data[i].sealPattern = "党徽";
        } else if (data[i].sealPattern == "00603") {
            data[i].sealPattern = "国徽";
        } else if (data[i].sealPattern == "00604") {
            data[i].sealPattern = "团徽";
        } else if (data[i].sealPattern == "00699") {
            data[i].sealPattern = "其他";
        }
        if (data[i].sealType == "01001") {
            data[i].sealType = "单位专用章";
        } else if (data[i].sealType == "01002") {
            data[i].sealType = "财务专用章";
        } else if (data[i].sealType == "01003") {
            data[i].sealType = "税务专用章";
        } else if (data[i].sealType == "01004") {
            data[i].sealType = "合同专用章";
        } else if (data[i].sealType == "01005") {
            data[i].sealType = "法人代表用章";
        } else if (data[i].sealType == "01006") {
            data[i].sealType = "私章";
        }
    }
    $('#sealTable').bootstrapTable('destroy');
    $('#sealTable').bootstrapTable({
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
                title: '单位编码',
                visible: false
            }, {
                field: 'markCompany',
                title: '制作单位名称',
                visible: false
            }, {
                field: 'lawPerson',
                title: '法人姓名',
                visible: false
            }, {
                field: 'lawPersonCard',
                title: '法人证件号',
                visible: false
            }, {
                field: 'sealId',
                title: '印章编码',
            }, {
                field: 'company',
                title: '单位名称'
            }, {
                field: 'sealName',
                title: '印章名称',
            }, {
                field: 'dominion',
                title: '管辖单位',
            }, {
                field: 'sealType',
                title: '印章类型',
            }, {
                field: 'sealMaterial',
                title: '印章材质',
            }, {
                field: 'sealModel',
                title: '印章规格',
            }, {
                field: 'sealPattern',
                title: '中心图案'
            },
            {
                field: 'registerDate',
                title: '登记时间',
            }, {
                field: 'id',
                title: 'subSealInfo对象id',
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
                field: 'lawPersonPhone',
                title: '法人联系方式',
                visible: false
            }, {
                field: 'markCompanyAddress',
                title: '制作单位地址',
                visible: false
            }
        ]
    });
}

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