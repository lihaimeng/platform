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
    }, icon + "菜单名称不允许包含特殊符号!");
    $("#PermissionForm").validate({
        rules: {
            name1: {
                required: true,
                stringCheck: true
            },
            orderby1: {
                required: true,
                digits: true
            }
        },
        messages: {
            name1: {
                required: icon + "请输入您的菜单名称"
            },
            orderby1: {
                required: icon + "请输入您的排列序号",
                digits: icon + "请输入大于0的整数"
            }
        }
    });

    //用户修改表单验证
    $("#updateForm").validate({
        rules: {
            name2: {
                required: true,
                stringCheck: true
            },
            orderby2: {
                required: true,
                digits: true
            }
        },
        messages: {
            name2: {
                required: icon + "请输入您的菜单名称"
            },
            orderby2: {
                required: icon + "请输入您的排列序号",
                digits: icon + "请输入大于0的整数"
            }
        }
    });


});
