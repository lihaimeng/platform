var uploadarr = [];
var ajaxreturn = [];

$(function () {
    /**
     *获取行业类别
     */
    var typeArray = [];//定义一个类型数组
    function initTypeArray(name) {
        this.name = name;
    }

    typeArray.push(new initTypeArray("行业类型"));

    for (var i = 0; i < typeArray.length; i++) {
        var initSelectOption = localStorage.getItem(typeArray[i].name);
        initSelectOption = JSON.parse(initSelectOption);
        console.info(initSelectOption);
        if (initSelectOption != null || initSelectOption != "") {
            initSelectOption.forEach(function (item, index) {
                if (typeArray[i].name == "行业类型") {
                    $('#hylx').append("<option value=" + item.name + ">" + item.name + "</option>");
                }
            })

        }
    }
    $.ajax({
        url: '../../dmxctb/selectList',
        type: 'GET',
        success: function (data) {
            getDataList(data);


            //点击查询按钮
            $("#btn_search").unbind();
            $("#btn_search").click(function () {
                var xctb = {};
                //console.log("查询事件");
                xctb.fbsj = new Date($("#fbsjslect").val()).getTime();
                //xctb.fbsj=1520301540000;
                xctb.jzrq = new Date($("#jzsjselect").val()).getTime();
                if (xctb.fbsj > xctb.jzrq) {
                    warnningMsg("发布结束时间必须大于开始时间！");
                    return false;
                }
                var options = $("#hylx option:selected");
                xctb.sxhylbmc = options.val();
                xctb.fbdw = $("#fbdwselect").val();
                xctb.fbr = $("#fbrselect").val();


                xctb.fbsj = new Date($("#fbsjslect").val()).getTime();
                //xctb.fbsj=1520301540000;
                xctb.jzrq = new Date($("#jzsjselect").val()).getTime();

                //查询按钮对协查通报表模糊查询
                $.ajax({
                    url: '../../dmxctb/selectByExample?state=0',
                    type: 'POST',
                    contentType: 'application/json;charset=UTF-8',
                    data: JSON.stringify(xctb),
                    success: function (data) {
                        getDataList(data);
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
                                if (data != null && data.length == 1) {
                                    window.location.href = '../../common/attachmentDownload?tableId=' + sysAttachments.tableId + "&tableName=" + "dm_xctb";
                                } else {
                                    warnningMsg("服务器文件丢失，请重新上传");
                                }
                            }
                        }); //查询本表id 下载完成

                    });

                    var str = selectdata.sxhylbmc;
                    $("#myModalMsg input:checkbox").each(function (i) {
                        $(this).prop("checked", false);
                    });
                    if (str != null) {
                        str = str.split("，");
                        $("#myModalMsg input:checkbox").each(function (i) {
                            for (var i = 0; i < str.length; i++) {
                                if (str[i] != "" && $(this).val() == str[i]) {
                                    $(this).prop("checked", true);
                                }
                            }
                        });
                    }
                    $("#myModalMsg #fbr").html(selectdata.fbr);
                    $("#myModalMsg #fbsj").html(changeDateFormat(selectdata.fbsj));
                    $("#myModalMsg #jzrq").html(changeDateFormat(selectdata.jzrq));
                    $("#myModalMsg #fbdw").html(selectdata.fbdw);
                    $("#myModalMsg #bt").html(selectdata.bt);
                    $("#myModalMsg #fbnr").val(selectdata.fbnr);

                    var sysAttachments = {};
                    sysAttachments.tableId = selectdata.tbid;
                    sysAttachments.tableName = "dm_xctb";


                    for (var i = 0; i < uploadarr.length; i++) {
                        if (uploadarr[i] == selectdata.tbid) {
                            $("#myModalMsg #msgfilename").val("正在上传文件");
                            $("#download").val("");
                            ajaxreturn[i].done(function (result) {
                                $("#myModalMsg #msgfilename").val(result.newname);
                            });
                            return;
                        }
                    }
                    //查询本表id对应的文件表的文件信息,详情业文件信息填充
                    $.ajax({
                        url: '../../sysAttachments/selectByExample',
                        type: 'POST',
                        contentType: 'application/json;charset=UTF-8',
                        data: JSON.stringify(sysAttachments),
                        success: function (data) {

                            var fileattach = data[0];
                            if (fileattach == null) {
                                $("#myModalMsg #msgfilename").val("未上传文件");
                                $("#download").val("");
                            } else {
                                $("#myModalMsg #msgfilename").val(fileattach.fileName);
                                $("#download").val(fileattach.fileName);
                            }
                        }
                    });

                } else {
                    warnningMsg("请选择一行");
                    $("#btn_detail").attr("data-target", "");
                }
            });

            //新增按钮
            $("#btn_add").unbind();
            $("#btn_add").click(function () {
                $("#myModalAddtitle").html("协查通告新增");

                //清空表单数据
                $("#myModalAdd input:checkbox").each(function (i) {
                    $(this).prop("checked", false);
                });
                $("#myModalAdd #bt2").val("");
                $("#myModalAdd #fbnr2").val("");
                $("#up").val("");
                $("#filename").val("");


                var data = {};
                $("#fileupload").unbind();
                $("#fileupload").click(function () {
                    $("#up").unbind();
                    $("#up").trigger("click");
                    $("#up").on("change", function () {
                        var file = $("#up").val();
                        var fileName = getFileName(file);

                        $("#filename").val(fileName);
                    })
                });

                $("#filedelete").unbind();
                $("#filedelete").click(function () {
                    $("#up").val("");
                    $("#filename").val("");
                });

                //保存文件事件开始
                $("#save").unbind();
                $("#save").click(function () {
                    $("#myModalAdd input:checkbox").each(function (i) {
                        if ($(this).is(":checked")) {
                            if (data.sxhylbmc == null)
                                data.sxhylbmc = $(this).val();
                            else
                                data.sxhylbmc = data.sxhylbmc + "，" + $(this).val();
                        }
                    });


                    data.fbsj = new Date().getTime();
                    data.jzrq = new Date().getTime();

                    // data.fbdw=$("#myModalAdd #fbdw").html();
                    data.bt = $("#myModalAdd #bt2").val();
                    data.fbnr = $("#myModalAdd #fbnr2").val();

                    if ((data.sxhylbmc == null) || (data.bt == "") || (data.fbnr == "")) {
                        warnningMsg("行业，标题和内容不能为空");
                        return;
                    }
                    $("#myModalAdd").modal('hide');  //手动关闭

                    $.ajax({
                        url: '../../dmxctb/insertSelective',
                        type: 'POST',
                        contentType: 'application/json;charset=UTF-8',
                        data: JSON.stringify(data),
                        success: function (data) {
                            if (data != null) {
                                successMsg("新增成功");

                                $('#table').bootstrapTable('refresh', {
                                    url: '../../dmxctb/selectList'
                                });
                                uploadfile(data);
                            }
                        }
                    });
                    /*//关联用户
                    $.ajax({
                        url: '../../dmxctb/getUser',
                        type: 'GET',
                        success: function (user) {
                            data.fbr = user.realname;

                            //查询组织机构
                            $.ajax({
                                url: '../../sysOrganization/selectByPrimaryKey/' + user.userid,
                                type: 'GET',
                                success: function (sysOrganization) {
                                    data.fbdw = sysOrganization.name;

                                    $.ajax({
                                        url: '../../dmxctb/insertSelective',
                                        type: 'POST',
                                        contentType: 'application/json;charset=UTF-8',
                                        data: JSON.stringify(data),
                                        success: function (data) {
                                            if (data != null) {
                                                successMsg("新增成功");

                                                $('#table').bootstrapTable('refresh', {
                                                    url: '../../dmxctb/selectList'
                                                });
                                                uploadfile(data);
                                            }
                                        }
                                    });
                                }
                            });//结束查询组织机构
                        }
                    });//关联用户结束*/


                });//保存文件事件结束
            });

            //点击修改按钮
            $("#btn_edit").unbind();
            $("#btn_edit").click(function () {
                var editfilemark = false;
                if ($('.selected').length == 1) {
                    $("#myModalAddtitle").html("协查通告修改");
                    $("#up").val("");
                    var selectdata = $("#table").bootstrapTable('getSelections')[0];
                    //qqq
                    for (var i = 0; i < uploadarr.length; i++) {
                        if (uploadarr[i] == selectdata.tbid) {
                            warnningMsg("正在上传文件，无法修改");
                            $("#btn_edit").attr("data-target", "");
                            ajaxreturn[i].done(function () {
                                $("#btn_edit").attr("data-target", "#myModalAdd");
                            });
                            return;
                        }
                    }
                    $("#btn_edit").attr("data-target", "#myModalAdd");
                    //为修改页面上传按钮增加事件
                    $("#fileupload").unbind();
                    $("#fileupload").click(function () {

                        $("#up").unbind();
                        $("#up").trigger("click");
                        $("#up").on("change", function () {
                            var file = $("#up").val();
                            var fileName = getFileName(file);

                            $("#filename").val(fileName);
                            editfilemark = true;
                        })
                    });

                    //为修改页面删除文件按钮增加事件
                    $("#filedelete").unbind();
                    $("#filedelete").click(function () {
                        $("#up").val("");
                        $("#filename").val("");
                        editfilemark = true;
                    });


                    var str = selectdata.sxhylbmc;
                    $("#myModalAdd input:checkbox").each(function (i) {
                        $(this).prop("checked", false);
                    });
                    if (str != null) {
                        str = str.split("，");
                        $("#myModalAdd input:checkbox").each(function (i) {
                            for (var i = 0; i < str.length; i++) {
                                if (str[i] != "" && $(this).val() == str[i]) {
                                    $(this).prop("checked", true);
                                }
                            }
                        });
                    }
                    $("#myModalAdd #bt2").val(selectdata.bt);
                    $("#myModalAdd #fbnr2").val(selectdata.fbnr);


                    //查询本表id对应的文件表的文件信息,详情业文件信息填充
                    var sysAttachments = {};
                    sysAttachments.tableId = selectdata.tbid;
                    sysAttachments.tableName = "dm_xctb";
                    $.ajax({
                        url: '../../sysAttachments/selectByExample',
                        type: 'POST',
                        contentType: 'application/json;charset=UTF-8',
                        data: JSON.stringify(sysAttachments),
                        success: function (data) {
                            if (data.length > 0) {
                                var fileattach = data[0];
                                $("#filename").val(fileattach.fileName);
                            } else {
                                $("#filename").val("未上传文件");
                                $("#up").val("");
                            }

                            //修改保存事件
                            $("#save").unbind();
                            $("#save").click(function () {
                                // $("#myModalAdd").hide();
                                // $('.modal-backdrop').remove();
                                $("#myModalAdd").modal('hide');  //手动关闭

                                var sysAttachments = {};
                                sysAttachments.tableId = selectdata.tbid;
                                sysAttachments.tableName = "dm_xctb";

                                //修改页面删除文件逻辑
                                if ($("#up").val() == "" && editfilemark == true) {   //上传控件为空直接删除文件
                                    //查询本表id对应的文件表的文件信息
                                    $.ajax({
                                        url: '../../sysAttachments/selectByExample',
                                        type: 'POST',
                                        contentType: 'application/json;charset=UTF-8',
                                        data: JSON.stringify(sysAttachments),
                                        success: function (data) {
                                            if (data.length > 0) {
                                                var fileattach = data[0];
                                                //console.log("删除对应信息：" + fileattach.id);
                                                //删除文件表对应信息
                                                $.ajax({
                                                    url: '../../sysAttachments/deleteByPrimaryKey/' + fileattach.id,
                                                    type: 'GET',
                                                    success: function (data) {
                                                    }
                                                });
                                            }
                                        }
                                    });
                                } else if (editfilemark == true) { //上传控件不为空，且被改动，先删除文件，再上传新文件
                                    //查询本表id对应的文件表的文件信息
                                    $.ajax({
                                        url: '../../sysAttachments/selectByExample',
                                        type: 'POST',
                                        contentType: 'application/json;charset=UTF-8',
                                        data: JSON.stringify(sysAttachments),
                                        success: function (data) {
                                            if (data.length > 0) {
                                                var fileattach = data[0];
                                                //console.log("删除对应信息：" + fileattach.id);
                                                //删除文件表对应信息
                                                $.ajax({
                                                    url: '../../sysAttachments/deleteByPrimaryKey/' + fileattach.id,
                                                    type: 'GET',
                                                    success: function (data) {
                                                        uploadfile(selectdata.tbid);
                                                    }
                                                });
                                            } else {
                                                uploadfile(selectdata.tbid);
                                            }
                                        }
                                    });
                                }


                                selectdata.sxhylbmc = null;
                                $("#myModalAdd input:checkbox").each(function (i) {
                                    if ($(this).is(":checked")) {
                                        if (selectdata.sxhylbmc == null)
                                            selectdata.sxhylbmc = $(this).val();
                                        else
                                            selectdata.sxhylbmc = selectdata.sxhylbmc + "，" + $(this).val();
                                    }
                                });
                                selectdata.bt = $("#myModalAdd #bt2").val();
                                selectdata.fbnr = $("#myModalAdd #fbnr2").val();

                                $.ajax({
                                    url: '../../dmxctb/updateByPrimaryKey',
                                    type: 'POST',
                                    contentType: 'application/json;charset=UTF-8',
                                    data: JSON.stringify(selectdata),
                                    success: function (data) {
                                        if (data == 1) {
                                            successMsg("修改成功");
                                            $('#table').bootstrapTable('refresh', {
                                                url: '../../dmxctb/selectList'
                                            });
                                        }
                                    }
                                });
                            }); //修改保存事件结束
                        }
                    });


                } else {
                    warnningMsg("请选择一行");
                    $("#btn_edit").attr("data-target", "");
                }
            });

            //点击删除按钮
            $("#btn_delete").unbind();
            $("#btn_delete").click(function () {
                if ($('.selected').length == 1) {
                    deleteMsg("确认要删除吗")

                } else {
                    warnningMsg("请选择一行");
                    $("#btn_edit").attr("data-target", "");
                }
            }); //删除按钮事件结束

        },
    });


});

//上传文件名截取
function getFileName(o) {
    var pos = o.lastIndexOf("\\");
    return o.substring(pos + 1);
}


function uploadfile(state) {
    //文件上传开始
    var fileObj = document.getElementById("up").files[0]; // js 获取文件对象
    if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
        //alert("请选择上传文件");
        return;
    }
    var formFile = new FormData();
    formFile.append("action", "UploadVMKImagePath");
    formFile.append("file", fileObj); //加入文件对象
    var data = formFile;
    var upajax = $.ajax({
        url: '../../common/attachmentUpload',
        data: data,
        type: "Post",
        cache: false,//上传文件无需缓存
        processData: false,//用于对data参数进行序列化处理 这里必须false
        contentType: false, //必须
        success: function (result) {
            //console.log("上传完成!");
            if (result.state == "OK") {
                //*状态零增加表关联
                //console.log("上传d完成! 文件名:"+result.newname);

                $.ajax({
                    url: '../../sysAttachments/insertSelectiveState?state=' + state + "&filename=" + result.newname,
                    type: 'GET',
                    success: function (data) {
                        if (data == 1) {
                            //console.log("新增成功");
                            ajaxreturn.shift();
                            uploadarr.shift();
                        }
                    }
                });

            }
        },
    });
    ajaxreturn.push(upajax);
    uploadarr.push(state);
    //文件上传结束
}


/**
 *获取协查通报表格数据
 */
function getDataList(data) {
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
                align: 'center'
            }, {
                field: 'bt',
                title: '标题',
                align: 'center'
            }, {
                field: 'sxhylbmc',
                title: '行业类型',
                align: 'center'
            }, {
                field: 'fbdw',
                title: '发布单位',
                align: 'center'
            }, {
                field: 'fbr',
                title: '发布人',
                align: 'center'

            }, {
                field: 'fbsj',
                align: 'center',
                title: '发布开始时间',
                //——修改——获取日期列的值进行转换
                formatter: function (value, row, index) {
                    return changeDateFormat(value)
                }
            }
        ],
        data: data
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

/*删除确认提示信息*/
function deleteMsg(data) {
    var selectdata = $("#table").bootstrapTable('getSelections')[0];

    for (var i = 0; i < uploadarr.length; i++) {
        if (uploadarr[i] == selectdata.tbid) {
            warnningMsg("正在上传文件，无法删除");
            return;
        }
    }
    $.smkConfirm({
        text: data,
        accept: '确定',
        cancel: '取消'
    }, function (res) {
        // Code here
        if (res) {
            var selectdata = $("#table").bootstrapTable('getSelections')[0];

            $.ajax({
                url: '../../dmxctb/deleteByPrimaryKey/' + selectdata.tbid,
                type: 'GET',
                success: function (data) {
                    if (data == 1) {
                        $('#table').bootstrapTable('refresh', {
                            url: '../../dmxctb/selectList'
                        });
                    }
                }
            });

            var sysAttachments = {};
            sysAttachments.tableId = selectdata.tbid;
            sysAttachments.tableName = "dm_xctb";
            //删除按钮删除文件逻辑
            //查询本表id对应的文件表的文件信息
            $.ajax({
                url: '../../sysAttachments/selectByExample',
                type: 'POST',
                contentType: 'application/json;charset=UTF-8',
                data: JSON.stringify(sysAttachments),
                success: function (data) {
                    if (data.length > 0) {
                        var fileattach = data[0];
                        //console.log("删除对应信息：" + fileattach.id);
                        //删除文件表对应信息
                        $.ajax({
                            url: '../../sysAttachments/deleteByPrimaryKey/' + fileattach.id,
                            type: 'GET',
                            success: function (data) {
                            }
                        });
                    }
                }
            });

            successMsg("删除成功");
        }
    });
}