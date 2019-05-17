//生成bootstrapTable  
//bootstrapTable表格属性参考http://bootstrap-table.wenzhixin.net.cn/zh-cn/documentation/
(function () {
    /**********************
     *从业人员列表
     **********************/
    loadTable();
    /**********************
     *企业人员信息查询
     **********************/
    $('#search').click(function () {
        // $('#exampleTableEvents').bootstrapTable('refresh', {url:'../../qyry/selectQyryxxs'});//bug:当输入条件查询条件时，点击新增会直接查询
        $("#exampleTableEvents").bootstrapTable('destroy');
        $('#exampleTableEvents').bootstrapTable({
            method: 'get',
            //contentType: "application/x-www-form-urlencoded",//一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
            url: "../../qyry/selectQyryxxs",//要请求数据的文件路径
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
                },
                {
                    field: 'state',
                    checkbox: true
                },
                {
                    field: 'cyrybh',
                    title: '人员编号',
                    align: 'center',
                    width: 20,
                },
                {
                    field: 'xm',
                    title: '姓名',
                    align: 'center'
                },
                {
                    field: 'xb',
                    title: '性别',
                    align: 'center'
                }, {
                    field: 'xbdm',
                    title: '性别代码',
                    align: 'center',
                    visible: false
                },
                {
                    field: 'zjhm',
                    title: '证件号码',
                    align: 'center'
                },
                {
                    field: 'minzu',
                    title: '民族',
                    align: 'center'
                },
                {
                    field: 'mzdm',
                    title: '民族代码',
                    align: 'center',
                    visible: false
                },
                {
                    field: 'cyzj',
                    title: '证件类型',
                    align: 'center',
                    visible: false
                },
                {
                    field: 'cyzjdm',
                    title: '常用证件代码',
                    align: 'center',
                    visible: false
                },
                {
                    field: 'whcd',
                    title: '文化程度',
                    align: 'center',
                    visible: false
                },
                {
                    field: 'whcddm',
                    title: '文化程度代码',
                    align: 'center',
                    visible: false
                },
                {
                    field: 'rzrq',
                    title: '入职日期',
                    align: 'center',
                    visible: false
                },
                {
                    field: 'cyryzt',
                    title: '人员状态',
                    align: 'center'
                },
                {
                    field: 'cyryztdm',
                    title: '人员状态代码',
                    align: 'center',
                    visible: false
                },
                {
                    field: 'lxdh',
                    title: '联系方式',
                    align: 'center',
                    visible: false
                },
                {
                    field: 'hjdxz',
                    title: '户籍住址',
                    align: 'center',
                    visible: false
                },
                {
                    field: 'xzdxzqh',
                    title: '现住址',
                    align: 'center',
                    visible: false
                },
                {
                    field: 'qymc',
                    title: '企业名称',
                    align: 'center'
                },
                {
                    field: 'qybm',
                    title: '企业编号',
                    align: 'center'
                },
                {
                    field: 'roleName',
                    title: '角色',
                    align: 'center',
                    visible: false
                }
            ]
        });
    });
    /**********************
     *新增从业人员
     **********************/
    /*点击新增按钮时，去掉输入框内容*/
    $("#addButton").click(function () {
        $("#addForm")[0].reset();
        $('.form-group').removeClass('has-error');
        $("#imageAdd1").attr("src", "weichat.jpg");
    });
    $("#submitForAdd").click(function () {
        var varningStr = '';
        var qyryxx = {};
        var role = {};

        //var cyrybh = $("#cyrybh").val();
        var xm = $("#xm").val();
        if (xm == '') {
            varningStr += "请填写人员姓名" + "</br>";
            warnningMsg(varningStr);
            return false;
        }
        var cyzjdm = $("#cyzj").val();
        if (cyzjdm == '') {
            varningStr += "请填写常用证件类型" + "</br>";
            warnningMsg(varningStr);
            return false;
        }
        var cyzj = $('#cyzj option:selected').text().trim();
        var zjhm = $("#zjhm").val();
        if (zjhm == '') {
            varningStr += "请填写证件号码" + "</br>";
            warnningMsg(varningStr);
            return false;
        }
        var whcddm = $("#whcd").val();
        if (whcddm == '') {
            varningStr += "请填写文化程度" + "</br>";
            warnningMsg(varningStr);
            return false;
        }
        var whcd = $('#whcd option:selected').text().trim();
        var rzrq = $("#rzrq").val();
        if (rzrq == '') {
            varningStr += "请填写入职日期" + "</br>";
            warnningMsg(varningStr);
            return false;
        }
        var mzdm = $("#minzu").val();
        if (mzdm == '') {
            varningStr += "请填写民族" + "</br>";
            warnningMsg(varningStr);
            return false;
        }
        var minzu = $('#minzu option:selected').text().trim();
        var xbdm = $("#xb").val();
        if (xbdm == '') {
            varningStr += "请填写性别" + "</br>";
            warnningMsg(varningStr);
            return false;
        }
        var xb = $('#xb option:selected').text().trim();
        //角色
        var roleName = $("#roleName").val();
        if (roleName == '') {
            varningStr += "请填写角色" + "</br>";
            warnningMsg(varningStr);
            return false;
        }
        var lxdh = $("#lxdh").val();
        if (lxdh == '') {
            varningStr += "请填写联系方式" + "</br>";
            return false;
        }
        var hjdxz = $("#hjdxz").val();
        var xzdxzqh = $("#xzdxzqh").val();
        // 'cyrybh': cyrybh,
        qyryxx.roleName = roleName;
        qyryxx.xm = xm;
        qyryxx.xbdm = xbdm;
        qyryxx.xb = xb;
        qyryxx.mzdm = mzdm;
        qyryxx.minzu = minzu;
        qyryxx.cyzjdm = cyzjdm;
        qyryxx.cyzj = cyzj;
        qyryxx.zjhm = zjhm;
        qyryxx.whcddm = whcddm;
        qyryxx.whcd = whcd;
        qyryxx.rzrq = rzrq;
        qyryxx.lxdh = lxdh;
        qyryxx.hjdxz = hjdxz;
        qyryxx.xzdxzqh = xzdxzqh;
        role.name = roleName;
        var requestDate = JSON.stringify({
            qyryxx: qyryxx,
            role: role
        });
        if ($("#addForm").valid()) {//表单验证
            $.ajax({
                url: "../../qyry/insert",
                contentType: "application/json;charset=UTF-8",
                type: "post",
                data: requestDate,
                success: function (data) {
                    var msg = data.result;
                    if (msg == "操作成功") {
                        $('.closeBtn').click();
                        $('#ryid').val(data.resultRyid);
                        insertAttachment();//批量保存典当照片信息
                        successMsg(msg);
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
     *修改从业人员
     **********************/
    var jsonStrInit;//表单初始化时，序列化的json字符串(当户信息)
    $("#editButton").click(function () {
        jsonStrInit = "";
        $("#editForm")[0].reset();
        $('.form-group').removeClass('has-error');
        var array = $('#exampleTableEvents').bootstrapTable('getSelections');
        var table_name = $("#table_name").val();
        if (array.length == 1) {
            obj = array[0];
            $("#editForm")[0].reset();
            $("#editForm").validate().resetForm();
            // $("#cyrybh").val(obj.cyrybh);
            $("#xmxg").val(obj.xm);
            if (obj.roleName == '从业人员') {
                $("#roleNamexg").val("02301");
            }
            $("#minzuxg").val(obj.mzdm);
            $("#xbxg").val(obj.xbdm);
            $("#cyzjxg").val(obj.cyzjdm);
            $("#zjhmxg").val(obj.zjhm);
            $("#whcdxg").val(obj.whcddm);
            $("#rzrqxg").val(obj.rzrq);
            $("#cyryztxg").val(obj.cyryztdm);
            $("#lxdhxg").val(obj.lxdh);
            $("#hjdxzxg").val(obj.hjdxz);
            $("#xzdxzqhxg").val(obj.xzdxzqh);
            $("#imageEdit1").attr('src', '../../common/previeAndLoad?tableId=' + obj.ryid + '&' + 'tableName=' + table_name);
            jsonStrInit += jsonTextInit("editForm");
        } else {
            warnningMsg('请选择一条数据！');
            return false;
        }
    });
    $("#submitForEdit").click(function () {
        var varningStr = '';
        var jsonStr = '';
        var qyryxx = {};
        var role = {};
        jsonStr += jsonTextInit("editForm");

        var array = $('#exampleTableEvents').bootstrapTable('getSelections');
        var table_name = $("#table_name").val();
        obj = array[0];
        var ryid = obj.ryid;
        // var cyrybh = $("#cyrybh").val();
        var xm = $("#xmxg").val();
        if (xm == '') {
            varningStr += "请填写人员姓名" + "</br>";
            warnningMsg(varningStr);
            return false;
        }
        var cyzjdm = $("#cyzjxg").val();
        if (cyzjdm == '') {
            varningStr += "请填写常用证件类型" + "</br>";
            warnningMsg(varningStr);
            return false;
        }
        var cyzj = $('#cyzjxg option:selected').text().trim();
        var zjhm = $("#zjhmxg").val();
        if (zjhm == '') {
            varningStr += "请填写证件号码" + "</br>";
            warnningMsg(varningStr);
            return false;
        }
        var whcddm = $("#whcdxg").val();
        if (whcddm == '') {
            varningStr += "请填写文化程度" + "</br>";
            warnningMsg(varningStr);
            return false;
        }
        var whcd = $('#whcdxg option:selected').text().trim();
        var rzrq = $("#rzrqxg").val();
        if (rzrq == '') {
            varningStr += "请填写入职日期" + "</br>";
            warnningMsg(varningStr);
            return false;
        }
        var cyryztdm = $("#cyryztxg").val();
        if (cyryztdm == '') {
            varningStr += "请填写人员状态" + "</br>";
            warnningMsg(varningStr);
            return false;
        }
        var cyryzt = $('#cyryztxg option:selected').text().trim();
        var mzdm = $("#minzuxg").val();
        if (mzdm == '') {
            varningStr += "请填写民族" + "</br>";
            warnningMsg(varningStr);
            return false;
        }
        var minzu = $('#minzuxg option:selected').text().trim();
        var xbdm = $("#xbxg").val();
        if (xbdm == '') {
            varningStr += "请填写性别" + "</br>";
            warnningMsg(varningStr);
            return false;
        }
        xbdm = obj.xbdm;
        var xb = $('#xbxg option:selected').text().trim();
        var roleName = $("#roleNamexg").val();
        if (roleName == '') {
            varningStr += "请填写角色" + "</br>";
            warnningMsg(varningStr);
            return false;
        }
        var lxdh = $("#lxdhxg").val();
        if (lxdh == '') {
            varningStr += "请填写联系方式" + "</br>";
            warnningMsg(varningStr);
            return false;
        }
        var hjdxz = $("#hjdxzxg").val();
        var xzdxzqh = $("#xzdxzqhxg").val();
        qyryxx.ryid = ryid,
            qyryxx.xm = xm,
            qyryxx.xbdm = xbdm,
            qyryxx.xb = xb,
            qyryxx.mzdm = mzdm,
            qyryxx.minzu = minzu,
            qyryxx.cyzjdm = cyzjdm,
            qyryxx.cyzj = cyzj,
            qyryxx.zjhm = zjhm,
            qyryxx.whcddm = whcddm,
            qyryxx.whcd = whcd,
            qyryxx.rzrq = rzrq,
            qyryxx.cyryztdm = cyryztdm,
            qyryxx.cyryzt = cyryzt,
            qyryxx.lxdh = lxdh,
            qyryxx.hjdxz = hjdxz,
            //  qyryxx.cyrybh = cyrybh,
            qyryxx.xzdxzqh = xzdxzqh;
        role.name = roleName;
        var requestDate = JSON.stringify({
            qyryxx: qyryxx,
            role: role
        });
        if ($("#editForm").valid()) {	//表单验证
            $.ajax({
                url: "../../qyry/update",
                contentType: "application/json;charset=UTF-8",
                type: "post",
                data: requestDate,
                success: function (data) {
                    var msg = data.result;
                    if (msg == "操作成功") {
                        updateAttachments(ryid);//修改普通信息成功后，修改图片信息
                        successMsg(data.result);
                        $('.closeBtn').click();
                        setTimeout(function () {
                            window.location.reload();
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
     *从业人员详情
     **********************/
    $("#detailButton").click(function () {
        var array = $('#exampleTableEvents').bootstrapTable('getSelections');
        if (array.length == 1) {
            var obj = array[0];
            var table_name = $("#table_name").val();
            $("#cyrybhxq").html(obj.cyrybh);
            $("#xmxq").html(obj.xm);
            $("#xbxq").html(obj.xb);
            $("#minzuxq").html(obj.minzu);
            $("#cyzjxq").html(obj.cyzj);
            $("#zjhmxq").html(obj.zjhm);
            $("#whcdxq").html(obj.whcd);
            $("#rzrqxq").html(obj.rzrq);
            $("#cyryztxq").html(obj.cyryzt);
            $("#lxdhxq").html(obj.lxdh);
            $("#hjdxzxq").html(obj.hjdxz);
            $("#xzdxzqhxq").html(obj.xzdxzqh);
            $("#roleNamexq").html(obj.roleName);
            $("#imageDetail1").attr('src', '../../common/previeAndLoad?tableId=' + obj.ryid + '&' + 'tableName=' + table_name);
        } else {
            warnningMsg('请选择一条数据！');
            return false;
        }
    });
    /**********************
     *删除从业人员
     **********************/
    $('#deleteButton').click(function () {
        var array = $('#exampleTableEvents').bootstrapTable('getSelections');
        if (array.length != 1) {
            warnningMsg("请选择一条数据！");
            return false;
        }
        var ryObj = array[0];
        var id = ryObj.ryid;
        var table_name = $('#table_name').val();//模块名称
        deleteMsg("您确认要删除所选数据吗？", id);
    });
})();

function loadTable() {
    $("#exampleTableEvents").bootstrapTable('destroy');
    $('#exampleTableEvents').bootstrapTable({
        method: 'get',
        //contentType: "application/x-www-form-urlencoded",//一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
        url: "../../qyry/selectQyryxxs",//要请求数据的文件路径
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination: true,//是否分页
        //queryParams: queryParams,//请求服务器时所传的参数
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
                field: 'cyrybh',
                title: '人员编号',
                align: 'center'
            },
            {
                field: 'xm',
                title: '姓名',
                align: 'center'
            },
            {
                field: 'xb',
                title: '性别',
                align: 'center'
            },
            {
                field: 'zjhm',
                title: '证件号码',
                align: 'center'
            },
            {
                field: 'minzu',
                title: '民族',
                align: 'center'
            },
            {
                field: 'cyzj',
                title: '证件类型',
                align: 'center',
                visible: false
            },
            {
                field: 'whcd',
                title: '文化程度',
                align: 'center',
                visible: false
            },
            {
                field: 'rzrq',
                title: '入职日期',
                align: 'center',
                visible: false
            },
            {
                field: 'cyryzt',
                title: '人员状态',
                align: 'center'
            },
            {
                field: 'lxdh',
                title: '联系方式',
                align: 'center',
                visible: false
            },
            {
                field: 'hjdxz',
                title: '户籍住址',
                align: 'center',
                visible: false
            },
            {
                field: 'xzdxzqh',
                title: '现住址',
                align: 'center',
                visible: false
            },
            {
                field: 'qymc',
                title: '企业名称',
                align: 'center'
            },
            {
                field: 'qybm',
                title: '企业编号',
                align: 'center'
            },
            {
                field: 'roleName',
                title: '角色',
                align: 'center',
                visible: false
            }
        ]
    });
}

//请求服务数据时所传参数
function queryParams(params) {
    /*var gxdw = $("#gxdw").val().trim();
    if(gxdw=='请选择'){
        gxdw='';
    }*/
    var xb1 = $("#xb1").val().trim();
    var ryzt = $("#ryzt").val().trim();
    return {
        pageSize: params.limit, //每一页的数据行数，默认是上面设置的10(pageSize)
        pageIndex: params.offset / params.limit + 1, //当前页面,默认是上面设置的1(pageNumber)
        // qymc : $("#qymc").val().trim(),
        // qybm : $("#qybh").val().trim(),
        // gxdwmc : gxdw,
        xm: $("#mz").val().trim(),
        xbdm: xb1,
        zjhm: $("#zjhm1").val().trim(),
        //cyrybh : $("#rybh").val().trim(),
        cyryztdm: ryzt
    }
}

//添加图片
function insertAttachment() {
    var ryid = $('#ryid').val();
    var table_name = $('#table_name').val();
    var file_name = $('#filenameAdd').val();
    var file_type = $('#filetypeAdd').val();
    var real_path = $('#realpathAdd').val();
    var requestDate = JSON.stringify({
        'tableId': ryid,
        'tableName': table_name,
        'fileName': file_name,
        'fileType': file_type,
        'realPath': real_path
    });
    if (real_path != null && real_path != '') {
        $.ajax({
            url: "../../qyry/insertAttach",
            contentType: "application/json;charset=UTF-8",
            type: "post",
            data: requestDate,
            success: function (data) {

            },
            error: function (data) {
                dangerMsg(data.errMsg);
            }
        });
    }
}

//修改图片
function updateAttachments(ryid) {
    var table_name = $('#table_name').val();//模块名称
    var file_name = $('#filenameEdit').val();
    var file_type = $('#filetypeEdit').val();
    var real_path = $('#realpathEdit').val();
    var requestDate = JSON.stringify({
        'tableId': ryid,
        'tableName': table_name,
        'fileName': file_name,
        'fileType': file_type,
        'realPath': real_path
    });
    if (real_path != null && real_path != '') {
        $.ajax({
            url: "../../qyry/updateAttach",
            contentType: "application/json;charset=UTF-8",
            type: "post",
            data: requestDate,
            success: function (data) {
                /*var msg = data.result;
                if(msg=="操作成功"){
                    successMsg(data.result);
                }else{
                    dangerMsg(data.result);
                    return;
                }*/
            },
            error: function (data) {
                dangerMsg(data.errMsg);
            }
        });
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
        time: 2
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
                url: "../../qyry/delete?id=" + id,
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
