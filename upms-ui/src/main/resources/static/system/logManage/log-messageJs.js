function add0(m) {
    return m < 10 ? '0' + m : m
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

function format(shijianchuo) {
    //shijianchuo是整数，否则要parseInt转换
    var time = new Date(shijianchuo);
    var y = time.getFullYear();
    var m = time.getMonth() + 1;
    var d = time.getDate();
    var h = time.getHours();
    var mm = time.getMinutes();
    var s = time.getSeconds();
    return y + '-' + add0(m) + '-' + add0(d) + '&nbsp;&nbsp;' + add0(h) + ':' + add0(mm) + ':' + add0(s);//+' '+add0(h)+':'+add0(mm)+':'+add0(s)
}

$(document).ready(function () {
    $.ajax({
        url: '../../log/selectLog',
        type: "GET",
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                data[i].addtime = format(data[i].addtime);
            }
            $('#exampleTableEvents').bootstrapTable('destroy');
            $('#exampleTableEvents').bootstrapTable({
                pagination: true,//设置为 true 会在表格底部显示分页条
                pageNumber: 1,
                pageSize: 15,								//如果设置了分页，页面数据条数
                pageList: [15, 30],				//如果设置了分页，设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录。
                toolbar: '#exampleTableEventsToolbar',		//一个jQuery 选择器，指明自定义的toolbar 例如:#toolbar, .toolbar.
                clickToSelect: true,
                singleSelect: true,
                data: data,
                sortable: true,
                columns: [
                    {
                        field: 'number',
                        title: '序号',
                        align: 'center',
                        width: 30,
                        formatter: function (value, row, index) {
                            return index + 1;
                        }
                    },
                    {
                        field: 'logId',
                        title: '主键',
                        visible:false
                    }, {
                        field: 'username',
                        title: '参数名称'
                    }, {
                        field: 'uri',
                        title: '参数路径'
                    }, {
                        field: 'ip',
                        title: '参数ip'
                    }, {
                        field: 'description',
                        title: '日志描述'
                    }, {
                        field: 'addtime',
                        title: '操作时间'
                    }
                ]
            })
        }
    });
});
$('#search').click(function () {

    var paramName = $('#paramName').val().trim();
    var paramValue = $('#paramValue').val().trim();
    var description = $('#description').val().trim();
    var loginDateStart = $('#loginDateStart').val().trim();
    var loginDateEnd = $('#loginDateEnd').val().trim();
    if (Date.parse(loginDateEnd) < Date.parse(loginDateStart)) {
        warnningMsg("操作结束时间必须大于开始时间！");
        return false;
    }
    $.ajax({
        url: '../../log/selectByCondition',
        type: 'POST',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify({
            'paramName': paramName,
            'paramValue': paramValue,
            'description': description,
            'loginDateStart': loginDateStart,
            'loginDateEnd': loginDateEnd
        }),
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                data[i].addtime = format(data[i].addtime);
            }
            $('#exampleTableEvents').bootstrapTable('destroy');
            $('#exampleTableEvents').bootstrapTable({
                pagination: true,//设置为 true 会在表格底部显示分页条
                pageNumber: 1,
                pageSize: 15,								//如果设置了分页，页面数据条数
                pageList: [15, 30, 45, 60],				//如果设置了分页，设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录。
                toolbar: '#exampleTableEventsToolbar',		//一个jQuery 选择器，指明自定义的toolbar 例如:#toolbar, .toolbar.
                clickToSelect: true,
                singleSelect: true,
                data: data,
                sortable: true,
                columns: [
                    {
                        field: 'logId',
                        title: '序号'
                    }, {
                        field: 'username',
                        title: '参数名称'
                    }, {
                        field: 'uri',
                        title: '参数路径'
                    }, {
                        field: 'ip',
                        title: '参数ip'
                    }, {
                        field: 'description',
                        title: '日志描述'
                    }, {
                        field: 'addtime',
                        title: '操作时间'
                    }
                ]
            })
        },
        error: function (data) {
            dangerMsg(data);
        }

    })
});