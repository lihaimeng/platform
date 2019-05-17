(function () {
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

    var typeArray = [];//定义一个类型数组
    function initTypeArray(name) {
        this.name = name;
    }

    typeArray.push(new initTypeArray("印章类型"));
    for (var i = 0; i < typeArray.length; i++) {
        var initSelectOption = localStorage.getItem(typeArray[i].name);
        initSelectOption = JSON.parse(initSelectOption);
        if (initSelectOption != null || initSelectOption != "") {
            initSelectOption.forEach(function (item, index) {
                if (typeArray[i].name == "印章类型") {
                    $('#sealType').append("<option value=" + item.name + ">" + item.name + "</option>");
                }
            })

        }
    }


    /*$('#btn_companyMsg1')[0].style.backgroundColor = '#1ab394';
     $("#company2").css("display", 'none');*/
    var companyNum = $('#companyNum').val().trim();
    var companyName = $('#companyName').val().trim();
    var dominion = $('#dominion').val().trim();
    if (dominion == '0') {
        dominion = "";
    }
    var markCompanyName = $('#markCompanyName').val().trim();
    var sealNum = $('#sealNum').val().trim();
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
            'company': companyName,
            'companyId': companyNum,
            'dominionCode': dominion,
            'markCompany': markCompanyName,
            'sealId': sealNum,
            'sealType': sealType,
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
    $('#search_btn').click(function () {
        var companyNum = $('#companyNum').val().trim();
        var companyName = $('#companyName').val().trim();
        var dominion = $('#dominion').val().trim();
        if (dominion == '0') {
            dominion = "";
        }
        var markCompanyName = $('#markCompanyName').val().trim();
        var sealNum = $('#sealNum').val().trim();
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
                'company': companyName,
                'companyId': companyNum,
                'dominionCode': dominion,
                'markCompany': markCompanyName,
                'sealId': sealNum,
                'sealType': sealType,
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

    /**
     * 详情验证选中数据
     */
    $("#btn_Msg").click(function () {
        var data = $("#companyTable").bootstrapTable('getSelections')[0];
        if (typeof(data) != 'undefined') {
            $("#companyNumMsg").html(data.companyId);
            $("#companyNameMsg").html(data.company);
            $("#dominionMsg").html(data.dominion);
            $("#companyTypeMsg").html(data.companyType);
            $("#lawPersonNameMsg").html(data.lawPerson);
            $("#lawPersonIdTypeMsg").html(data.lawPersonCardType);
            $("#lawPersonIdMsg").html(data.lawPersonCard);
            $("#phoneMsg").html(data.lawPersonPhone);
            $("#addressMsg").html(data.companyAddress);
            $("#nameMsg").html(data.operator);
            $("#IdTypeMsg").html(data.operatorCardType);
            $("#IdMsg").html(data.operatorCard);
            $("#markCompanyNumMsg").html(data.markCompanyId);
            $("#markCompanyNameMsg").html(data.markCompany);
            $("#markLawPersonNameMsg").html(data.markLawPerson);
            $("#markLawPersonIdType").html(data.markLawCardType);
            $("#markLawPersonIdMsg").html(data.getMarkLawCard);
            $("#markPhoneMsg").html(data.markPhone);
            $("#markAddressMsg").html(data.markCompanyAddress);
            $.ajax({
                url: '../seal/selectSealInfoByParams',
                type: 'POST',
                contentType: 'application/json;charset=UTF-8',
                data: JSON.stringify({
                    'company': data.company,
                    'companyId': data.companyId
                }),
                success: function (data) {
                    getSealTableData(data);
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

})();

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
    $('#companyTable').bootstrapTable('destroy');
    $('#companyTable').bootstrapTable({
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
                title: '使用单位编号',
            }, {
                field: 'company',
                title: '使用单位名称',
            }, {
                field: 'dominion',
                title: '管辖单位',
            }, {
                field: 'markCompany',
                title: '制作单位名称',
            }, {
                field: 'lawPerson',
                title: '法人姓名',
                visible: false
            },
            {
                field: 'lawPersonCard',
                title: '法人证件号',
                visible: false
            }, {
                field: 'sealId',
                title: '印章编码',
            }, {
                field: 'sealType',
                title: '印章类型',
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

//获取表格数据
function getSealTableData(sealData) {
    for (var i = 0; i < sealData.length; i++) {
        if (sealData[i].sealModel == "00901") {
            sealData[i].sealModel = "30*40";
        } else if (sealData[i].sealModel == "00902") {
            sealData[i].sealModel = "38";
        } else if (sealData[i].sealModel == "00903") {
            sealData[i].sealModel = "18*18";
        } else if (sealData[i].sealModel == "00904") {
            sealData[i].sealModel = "20*20";
        } else if (sealData[i].sealModel == "00905") {
            sealData[i].sealModel = "45*30";
        } else if (sealData[i].sealModel == "00906") {
            sealData[i].sealModel = "45";
        } else if (sealData[i].sealModel == "00907") {
            sealData[i].sealModel = "42";
        } else if (sealData[i].sealModel == "00908") {
            sealData[i].sealModel = "40";
        } else if (sealData[i].sealModel == "00909") {
            sealData[i].sealModel = "20*14";
        }
        if (sealData[i].sealMaterial == "00801") {
            sealData[i].sealMaterial = "铜质章";
        } else if (sealData[i].sealMaterial == "00802") {
            sealData[i].sealMaterial = "橡塑合成章";
        } else if (sealData[i].sealMaterial == "00803") {
            sealData[i].sealMaterial = "牛角";
        } else if (sealData[i].sealMaterial == "00804") {
            sealData[i].sealMaterial = "有机玻璃";
        } else if (sealData[i].sealMaterial == "00805") {
            sealData[i].sealMaterial = "光敏章";
        } else if (sealData[i].sealMaterial == "00806") {
            sealData[i].sealMaterial = "回墨印";
        }
        if (sealData[i].sealShape == "00701") {
            sealData[i].sealShape = "五角星";
        } else if (sealData[i].sealShape == "00702") {
            sealData[i].sealShape = "圆形";
        } else if (sealData[i].sealShape == "00703") {
            sealData[i].sealShape = "椭圆形";
        } else if (sealData[i].sealShape == "00704") {
            sealData[i].sealShape = "长方形";
        } else if (sealData[i].sealShape == "00705") {
            sealData[i].sealShape = "正方形";
        } else if (sealData[i].sealShape == "00799") {
            sealData[i].sealShape = "其他";
        }
        if (sealData[i].sealPattern == "00601") {
            sealData[i].sealPattern = "五角星";
        } else if (sealData[i].sealPattern == "00602") {
            sealData[i].sealPattern = "党徽";
        } else if (sealData[i].sealPattern == "00603") {
            sealData[i].sealPattern = "国徽";
        } else if (sealData[i].sealPattern == "00604") {
            sealData[i].sealPattern = "团徽";
        } else if (sealData[i].sealPattern == "00699") {
            sealData[i].sealPattern = "其他";
        }
        if (sealData[i].sealType == "01001") {
            sealData[i].sealType = "单位专用章";
        } else if (sealData[i].sealType == "01002") {
            sealData[i].sealType = "财务专用章";
        } else if (sealData[i].sealType == "01003") {
            sealData[i].sealType = "税务专用章";
        } else if (sealData[i].sealType == "01004") {
            sealData[i].sealType = "合同专用章";
        } else if (sealData[i].sealType == "01005") {
            sealData[i].sealType = "法人代表用章";
        } else if (sealData[i].sealType == "01006") {
            sealData[i].sealType = "私章";
        }
    }
    $('#sealTable').bootstrapTable('destroy');
    $('#sealTable').bootstrapTable({
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination: true,//是否分页
        data: sealData,
        pageSize: 5,//单页记录数
        pageList: [5],//分页步进值
        columns: [
            {
                field: 'companyId',
                title: '使用单位编号',
                visible: false
            }, {
                field: 'company',
                title: '使用单位名称',
                visible: false
            }, {
                field: 'dominion',
                title: '管辖单位',
                visible: false
            }, {
                field: 'markCompany',
                title: '制作单位名称',
                visible: false
            }, {
                field: 'lawPerson',
                title: '法人姓名',
                visible: false
            },
            {
                field: 'lawPersonCard',
                title: '法人证件号',
                visible: false
            }, {
                field: 'sealId',
                title: '印章编码',
            }, {
                field: 'sealName',
                title: '印章名称'
            }, {
                field: 'sealType',
                title: '印章类型',
            }, {
                field: 'sealShape',
                title: '印章形状',
            }, {
                field: 'sealModel',
                title: '印章规格'
            }, {
                field: 'sealMaterial',
                title: '印章材质'
            }, {
                field: 'sealPattern',
                title: '印章中心图案',
            },
            {
                field: 'registerDate',
                title: '登记时间',
                visible: false
            }, {
                field: 'id',
                title: 'subSealInfo对象id',
                visible: false
            }, {
                field: 'state',
                title: '印章状态',
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