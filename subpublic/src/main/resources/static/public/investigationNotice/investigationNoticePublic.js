$(function () {
    var xctb = {};
    //加载典当行业协查通报
    $.ajax({
        url: '../../dmxctb/selectByExample?state=3',
        type: 'POST',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify(xctb),
        success: function (data) {
            getDataList2(data);
            //点击查询按钮
            $("#btn_search").unbind();
            $("#btn_search").click(function () {
                var xctb = {};
                //console.log("查询事件");

                xctb.fbsj = new Date($("#fbsjslect").val()).getTime();
                xctb.jzrq = new Date($("#jzsjselect").val()).getTime();
                xctb.bt = $("#btselect").val();
                if (xctb.fbsj > xctb.jzrq) {
                    warnningMsg("发布结束时间必须大于开始时间！");
                    return false;
                }
                //查询按钮对协查通报表模糊查询
                $.ajax({
                    url: '../../dmxctb/selectByExample?state=1',
                    type: 'POST',
                    contentType: 'application/json;charset=UTF-8',
                    data: JSON.stringify(xctb),
                    success: function (data) {
                        getDataList2(data);
                    }
                });

            }); //点击查询按钮事件结束

            //点击详情按钮
            $("#btn_detail").unbind();
            $("#btn_detail").click(function () {
                if ($('.selected').length == 1) {
                    $("#btn_detail").attr("data-target", "#myModalMsg");
                    var selectdata = $("#table").bootstrapTable('getSelections')[0];

                    $("#download").unbind();
                    $("#download").click(function () {
                        var sysAttachments = {};
                        sysAttachments.tableId = selectdata.tbid;
                        sysAttachments.tableName = "dm_xctb";

                        //查询本表id对应的文件表的文件信息
                        $.ajax({
                            url: '../../sysAttachments/selectByExample',
                            type: 'POST',
                            contentType: 'application/json;charset=UTF-8',
                            data: JSON.stringify(sysAttachments),
                            success: function (data) {
                                // if(data.length>0){
                                //     window.location.href='../../common/attachmentDownload?tableId='+sysAttachments.tableId+"&tableName="+"dm_xctb";
                                // }
                                if (data != null && data.length == 1) {
                                    var fileattach = data[0];
                                    window.location.href = '../../dmxctb/download?id=' + fileattach.id;
                                } else {
                                    warnningMsg("服务器文件丢失，请重新上传");
                                }
                            }
                        });

                    });

                    $("#myModalMsg input:checkbox").each(function (i) {
                        $(this).prop("checked", false);
                        if ($(this).val() == selectdata.sxhylbmc) {
                            $(this).prop("checked", true);
                        }
                    });
                    $("#myModalMsg #fbr").html(selectdata.fbr);
                    $("#myModalMsg #fbsj").html(changeDateFormat(selectdata.fbsj));
                    $("#myModalMsg #jzrq").html(changeDateFormat(selectdata.jzrq));
                    $("#myModalMsg #fbdw").html(selectdata.fbdw);
                    $("#myModalMsg #bt").html(selectdata.bt);
                    $("#myModalMsg #fbnr").val(selectdata.fbnr);
                    var sysAttachments = {};
                    sysAttachments.tableId = selectdata.tbid;
                    sysAttachments.tableName = "dm_xctb";

                    //查询本表id对应的文件表的文件信息
                    $.ajax({
                        url: '../../sysAttachments/selectByExample',
                        type: 'POST',
                        contentType: 'application/json;charset=UTF-8',
                        data: JSON.stringify(sysAttachments),
                        success: function (data) {
                            if (data.length > 0) {
                                var fileattach = data[0];
                                $("#msgfilename").val(fileattach.fileName);
                                //$("#up").val(fileattach.fileName);
                            } else {
                                $("#msgfilename").val("未上传文件");
                                $("#up").val("");
                            }
                        }
                    });

                } else {
                    warnningMsg("请选择一行");
                    $("#btn_detail").attr("data-target", "");
                }
            });


        }
    });
});


/**
 *获取协查通报表格数据
 */
function getDataList() {
    $('#table').bootstrapTable('destroy');
    $('#table').bootstrapTable({
        method: 'POST',
        //contentType: "application/x-www-form-urlencoded",//一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
        url:  "../../dmxctb/selectByExample?state=2",//要请求数据的文件路径
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,
        pageSize: 15,								//如果设置了分页，页面数据条数
        pageList: [15, 30, 45, 60],				//如果设置了分页，设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录。
        clickToSelect: true,
        singleSelect: true,
        sortable: true,
        columns: [
            {
                title: '序号',
                align: 'center',
                width: 20,
                formatter: function (value, row, index) {
                    return index + 1;
                }
            }, {
                field: 'state',
                checkbox: true,
                align: 'center'
            }, {
                field: 'fbsj',
                title: '发布时间',
                align: 'center',
                formatter: function (value, row, index) {
                    return changeDateFormat(value)
                }
            }, {
                field: 'fbdw',
                title: '发布单位',
                align: 'center'
            }, {
                field: 'bt',
                title: '标题',
                align: 'center'
            }, {
                field: 'fbr',
                title: '发布人',
                align: 'center'
            }
        ]
    });
}


//修改——转换日期格式(时间戳转换为datetime格式)
function changeDateFormat(cellval) {
    cellval = "/Date(" + cellval + ")/";
    if (cellval != null) {
        var date = new Date(parseInt(cellval.replace("/Date(", "").replace(")/", ""), 10));
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        var hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
        var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
        var second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
        return date.getFullYear() + "-" + month + "-" + currentDate + " " + hour + ":" + minutes + ":" + second;
    }
}


function getDataList2(data) {
    $('#table').bootstrapTable('destroy');
    $('#table').bootstrapTable({
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,
        pageSize: 15,								//如果设置了分页，页面数据条数
        pageList: [15, 30, 45, 60],				//如果设置了分页，设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录。
        clickToSelect: true,
        singleSelect: true,
        data: data,
        sortable: true,
        columns: [
            {
                title: '序号',
                align: 'center',
                width: 20,
                formatter: function (value, row, index) {
                    return index + 1;
                }
            }, {
                field: 'state',
                checkbox: true,
                align: 'center',
            }, {
                field: 'bt',
                title: '标题',
                align: 'center',
            }, {
                field: 'fbdw',
                title: '发布单位',
                align: 'center',
            }, {
                field: 'fbr',
                title: '发布人',
                align: 'center',
            }, {
                field: 'fbsj',
                title: '发布时间',
                align: 'center',
                formatter: function (value, row, index) {
                    return changeDateFormat(value)
                }
            }
        ],
        data: data
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