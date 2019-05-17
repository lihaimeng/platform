//以下为修改jQuery Validation插件兼容Bootstrap的方法，没有直接写在插件中是为了便于插件升级
$.validator.setDefaults({
    highlight: function (element) {
        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
    },
    success: function (element) {
        element.closest('.form-group').removeClass('has-error').addClass('has-success');
    },
    errorElement: "span",
    onkeyup: false,
    errorPlacement: function (error, element) {
        error.css({'margin-top': '-1px', 'margin-bottom': '-17px'});
        if (element.is(":radio") || element.is(":checkbox")) {
            error.appendTo(element.parent().parent().parent());
        } else {
            error.appendTo(element.parent());
        }
    },
    errorClass: "help-block m-b-none",
    validClass: "help-block m-b-none"


});

$().ready(function () {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules: {
            code: {
                required: true,
                numberOrEnglish: true //与下面的param_value 相对应
                /* remote: {                                          //验证用户名是否存在
                     type: "POST",
                     url: "loginVerifyAction",             //servlet
                     data: {
                         code: function () {
                             return $("#code").val();
                         }
                     }
                 }*/
            },
            param_name: {
                required: true,
                chineseOrEnglish: true  //与下面的param_value 相对应
            },
            param_value: {
                required: true,
                specialCharacter: true
            }
        },
        messages: {
            code: {
                required: icon + "请输入参数编码",
                numberOrEnglish: icon + "请输入数字或英文字母",
                //remote: jQuery.format("参数编码已经存在")
            },
            param_name: {
                required: icon + "请输入参数名称",
                chineseOrEnglish: icon + "请输入中文或英文名称"
            },
            param_value: {
                required: icon + "请输入参数值",
                specialCharacter: icon + "请不要输入特殊字符"
            }
        }
    });
    $("#signupFormForEdit").validate({
        rules: {
            codeForEdit: {
                required: true,
                numberOrEnglish: true  //与下面的param_value 相对应
            },
            param_nameForEdit: {
                required: true,
                chineseOrEnglish: true  //与下面的param_value 相对应
            },
            param_valueForEdit: {
                required: true,
                specialCharacter: true  //与下面的param_value 相对应
            }
        },
        messages: {
            codeForEdit: {
                required: icon + "请输入参数编码",
                numberOrEnglish: icon + "请输入数字或英文字母"
            },
            param_nameForEdit: {
                required: icon + "请输入参数名称",
                chineseOrEnglish: icon + "请输入中文或英文名称"
            },
            param_valueForEdit: {
                required: icon + "请输入参数值",
                specialCharacter: icon + "请不要输入特殊字符"
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
    jQuery.validator.addMethod("numberOrEnglish", function (value, element) {
        var numberOrEnglish = /^[0-9a-zA-Z]+$/;
        return this.optional(element) || (numberOrEnglish.test(value));
    }, "请输入数字或英文字母");
    jQuery.validator.addMethod("specialCharacter", function (value, element) {
        var specialCharacter = /[`~!@#$%^&*()_\-+=<>?:"{}|,.\/;'\\[\]·~！@#￥%……&*（）——\-+={}|《》？：“”【】、；‘’，。、]/im;
        return this.optional(element) || (!specialCharacter.test(value));
    }, "请不要输入特殊字符");
});
