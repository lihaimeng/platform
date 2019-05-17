$(document).ready(function () {
    /**
     * 新增判断
     */
    $('.addBtn').click(function () {
        var id = $("#hid").val();
        if (id == '' || id == null) {
            warnningMsg("请点击组织机构，进入下级菜单");
            return false;
        }
        if ($('.jstree-clicked').length == 0) {
            warnningMsg("请选择数据字典");
            return false;
        }
    });
    /**
     * 表单关闭清空数据
     */
    $('.closeBtn').click(function () {
        $("#organizationFormAdd")[0].reset();
        $('.form-group').removeClass('has-error');
        if ($('#name-error').length != 0) {
            $('#name-error')[0].style.display = 'none';
        }
        if ($('#description-error').length != 0) {
            $('#description-error')[0].style.display = 'none';
        }
        if ($('#code-error').length != 0) {
            $('#code-error')[0].style.display = 'none';
        }
    });
    /**
     * 机构删除
     */
    $('#deleteBtn').click(function () {
        var data = $("#exampleTableEvents").bootstrapTable('getSelections')[0];
        if (typeof(data) != 'undefined') {
            var id = data.organizationId;
            var pid = data.pid;
            $.smkConfirm({
                text: "您确认要删除所选数据吗？",
                accept: '确定',
                cancel: '取消'
            }, function (res) {
                if (res) {
                    $.ajax({
                        url: '../../organization/delete/' + id,
                        type: 'GET',
                        success: function (data) {
                            if (data.result == '操作成功') {
                                successMsg("删除成功");
                                $('#' + pid + '_anchor').parent().parent().prev().click();
                                $('#' + pid + '_anchor').click();
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
    });
    /**
     * 机构新增
     */
    $("#submitMsg").click(function () {
        var level = $('#level').val();
        if (parseInt(level) > 3) {
            infoMsg('不能为该目录等级下，添加菜单信息！');
            return false;
        } else {
            var name = $("#name").val();
            var code = $("#code").val();
            var description = $("#description").val();
            var pidStr = $("#hid").val();
            if (pidStr == null || pidStr == '') {
                pidStr = '0';
            }
            var pid = parseInt(pidStr);
            var organizationIdStr = $("#organizationId").val();
            var organizationId = parseInt(organizationIdStr);
            if ($("#organizationFormAdd").valid()) {
                $.ajax({
                    url: "../../organization/insert",
                    contentType: "application/json; charset=UTF-8",
                    type: "POST",
                    data: JSON.stringify({
                        'code': code,
                        'name': name,
                        'description': description,
                        'pid': pid,
                        'organizationId': organizationId
                    }),
                    success: function (data) {
                        if (data.result == "新增成功") {
                            successMsg(data.result);
                            $('.closeBtn').click();
                            $('.jstree-clicked').click();
                        } else {
                            dangerMsg(data.result);
                        }
                    },
                    error: function (data) {
                        dangerMsg(data.errMsg);
                    }
                });
            }
        }
    });

    /**
     * 机构编辑验证选中数据
     */
    $("#edit").click(function () {
        var id = $("#hid").val();
        if (id == '' || id == null) {
            warnningMsg("请点击组织结构，进入下级菜单！");
            return false;
        }
        var data = $("#exampleTableEvents").bootstrapTable('getSelections')[0];
        if (typeof(data) != 'undefined') {
            $("#nameEdit").val(data.name);
            $("#organizationIdEdit").val(data.organizationId);
            $("#brevitycodeEdit").val(data.brevitycode);
            $("#descriptionEdit").val(data.description);
            $("#codeEdit").val(data.code);
            $("#pidEdit").val($("#hid").val());
        } else {
            warnningMsg("请选择一条数据！");
            return false;
        }
    });
    /**
     * 机构编辑提交
     */
    $("#editButton").click(function () {
        var name = $("#nameEdit").val();
        var code = $("#codeEdit").val();
        var description = $("#descriptionEdit").val();
        var pidStr = $("#pidEdit").val();
        var pid = parseInt(pidStr);
        var organizationIdStr = $("#organizationIdEdit").val();
        var organizationId = parseInt(organizationIdStr);
        if ($("#organizationFormEdit").valid()) {
            $.ajax({
                url: "../../organization/update",
                contentType: "application/json; charset=UTF-8",
                type: "POST",
                data: JSON.stringify({
                    'code': code,
                    'name': name,
                    'description': description,
                    'pid': pid,
                    'organizationId': organizationId
                }),
                success: function (data) {
                    if (data.result == "修改成功") {
                        successMsg(data.result);
                        $('.closeBtn1').click();
                        $('.jstree-clicked').click();
                    } else {
                        warnningMsg(data.result);
                    }
                },
                error: function (data) {
                    dangerMsg(data.errMsg);
                }
            });
        }
    });
});

/**
 * 成功提示信息
 * @param data 信息
 * @returns
 */
function successMsg(data) {
    $.smkAlert({
        text: data,
        type: 'success',
        position: 'top-center',
        time: 1
    });
}

/**
 * 警告提示信息
 * @param data 信息
 * @returns
 */
function warnningMsg(data) {
    $.smkAlert({
        text: data,
        type: 'warning',
        position: 'top-center',
        time: 1
    });
}

/**
 * 错误提示信息
 * @param data 信息
 * @returns
 */
function dangerMsg(data) {
    $.smkAlert({
        text: data,
        type: 'danger',
        position: 'top-center',
        time: 2,
        /*permanent: true*/
    });
}

/**
 * 正常提示信息
 * @param data 信息
 * @returns
 */
function infoMsg(data) {
    $.smkAlert({
        text: data,
        type: 'info',
        position: 'top-center',
        time: 1
    });
}

/**
 * 删除提示信息
 * @param data 信息
 * @returns
 */
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

