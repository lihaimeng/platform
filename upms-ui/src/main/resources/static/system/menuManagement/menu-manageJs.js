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
$('.closeBtn1').click(function () {
    $("#PermissionForm")[0].reset();
    // $('.form-group').removeClass('has-error');
    // $('#name1-error')[0].style.display = 'none';
    // $('#uri1-error')[0].style.display = 'none';
    // $('#orderby1-error')[0].style.display = 'none';
});

/******************
 * 增加菜单
 * ****************/
function addPermission() {
    //通过ajax请求获取数据
    var pid = $("#hid").val();
    var name = $("#name1").val();
    var orderby = $("#orderby1").val();
    var uri = $("#uri1").val();
    var icon = $("#icon").val();
    var type = 1;
    var value = 1;
    var requestData = JSON.stringify({
        'name': name,
        'orderby': orderby,
        'uri': uri,
        'icon': icon,
        'type': type,
        'value': value,
        'pid': pid,
    });
    if ($("#PermissionForm").valid()) {//表单验证
        $.ajax({
            url: "../../permission/insert",
            contentType: "application/json;charset=UTF-8",
            type: "post",
            data: requestData,
            success: function (data) {
                var msg = data.result;
                if (msg == "新增成功") {
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
}

/**********************
 *判断复选框选择个数，用于修改(有且只有一个复选框被选中)
 **********************/
var getSelectedNumber = function () {
    var array = $('#exampleTableEvents').bootstrapTable('getSelections');
    if (array.length != 1) {
        warnningMsg("请选择一条数据");
        $("#updateMenu").attr("data-target", "");
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
function menuSetValueForInput() {
    if (getSelectedNumber()) {
        $("#updateMenu").attr("data-target", "#myModal6");
        var parameterObj = getSelectedItem();
        var name2 = parameterObj.name;
        var uri2 = parameterObj.uri;
        var icon2 = parameterObj.icon;
        var orderby2 = parameterObj.orderby;
        $('input[name=name2]').val(name2);
        $('input[name=uri2]').val(uri2);
        $('input[name=icon2]').val(icon2);
        $('input[name=orderby2]').val(orderby2);
    }
}

var oid;
/**********************
 *修改菜单
 **********************/
$("#updatePermission").click(function () {
    //从表格中获取选中的对象
    var roleObj = getSelectedItem();
    var name2 = $("#name2").val();
    var uri2 = $("#uri2").val();
    var icon2 = $("#icon2").val();
    var orderby2 = $("#orderby2").val();
    oid = $(".selected")[0].children[2].innerHTML;
    var requestData = JSON.stringify({
        "permissionId": oid,
        "name": name2,
        'uri': uri2,
        'icon': icon2,
        'orderby': orderby2,
        'value': "1",
        'type': "1"

    });
    if ($("#updateForm").valid()) {	//表单验证
        $.ajax({
            url: "../../permission/update",
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
/**
 * 删除菜单
 */
$('#deleteBtn').click(function () {
    var id = $("#hid").val();
    if (id == '' || id == null) {
        warnningMsg("请点击组织结构，进入下级菜单！");
    } else {
        var data = $("#exampleTableEvents").bootstrapTable('getSelections')[0];
        if (typeof(data) != 'undefined') {
            var id = data.permissionId;
            $.smkConfirm({
                text: "您确认要删除所选数据吗？",
                accept: '确定',
                cancel: '取消'
            }, function (res) {
                if (res) {
                    $.ajax({
                        url: "../../permission/delete/" + id,
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
});
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

