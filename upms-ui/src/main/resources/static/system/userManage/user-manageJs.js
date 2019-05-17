(function () {
    $('#searchUser').click(function () {
        $("#exampleTableEvents").bootstrapTable('destroy');
        $('#exampleTableEvents').bootstrapTable({
            method: 'get',
            //contentType: "application/x-www-form-urlencoded",//一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
            url: "../../user/selectUserList",//要请求数据的文件路径
            pageNumber: 1, //初始化加载第一页，默认第一页
            pagination: true,//是否分页
            queryParams: queryParams,//请求服务器时所传的参数
            sidePagination: 'client',//指定服务器端分页
            singleSelect: true,
            pageSize: 15,//单页记录数
            pageList: [15, 30],//分页步进值
            toolbar: '#exampleTableEventsToolbar',		//一个jQuery 选择器，指明自定义的toolbar 例如:#toolbar, .toolbar.
            clickToSelect: true,    //是否启用点击选中行
            columns: [
                {
                    field: 'number',
                    title: '序号',
                    align: 'center',
                    width: 20,
                    formatter: function (value, row, index) {
                        return index + 1;
                    }
                }, {
                    field: 'state',
                    checkbox: true
                },
                {
                    field: 'username',
                    title: '登录账号',
                    align: 'center'
                },
                {
                    field: 'email',
                    title: '电子邮箱',
                    align: 'center'
                },
                {
                    field: 'realname',
                    title: '用户姓名',
                    align: 'center'
                },
                {
                    field: 'phone',
                    title: '联系方式',
                    align: 'center'
                }
            ]
        });
    });
    /**
     * 新增判断
     */
    $('.addBtn').click(function () {
        var id = $("#hid").val();
        if (id == '' || id == null) {
            warnningMsg("请点击组织结构，进入下级菜单！");
            return false;
        }
    });
    /**
     * 表单关闭清空数据
     */
    $('.closeBtn').click(function () {
        $("#addUserForm")[0].reset();
        $('.form-group').removeClass('has-error');
        $('#email-error')[0].style.display = 'none';
        $('#realname-error')[0].style.display = 'none';
        $('#phone-error')[0].style.display = 'none';
    });
    $('.closeBtnForEdit').click(function () {
        $("#userUpdateForm")[0].reset();
        $('.form-group').removeClass('has-error');
        $('#username2-error')[0].style.display = 'none';
        $('#email2-error')[0].style.display = 'none';
        $('#realname2-error')[0].style.display = 'none';
        $('#phone2-error')[0].style.display = 'none';
    });


})();

/******************
 * 增加用户
 * ****************/
function addUser() {
    //通过ajax请求获取数据
    var username = $("#username").val();
    var password = "123456";
    var email = $("#email").val();
    var realname = $("#realname").val();
    var phone = $("#phone").val();
    var requestData = JSON.stringify({
        'username': username,
        'password': password,
        'email': email,
        'realname': realname,
        'phone': phone,
        'status': 1,
        'sex': 1,
        'organizationId': oid
    });
    if ($("#addUserForm").valid()) {//表单验证
        $.ajax({
            url: "../../user/insert",
            contentType: "application/json;charset=UTF-8",
            type: "post",
            data: requestData,
            success: function (data) {
                var msg = data.result;
                if (msg == "新增成功") {
                    successMsg(data.result);
                    $('.closeBtn').click();
                    $('.jstree-clicked').click();
                } else if (msg == '失败') {
                    dangerMsg("该用户名已存在！");
                } else {
                    dangerMsg(data.result);
                }
            },
            error: function (data) {
                dangerMsg(data.result);
            }
        });
    }
}

/**********************
 *修改用户
 **********************/
$("#updateUser").click(function () {
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
                    $('.closeBtnForEdit').click();
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
$("#characterSet").click(function () {
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
                successMsg("设置成功");
                $('.closeBtnRole').click();
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

/**********************
 *重置密码
 **********************/
function resetPassword() {
    var id = $("#hid").val();
    if (id == '' || id == null) {
        warnningMsg("请点击组织结构，进入下级菜单！");
    } else {
        var data = $("#exampleTableEvents").bootstrapTable('getSelections')[0];
        if (typeof(data) != 'undefined') {
            var userId = data.userId;
            $.smkConfirm({
                text: "您确认要重置密码吗？",
                accept: '确定',
                cancel: '取消'
            }, function (res) {
                if (res) {
                    $.ajax({
                        url: "../../user/resetPwd/" + userId,
                        contentType: "application/json;charset=UTF-8",
                        type: "post",
                        success: function (data) {
                            if (data.result == "重置密码成功") {
                                successMsg("重置密码成功（初始密码为123456）");
                                window.close();
                            } else {
                                dangerMsg(data.result);
                            }
                        },
                        error: function (data) {
                            dangerMsg(data);
                        }
                    });
                }
            });
        } else {
            warnningMsg('请选择一条数据！');
            return false;
        }
    }
}

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
 *为用户修改弹出框赋值
 **********************/
function userSetValueForInput() {
    if (getSelectedNumber()) {
        $("#updateU").attr("data-target", "#myModal6");
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

/*获取下拉角色列表*/
function showSel() {
    if (getSelected()) {
        //获取用户角色
        getUserRole();
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
                    var opt = "";
                    if(userRoleId == roleId){
                        opt = "<option value='" + roleId + "' selected>" + rolename + "</option>";
                    }else{
                        opt = "<option value='" + roleId + "'>" + rolename + "</option>";
                    }
                    opts += opt;
                }
                document.getElementById("roleSet").innerHTML = opts;
            }
        });

    }

}
var userRoleId = '';
//获取用户对应的角色
function getUserRole(){
    if (getSelected()) {
        var userId = getSelectedItem().userId;
        $.ajax({
            type: 'post',
            url: "../../userRole/getUserRole",
            async:false,
            data:{"userId":userId},
            success: function (data) {
                if(data != null){
                    userRoleId = data.roleId;
                }
            }
        });
    }
}

/**
 * 删除用户
 */
function deleteUser() {
    var id = $("#hid").val();
    if (id == '' || id == null) {
        warnningMsg("请点击组织结构，进入下级菜单！");
    } else {
        var data = $("#exampleTableEvents").bootstrapTable('getSelections')[0];
        if (typeof(data) != 'undefined') {
            var userId = data.userId;
            $.smkConfirm({
                text: "您确认要删除所选数据吗？",
                accept: '确定',
                cancel: '取消'
            }, function (res) {
                if (res) {
                    $.ajax({
                        url: "../../user/delete/" + userId,
                        type: 'GET',
                        success: function (data) {
                            if (data.result == '操作成功') {
                                successMsg("删除成功");
                                $('.jstree-clicked').click();
                            } else {
                                dangerMsg(data.result);
                            }
                        },
                        error: function (data) {
                            dangerMsg(data);
                        }
                    });
                }
            })
        } else {
            warnningMsg('请选择一条数据！');
            return false;
        }
    }
}

//请求服务数据时所传参数
function queryParams(params) {
    var username = $("#username1").val().trim();
    var realname = $("#realname1").val().trim();
    var phone = $("#phone1").val().trim();
    var organizationId = JSON.parse(localStorage.getItem('userOrganizationId'))
    if(organizationId=="" || organizationId==null){
        dangerMsg("请选择组织结构");
    }
    return {
        pageSize: params.limit, //每一页的数据行数，默认是上面设置的10(pageSize)
        pageIndex: params.offset / params.limit + 1, //当前页面,默认是上面设置的1(pageNumber)
        username: username,
        realname: realname,
        phone: phone,
        organizationId: organizationId
    }
}

/**********************
 *提示框
 **********************/

/*成功提示信息*/
function successMsg(data) {
    $.smkAlert({
        text: data,
        type: 'success',
        position: 'top-center',
        time: 1
    });
}

/*警告提示信息*/
function warnningMsg(data) {
    $.smkAlert({
        text: data,
        type: 'warning',
        position: 'top-center',
        time: 1
    });
}

/*错误提示信息*/
function dangerMsg(data) {
    $.smkAlert({
        text: data,
        type: 'danger',
        position: 'top-center',
        permanent: true
    });
}

/*正常提示信息*/
function infoMsg(data) {
    $.smkAlert({
        text: data,
        type: 'info',
        position: 'top-center',
        time: 1
    });
}

/*删除提示信息*/
function deleteMsg(data) {
    $.smkConfirm({
        text: data,
        accept: '确定',
        cancel: '取消'
    }, function (res) {
        if (res) {
            successMsg("删除成功");
        }
    });
}