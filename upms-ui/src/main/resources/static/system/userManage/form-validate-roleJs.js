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
    jQuery.validator.addMethod("stringCheck", function (value, username) {
        return this.optional(username) || /^[\u4E00-\u9FA5A-Za-z0-9]+$/.test(value);
    }, icon + "登录账号不允许包含特殊符号!");
    jQuery.validator.addMethod("string", function (value, element) {
        return this.optional(element) || /^[\u4E00-\u9FA5A-Za-z0-9]+$/.test(value);
    }, icon + "用户姓名不允许包含特殊符号!");
    // 手机号码验证
    jQuery.validator.addMethod("isMobile", function (value, element) {
        var length = value.length;
        var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, icon + "请正确填写您的手机号码");
    $("#addUserForm").validate({
        rules: {
            username: {
                required: true,
                stringCheck: true
            },

            email: {
                required: true,
                email: true
            },
            realname: {
                required: true,
                minlength: 2,
                string: true
            },
            phone: {
                required: true,
                isMobile: true
            }
        },
        messages: {
            username: {
                required: icon + "请输入您的登录账号"
            },
            email: {
                required: icon + "请输入您的邮箱",
                email: icon + "请输入正确的邮箱格式如123456@qq.com"
            },
            realname: {
                required: icon + "请输入您的真实姓名",
                minlength: "用户名不得少于2个字符!"
            },
            phone: {
                required: icon + "请输入您的联系方式"
            }
        }
    });

    //用户修改表单验证
    $("#userUpdateForm").validate({
        rules: {
            username2: {
                required: true,
                stringCheck: true
            },

            email2: {
                required: true,
                email: true
            },
            realname2: {
                required: true,
                minlength: 2,
                string: true
            },
            phone2: {
                required: true,
                isMobile: true
            }
        },
        messages: {
            username2: {
                required: icon + "请输入您的登录账号"
            },
            email2: {
                required: icon + "请输入您的邮箱",
                email: icon + "请输入正确的邮箱格式如123456@qq.com"
            },
            realname2: {
                required: icon + "请输入您的真实姓名",
                minlength: icon + "用户名不得少于2个字符!"
            },
            phone2: {
                required: icon + "请输入您的联系方式"
            }
        }
    });


});
