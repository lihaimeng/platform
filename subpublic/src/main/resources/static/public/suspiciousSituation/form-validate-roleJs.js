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
    $("#addForm").validate({
        rules: {
            kyqklx3: {
                required: true
            },
            tbnr3: {
                required: true
            }
        },
        messages: {
            kyqklx3: {
                required: "请选择可疑情况类型"
            },
            tbnr3: {
                required: "请输入填报内容"
            }
        }
    });

    //修改表单验证
    $("#editForm").validate({
        rules: {
            kyqklx4: {
                required: true
            },
            tbnr4: {
                required: true
            }
        },
        messages: {
            kyqklx4: {
                required: "请选择可疑情况类型"
            },
            tbnr4: {
                required: "请输入可疑情况详情描述"
            }
        }
    });


});
