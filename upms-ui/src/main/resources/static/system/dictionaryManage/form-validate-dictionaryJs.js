//以下为修改jQuery Validation插件兼容Bootstrap的方法，没有直接写在插件中是为了便于插件升级
$.validator.setDefaults({
    showErrors: function (errorMap, errorList) {
        var msg = "";
        $.each(errorList, function (i, v) {
            msg = (v.message);
            if (msg != "") {
                warnningMsg(msg);
                return false;
            }
        });
    },
    onkeyup: false,
    onfocusout: false,
    /**
     //失去焦点时校验
     onfocusout: function(element) {
        if(! $(element).valid()) {
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
    $("#PermissionForm").validate({
        rules: {
            dicNameAdd: {
                required: true,
                chineseOrEnglish: true
            },
            dicCodeAdd: {
                required: true,
                number: true
            },
            orderbyAdd: {
                number: true
            }
        },
        messages: {
            dicNameAdd: {
                required: "请输入名称",
                chineseOrEnglish: "请输入中文或英文名称"
            },
            dicCodeAdd: {
                required: "请输入编号",
                number: "请输入正整数"
            },
            orderbyAdd: {
                number: "请输入正整数"
            }
        }
    });
    $("#dictionaryFormEdit").validate({
        rules: {
            dicNameEdit: {
                required: true,
                chineseOrEnglish: true
            },
            dicCodeEdit: {
                required: true,
                number: true
            },
            orderbyEdit: {
                number: true
            }
        },
        messages: {
            dicNameEdit: {
                required: "请输入名称",
                chineseOrEnglish: "请输入中文或英文名称"
            },
            dicCodeEdit: {
                required: "请输入编号",
                number: "请输入正整数"
            },
            orderbyEdit: {
                number: "请输入正整数"
            }
        }
    });
    jQuery.validator.addMethod("chineseOrEnglish", function (value, element) {
        var chineseOrEnglish = /^[a-zA-Z\u4e00-\u9fa5]+$/;
        return this.optional(element) || (chineseOrEnglish.test(value));
    }, "请输入中文或英文名称");
    jQuery.validator.addMethod("number", function (value, element) {
        var number = /^[0-9]+.?[0-9]*$/;
        return this.optional(element) || (number.test(value));
    }, "请输入正整数");
    jQuery.validator.addMethod("numberRange", function (value, element) {
        var number = /^100$|^(\d|[1-9]\d)(\.\d+)*$/;
        return this.optional(element) || (number.test(value));
    }, "请输入合理的数字范围（0-100）");
});

function warnningMsg(data) {
    $.smkAlert({
        text: data,
        type: 'warning',
        position: 'top-center',
        time: 1
    });
}