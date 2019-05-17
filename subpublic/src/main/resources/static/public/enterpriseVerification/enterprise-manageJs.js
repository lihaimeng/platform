(function () {

    /**
     * 表单关闭清空数据
     */
    $('.closeBtn').click(function () {
        $("#addUserForm")[0].reset();
        $('.form-group').removeClass('has-error');
        $('#username-error')[0].style.display = 'none';
        $('#password-error')[0].style.display = 'none';
        $('#email-error')[0].style.display = 'none';
        $('#realname-error')[0].style.display = 'none';
        $('#phone-error')[0].style.display = 'none';
    });
    /**********************
     *修改用户
     **********************/
    $("#updateUswwwer1").click(function () {
        //从表格中获取选中的对象
        var roleObj = getSelectedItem();
        var id = roleObj.userId;
        var username = $("#username2").val();
        var email = $("#email2").val();
        var realname = $("#realname2").val();
        var phone = $("#phone2").val();
        var requestData = JSON.stringify({
            'userId': id,
            'username': username,
            'email': email,
            'realname': realname,
            'phone': phone
        });
        if ($("#userUpdateForm").valid()) {	//表单验证
            $.ajax({
                url: "../../user/update",
                contentType: "application/json;charset=UTF-8",
                type: "post",
                data: requestData,
                success: function (data) {
                    var msg = data.result;
                    if (msg == "修改成功") {
                        successMsg(data.result);
                        $('.closeBtn1').click();
                        $('.jstree-clicked').click();
                    } else {
                        dangerMsg(data.result);

                    }
                },
                error: function (data) {
                    dangerMsg(data.result);
                }
            });
        }
    });
    /**********************
     *修改角色
     **********************/
    $("#characterSet1").click(function () {
        var sel = document.getElementById("roleSet");
        var roleId = sel.options[sel.selectedIndex].value;
        var userId = getSelectedItem().userId;
        var requestData = JSON.stringify({
            'roleId': roleId,
            'userId': userId,
        });
        $.ajax({
            url: "../../user/updateUserRole",
            contentType: "application/json;charset=UTF-8",
            type: "post",
            data: requestData,
            success: function (data) {
                var msg = data.result;
                if (msg == "修改成功") {
                    successMsg(data.result);
                    $('.closeBtn2').click();
                    $('.jstree-clicked').click();
                } else {
                    dangerMsg(data.result);

                }
            },
            error: function (data) {
                dangerMsg(data.result);
            }
        });
    });

})();


/**********************
 *判断复选框选择个数，用于修改(有且只有一个复选框被选中)
 **********************/
var getSelectedNumber = function () {
    var array = $('#exampleTableEvents').bootstrapTable('getSelections');
    if (array.length != 1) {
        warnningMsg("请选择一条数据！");
        $("#updateU").attr("data-target", "");
        return false;
    } else {
        return true;
    }
};
/**********************
 *提取选择数据,用于修改
 **********************/
var getSelectedItem = function () {
    var array = $('#exampleTableEvents').bootstrapTable('getSelections');
    return array[0];
};

/**********************
 *为修改弹出框赋值
 **********************/
function userSetValueForInput() {
    if (getSelectedNumber()) {
        $("#updateU").attr("data-target", "#myModal5");
        var parameterObj = getSelectedItem();
        var username = parameterObj.username;
        var email = parameterObj.email;
        var realname = parameterObj.realname;
        var phone = parameterObj.phone;
        $('input[name=username2]').val(username);
        $('input[name=email2]').val(email);
        $('input[name=realname2]').val(realname);
        $('input[name=phone2]').val(phone);
    }
}


/**********************
 *判断复选框选择个数，用于角色设置(有且只有一个复选框被选中)
 **********************/
var getSelected = function () {
    var array = $('#exampleTableEvents').bootstrapTable('getSelections');
    if (array.length != 1) {
        warnningMsg("请选择一条数据！");
        $("#userRole").attr("data-target", "");
        return false;
    } else {
        $("#userRole").attr("data-target", "#myModal7");
        return true;
    }
};
/**********************
 *角色设置
 **********************/

/*获取下拉角色列表*/
function showSel() {
    if (getSelected()) {
        $.ajax({
            type: 'get',
            url: "../../role/roleList",
            dataType: "json",
            success: function (data) {
                var depart_list = data;
                var opts = "";
                for (var depart_index = 0; depart_index < depart_list.length; depart_index++) {
                    var rolename = depart_list[depart_index].name;
                    var roleId = depart_list[depart_index].roleId;
                    opts += "<option value='" + roleId + "'>" + rolename + "</option>";
                }
                $("#roleSet").append(opts);
            }
        });

    }

}

/**********************
 *提示框
 **********************/

/*成功提示信息*/
function successMsg(data) {
    //e.preventDefault();
    $.smkAlert({
        text: data,
        type: 'success',
        position: 'top-center',
        time: 1
    });
}

/*警告提示信息*/
function warnningMsg(data) {
    //e.preventDefault();
    $.smkAlert({
        text: data,
        type: 'warning',
        position: 'top-center',
        time: 1
    });
}

/*错误提示信息*/
function dangerMsg(data) {
    //e.preventDefault();
    $.smkAlert({
        text: data,
        type: 'danger',
        position: 'top-center',
        permanent: true
    });
}

/*正常提示信息*/
function infoMsg(data) {
    //e.preventDefault();
    $.smkAlert({
        text: data,
        type: 'info',
        position: 'top-center',
        time: 1
    });
}

/*删除提示信息*/
function deleteMsg(data) {
    //e.preventDefault();
    $.smkConfirm({
        text: data,
        accept: '确定',
        cancel: '取消'
    }, function (res) {
        // Code here
        if (res) {
            successMsg("删除成功");
        }
    });
}