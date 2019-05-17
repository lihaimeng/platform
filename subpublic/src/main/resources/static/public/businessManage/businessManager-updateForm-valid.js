var array;
var nameArr = [];

function clsIDCard(CardNo) {
    this.Valid = false;
    this.ID15 = '';
    this.ID18 = '';
    this.Local = '';
    if (CardNo != null) this.SetCardNo(CardNo);
}

// 设置身份证号码，15位或者18位
clsIDCard.prototype.SetCardNo = function (CardNo) {
    this.ID15 = '';
    this.ID18 = '';
    this.Local = '';
    CardNo = CardNo.replace(" ", "");
    var strCardNo;
    if (CardNo.length == 18) {
        pattern = /^\d{17}(\d|x|X)$/;
        if (pattern.exec(CardNo) == null) return;
        strCardNo = CardNo.toUpperCase();
    } else {
        pattern = /^\d{15}$/;
        if (pattern.exec(CardNo) == null) return;
        strCardNo = CardNo.substr(0, 6) + '19' + CardNo.substr(6, 9);
        strCardNo += this.GetVCode(strCardNo);
    }
    this.Valid = this.CheckValid(strCardNo);
};
// 校验身份证有效性
clsIDCard.prototype.IsValid = function () {
    return this.Valid;
};
// 返回生日字符串，格式如下，1981-10-10
clsIDCard.prototype.GetBirthDate = function () {
    var BirthDate = '';
    if (this.Valid) BirthDate = this.GetBirthYear() + '-' + this.GetBirthMonth() + '-' + this.GetBirthDay();
    return BirthDate;
};
// 返回生日中的年，格式如下，1981
clsIDCard.prototype.GetBirthYear = function () {
    var BirthYear = '';
    if (this.Valid) BirthYear = this.ID18.substr(6, 4);
    return BirthYear;
};
// 返回生日中的月，格式如下，10
clsIDCard.prototype.GetBirthMonth = function () {
    var BirthMonth = '';
    if (this.Valid) BirthMonth = this.ID18.substr(10, 2);
    if (BirthMonth.charAt(0) == '0') BirthMonth = BirthMonth.charAt(1);
    return BirthMonth;
};
// 返回生日中的日，格式如下，10
clsIDCard.prototype.GetBirthDay = function () {
    var BirthDay = '';
    if (this.Valid) BirthDay = this.ID18.substr(12, 2);
    return BirthDay;
};
// 返回性别，1：男，0：女
clsIDCard.prototype.GetSex = function () {
    var Sex = '';
    if (this.Valid) Sex = this.ID18.charAt(16) % 2;
    return Sex;
};
// 返回15位身份证号码
clsIDCard.prototype.Get15 = function () {
    var ID15 = '';
    if (this.Valid) ID15 = this.ID15;
    return ID15;
};
// 返回18位身份证号码
clsIDCard.prototype.Get18 = function () {
    var ID18 = '';
    if (this.Valid) ID18 = this.ID18;
    return ID18;
};
// 返回所在省，例如：上海市、浙江省
clsIDCard.prototype.GetLocal = function () {
    var Local = '';
    if (this.Valid) Local = this.Local;
    return Local;
};
clsIDCard.prototype.GetVCode = function (CardNo17) {
    var Wi = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1];
    var Ai = ['1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'];
    var cardNoSum = 0;
    for (var i = 0; i < CardNo17.length; i++) cardNoSum += CardNo17.charAt(i) * Wi[i];
    var seq = cardNoSum % 11;
    return Ai[seq];
};
clsIDCard.prototype.IsDate = function (strDate) {
    var r = strDate.match(/^(\d{1,4})(\d{1,2})(\d{1,2})$/);
    if (r == null) return false;
    var d = new Date(r[1], r[2] - 1, r[3]);
    return (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[2] && d.getDate() == r[3]);
};
clsIDCard.prototype.CheckValid = function (CardNo18) {
    if (this.GetVCode(CardNo18.substr(0, 17)) != CardNo18.charAt(17)) return false;
    if (!this.IsDate(CardNo18.substr(6, 8))) return false;
    var aCity = {
        11: "北京",
        12: "天津",
        13: "河北",
        14: "山西",
        15: "内蒙古",
        21: "辽宁",
        22: "吉林",
        23: "黑龙江 ",
        31: "上海",
        32: "江苏",
        33: "浙江",
        34: "安徽",
        35: "福建",
        36: "江西",
        37: "山东",
        41: "河南",
        42: "湖北 ",
        43: "湖南",
        44: "广东",
        45: "广西",
        46: "海南",
        50: "重庆",
        51: "四川",
        52: "贵州",
        53: "云南",
        54: "西藏 ",
        61: "陕西",
        62: "甘肃",
        63: "青海",
        64: "宁夏",
        65: "新疆",
        71: "台湾",
        81: "香港",
        82: "澳门",
        91: "国外"
    };
    if (aCity[parseInt(CardNo18.substr(0, 2))] == null) return false;
    this.ID18 = CardNo18;
    this.ID15 = CardNo18.substr(0, 6) + CardNo18.substr(8, 9);
    this.Local = aCity[parseInt(CardNo18.substr(0, 2))];
    return true;
};

function getxzqh(arr, code) {
    var qystr = '';
    var str = code.substring(0, 6);
    find(arr, str);
    nameArr = nameArr.reverse();
    if (nameArr.length > 0) {
        for (var i = 0; i < nameArr.length; i++) {
            qystr += nameArr[i];
        }
    }
    return qystr;
}

find = function (arr, code) {
    for (var x in arr) {
        if (arr[x].code == code) {
            nameArr.push(arr[x].name);
            var parentCode = arr[x].parentCode;
            find(array, parentCode);
            return nameArr;
        } else if (arr[x].children) {
            find(arr[x].children, code);
        }
    }
};
//以下为修改jQuery Validation插件兼容Bootstrap的方法，没有直接写在插件中是为了便于插件升级
$.validator.setDefaults({
    showErrors: function (errorMap, errorList) {
        var msg = "";
        $.each(errorList, function (i, v) {
            msg = (v.message);
            if (msg != "") {
                dangerMsg(msg);
            }
        });

    },


    onkeyup: false,
    onfocusout: false,
    /**
     //失去焦点时校验
     onfocusout: function (element) {
        if (!$(element).valid()) {
            // 自定义错误处理样式，并显示错误消息
            $(element).closest('.form-control').removeClass('has-success').addClass('has-error');
        } else {
            // 验证成功后删除
            $(element).closest('.form-control').removeClass('has-error').addClass('has-success');
        }
    }
     **/

});

$().ready(function () {
    array = window.parent.array;
    nameArr = [];
    $("#securityPersonIdEditMsg").click(function () {
        var value = $('#securityPersonIdEditMsg').val();
        var checkFlag = new clsIDCard(value);
        var values = getxzqh(array, value);
        if (checkFlag.IsValid()) {
            $('#securityJGEditMsg').val(values);
        }
        nameArr = [];
    });
    $("#companyFormForEdit").validate({
        rules: {
            companyNameEdit: {
                required: true,
                chineseName: true
            },
            dominionEdit: {
                required: true,
            },
            companyTypeEdit: {
                required: true,
            },
            lawPersonNameEdit: {
                required: true,
                chineseOrEnglish: true
            },
            lawPersonIDEdit: {
                required: true,
                isCardID: true
            },
            businessNumberEdit: {
                required: true,
                path: true
            },
            phoneEdit: {
                required: true,
                phone: true
            },
            companyAddressEdit: {
                required: true,
                specialCharacter: true
            },
            businessScopeEdit: {
                specialCharacter: true
            }
        },
        messages: {
            companyNameEdit: {
                required: "请输入单位名称",
                chineseName: "请输入中文单位名称"
            },
            dominionEdit: {
                required: "请选择管辖单位",
            },
            companyTypeEdit: {
                required: "请选择企业类型",
            },
            lawPersonNameEdit: {
                required: "请输入法人姓名",
                chineseOrEnglish: "请输入中文或英文法人姓名"
            },
            lawPersonIDEdit: {
                required: "请输入法人证件号",
                isCardID: "请输入正确身份证号"
            },
            businessNumberEdit: {
                required: "请输入营业执照编号",
                path: "营业执照编号必须是数字或英文字符"
            },
            phoneEdit: {
                required: "请输入联系电话",
                phone: "请输入正确联系电话"
            },
            companyAddressEdit: {
                required: "请输入单位地址",
                specialCharacter: "请不要输入特殊字符"
            },
            businessScopeEdit: {
                specialCharacter: "请不要输入特殊字符"
            }
        }
    });
    $('#editSecurityFormMsg').validate({
        rules: {
            securityPersonNameEditMsg: {
                required: true,
                chineseName: true
            },
            securityPersonIdEditMsg: {
                required: true,
                isCardID: true

            },
            securityJGEditMsg: {
                required: true,
                chineseName: true
            },
            securityPersonPhoneEditMsg: {
                required: true,
                phone: true
            },
            securityTCBEditMsg: {
                required: true,
                chineseName: true
            },
            securityPersonTypeEditMsg: {
                required: true
            },
            securityPersonDateEditMsg: {
                required: true
            },
            securityPersonAddressEditMsg: {
                required: true,
                specialCharacter: true
            }
        },
        messages: {
            securityPersonNameEditMsg: {
                required: "请输入安保人员姓名",
                chineseName: "请输入中文姓名"
            },
            securityPersonIdEditMsg: {
                required: "请输入安保人员证件号",
                isCardID: "请输入正确身份证号"
            },
            securityJGEditMsg: {
                required: "请输入安保人员籍贯",
                chineseName: "请输入中文籍贯"
            },
            securityPersonPhoneEditMsg: {
                required: "请输入安保人员联系方式",
                phone: "请输入正确联系电话"
            },
            securityTCBEditMsg: {
                required: "请输入发证机构",
                chineseName: "请输入中文姓名"
            },
            securityPersonTypeEditMsg: {
                required: "请选择保安类型"
            },
            securityPersonDateEditMsg: {
                required: "请输入上岗日期"
            },
            securityPersonAddressEditMsg: {
                required: "请输入地址",
                specialCharacter: "请不要输入特殊字符"
            }
        }
    });
    $('#editMonitoringFormMsg').validate({
        rules: {
            monitoringNameEditMsg: {
                required: true,
                chineseName: true
            },
            monitoringManufacturerEditMsg: {
                required: true,
                specialCharacter: true
            },
            monitoringModelEditMsg: {
                required: true,
                path: true
            },
            monitoringDetectionNameEditMsg: {
                chineseOrEnglish: true
            },
            monitoringNetworkTypeEditMsg: {
                required: true,
                chineseOrEnglish: true
            },
            monitoringNumberEditMsg: {
                required: true,
                number: true
            },
            isVideoEditMsg: {
                required: true
            },
            IPAddressEditMsg: {
                required: true,
                ipv4: true

            }
        },
        messages: {
            monitoringNameEditMsg: {
                required: "请输入设备名称",
                chineseName: "请输入中文设备名称"
            },
            monitoringManufacturerEditMsg: {
                required: "请输入生产厂商",
                specialCharacter: "请不要输入特殊字符"
            },
            monitoringModelEditMsg: {
                required: "请输入规格型号",
                path: "规格型号编号必须是数字或英文字符"
            },
            monitoringDetectionNameEditMsg: {
                chineseOrEnglish: "请输入中文或英文检测机构名称"
            },
            monitoringNetworkTypeEditMsg: {
                required: "请输入网络传输类型",
                chineseOrEnglish: "请输入中文或英文网络传输类型"
            },
            monitoringNumberEditMsg: {
                required: "请输入设备数量",
                number: "请输入数字"
            },
            isVideoEditMsg: {
                required: "请选择是否录像"
            },
            IPAddressEditMsg: {
                required: "请输入IP地址",
                ipv4: "请输入正确IPv4地址"
            }
        }
    });
    $('#editTechnicalFormMsg').validate({
        rules: {
            technicalNameEditMsg: {
                required: true,
                chineseName: true
            },
            technicalModelEditMsg: {
                required: true,
                path: true
            },
            technicalTypeEditMsg: {
                required: true,
            },
            technicalNumberEditMsg: {
                required: true,
                number: true
            }
        },
        messages: {
            technicalNameEditMsg: {
                required: "请输入设备名称",
                chineseName: "请输入中文设备名称"
            },
            technicalModelEditMsg: {
                required: "请输入规格型号",
                path: "规格型号编号必须是数字或英文字符"
            },
            technicalTypeEditMsg: {
                required: "请选择种类",
            },
            technicalNumberEditMsg: {
                required: "请输入数量",
                number: "请输入数字"
            }
        }
    });

    //修改功能下的新增
    $('#editSecurityForm').validate({
        rules: {
            securityPersonNameEdit: {
                required: true,
                chineseName: true
            },
            securityPersonIdEdit: {
                required: true,
                isCardID: true

            },
            securityJGEdit: {
                required: true,
                chineseName: true
            },
            securityPersonPhoneEdit: {
                required: true,
                phone: true
            },
            securityTCBEdit: {
                required: true,
                chineseName: true
            },
            securityPersonTypeEdit: {
                required: true
            },
            securityPersonDateEdit: {
                required: true
            },
            securityPersonAddressEdit: {
                required: true,
                specialCharacter: true
            }
        },
        messages: {
            securityPersonNameEdit: {
                required: "请输入安保人员姓名",
                chineseName: "请输入中文姓名"
            },
            securityPersonIdEdit: {
                required: "请输入安保人员证件号",
                isCardID: "请输入正确身份证号"
            },
            securityJGEdit: {
                required: "请输入安保人员籍贯",
                chineseName: "请输入中文籍贯"
            },
            securityPersonPhoneEdit: {
                required: "请输入安保人员联系方式",
                phone: "请输入正确联系电话"
            },
            securityTCBEdit: {
                required: "请输入发证机构",
                chineseName: "请输入中文姓名"
            },
            securityPersonTypeEdit: {
                required: "请选择保安类型"
            },
            securityPersonDateEdit: {
                required: "请输入上岗日期"
            },
            securityPersonAddressEdit: {
                required: "请输入地址",
                specialCharacter: "请不要输入特殊字符"
            }
        }
    });
    $('#editMonitoringForm').validate({
        rules: {
            monitoringNameEdit: {
                required: true,
                chineseName: true
            },
            monitoringManufacturerEdit: {
                required: true,
                specialCharacter: true
            },
            monitoringModelEdit: {
                required: true,
                path: true
            },
            monitoringDetectionNameEdit: {
                chineseOrEnglish: true
            },
            monitoringNetworkTypeEdit: {
                required: true,
                chineseOrEnglish: true
            },
            monitoringNumberEdit: {
                required: true,
                number: true
            },
            isVideoEdit: {
                required: true
            },
            IPAddressEdit: {
                required: true,
                ipv4: true

            }
        },
        messages: {
            monitoringNameEdit: {
                required: "请输入设备名称",
                chineseName: "请输入中文设备名称"
            },
            monitoringManufacturerEdit: {
                required: "请输入生产厂商",
                specialCharacter: "请不要输入特殊字符"
            },
            monitoringModelEdit: {
                required: "请输入规格型号",
                path: "规格型号编号必须是数字或英文字符"
            },
            monitoringDetectionNameEdit: {
                chineseOrEnglish: "请输入中文或英文检测机构名称"
            },
            monitoringNetworkTypeEdit: {
                required: "请输入网络传输类型",
                chineseOrEnglish: "请输入中文或英文网络传输类型"
            },
            monitoringNumberEdit: {
                required: "请输入设备数量",
                number: "请输入数字"
            },
            isVideoEdit: {
                required: "请选择是否录像"
            },
            IPAddressEdit: {
                required: "请输入IP地址",
                ipv4: "请输入正确IPv4地址"
            }
        }
    });
    $('#editTechnicalForm').validate({
        rules: {
            technicalNameEdit: {
                required: true,
                chineseName: true
            },
            technicalModelEdit: {
                required: true,
                path: true
            },
            technicalTypeEdit: {
                required: true,
            },
            technicalNumberEdit: {
                required: true,
                number: true
            }
        },
        messages: {
            technicalNameEdit: {
                required: "请输入设备名称",
                chineseName: "请输入中文设备名称"
            },
            technicalModelEdit: {
                required: "请输入规格型号",
                path: "规格型号编号必须是数字或英文字符"
            },
            technicalTypeEdit: {
                required: "请选择种类",
            },
            technicalNumberEdit: {
                required: "请输入数量",
                number: "请输入数字"
            }
        }
    });
    //文件上传校验
    $('#roleFormForEdit').validate({
        rules: {
            businessLicenseEdit: {
                required: true,
                specialCharacterExceptSpot: true
            },
            lawPersonNumIdEdit: {
                required: true,
                specialCharacterExceptSpot: true
            },
            businessPermitsEdit: {specialCharacterExceptSpot: true},
            companyShapeEdit: {specialCharacterExceptSpot: true},
            placeProveEdit: {specialCharacterExceptSpot: true},
            othersEdit: {specialCharacterExceptSpot: true}
        },
        messages: {
            businessLicenseEdit: {
                required: "请上传营业执照文件",
                specialCharacterExceptSpot: "请不要输入除.以外的特殊字符"
            },
            lawPersonNumIdEdit: {
                required: "请上传法人身份证文件",
                specialCharacterExceptSpot: "请不要输入除.以外的特殊字符"
            },
            businessPermitsEdit: {specialCharacterExceptSpot: "请不要输入除.以外的特殊字符"},
            companyShapeEdit: {specialCharacterExceptSpot: "请不要输入除.以外的特殊字符"},
            placeProveEdit: {specialCharacterExceptSpot: "请不要输入除.以外的特殊字符"},
            othersEdit: {specialCharacterExceptSpot: "请不要输入除.以外的特殊字符"}
        }
    });
    //新添加的校验方法
    jQuery.validator.addMethod("number", function (value, element) {
        var number = /^[0-9]+.?[0-9]*$/;
        return this.optional(element) || (number.test(value));
    }, "请输入数字");
    jQuery.validator.addMethod("numberRange", function (value, element) {
        var number = /^100$|^(\d|[1-9]\d)(\.\d+)*$/;
        return this.optional(element) || (number.test(value));
    }, "请输入合理的数字范围（0-100）");
    jQuery.validator.addMethod("chineseName", function (value) {
        var p = /^[\u4E00-\u9FA5]+$/;
        return p.exec(value) ? true : false;
    }, "请输入中文名称");
    jQuery.validator.addMethod("chineseOrEnglish", function (value, element) {
        var chineseOrEnglish = /^[a-zA-Z\u4e00-\u9fa5]+$/;
        return this.optional(element) || (chineseOrEnglish.test(value));
    }, "请输入中文或英文名称");
    jQuery.validator.addMethod("isCardID", function (value, element) {
        var checkFlag = new clsIDCard(value);
        return this.optional(element) || checkFlag.IsValid();
    }, "请输入正确的身份证号");
    jQuery.validator.addMethod("path", function (value) {
        var p = /^[0-9a-zA-Z]+$/;
        return p.exec(value) ? true : false;
    }, "Please enter only letters and digits");
    jQuery.validator.addMethod("phone", function (value) {
        var p = /^\s*(13[0-9]|15[0|1|2|3|5|6|7|8|9]|18[0-9]|14[5|7])\d{8}\s*$/;
        if (p.exec(value)) {
            return true;
        } else {
            p = /^\s*((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?\s*$/;
            if (p.exec(value)) {
                return true;
            }
            else {
                return false;
            }
        }
    }, "请输入正确的手机号");
    jQuery.validator.addMethod("specialCharacter", function (value, element) {
        var specialCharacter = /[`~!@#$%^&*()_\-+=<>?:"{}|,.\/;'\\[\]·~！@#￥%……&*（）——\-+={}|《》？：“”【】、；‘’，。、]/im;
        return this.optional(element) || (!specialCharacter.test(value));
    }, "请不要输入特殊字符");
    jQuery.validator.addMethod("ipv4", function (value, element) {
        var ipv4 = /(?=(\b|\D))(((\d{1,2})|(1\d{1,2})|(2[0-4]\d)|(25[0-5]))\.){3}((\d{1,2})|(1\d{1,2})|(2[0-4]\d)|(25[0-5]))(?=(\b|\D))/;
        return this.optional(element) || (ipv4.test(value));
    }, "请不要输入特殊字符");
});