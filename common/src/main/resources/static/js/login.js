// Checkbix.init();
$(function () {
    // 点击登录按钮
    $('#login-bt').click(function () {
        if ($('#username').val() == "" || $('#password').val() == "") {
            dangerMsg("用户名和密码不能为空");
            return;
        }
        login();
    });
    // 回车事件
    $('#username, #password').keypress(function (event) {
        if (13 == event.keyCode) {
            login();
        }
    });
});

// 登录
function login() {
    $.ajax({
        url: 'user/userlogin',
        type: 'POST',
        data: {
            username: $('#username').val(),
            password: $('#password').val()
        },
        success: function (json) {

            if (json.code == 1) {
                 location.href = 'main';
               //  console.log(location)
               //  location.href = '/unlock';
            } else {
                dangerMsg('用户名密码错误');
                $('#username').focus();
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
}

/*错误提示信息*/
function dangerMsg(data) {
    //e.preventDefault();
    $.smkAlert({
        text: data,
        type: 'danger',
        position: 'top-center',
        time: 2
    });
}