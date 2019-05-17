//生成bootstrapTable  
//bootstrapTable表格属性参考http://bootstrap-table.wenzhixin.net.cn/zh-cn/documentation/
$(function () {

    /**
     * 获取管辖单位
     */
    var josnOrganization = localStorage.getItem("organization");
    var organizationList = JSON.parse(josnOrganization);
    for (var i = 0; i < organizationList.length; i++) {
        if (organizationList[i].code != "") {
            $('#gxdw').append("<option value=" + organizationList[i].brevitycode + ">" + organizationList[i].name + "</option>");
        }
    }
    $('#gxdw').trigger('chosen:updated');
    //管辖单位下拉列表选中事件
    $('#gxdw').change(function () {
        var dominionValue = $("#gxdw").val();
        $("#gxdw option[value=dominionValue]").attr("selected", true);
    });

    /**
     *获取行业类别，可疑情况类型
     */
    var typeArray = [];//定义一个类型数组
    function initTypeArray(name) {
        this.name = name;
    }

    typeArray.push(new initTypeArray("行业类型"));
    typeArray.push(new initTypeArray("可疑情况类型"));

    for (var i = 0; i < typeArray.length; i++) {
        var initSelectOption = localStorage.getItem(typeArray[i].name);
        initSelectOption = JSON.parse(initSelectOption);
        console.info(initSelectOption);
        if (initSelectOption != null || initSelectOption != "") {
            initSelectOption.forEach(function (item, index) {
                if (typeArray[i].name == "行业类型") {
                    $('#hylx').append("<option value=" + item.name + ">" + item.name + "</option>");
                }
                if (typeArray[i].name == "可疑情况类型") {
                    $('#kyqklx').append("<option value=" + item.name + ">" + item.name + "</option>");
                }
            })

        }
    }

    /**********************
     *可疑情况列表
     **********************/
    loadTable();
});
/**********************
 *条件查询可疑情况列表
 **********************/
$('#search').click(function () {
    var startDate = $("#startDate").val().trim();
    var endDate = $("#endDate").val().trim();
    if (Date.parse(endDate) < Date.parse(startDate)) {
        warnningMsg("结束时间必须大于开始时间！");
        return false;
    }
    $("#exampleTableEvents").bootstrapTable('destroy');
    $('#exampleTableEvents').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded",//一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
        url: "../../zzkyqk/selectKyqkListHt",//要请求数据的文件路径
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
                field: 'qymc',
                title: '企业名称',
                align: 'center'
            },
            {
                field: 'hylb',
                title: '行业类型',
                align: 'center'
            },
            {
                field: 'gxdwmc',
                title: '管辖单位',
                align: 'center'
            },
            {
                field: 'kyqklx',
                title: '可疑情况类型',
                align: 'center'
                //visible: false
            },
            {
                field: 'tbsj',
                title: '上报日期',
                align: 'center',
                formatter: function (value, row, index) {
                    return changeDateFormat(value);
                }
            },
            {
                field: 'clzt',
                title: '处理状态',
                align: 'center'
            }
        ]
    });
});

function loadTable() {
    $("#exampleTableEvents").bootstrapTable('destroy');
    $('#exampleTableEvents').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded",//一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
        url: "../../zzkyqk/selectKyqkListHt",//要请求数据的文件路径
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination: true,//是否分页w
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
            },
            {
                field: 'state',
                checkbox: true
            },
            {
                field: 'qymc',
                title: '企业名称',
                align: 'center'
            },
            {
                field: 'hylb',
                title: '行业类型',
                align: 'center'
            },
            {
                field: 'gxdwmc',
                title: '管辖单位',
                align: 'center'
            },
            {
                field: 'kyqklx',
                title: '可疑情况类型',
                align: 'center'
            },
            {
                field: 'tbsj',
                title: '上报日期',
                align: 'center',
                formatter: function (value, row, index) {
                    return changeDateFormat(value);
                }
            },
            {
                field: 'clzt',
                title: '处理状态',
                align: 'center'
            },
            {
                field: 'ydxxms',
                title: '疑点信息描述',
                align: 'center',
                visible: false
            },
            {
                field: 'jjrgh',
                title: '接警人工号',
                align: 'center',
                visible: false
            },
            {
                field: 'jjrxm',
                title: '接警人姓名',
                align: 'center',
                visible: false
            },
            {
                field: 'jjsj',
                title: '接警时间',
                align: 'center',
                visible: false
            },
            {
                field: 'jjcljg',
                title: '处理结果',
                align: 'center',
                visible: false
            }
        ]
    });
}

/**********************
 *可疑情况详情
 * ..................................
 **********************/
$("#detailButton").click(function () {
    var array = $('#exampleTableEvents').bootstrapTable('getSelections');
    if (array.length == 1) {
        var obj = array[0];
        $("#djbh2").html(obj.kyqkid);
        $("#kyqklx2").html(obj.kyqklx);
        $("#tbrybh2").html(obj.tbrbh);
        $("#tbryxm2").html(obj.tbrxm);
        $("#xqms2").html(obj.ydxxms);
        $("#gxdw2").html(obj.gxdwmc);
        $("#jjrgh2").html(obj.jjrgh);
        $("#jjrxm2").html(obj.jjrxm);
        $("#cljg2").html(obj.jjcljg);
        if(obj.jjsj != null && obj.jjsj.length > 18){
            $("#jjsj2").html(obj.jjsj.substring(0, 19));
        }
    } else {
        warnningMsg('请选择一条数据！');
        return false;
    }
});


/**********************
 *可疑情况处理
 **********************/
var jsonStrInit;//表单初始化时，序列化的json字符串
$("#editButton").click(function () {
    jsonStrInit = "";
    $("#editForm")[0].reset();
    $("#editForm").validate().resetForm();
    var array = $('#exampleTableEvents').bootstrapTable('getSelections');
    if (array.length == 1) {
        obj = array[0];
        var clzt = obj.clzt;
        if (clzt != '已处理') {
            $("#editForm")[0].reset();
            $("#editForm").validate().resetForm();
            $("#djbh3").html(obj.kyqkid);
            $("#kyqklx3").html(obj.kyqklx);
            $("#tbrybh3").html(obj.tbrbh);
            $("#tbryxm3").html(obj.tbrxm);
            $("#xqms3").html(obj.ydxxms);
            $("#gxdw3").html(obj.gxdwmc);
            jsonStrInit += jsonTextInit("editForm");
        } else {
            warnningMsg('该数据已处理！');
            return false;
        }

    } else {
        warnningMsg('请选择一条数据！');
        return false;
    }
});
$("#search1").click(function () {
    var jsonStr = '';
    jsonStr += jsonTextInit("editForm");
    if (jsonStrInit == jsonStr) {
        warnningMsg("您未做修改操作");
        return false;
    } else {
        var array = $('#exampleTableEvents').bootstrapTable('getSelections');
        obj = array[0];
        var djbh = obj.kyqkid;
        var cljg = $("#cljg").val();
        var requestDate = JSON.stringify({
            'kyqkid': djbh,
            'jjcljg': cljg,
        });
        if ($("#editForm").valid()) {	//表单验证
            $.ajax({
                url: "../../zzkyqk/updateKyqkHt",
                contentType: "application/json;charset=UTF-8",
                type: "post",
                data: requestDate,
                success: function (data) {
                    var msg = data.result;
                    if (msg == "操作成功") {
                        successMsg(data.result);
                        $("#myModal2").modal('hide');
                        loadTable();
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

//请求服务数据时所传参数
function queryParams(params) {
    var qymc = $("#qymc").val().trim();
    var hylx = $("#hylx").val().trim();
    var gxdwbm = $("#gxdw").val().trim();
    var kyqklx = $("#kyqklx").val().trim();
    var startDate = $("#startDate").val().trim();
    var endDate = $("#endDate").val().trim();
    var organizationCode = JSON.parse(localStorage.getItem('organizationCode'));
    return {
        pageSize: params.limit, //每一页的数据行数，默认是上面设置的10(pageSize)
        pageIndex: params.offset / params.limit + 1, //当前页面,默认是上面设置的1(pageNumber)
        qymc: qymc,
        hylx: hylx,
        gxdwbm: gxdwbm,
        kyqklx: kyqklx,
        startDate: startDate,
        endDate: endDate,
        organizationCode:organizationCode
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

//日期截取
function changeDateFormat(cellval) {
    var dateVal = cellval + "";
    if (cellval != null) {
        var date = dateVal.substring(0, 19);
        return date
    }
    return ("");
}

