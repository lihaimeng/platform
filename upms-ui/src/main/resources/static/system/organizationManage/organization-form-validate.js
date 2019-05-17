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
    $("#organizationFormAdd").validate({
        rules: {
            name: {
                required: true,
                chinese: true
            },
            code: {
                required: true,
                digits: true,
                maxlength: 6,
                minlength: 6
            },
            description: {
                required: true,
                chinese: true
            }
        },
        messages: {
            name: {
                required: icon + "请输入机构名称"
            },
            code: {
                required: icon + "请输入机构编码",
                digits: icon + "机构编码必须为数字",
                maxlength: icon + "机构编码必须为六位数",
                minlength: icon + "机构编码必须为六位数"
            },
            description: {
                required: icon + "请输入机构描述"
            }
        }
    });
    $("#organizationFormEdit").validate({
        rules: {
            nameEdit: "required",
            codeEdit: {
                required: true,
                digits: true,
                maxlength: 6,
                minlength: 6
            },
            descriptionEdit: {
                required: true,
                chinese: true
            }
        },
        messages: {
            nameEdit: icon + "机构名称不能为空",
            codeEdit: {
                required: icon + "预留编号不能为空",
                digits: icon + "机构编码必须为数字",
                maxlength: icon + "机构编码必须为六位数",
                minlength: icon + "机构编码必须为六位数"
            },
            descriptionEdit: {
                required: icon + "机构描述不能为空"
            }
        }
    });
    jQuery.validator.addMethod("chinese", function (value, element) {
        var tel = /^[\u4E00-\u9FFF]+$/;
        return this.optional(element) || (tel.test(value));
    }, "机构名称只能为汉字");
});
