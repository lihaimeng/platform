//以下为修改jQuery Validation插件兼容Bootstrap的方法，没有直接写在插件中是为了便于插件升级
$.validator.setDefaults({
    showErrors: function (errorMap, errorList) {
        var msg = "";
        $.each(errorList, function (i, v) {
            msg += (v.message);
        });
        if (msg != "") warnningMsg(msg);
    },
    onkeyup: false,
    /**
     //失去焦点时校验
     onfocusout: function(element) {
        if(! $(element).valid()) {
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

    //处理表单验证
    $("#editForm").validate({
        rules: {
            cljg: {
                required: true
            }
        },
        messages: {
            cljg: {
                required: "请输入处理结果"
            }
        }
    });
});
