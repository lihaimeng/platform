//身份证校验相关Begin
var array;
var nameArr = [];
$(document).ready(function () {
    array = window.parent.array;
    nameArr = [];
    //新增时证件号码验证
    $("#cyzj").change(function (e) {
        var cyzj = $('#cyzj option:selected').text().trim();
        if ('身份证' == cyzj) {
            $("#zjhm").addClass('isCardID');
        } else {
            $("#zjhm").removeClass('isCardID');
        }
    });
    $("#zjhm").blur(function () {
        var value = $('#zjhm').val();
        var checkFlag = new clsIDCard(value);
        var values = getxzqh(array, value);
        if (checkFlag.IsValid()) {
            $('#hjdxz').val(values);
            $('#xb').val(checkFlag.GetSex() == 0 ? '00302' : '00301');
        }
        nameArr = [];
    });

    //修改时证件号码验证
    $("#cyzjxg").change(function (e) {
        var cyzj = $('#cyzjxg option:selected').text().trim();
        if ('身份证' == cyzj) {
            $("#zjhmxg").addClass('isCardID');
        } else {
            $("#zjhmxg").removeClass('isCardID');
        }
    });
    $("#zjhmxg").blur(function () {
        var value = $('#zjhmxg').val();
        var checkFlag = new clsIDCard(value);
        var values = getxzqh(array, value);
        if (checkFlag.IsValid()) {
            $('#hjdxzxg').val(values);
            $('#xbxg').val(checkFlag.GetSex() == 0 ? '00302' : '00301');
        }
        nameArr = [];
    });

});
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
clsIDCard.prototype.IsDate = function (strDate) {
    var r = strDate.match(/^(\d{1,4})(\d{1,2})(\d{1,2})$/);
    if (r == null) return false;
    var d = new Date(r[1], r[2] - 1, r[3]);
    return (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[2] && d.getDate() == r[3]);
};
//身份证校验相关END

//以下为修改jQuery Validation插件兼容Bootstrap的方法，没有直接写在插件中是为了便于插件升级
$.validator.setDefaults({
    showErrors: function (errorMap, errorList) {
        var msg = "";
        $.each(errorList, function (i, v) {
            msg += (v.message);
        });
        if (msg != "") warnningMsg(msg);
    },
    //失去焦点时校验
    onkeyup: false,
    /**  onfocusout: function (element) {
        if (!$(element).valid()) {
            // 自定义错误处理样式，并显示错误消息
            $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
        } else {
            // 验证成功后删除
            $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
        }
    }
     **/
});

$().ready(function () {
    $("#addForm").validate({
        rules: {
            xm: {
                required: true,
                chineseOrEnglish: true  //与下面的param_value 相对应
            },
            xb: {
                required: true
            },
            minzu: {
                required: true
            },
            cyzj: {
                required: true
            },
            zjhm: {
                required: true,
                zjhm: true
            },
            whcd: {
                required: true
            },
            roleName: {
                required: true
            },
            /*rzrq: {
                required: true,
                minlength: 2  //与下面的param_value 相对应
            },*/
            lxdh: {
                required: true,
                phone: true  //与下面的param_value 相对应
            },
            hjdxz: {
                specialCharacter: true  //与下面的param_value 相对应
            },
            xzdxzqh: {
                specialCharacter: true  //与下面的param_value 相对应
            }
        },
        messages: {
            xm: {
                required: "请输入人员姓名",
                chineseOrEnglish: "请输入中文或英文名称"
            },
            xb: {
                required: "请输入性别"
            },
            minzu: {
                required: "请输入民族"
            },
            cyzj: {
                required: "请输入证件类型"
            },
            zjhm: {
                required: "请输入证件号码",
                zjhm: "证件号码必须是数字或英文字符",
            },
            whcd: {
                required: "请输入文化程度"
            },
            roleName: {
                required: "请输入角色"
            },
            /*rzrq:{
                required:"请输入入职日期",
                minlength:"入职日期必须两个字符以上"
            },*/
            lxdh: {
                required: "请输入联系方式",
                phone: "请输入正确的联系电话"
            },
            hjdxz: {
                specialCharacter: "请不要输入特殊字符"
            },
            xzdxzqh: {
                specialCharacter: "请不要输入特殊字符"
            }
        }
    });
    $("#editForm").validate({
        rules: {
            cyrybhxg: {
                required: true
                /*remote:{                                          //验证用户名是否存在
                      type:"POST",
                      url:"loginVerifyAction",             //servlet
                      data:{
                          code:function(){return $("#code").val();}
                      }
                     }*/
            },
            xmxg: {
                required: true,
                chineseOrEnglish: true  //与下面的param_value 相对应
            },
            xbxg: {
                required: true
            },
            minzuxg: {
                required: true
            },
            cyzjxg: {
                required: true
            },
            zjhmxg: {
                required: true,
                zjhm: true  //与下面的param_value 相对应
            },
            whcdxg: {
                required: true
            },
            /*rzrqxg: {
                required: true,
                minlength: 2  //与下面的param_value 相对应
            },*/
            cyryztxg: {
                required: true
            },
            roleNamexg: {
                required: true
            },
            lxdhxg: {
                required: true,
                phone: true  //与下面的param_value 相对应
            },
            hjdxzxg: {
                specialCharacter: true
            },
            xzdxzqhxg: {
                specialCharacter: true
            }
        },
        messages: {
            cyrybhxg: {
                required: "请输入人员编号",
                //remote:jQuery.format("参数编码已经存在")
            },
            xmxg: {
                required: "请输入人员姓名",
                chineseOrEnglish: "请输入中文或英文名称"
            },
            xbxg: {
                required: "请输入性别"
            },
            minzuxg: {
                required: "请输入民族"
            },
            cyzjxg: {
                required: "请输入证件类型"
            },
            zjhmxg: {
                required: "请输入证件号码",
                zjhm: "证件号码必须是数字或英文字符"
            },
            whcdxg: {
                required: "请输入文化程度"
            },
            /*rzrqxg:{
                required:"请输入入职日期",
                minlength:"入职日期必须两个字符以上"
            },*/
            cyryztxg: {
                required: "请输入人员状态"
            },
            roleNamexg: {
                required: "请输入角色"
            },
            lxdhxg: {
                required: "请输入联系方式",
                phone: "请输入正确的联系电话"
            },
            hjdxzxg: {
                specialCharacter: "请不要输入特殊字符"
            },
            xzdxzqhxg: {
                specialCharacter: "请不要输入特殊字符"
            }
        }
    });
    jQuery.validator.addMethod("chineseOrEnglish", function (value, element) {
        var chineseOrEnglish = /^[a-zA-Z\u4e00-\u9fa5]+$/;
        return this.optional(element) || (chineseOrEnglish.test(value));
    }, "请输入中文或英文名称");
    jQuery.validator.addMethod("number", function (value, element) {
        var number = /^\+?[1-9]\d*$/;
        return this.optional(element) || (number.test(value));
    }, "请输入数字（数字必须是正整数）");
    jQuery.validator.addMethod("isCardID", function (value, element) {
        var checkFlag = new clsIDCard(value);
        return this.optional(element) || checkFlag.IsValid();
    }, "请输入正确的身份证号");
    //验证手机号
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
    jQuery.validator.addMethod("zjhm", function (value) {
        var p = /^[0-9a-zA-Z]+$/;
        return p.exec(value) ? true : false;
    }, "Please enter only letters and digits");
    jQuery.validator.addMethod("specialCharacter", function (value, element) {
        var specialCharacter = /[`~!@#$%^&*()_\-+=<>?:"{}|,.\/;'\\[\]·~！@#￥%……&*（）——\-+={}|《》？：“”【】、；‘’，。、]/im;
        return this.optional(element) || (!specialCharacter.test(value));
    }, "请不要输入特殊字符");
});
