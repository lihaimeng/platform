//生成bootstrapTable  
//bootstrapTable表格属性参考http://bootstrap-table.wenzhixin.net.cn/zh-cn/documentation/
var ts = [];//角色权限 保存按钮 已选菜单id数组
(function () {
    var jsonStrInit = "";
    /**********************
     *角色列表
     **********************/
    loadTable();
    /**********************
     *新增角色BEGIN
     **********************/
    /*点击新增按钮时，去掉输入框内容*/
    $('.addRole').click(function () {
        $("#roleFormForAdd")[0].reset();
        $('.form-group').removeClass('has-error');
        if ($('#roleName-error').length != 0) {
            $('#roleName-error')[0].style.display = 'none';
        }
        if ($('#description-error').length != 0) {
            $('#description-error')[0].style.display = 'none';
        }
    });

    /*点击新增角色的保存按钮*/
    $("#addRoleSubmit").click(function () {
        var name = $('input[name=roleName]').val();
        var description = $('input[name=description]').val();
        var requestDate = JSON.stringify({'name': name, 'description': description});
        if ($("#roleFormForAdd").valid()) {//表单验证
            $.ajax({
                url: "../../role/insert",
                contentType: "application/json;charset=UTF-8",
                type: "post",
                data: requestDate,
                success: function (data) {
                    if (data.result == "新增成功") {
                        successMsg(data.result);
                        $('.closeBtn').click();
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

    /**********************
     *修改角色BEGIN
     **********************/
    /*为修改弹出框赋值*/
    $(".editRole").click(function () {
        jsonStrInit = "";//表单初始化时，序列化的json字符串
        if (getSelectedNumber()) {
            $("#editButton").attr("data-target", "#myModal6");
            $("#roleFormForEdit")[0].reset();
            $('.form-group').removeClass('has-error');
            if ($('#roleNameForEdit-error').length != 0) {
                $('#roleNameForEdit-error')[0].style.display = 'none';
            }
            if ($('#descriptionForEdit-error').length != 0) {
                $('#descriptionForEdit-error')[0].style.display = 'none';
            }
            var roleObj = getSelectedItem();
            var roleName = roleObj.name;
            var roleDescriptione = roleObj.description;
            var name = $('input[name=roleNameForEdit]').val(roleName);
            var description = $('input[name=descriptionForEdit]').val(roleDescriptione);
            jsonStrInit += jsonTextInit("roleFormForEdit");
        }
    });
    /*点击修改角色的保存按钮*/
    $("#editRoleSubmit").click(function () {
        /**
         var jsonStr = jsonTextInit("roleFormForEdit");
         //提交之前，查看页面是否进行过修改
         if (jsonStr == jsonStrInit) {
                    warnningMsg("您未做修改操作")
                    return false;
                } else {
         **/
            //从表格中获取选中的对象
        var roleObj = getSelectedItem();
        var id = roleObj.roleId;
        var name = $('input[name=roleNameForEdit]').val();
        var description = $('input[name=descriptionForEdit]').val();
        var requestDate = JSON.stringify({'roleId': id, 'name': name, 'description': description});
        if ($("#roleFormForEdit").valid()) {	//表单验证
            $.ajax({
                url: "../../role/update",
                contentType: "application/json;charset=UTF-8",
                type: "post",
                data: requestDate,
                success: function (data) {
                    if (data.result == "修改成功") {
                        successMsg(data.result);
                        $('.closeBtnForEdit').click();
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

    /**********************
     *批量删除角色
     **********************/
    $('.deleteRole').click(function () {
        if (getSelectedNumberForDelete()) {
            var roleObj = getSelectedItem();
            var id = roleObj.roleId;
            deleteMsg("您确认要删除所选数据吗？", id);
        }
    });

    /**********************
     *角色权限BEGIN
     **********************/
    /*点击角色权限按钮时，为角色名称赋值并加载角色树*/
    $('.power').click(function () {
        if (getSelectedNumberForPower()) {
            $("#powerButton").attr("data-target", "#myModal7");
            var roleObj = getSelectedItem();
            var roleName = roleObj.name;
            var name = $('input[name=roleNameForPower]').val(roleName);
            getRoleTree(roleObj.roleId);//加载菜单树
        }
    });
    /*角色权限保存按钮*/
    $('#rolePowerSubmit').click(function () {
        var roleObj = getSelectedItem();
        var id = roleObj.roleId;
        var node = $("#treeview-checkable").treeview('getNode', 0);
        ts = [];//每次点击保存按钮时，ts数组清空
        GetCheckedNode(node);
        $.ajax({
            url: "../../rolePermission/insert/" + id + "/" + ts,
            contentType: "application/json;charset=UTF-8",
            type: "post",
            success: function (data) {
                if (data.result == "操作成功") {
                    successMsg(data.result);
                    $('.closeBtnForPower').click();
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
    });
})();

function loadTable() {
    $.ajax({
        url: "../../role/roleList",
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

/**********************
 *判断复选框选择个数，用于角色权限(有且只有一个复选框被选中)
 **********************/
var getSelectedNumberForPower = function () {
    var array = $('#exampleTableEvents').bootstrapTable('getSelections');
    if (array.length != 1) {
        warnningMsg("请选择一条数据！");
        $("#powerButton").attr("data-target", "");
        return false;
    } else {
        return true;
    }
};

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
        // permanent: true,
        time: 1
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
                url: "../../role/delete/" + id,
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

/**********************
 *treeview获取选中的节点的id值
 **********************/
function GetCheckedNode(node) {
    var nodeSiblings = $('#treeview-checkable').treeview('getSiblings', node);
    nodeSiblings.push(node);
    if (nodeSiblings != undefined) {
        for (j in nodeSiblings) {
            GetCheckedNodeID(nodeSiblings[j]);
        }
    }


}

function GetCheckedNodeID(node) {
    if (node.state.checked == true) {
        ts.push(node.id);
    }
    if (node.nodes != null) {
        for (x in node.nodes) {
            GetCheckedNodeID(node.nodes[x]);
        }
    }
    return ts;
}

//在表单加载(初始化)时把表单序列化成json格式数据
function jsonTextInit(formName) {
    var seletor = "#" + formName;
    var dataformInit = $(seletor).serializeArray();
    var jsonTextInit = JSON.stringify({data: dataformInit});
    return jsonTextInit;
}