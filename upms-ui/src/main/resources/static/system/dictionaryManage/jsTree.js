$(document).ready(function () {
    $('#using_json').jstree({
        'core': {
            'check_callback': true,
            "data": function (obj, callback) {
                $.ajax({
                    url: "../../dictionary/-1",
                    dataType: "json",
                    type: "GET",
                    success: function (data) {
                        data = dataTojson(data);
                        if (data) {
                            callback.call(this, data);
                        } else {
                            $("#using_json").html("暂无数据！");
                        }
                    }
                });
            }
        },
        "plugins": ["sort"]
    }).bind("select_node.jstree", function (event, data) {
        var inst = data.instance;
        var selectedNode = inst.get_node(data.selected);
        var level = $("#" + selectedNode.id).attr("aria-level");
        if (parseInt(level) <= 3) {
            loadConfig(inst, selectedNode);
        }
        $("#exampleTableEvents").bootstrapTable('destroy');
        $('#exampleTableEvents').bootstrapTable({
            classes: 'exampleTable',
            url: "../../dictionary/" + selectedNode.id,
            pagination: true,//设置为 true 会在表格底部显示分页条
            pageSize: 15,								//如果设置了分页，页面数据条数
            pageList: [15, 30, 45, 60],				//如果设置了分页，设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录。
            toolbar: '#exampleTableEventsToolbar',		//一个jQuery 选择器，指明自定义的toolbar 例如:#toolbar, .toolbar.
            clickToSelect: true,
            //showColumns: true,
            // height:$('#exampleTableEvents').height()*19,
            singleSelect: true,
            sortable: true,
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
    });
});
var pid = "";
var oid = "";

function loadConfig(inst, selectedNode) {
    $.ajax({
        url: "../../dictionary/" + selectedNode.id,
        dataType: "json",
        type: "GET",
        success: function (data) {
            data = dataTojson(data);
            if (data) {
                selectedNode.children = [];
                selectedNode.children_d = [];
                inst.close_node(selectedNode);
                $.each(data, function (i, item) {
                    inst.create_node(selectedNode, item, "last");
                });
                selectedNode.children = selectedNode.children_d;
                inst.open_node(selectedNode);
            } else {
                $("#using_json").html("暂无数据！");
            }
            $("#hid").val(selectedNode.id);
            pid = selectedNode.id;
        }

    });
}

var num = 0;

function dataTojson(arrays) {
    num++;
    var jsonstr = "[]";
    var jsonarray = eval('(' + jsonstr + ')');
    var dataStr = "[]";
    var dataArray = eval('(' + dataStr + ')');
    var msg;
    for (var i = 0; i < arrays.length; i++) {
        var arr = {
            "id": arrays[i].dictId,
            "parent": arrays[i].pdictId == "-1" ? "#" : arrays[i].pdictId,
            "text": arrays[i].dicName,
        };
        jsonarray.push(arr);
        var dataObj = {
            "dictId": arrays[i].dictId,
            "dicName": arrays[i].dicName,
            "pdictId": arrays[i].pdictId,
            "orderby": arrays[i].orderby,
        };
        oid = arrays[0].dictId;
        if (num != 1) {
            dataArray.push(dataObj);
        }
    }

    return jsonarray;
}