(function () {
    /**********************
     *新增
     **********************/
    /**
     * 新增判断
     */
    $('.addBtn').click(function () {
        var id = $("#hid").val();
        if (id == '' || id == null) {
            warnningMsg("请点击数据字典，进入下级菜单！");
            return false;
        }
        if ($('.jstree-clicked').length == 0) {
            warnningMsg("请选择数据字典！");
            return false;
        }
    });

    /**
     * 表单关闭清空数据
     */
    $('#closeBtnAdd').click(function () {
        $("#PermissionForm")[0].reset();
        $('.form-group').removeClass('has-error');
        /*$('#dicNameAdd-error')[0].style.display = 'none';
        $('#dicTypeAdd-error')[0].style.display = 'none';
        $('#orderbyAdd-error')[0].style.display = 'none';*/
        $('#myModal5').modal('hide');
    });
    $('#closeBtnEdit').click(function () {
        $("#dictionaryFormEdit")[0].reset();
        $('.form-group').removeClass('has-error');
        /*$('#dicNameEdit-error')[0].style.display = 'none';
        $('#dicTypeEdit-error')[0].style.display = 'none';
        $('#orderbyEdit-error')[0].style.display = 'none';*/
        $('#myModal6').modal('hide');
    });

    $("#submitMsg").click(function () {
        var level = $('#level').val();
        if (parseInt(level) > 3) {
            infoMsg('不能为该目录等级下，添加字典信息！');
            return false;
        } else {
            var dicName = $("#dicNameAdd").val();
            // var dicType = $("#dicTypeAdd").val();
            var orderby = $("#orderbyAdd").val();
            var dicCode = $("#dicCodeAdd").val();
            var pidStr = $("#hid").val();
            if (pidStr == null || pidStr == '') {
                pidStr = '0';
            }
            var pid = parseInt(pidStr);
            if (dicName == null || dicName == "") {
                warnningMsg("请输入名称！");
                return false;
            }
            if ($("#PermissionForm").valid()) {

                $.ajax({
                    url: "../../dictionary/insert",
                    contentType: "application/json; charset=UTF-8",
                    type: "POST",
                    data: JSON.stringify({
                        'dicName': dicName,
                        // 'dicType': dicType,
                        'dicCode': dicCode,
                        'orderby': orderby,
                        'pdictId': pid
                    }),
                    success: function (data) {
                        if (data.result == "新增成功") {
                            successMsg(data.result);
                            $('#closeBtnAdd').click();
                            $('.jstree-clicked').click();
                        }/*if(data.result == "字典名称已存在"){
                            warnningMsg("字典名称已存在");
                        }*/ else {
                            warnningMsg(data.result);
                        }
                    },
                    error: function (data) {
                        dangerMsg(data.errMsg);
                    }
                });
            }
        }
    });
    /**********************
     *修改字典
     **********************/
    //为修改弹出框赋值
    $('.editBtn').click(function () {
        var id = $("#hid").val();
        if (id == '' || id == null) {
            warnningMsg("请点击数据字典，进入下级菜单！");
            return false;
        }
        if ($('.jstree-clicked').length == 0) {
            warnningMsg("请选择数据字典！");
            return false;
        }
        var array = $('#exampleTableEvents').bootstrapTable('getSelections');
        if (array.length != 1) {
            warnningMsg("请选择一条数据");
            return false;
        } else {
            var obj = array[0];
            var dicNameEdit = obj.dicName;
            var dicCodeEdit = obj.dicCode;
            // var dicTypeEdit = obj.dicType;
            var orderbyEdit = obj.orderby;
            $('#dicNameEdit').val(dicNameEdit);
            // $('#dicTypeEdit').val(dicTypeEdit);
            $('#dicCodeEdit').val(dicCodeEdit);
            $('#orderbyEdit').val(orderbyEdit);
        }
    });
    //点击保存按钮
    $("#submitEditBtn").click(function () {
        var array = $('#exampleTableEvents').bootstrapTable('getSelections');
        var obj = array[0];
        var dictid = obj.dictId;
        var dicNameEdit = $("#dicNameEdit").val();
        // var dicTypeEdit = $("#dicTypeEdit").val();
        var dicCodeEdit = $("#dicCodeEdit").val();
        var orderbyEdit = $("#orderbyEdit").val();
        var requestData = JSON.stringify({
            "dictId": dictid,
            "dicName": dicNameEdit,
            // 'dicType': dicTypeEdit,
            'dicCode': dicCodeEdit,
            'orderby': orderbyEdit
        });
        if ($("#dictionaryFormEdit").valid()) {	//表单验证

            $.ajax({
                url: "../../dictionary/update",
                contentType: "application/json;charset=UTF-8",
                type: "post",
                data: requestData,
                success: function (data) {
                    var msg = data.result;
                    if (msg == "修改成功") {
                        successMsg(data.result);
                        $('#closeBtnEdit').click();
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
     *字典详情
     **********************/
    $('#btn_detail').click(function () {
        var id = $("#hid").val();
        if (id == '' || id == null) {
            warnningMsg("请点击数据字典，进入下级菜单！");
            return false;
        }
        if ($('.jstree-clicked').length == 0) {
            warnningMsg("请选择数据字典！");
            return false;
        }
        var array = $('#exampleTableEvents').bootstrapTable('getSelections');
        if (array.length != 1) {
            warnningMsg("请选择一条数据");
            return false;
        } else {
            var obj = array[0];
            var dicNameDetail = obj.dicName;
            //var dicTypeDetail = obj.dicType;
            var dicCodeDetail = obj.dicCode;
            var orderbyDetail = obj.orderby;
            $('#dicNameDetail').html(dicNameDetail);
            $('#dicCodeDetail').html(dicCodeDetail);
            $('#orderbyDetail').html(orderbyDetail);
        }
    });

    /**********************
     *删除字典
     **********************/
    $('#deleteBtn').click(function () {
        var id = $("#hid").val();
        if (id == '' || id == null) {
            warnningMsg("请点击数据字典，进入下级菜单！");
            return false;
        }
        if ($('.jstree-clicked').length == 0) {
            warnningMsg("请选择数据字典！");
            return false;
        }
        var array = $('#exampleTableEvents').bootstrapTable('getSelections');
        if (array.length != 1) {
            warnningMsg("请选择一条数据");
            return false;
        } else {
            var obj = array[0];
            var id = obj.dictId;
            deleteMsg("您确认要删除所选数据吗？", id);
        }
    });

})();

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
function deleteMsg(data, id) {
    //e.preventDefault();
    $.smkConfirm({
        text: data,
        accept: '确定',
        cancel: '取消'
    }, function (res) {
        // Code here
        if (res) {
            $.ajax({
                url: "../../dictionary/delete/" + id,
                contentType: "application/json;charset=UTF-8",
                type: "get",
                success: function (data) {
                    if (data.result == "操作成功") {
                        successMsg("删除成功");
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
    });
}

