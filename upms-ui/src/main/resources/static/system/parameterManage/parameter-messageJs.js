//生成bootstrapTable  
//bootstrapTable表格属性参考http://bootstrap-table.wenzhixin.net.cn/zh-cn/documentation/
(function () {
    var jsonStrInit = "";
    /**********************
     *参数列表
     **********************/
    loadTable();

    /**********************
     *新增参数
     **********************/
    /*点击新增按钮时，去掉输入框内容*/
    $(".addRole").click(function () {
        $("#signupForm")[0].reset();
        $('.form-group').removeClass('has-error');
        if ($('#code-error').length != 0) {
            $('#code-error')[0].style.display = 'none';
        }
        if ($('#param_name-error').length != 0) {
            $('#param_name-error')[0].style.display = 'none';
        }
        if ($('#param_value-error').length != 0) {
            $('#param_value-error')[0].style.display = 'none';
        }
    });
    // $("#roleForm").validate();
    $("#submitForAdd").click(function () {
        var code = $('input[name=code]').val();
        var param_name = $('input[name=param_name]').val();
        var param_value = $('input[name=param_value]').val();
        var requestDate = JSON.stringify({
            'code': code,
            'paramName': param_name,
            'paramValue': param_value
        });
        if ($("#signupForm").valid()) {//表单验证
            $.ajax({
                url: "../../param/insert",
                contentType: "application/json;charset=UTF-8",
                type: "post",
                data: requestDate,
                success: function (data) {
                    var msg = data.result;
                    if (msg == "新增成功") {
                        successMsg(data.result);
                        $('.closeBtn').click();
                        setTimeout(function () {
                            //window.location.reload()
                            loadTable();
                        }, 1000);
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

    /**********************
     *为修改弹出框赋值
     **********************/
    $("#editButton").click(function () {
        jsonStrInit = "";//表单初始化时，序列化的json字符串
        if (getSelectedNumber()) {
            $("#editButton").attr("data-target", "#myModal6");
            $("#signupFormForEdit")[0].reset();
            $('.form-group').removeClass('has-error');
            if ($('#codeForEdit-error').length != 0) {
                $('#codeForEdit-error')[0].style.display = 'none';
            }
            if ($('#param_nameForEdit-error').length != 0) {
                $('#param_nameForEdit-error')[0].style.display = 'none';
            }
            if ($('#param_valueForEdit-error').length != 0) {
                $('#param_valueForEdit-error')[0].style.display = 'none';
            }
            var parameterObj = getSelectedItem();
            var parameterName = parameterObj.paramName;
            var parameterCode = parameterObj.code;
            var parameterValue = parameterObj.paramValue;
            $('input[name=codeForEdit]').val(parameterCode);
            $('input[name=param_nameForEdit]').val(parameterName);
            $('input[name=param_valueForEdit]').val(parameterValue);
            jsonStrInit += jsonTextInit("signupFormForEdit");
        }
    });

    /**********************
     *修改参数
     **********************/
    $("#submitForEdit").click(function () {
        /**
         var jsonStr = jsonTextInit("signupFormForEdit");
         //提交之前，查看页面是否进行过修改
         if (jsonStr == jsonStrInit) {
            warnningMsg("您未做修改操作")
            return false;
        } else {
         **/
        var id = getSelectedItem().paramId;
        var code = $('input[name=codeForEdit]').val();
        var param_name = $('input[name=param_nameForEdit]').val();
        var param_value = $('input[name=param_valueForEdit]').val();
        var requestDate = JSON.stringify({
            'paramId': id,
            'code': code,
            'paramName': param_name,
            'paramValue': param_value
        });
        if ($("#signupFormForEdit").valid()) {	//表单验证
            $.ajax({
                url: "../../param/update",
                contentType: "application/json;charset=UTF-8",
                type: "post",
                data: requestDate,
                success: function (data) {
                    var msg = data.result;
                    if (msg == "修改成功") {
                        successMsg(data.result);
                        $('.closeBtnForEdit').click();
                        setTimeout(function () {
                            loadTable();
                            //window.location.reload()
                        }, 1000);
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

    /**********************
     *批量删除参数
     **********************/
    $('.deleteParameter').click(function () {
        if (getSelectedNumberForDelete()) {
            var paramObj = getSelectedItem();
            var id = paramObj.paramId;
            deleteMsg("您确认要删除所选数据吗？", id);
        }
    });
})();

function loadTable() {
    $.ajax({
        url: "../../param/paramList",
        dataType: 'json',
        type: "GET",
        success: function (data) {
            data = JSON.stringify(data);
            data = JSON.parse(data);
            $("#exampleTableEvents").bootstrapTable('destroy');
            $('#exampleTableEvents').bootstrapTable({
                pagination: true,//设置为 true 会在表格底部显示分页条
                //sidePagination:'server',
                pageNumber: 1,
                pageSize: 15,	//如果设置了分页，页面数据条数
                singleSelect: true,
                //height: $('#exampleTableEvents').height() * 19,
                clickToSelect: true,//一个jQuery 选择器，指明自定义的toolbar 例如:#toolbar, .toolbar.
                toolbar: '#exampleTableEventsToolbar',
                data: data,
                columns: [{
                    field: 'number',
                    title: '序号',
                    align: 'center',
                    width: 20,
                    formatter: function (value, row, index) {
                        /*console.log($('#exampleTableEvents').bootstrapTable('getOptions').data);
                        var pageSize=$('.exampleTable').bootstrapTable('getOptions').pageSize;
                        var pageNumber=$('.exampleTable').bootstrapTable('getOptions').pageNumber;
                        console.log(pageSize+'/'+pageNumber);
                        return pageSize*(pageNumber-1)+index+1;*/
                        return index + 1;
                    }
                }]
            });
        }
    });
}

/**********************
 *提取选择数据,用于修改
 **********************/
var getSelectedItem = function () {
    var array = $('#exampleTableEvents').bootstrapTable('getSelections');
    return array[0];
};

/**********************
 *提取选择的数据集合,用于批量删除
 **********************/
var getSelectedItems = function () {
    var array = $('#exampleTableEvents').bootstrapTable('getSelections');
    var id = "";
    $.each(array, function (index, obj) {
        id += obj.roleId + ",";
    });
    return id;
};

/**********************
 *判断复选框选择个数，用于修改(有且只有一个复选框被选中)
 **********************/
var getSelectedNumber = function () {
    var array = $('#exampleTableEvents').bootstrapTable('getSelections');
    if (array.length != 1) {
        warnningMsg("请选择一条数据！");
        $("#editButton").attr("data-target", "");
        return false;
    } else {
        return true;
    }
};

/**********************
 *判断复选框选择个数，用于删除(有且只有一个复选框被选中)
 **********************/
var getSelectedNumberForDelete = function () {
    var array = $('#exampleTableEvents').bootstrapTable('getSelections');
    if (array.length != 1) {
        warnningMsg("请选择一条数据！");
        return false;
    } else {
        return true;
    }
};

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
        //permanent: true
        time: 2
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
                url: "../../param/delete/" + id,
                contentType: "application/json;charset=UTF-8",
                type: "get",
                success: function (data) {
                    if (data.result == "操作成功") {
                        successMsg("删除成功");
                        setTimeout(function () {
                            loadTable();
                        }, 1000);
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

//在表单加载(初始化)时把表单序列化成json格式数据
function jsonTextInit(formName) {
    var seletor = "#" + formName;
    var dataformInit = $(seletor).serializeArray();
    var jsonTextInit = JSON.stringify({data: dataformInit});
    return jsonTextInit;
}
