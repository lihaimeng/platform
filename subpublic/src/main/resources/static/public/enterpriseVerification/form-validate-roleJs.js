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
    $("#addUserForm").validate({
        rules: {
            username: "required",

            password: {
                required: true,
                minlength: 6  //与下面的param_value 相对应
            },
            email: {
                required: true,
                email: true
            },
            realname: "required",
            phone: "required"
        },
        messages: {
            username: icon + "请输入您的名称",
            password: {
                required: icon + "请设置用户密码",
                minlength: icon + "密码长度不小于6位",
            },
            email: icon + "请输入您的E-mail",
            realname: icon + "请输入您的真实姓名",
            phone: icon + "请输入您的联系方式",
        }
    });

    //用户修改表单验证
    $("#userUpdateForm").validate({
        rules: {
            username2: "required",
            email2: {
                required: true,
                email: true
            },
            realname2: "required",
            phone2: "required"
        },
        messages: {
            username2: icon + "请输入您的名称",
            email2: icon + "请输入您的E-mail",
            realname2: icon + "请输入您的真实姓名",
            phone2: icon + "请输入您的联系方式",
        }
    });


});
