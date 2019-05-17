//生成bootstrapTable  
//bootstrapTable表格属性参考http://bootstrap-table.wenzhixin.net.cn/zh-cn/documentation/

$(function () {
     /**********************
     *可疑情况列表
     **********************/
    loadTable();
    //获取可疑情况类型下拉列表
    $.ajax({
        url: "../../dictionary/getKyqkType",
        type: 'post',
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                $('.kyqklx').append("<option>" + data[i].dicName + "</option>");
            }
        },
        error: function (data) {
            dangerMsg(data);
        }
    });
});

/**********************
 *条件查询可疑情况列表
 **********************/
$('#search').click(function () {
    var startDate1 = $("#startDate").val().trim();
    var endDate1 = $("#endDate").val().trim();
    if (Date.parse(endDate1) < Date.parse(startDate1)) {
        warnningMsg("结束时间必须大于开始时间！");
        return false;
    }

    $("#exampleTableEvents").bootstrapTable('destroy');
    $('#exampleTableEvents').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded",//一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
        url: "../../zzkyqk/selectKyqkList",//要请求数据的文件路径
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination: true,//是否分页
        queryParams: queryParams,//请求服务器时所传的参数
        sidePagination: 'client',//指定服务器端分页
        singleSelect: true,
        pageSize: 15,//单页记录数
        pageList: [15, 30],//分页步进值
        clickToSelect: true,    //是否启用点击选中行
        columns: [
            {
                field: 'number',
                title: '序号',
                align: 'center',
                width: 20,
                formatter: function (value, row, index) {
                    return index + 1;
                }
            }, {
                field: 'state',
                checkbox: true
            },
            {
                field: 'kyqkid',
                title: '登记序号',
                align: 'center'
            },

            {
                field: 'kyqklx',
                title: '可疑情况类型',
                align: 'center'
            },
            {
                field: 'tbsj',
                title: '填报时间',
                align: 'center',
                formatter: function (value, row, index) {
                    return changeDateFormat(value);
                }
            }
        ]
    });
});

function loadTable() {
    $("#exampleTableEvents").bootstrapTable('destroy');
    $('#exampleTableEvents').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded",//一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
        url: "../../zzkyqk/selectKyqkList",//要请求数据的文件路径
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination: true,//是否分页
        queryParams: queryParams,//请求服务器时所传的参数
        sidePagination: 'client',//指定服务器端分页
        singleSelect: true,
        pageSize: 15,//单页记录数
        toolbar: '#exampleTableEventsToolbar',		//一个jQuery 选择器，指明自定义的toolbar 例如:#toolbar, .toolbar.
        pageList: [15, 30],//分页步进值
        clickToSelect: true,    //是否启用点击选中行
        columns: [
            {
                field: 'number',
                title: '序号',
                align: 'center',
                width: 20,
                formatter: function (value, row, index) {
                    return index + 1;
                }
            }, {
                field: 'state',
                checkbox: true
            },
            {
                field: 'kyqkid',
                title: '登记序号',
                align: 'center'
            },
            {
                field: 'kyqklx',
                title: '可疑情况类型',
                align: 'center'
            },
            {
                field: 'tbsj',
                title: '填报时间',
                align: 'center',
                formatter: function (value, row, index) {
                    return changeDateFormat(value);
                }
            },
            {
                field: 'ydxxms',
                title: '填报内容',
                align: 'center',
                visible: false
            }
        ]
    });
}

/**********************
 *可疑情况详情
 **********************/
$("#detailButton").click(function () {
    var array = $('#exampleTableEvents').bootstrapTable('getSelections');
    if (array.length == 1) {
        var obj = array[0];
        $("#djbh2").html(obj.kyqkid);
        $("#kyqklx2").html(obj.kyqklx);
        $("#tbrybh2").html(obj.tbrbh);
        $("#tbryxm2").html(obj.tbrxm);
        $("#tbnr2").html(obj.ydxxms);
    } else {
        warnningMsg('请选择一条数据！');
        return false;
    }
});

/**********************
 *可疑情况添加
 *************/
$("#addButton").click(function () {
    $("#addForm")[0].reset();
    $("#addForm").validate().resetForm();
});

$("#search1").click(function () {
    var varningStr = '';
    var qyrybm = $('#qyrybm', parent.document).val();
    var qyid = $('#qyid3', parent.document).val();
    var qymc = $('#qymc3', parent.document).val();
    var hylb = $('#hylb3', parent.document).val();
    var gxdwmc = $('#gxdwmc3', parent.document).val();
    var gxdwbm = $('#gxdwbm3', parent.document).val();
    var kyqklx = $("#kyqklx3").val();
    var tbnr = $("#tbnr3").val();
    var loginName = $('#loginName', parent.document).html();

    var requestData = JSON.stringify({
        'kyqklx': kyqklx,
        'tbnr': tbnr,
        'tbrxm': loginName,
        'tbrbh': qyrybm,
        'qyid': qyid,
        'qymc': qymc,
        'hylb': hylb,
        'gxdwmc': gxdwmc,
        'gxdwbm': gxdwbm
    });
    if (varningStr != '') {
        warnningMsg(varningStr);
        return false;
    }
    if ($("#addForm").valid()) {
        $.ajax({
            url: "../../zzkyqk/insertKyqk",
            contentType: "application/json;charset=UTF-8",
            type: "post",
            data: requestData,
            success: function (data) {
                var msg = data.result;
                if (msg == "操作成功") {
                    warnningMsg("添加成功！");
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
 *删除
 **********************/
$('#deleteButton').click(function () {
    var array = $('#exampleTableEvents').bootstrapTable('getSelections');
    if (array.length != 1) {
        warnningMsg("请选择一条数据！");
        return false;
    }
    var obj = array[0];
    var kyqkid = obj.kyqkid;
    deleteMsg("您确认要删除所选数据吗？", kyqkid);
});

//请求服务数据时所传参数
function queryParams(params) {
    var loginName = $('#loginName', parent.document).html();
    var kyqklx = $("#kyqklx").val().trim();
    var startDate = $("#startDate").val().trim();
    var endDate = $("#endDate").val().trim();

    return {
        pageSize: params.limit, //每一页的数据行数，默认是上面设置的10(pageSize)
        pageIndex: params.offset / params.limit + 1, //当前页面,默认是上面设置的1(pageNumber)
        kyqklx: kyqklx,
        startDate: startDate,
        endDate: endDate,
        username: loginName
    }
}

//在表单加载(初始化)时把表单序列化成json格式数据
function jsonTextInit(formName) {
    var seletor = "#" + formName;
    var dataformInit = $(seletor).serializeArray();
    var jsonTextInit = JSON.stringify({data: dataformInit});
    return jsonTextInit;
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

/*删除提示信息*/
function deleteMsg(data, kyqkid) {
    //e.preventDefault();
    $.smkConfirm({
        text: data,
        accept: '确定',
        cancel: '取消'
    }, function (res) {
        // Code here
        if (res) {
            $.ajax({
                url: "../../zzkyqk/delete?kyqkid=" + kyqkid,
                contentType: "application/json;charset=UTF-8",
                type: "post",
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

//日期截取
function changeDateFormat(cellval) {
    var dateVal = cellval + "";
    if (cellval != null) {
        var date = dateVal.substring(0, 19);
        return date
    }
    return ("");
}