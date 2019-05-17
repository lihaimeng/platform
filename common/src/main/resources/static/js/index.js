function arrayToJson(treeArray) {
    var r = [];
    var tmpMap = {};
    for (var i = 0, l = treeArray.length; i < l; i++) {
        // 以每条数据的id作为obj的key值，数据作为value值存入到一个临时对象里面
        tmpMap[treeArray[i]["permissionId"]] = treeArray[i];
    }

    for (i = 0, l = treeArray.length; i < l; i++) {
        var key = tmpMap[treeArray[i]["pid"]];

        // 循环每一条数据的pid，假如这个临时对象有这个key值，就代表这个key对应的数据有children，需要Push进去
        if (key) {
            if (!key["children"]) {
                key["children"] = [];
                key["children"].push(treeArray[i]);
            } else {
                key["children"].push(treeArray[i]);
            }
        } else {
            // 如果没有这个Key值，那就代表没有父级,直接放在最外层
            r.push(treeArray[i]);
        }
    }
    return r
}

/**
 * 创建字典实体
 * @param name
 * @param code
 */
function dictionary(name, code) {
    this.name = name;
    this.code = code;
}

$(document).ajaxComplete(function (event, xhr, settings) {
    if (xhr.getResponseHeader("sessionstatus") == "timeout") {
        if (xhr.getResponseHeader("loginPath")) {
            alert("会话过期，请重新登陆!");
            window.location.replace('login.html');
        } else {
            alert("请求超时请重新登陆 !");
        }
    }
});


$(document)
    .ready(
        function () {

            $


                .ajax({
                    url: 'permission/getPermission',
                    async: false,// 同步
                    type: 'POST',
                    success: function (json) {
                        console.log(json,'json')
                        var user = json.user;
                        var dictionaryRecord = json.dictionaryRecord;
                        var organization = json.organization;
                        for (var i = 0; i < dictionaryRecord.length; i++) {
                            if (dictionaryRecord[i].pdictId == "0") {
                                var name = dictionaryRecord[i].dicName;
                                var dictId = dictionaryRecord[i].dictId;
                                var typeList = [];
                                for (var j = 0; j < dictionaryRecord.length; j++) {
                                    if (dictId == dictionaryRecord[j].pdictId) {
                                        typeList.push(new dictionary(dictionaryRecord[j].dicName,
                                            dictionaryRecord[j].dicCode))
                                    }
                                }
                                localStorage.setItem(name, JSON.stringify(typeList));
                            }
                        }
                        localStorage.setItem('user', JSON.stringify(user));
                        localStorage.setItem('organization', JSON.stringify(organization));
                        localStorage.setItem('pawn_url', JSON.stringify(json.pawn_url));
                        localStorage.setItem('zongzhi_url', JSON.stringify(json.zongzhi_url));
                        localStorage.setItem('organizationCode', JSON.stringify(json.organizationCode));
                        if (user != null || user != '') {
                            console.log(user,'user')
                            $('#userName').text(user.realname);
                            $('#roleName').html(user.roleName + '<b class="caret"></b>');
                            $('#loginId').html(user.username);
                            $('#loginName').html(user.realname);
                            $('#userSex').html(
                                user.sex == '1' ? '男' : '女');
                            $('#user_organization').html(
                                user.organizationName);
                            $('#userRoleName').html(user.roleName);
                            $('#userEmail').html(user.email);
                            $('#userPhone').html(user.phone);
                            $('#organizationId').val(user.organizationId);
                            $('#qyrybm').val(user.qyrybm);
                        }

                        var data = arrayToJson(json.list);
                        var showList = "";
                        for (var index = 0; index < data.length; index++) {
                            var child = data[index].children;
                            showList += "<li><a class='J_menuItem' href='" +
                                data[index].uri + "'> <i class='" + data[index].icon + "'></i> <span class='nav-label'>"
                                + data[index].name
                                + "</span> <span class='fa arrow'></span></a> <ul  class='nav nav-second-level'>";

                            if (child != null) {
                                for (var index2 = 0; index2 < child.length; index2++) {
                                    showList += "<li><a class='J_menuItem' href='"
                                        + child[index2].uri
                                        + "'>"
                                        + child[index2].name
                                        + "</a></li>";
                                }
                            }

                            showList += "</ul></li>";
                        }
                        $(".nav").append(showList);
                    },
                    error: function (error) {
                        dangerMsg(error.errMsg);
                    }
                });

            $('#savePwd').click(function () {
                var oldPwd = $('#oldPwd').val();
                var newPwd = $('#newPwd').val();
                var newPwd1 = $('#newPwd1').val();
                if (oldPwd == null || oldPwd == '') {
                    infoMsg('原密码不能为空！');
                    $('#oldPwd').focus();
                    return false;
                }
                if (newPwd == null || newPwd == '') {
                    infoMsg('新密码不能为空！');
                    $('#newPwd').focus();
                    return false;
                }
                if (newPwd1 == null || newPwd1 == '') {
                    infoMsg('确认密码不能为空！');
                    $('#newPwd1').focus();
                    return false;
                }
                if (newPwd != newPwd1) {
                    infoMsg('两次密码不一致，请重新输入！');
                    return false;
                }
                $.ajax({
                    url: 'user/updatePwd',
                    type: 'POST',
                    contentType: "application/json;charset=UTF-8",
                    data: JSON.stringify({
                        "oldPwd": oldPwd,
                        "newPwd": newPwd
                    }),
                    success: function (data) {
                        if ('旧密码不正确' == data.result) {
                            dangerMsg(data.result);
                            return false;
                        } else if ('密码修改成功' == data.result) {
                            $('.close').click();
                            successMsg(data.result);
                        }
                    }
                })
            });
        });

function exit() {
    /*
     * var mymessage = confirm("你确认要退出吗？"); if (mymessage == true) {
     * location.href = "userlogout"; } else if (mymessage == false) { }
     */
    $.smkConfirm({
        text: '您确认要退出吗？',
        accept: '确定',
        cancel: '取消'
    }, function (res) {
        // Code here
        if (res) {
            localStorage.removeItem('user');
            location.href = "userlogout";
        }
    });
}

/**
 * 成功提示信息
 *
 * @param data
 *            信息
 * @returns
 */
function successMsg(data) {
    // e.preventDefault();
    $.smkAlert({
        text: data,
        type: 'success',
        position: 'top-center',
        time: 2
    });
}

/**
 * 警告提示信息
 *
 * @param data
 *            信息
 * @returns
 */
function warnningMsg(data) {
    // e.preventDefault();
    $.smkAlert({
        text: data,
        type: 'warning',
        position: 'top-center',
        time: 2
    });
}

/**
 * 错误提示信息
 *
 * @param data
 *            信息
 * @returns
 */
function dangerMsg(data) {
    // e.preventDefault();
    $.smkAlert({
        text: data,
        type: 'danger',
        position: 'top-center',
        time: 2
    });
}

/**
 * 正常提示信息
 *
 * @param data
 *            信息
 * @returns
 */
function infoMsg(data) {
    // e.preventDefault();
    $.smkAlert({
        text: data,
        type: 'info',
        position: 'top-center',
        time: 2
    });
}


