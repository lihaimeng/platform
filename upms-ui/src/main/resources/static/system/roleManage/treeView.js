function getRoleTree(roleId) {
    $.ajax({
        type: "get",
        url: "../../permission/permissionByRoleId/" + roleId,
        dataType: "json",
        success: function (result) {
            defaultData = transData(result, 'id', 'pid', 'nodes');
            console.log(defaultData);
            $('#treeview-checkable').treeview({
                data: defaultData[0].nodes,
                showIcon: false,
                showCheckbox: true,
                onNodeChecked: function (event, node) {
                    var selectNodes = getChildNodeIdArr(node);    //获取所有子节点
                    if (selectNodes) { 							//子节点不为空，则选中所有子节点
                        $('#treeview-checkable').treeview('checkNode', [selectNodes, {silent: true}]);
                    }
                    var parentNode = $("#treeview-checkable").treeview("getNode", node.parentId);
                    setParentNodeCheck(node);
                },
                onNodeUnchecked: function (event, node) {         //取消选中节点
                    var selectNodes = getChildNodeIdArr(node);    //获取所有子节点
                    if (selectNodes) { 							//子节点不为空，则取消选中所有子节点
                        $('#treeview-checkable').treeview('uncheckNode', [selectNodes, {silent: true}]);
                    }
                    setParentNodeUnCheck(node);
                },
            });
            //hiddenRoot();
            /*$('li').on('click',function(){      //绑定事件
                hiddenRoot();
             }); */
        },
        error: function () {
            dangerMsg(data.errMsg);
        }
    });
}

function transData(a, idStr, pidStr, nodes) {
    var r = [], hash = {}, id = idStr, pid = pidStr, nodes = nodes, i = 0, j = 0, len = a.length;
    for (; i < len; i++) {
        hash[a[i][id]] = a[i];
    }
    for (; j < len; j++) {
        var aVal = a[j], hashVP = hash[aVal[pid]];
        if (hashVP) {
            !hashVP[nodes] && (hashVP[nodes] = []);
            hashVP[nodes].push(aVal);
        } else {
            r.push(aVal);
        }
    }
    return r;
}

/************************************
 *选中/取消选中父节点时，选中/取消选中所有子节点，
 *以及选中/取消所有子节点时，选中/取消父节点BEGIN
 ************************************/
function getChildNodeIdArr(node) {
    var ts = [];
    if (node.nodes) {
        for (x in node.nodes) {
            ts.push(node.nodes[x].nodeId);
            if (node.nodes[x].nodes) {
                var getNodeDieDai = getChildNodeIdArr(node.nodes[x]);
                for (j in getNodeDieDai) {
                    ts.push(getNodeDieDai[j]);
                }
            }
        }
    } else {
        ts.push(node.nodeId);
    }
    return ts;
}

function setParentNodeCheck(node) {
    var parentNode = $("#treeview-checkable").treeview("getNode", node.parentId);
    if (parentNode.nodes) {
        var checkedCount = 0;
        for (x in parentNode.nodes) {
            if (parentNode.nodes[x].state.checked) {
                checkedCount++;
            } else {
                break;
            }
        }
        if (checkedCount === parentNode.nodes.length) {
            $("#treeview-checkable").treeview("checkNode", parentNode.nodeId);
            setParentNodeCheck(parentNode);
        }
    }
}

function setParentNodeUnCheck(node) {
    var parentNode = $("#treeview-checkable").treeview("getNode", node.parentId);
    if (parentNode.nodes) {
        var checkedCount = 0;
        for (x in parentNode.nodes) {
            if (!parentNode.nodes[x].state.checked) {
                checkedCount++;
            } else {
                break;
            }
        }
        if (checkedCount === parentNode.nodes.length) {
            $("#treeview-checkable").treeview("uncheckNode", parentNode.nodeId);
            setParentNodeUnCheck(parentNode);
        }
    }
}

/************************************
 *选中/取消选中父节点时，选中/取消选中所有子节点，
 *以及选中/取消所有子节点时，选中/取消父节点END
 ************************************/

/* function hiddenRoot() {
    $("ul").each(function(){
        $(this).children().first().css("display","none");
        });
 } */
    