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
    $("#roleFormForAdd").validate({
        rules: {
            roleName: {
                required: true,
                chineseOrEnglish: true  //与下面的param_value 相对应
            },
            description: {
                required: true,
                minlength: 2  //与下面的param_value 相对应
            }
        },
        messages: {
            roleName: {
                required: icon + "请输入角色名称",
                chineseOrEnglish: icon + "请输入中文或英文名称"
            },
            description: {
                required: icon + "请输入角色描述",
                minlength: icon + "角色描述必须两个字符以上"
            }
        }
    });
    $("#roleFormForEdit").validate({
        rules: {
            roleNameForEdit: {
                required: true,
                chineseOrEnglish: true  //与下面的param_value 相对应
            },
            descriptionForEdit: {
                required: true,
                minlength: 2  //与下面的param_value 相对应
            }
        },
        messages: {
            roleNameForEdit: {
                required: icon + "请输入角色名称",
                chineseOrEnglish: icon + "请输入中文或英文名称"
            },
            descriptionForEdit: {
                required: icon + "请输入角色描述",
                minlength: icon + "角色描述必须两个字符以上"
            }
        }
    });
    jQuery.validator.addMethod("chineseOrEnglish", function (value, element) {
        var chineseOrEnglish = /^[a-zA-Z\u4e00-\u9fa5]+$/;
        return this.optional(element) || (chineseOrEnglish.test(value));
    }, "请输入中文或英文名称");
});
