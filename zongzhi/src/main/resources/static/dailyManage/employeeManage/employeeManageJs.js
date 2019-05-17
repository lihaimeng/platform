//生成bootstrapTable
//bootstrapTable表格属性参考http://bootstrap-table.wenzhixin.net.cn/zh-cn/documentation/
(function () {
    /**********************
     *加载字典项
     **********************/
    /**
     * 获取管辖单位
     */
    var josnOrganization = localStorage.getItem("organization");
    var organizationList = JSON.parse(josnOrganization);
    for (var i = 0; i < organizationList.length; i++) {
        if (organizationList[i].code != "") {
            $('#gxdwbm').append("<option value=" + organizationList[i].organizationId + ">" + organizationList[i].name + "</option>");
        }
    }
    $('#gxdwbm').trigger('chosen:updated');
    //管辖单位下拉列表选中事件
    $('#gxdwbm').change(function () {
        var dominionValue = $("#gxdwbm").val();
        $("#gxdwbm option[value=dominionValue]").attr("selected", true);
    });

    /**
     *获取行业类别，性别
     */
    var typeArray = [];//定义一个类型数组
    function initTypeArray(name) {
        this.name = name;
    }

    typeArray.push(new initTypeArray("行业类型"));
    typeArray.push(new initTypeArray("性别"));

    for (var i = 0; i < typeArray.length; i++) {
        var initSelectOption = localStorage.getItem(typeArray[i].name);
        initSelectOption = JSON.parse(initSelectOption);
        console.info(initSelectOption);
        if (initSelectOption != null || initSelectOption != "") {
            initSelectOption.forEach(function (item, index) {
                if (typeArray[i].name == "行业类型") {
                    $('#hylbdm').append("<option value=" + item.code + ">" + item.name + "</option>");
                }
                if (typeArray[i].name == "性别") {
                    $('#xb').append("<option value=" + item.code + ">" + item.name + "</option>");
                }
            })

        }
    }

    /**********************
     *从业人员列表
     **********************/
    loadTable();

    /**********************
     *企业人员信息查询
     **********************/
    $('#search').click(function () {
        $("#exampleTableEvents").bootstrapTable('destroy');
        $('#exampleTableEvents').bootstrapTable({
            method: 'get',
            contentType: "application/json; charset=UTF-8",
            //contentType: "application/x-www-form-urlencoded",//一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
            //  http://192.168.0.202:8080/pawn/qyry/selectQyryxxsForDaily?order=asc&limit=15&offset=0
            url: "../../qyry/selectQyryxxsForDaily",//要请求数据的文件路径
            // url: "http://localhost:8086/qyry/selectQyryxxsForDaily",//要请求数据的文件路径
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
                    field: 'qymc',
                    title: '单位名称',
                    align: 'center'
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
                    field: 'hylb',
                    title: '行业类别',
                    align: 'center'
                },
                {
                    field: 'gxdwmc',
                    title: '管辖单位',
                    align: 'center'
                },

                {
                    field: 'qybm',
                    title: '企业代码',
                    align: 'center',
                    visible: false
                },
                {
                    field: 'minzu',
                    title: '民族',
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
                    field: 'gwmc',
                    title: '岗位',
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
                    field: 'lzrq',
                    title: '离职日期',
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
                    field: 'xzdxzqhdm',
                    title: '现住址',
                    align: 'center',
                    visible: false
                },
                {
                    field: 'cyryzt',
                    title: '人员状态',
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
                    field: 'roleName',
                    title: '角色',
                    align: 'center',
                    visible: false
                }
            ]
        });
    });

    /**********************
     *从业人员详情
     **********************/
    $("#detailButton").click(function () {
        var array = $('#exampleTableEvents').bootstrapTable('getSelections');
        if (array.length == 1) {
            var obj = array[0];
            var table_name = $("#table_name").val();
            $("#xmxq").html(obj.xm);
            $("#zjhmxq").html(obj.zjhm);
            $("#xbxq").html(obj.xb);
            $("#cyrybhxq").html(obj.cyrybh);
            $("#qybmxq").html(obj.qybm);
            $("#minzuxq").html(obj.minzu);
            $("#whcdxq").html(obj.whcd);
            $("#js").html(obj.roleName);
            $("#rzrqxq").html(obj.rzrq);
            $("#xzdxzqhxq").html(obj.xzdxzqh);
            $("#hjdxzxq").html(obj.hjdxz);
            $("#imageDetail").attr('src', '../../common/previeAndLoad?tableId=' + obj.ryid + '&' + 'tableName=' + table_name);
        } else {
            warnningMsg('请选择一条数据！');
            return false;
        }
    });
})();

function loadTable() {
    $("#exampleTableEvents").bootstrapTable('destroy');
    $('#exampleTableEvents').bootstrapTable({
        method: 'get',
        //contentType: "application/x-www-form-urlencoded",//一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
        //url: "http://localhost:8086/qyry/selectQyryxxsForDaily",//要请求数据的文件路径
        //url: "http://1.194.229.66:8081/pawn/qyry/selectQyryxxsForDaily",//要请求数据的文件路径
        url: "../../qyry/selectQyryxxsForDaily",//要请求数据的文件路径
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination: true,//是否分页
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
                field: 'qymc',
                title: '单位名称',
                align: 'center'
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
                field: 'hylb',
                title: '行业类别',
                align: 'center'
            },
            {
                field: 'gxdwmc',
                title: '管辖单位',
                align: 'center'
            },
            {
                field: 'qybm',
                title: '企业代码',
                align: 'center',
                visible: false
            },
            {
                field: 'minzu',
                title: '民族',
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
                field: 'gwmc',
                title: '岗位',
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
                field: 'lzrq',
                title: '离职日期',
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
                field: 'xzdxzqhdm',
                title: '现住址',
                align: 'center',
                visible: false
            },
            {
                field: 'cyryzt',
                title: '人员状态',
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
    var gxdwbm = $("#gxdwbm").val().trim();
    var hylbdm = $("#hylbdm").val().trim();
    var xb = $("#xb").val().trim();
    return {
        pageSize: params.limit, //每一页的数据行数，默认是上面设置的10(pageSize)
        pageIndex: params.offset / params.limit + 1, //当前页面,默认是上面设置的1(pageNumber)
        qymc: $("#qymc").val().trim(),
        gxdwbm: gxdwbm,
        hylbdm: hylbdm,
        xm: $("#mz").val().trim(),
        xbdm: xb,
        zjhm: $("#zjhm").val().trim()
        //  cyrybh : $("#cyrybh").val().trim()
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
