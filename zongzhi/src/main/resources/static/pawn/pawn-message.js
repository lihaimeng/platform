var httpip = JSON.parse(localStorage.getItem('pawn_url'));

var organizationId = $('#organizationId', parent.document).val();
$(document).ready(function () {
    //典当子系统ip，用于查询子系统信息
    $('#btn_pawnMsg1')[0].style.backgroundColor = '#1ab394';
    $("#pawn2").css("display", 'none');

    $('#myModalForDetail').on('hidden.bs.modal', function () {
        $('#xqmsg').css({'overflow-y': 'scroll'});
    });
    /**
     * 获取管辖单位
     */
    var josnOrganization = localStorage.getItem("organization");
    var organizationList = JSON.parse(josnOrganization);
    for (var i = 0; i < organizationList.length; i++) {
        $('#gxdw').append("<option value=" + organizationList[i].organizationId + ">" + organizationList[i].name + "</option>");
    }
    $('#gxdw').trigger('chosen:updated');
    //管辖单位下拉列表选中事件
    $('#gxdw').change(function () {
        var dominionValue = $("#gxdw").val();
        $("#gxdw option[value=dominionValue]").attr("selected", true);
    });

    /**
     *获取典当状态
     */
    var typeArray = [];//定义一个类型数组
    function initTypeArray(name) {
        this.name = name;
    }

    typeArray.push(new initTypeArray("典当状态"));

    for (var i = 0; i < typeArray.length; i++) {
        var initSelectOption = localStorage.getItem(typeArray[i].name);
        initSelectOption = JSON.parse(initSelectOption);
        console.info(initSelectOption);
        if (initSelectOption != null || initSelectOption != "") {
            initSelectOption.forEach(function (item, index) {
                if (typeArray[i].name == "典当状态") {
                    $('#zt').append("<option value=" + item.code + ">" + item.name + "</option>");
                }
            })

        }
    }

    // var zongzhiddxx=getDdxxListByorgid(organizationId);
    // getDataList(zongzhiddxx);
    getDdxxListByorgid
        .fail(function () {
            getDataList([]);
        })
        .done(function (zongzhiddxx) {
            //qqq
            for (var i = 0; i < zongzhiddxx.length; i++) {
                if (chxundhfl(zongzhiddxx[i]) == "单位当户") {
                    zongzhiddxx[i].dhxm = zongzhiddxx[i].dwmc;
                }
                else if (chxundhfl(zongzhiddxx[i]) == "普通当户") {
                    zongzhiddxx[i].ddcscount = zongzhiddxx[i].dhxmddcscount;
                } else if (chxundhfl(zongzhiddxx[i]) == "外国当户") {
                    zongzhiddxx[i].dhxm = zongzhiddxx[i].ywm;
                    zongzhiddxx[i].ddcscount = zongzhiddxx[i].ywmcount;
                }
            }
            getDataList(zongzhiddxx);
            chaxun(organizationId);


            clickDcdd();
            clickXq();
            clickDwxxxq();
        });
});


var getDdxxListByorgid =
    $.ajax({
        url: httpip + '/ddywgl/getDdxxListByorgid',
        dataType: "json",
        data: {"orgid": organizationId},
        type: 'POST'
    });


function getDdxxLikeByorgid(likedata) {
    return $.ajax({
        url: httpip + '/ddywgl/getDdxxLikeByorgid',
        dataType: "json",
        data: {
            "orgid": likedata.orgid, "gxdwmc": likedata.gxdwmc, "qymc": likedata.qymc,
            "dphm": likedata.dphm, "zt": likedata.zt, "dhxm": likedata.dhxm,
            "dhzjhm": likedata.dhzjhm, "slsjstart": likedata.slsjstart, "slsjend": likedata.slsjend,
            "dqsjstart": likedata.dqsjstart, "dqsjend": likedata.dqsjend
        },
        type: 'POST'
    });
}

//当户分类
function chxundhfl(ddxx) {
    var reutnrdata;
    if (ddxx.dhgj == '中国' || ddxx.dhgj == null) {
        if (ddxx.dwmc != null && ddxx.dwmc != "")
            reutnrdata = "单位当户";
        else
            reutnrdata = "普通当户";
    } else {
        reutnrdata = "外国当户";
    }
    return reutnrdata
}

//查询按钮
function chaxun(organizationId) {
    $("#search").unbind();
    $("#search").click(function (userunderqyid) {
        var likedata = {};
        likedata.orgid = organizationId;
        var gxdwoptions = $("#gxdw option:selected");
        var orgid = gxdwoptions.val();
        likedata.orgid = orgid;
        likedata.qymc = $("#qymc").val();

        likedata.dphm = $("#dphm").val();
        var ztoptions = $("#zt option:selected");
        likedata.zt = ztoptions.val();

        likedata.dhxm = $("#dhxm").val();
        likedata.dhzjhm = $("#dhzjhm").val();
        if ($("#cdsj").val() != "")
            likedata.slsjstart = new Date($("#cdsj").val()).getTime();
        if ($("#cdsjend").val() != "")
            likedata.slsjend = new Date($("#cdsjend").val()).getTime();
        if ($("#dqsj").val() != "")
            likedata.dqsjstart = new Date($("#dqsj").val()).getTime();
        if ($("#dqsjend").val() != "")
            likedata.dqsjend = new Date($("#dqsjend").val()).getTime();


        if (Date.parse($("#cdsjend").val()) < Date.parse($("#cdsj").val())) {
            warnningMsg("出当结束时间必须大于开始时间！");
            return false;
        }

        if (Date.parse($("#dqsjend").val()) < Date.parse($("#dqsj").val())) {
            warnningMsg("结束时间必须大于开始时间！");
            return false;
        }

        // var listdata=getDdxxLikeByorgid(likedata);
        // getDataList(listdata);
        getDdxxLikeByorgid(likedata)
            .fail(function () {
                getDataList([]);
            })
            .done(function (listdata) {
                for (var i = 0; i < listdata.length; i++) {
                    if (chxundhfl(listdata[i]) == "单位当户") {
                        listdata[i].dhxm = listdata[i].dwmc;
                    }
                    else if (chxundhfl(listdata[i]) == "普通当户") {
                        listdata[i].ddcscount = listdata[i].dhxmddcscount;
                    } else if (chxundhfl(listdata[i]) == "外国当户") {
                        listdata[i].dhxm = listdata[i].ywm;
                        listdata[i].ddcscount = listdata[i].ywmcount;
                    }

                }
                getDataList(listdata);
            });
    });
}


//通过典当信息id查询典当物品信息
function selectDdxq(ddxxid, state) {
    var dtd;
    dtd = $.ajax({
        url: httpip + '/ddywgl/selectDdxq',
        dataType: "json",
        data: {"ddxxid": ddxxid, "state": state},
        type: 'POST'
    });
    return dtd;
}

//根据姓名查询多次典当
function selectDcdd(name, dhfl) {
    var returndata;
    returndata = $.ajax({
        url: httpip + '/ddywgl/selectDcdd',
        type: 'POST',
        data: {"name": name, "dhfl": dhfl, "orgid": organizationId},
    });
    return returndata;
}

/**
 *获取典当查询表格数据
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
                field: 'gxdwmc',
                title: '管辖单位',
                align: 'center'
            }, {
                field: 'qymc',
                title: '企业名称',
                align: 'center'
            }, {
                field: 'dhxm',
                title: '当户名称',
                align: 'center',
            }, {
                field: 'dhzjhm',
                title: '证件号',
                align: 'center'

            }, {
                field: 'dhxb',
                title: '性别',
                align: 'center',
            },

            {
                field: 'dphm',
                title: '当票号',
                align: 'center'
            }, {
                field: 'zt',
                title: '典当状态',
                align: 'center',
                formatter: function (value, row, index) {
                    if (value == ("00101")) {
                        return "活当";
                    } else if (value == ("00102")) {
                        return "绝当";
                    } else if (value == ("00103")) {
                        return "续当";
                    } else if (value == ("00104")) {
                        return "赎当";
                    } else if (value == ("00105")) {
                        return "部分赎当";
                    } else if (value == ("00106")) {
                        return "到期预警";
                    } else if (value == ("00107")) {
                        return "当票到期";
                    } else {
                        return "无";
                    }
                }
            }, {
                field: 'slsj',
                align: 'center',
                title: '出当时间',
                //——修改——获取日期列的值进行转换
                // formatter: function (value, row, index) {
                //     return changeDateFormat(value)
                // }
            }, {
                field: 'dqsj',
                align: 'center',
                title: '到期时间',
                //——修改——获取日期列的值进行转换
                // formatter: function (value, row, index) {
                //     return changeDateFormat(value)
                // }
            }, {
                field: 'ddcscount',
                title: '典当次数',
                align: 'center',
                visible: false
            }
        ],
    });
}


/**
 *获取多次典当表格数据
 */
function getDcddtbList(data) {
    $('#dcddtb').bootstrapTable('destroy');
    $('#dcddtb').bootstrapTable({
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
                field: 'dphm',
                title: '当票号',
                align: 'center'
            }, {
                field: 'dhxm',
                title: '当户名称',
                align: 'center'
            }, {
                field: 'dhzjhm',
                title: '证件号',
                align: 'center'

            }, {
                field: 'dhxb',
                title: '性别',
                align: 'center',
                formatter: function (value, row, index) {
                    return value == '00301' ? '男' : '女';
                }

            }, {
                field: 'slsj',
                align: 'center',
                title: '出当时间',
                //——修改——获取日期列的值进行转换
                // formatter: function (value, row, index) {
                //     return changeDateFormat(value)
                // }
            }, {
                field: 'dqsj',
                align: 'center',
                title: '到期时间',
                //——修改——获取日期列的值进行转换
                // formatter: function (value, row, index) {
                //     return changeDateFormat(value)
                // }
            }, {
                field: 'zt',
                title: '典当状态',
                align: 'center',
                formatter: function (value, row, index) {
                    if (value == ("00101"))
                        return "活当";
                    else if (value == ("00102"))
                        return "绝当";
                    else
                        return value;
                }
            }
        ],
    });
}

/**
 *获取当物信息表格数据
 */
function getDdwpxtbList(data) {
    $('#dwxxtb').bootstrapTable('destroy');
    $('#dwxxtb').bootstrapTable({
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
                field: 'ddlx',
                title: '当物类型',
                align: 'center'
            }, {
                field: 'wpmc',
                title: '当物名称',
                align: 'center'
            }, {
                field: 'sl',
                title: '数量',
                align: 'center'

            }, {
                field: 'pp',
                title: '品牌',
                align: 'center',
            }, {
                field: 'xh',
                title: '型号',
                align: 'center',
            }
        ],
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

//管辖单位下拉列表选中事件
$('#dominion').change(function () {
    $("#dominion option").attr("selected", true);
});

function changeMsg1() {
    $("#ddjbxx").css("display", 'block');
    $("#pawn2").css("display", 'none');
    $("#btn_pawnMsg1").css("background-color", 'rgb(26, 179, 148)');
    $("#btn_pawnMsg2").css("background-color", '');
}

function changeMsg2() {
    $("#pawn2").css("display", 'block');
    $("#ddjbxx").css("display", 'none');
    $("#btn_pawnMsg2").css("background-color", 'rgb(26, 179, 148)');
    $("#btn_pawnMsg1").css("background-color", '');
}

function changeMsg() {
    $("#pawnMsg").css("display", 'block');
    $("#Msg").css("display", 'none');
}


//详情按钮
function clickXq() {
    $("#xq_btn").unbind();
    $("#xq_btn").click(function () {

        var selectdata = $("#table").bootstrapTable('getSelections');

        if (selectdata.length == 1) {
            $("#xq_btn").attr("data-target", "#xqmsg");
            selectdata = selectdata[0];
            if (selectdata.dhxb == '00302')
                selectdata.dhxb = "女";
            else
                selectdata.dhxb = "男";

            var dhfl = chxundhfl(selectdata);

            var imgsrctop = httpip + '/common/previeAndLoad?tableId=' + selectdata.ddxxid + '&tableName=ddxx&mark=mark_top';
            $(".topimg").attr('src', imgsrctop);

            var imgsrccenter = httpip + '/common/previeAndLoad?tableId=' + selectdata.ddxxid + '&tableName=ddxx&mark=mark_centre';
            $(".centerimg").attr('src', imgsrccenter);
            var wgdh = false;
            var wgwtr = false;
            if (dhfl == "单位当户") {
                $("#dwdetail").show();
                $("#ptdetail").hide();
                $("#wgdetail").hide();

                $("#wtrmsg").hide();
                $("#ddxxmsg").hide();

                $("#dwmc").html("");
                $("#dwmc").html(selectdata.dwmc);
                $("#frdb").html("");
                $("#frdb").html(selectdata.dwfrdb);
                $("#lxdh").html("");
                $("#lxdh").html(selectdata.dhdh);
                $("#sqwtsx").html("");
                $("#sqwtsx").html(selectdata.dwsqwtssx);
                $("#xxdz").html("");
                $("#xxdz").html(selectdata.dhhjdz);
            } else if (dhfl == "普通当户") {

                $("#ptdetail").show();
                $("#dwdetail").hide();
                $("#wgdetail").hide();


                //当户信息
                $("#dhxmForDetail").html("");
                $("#dhxmForDetail").html(selectdata.dhxm);
                $("#dhcyzjlxdmForDetail").html("");
                $("#dhcyzjlxdmForDetail").html(selectdata.dhcyzj);
                $("#dhzjhmForDetail").html("");
                $("#dhzjhmForDetail").html(selectdata.dhzjhm);
                $("#dhxzqhForDetail").html("");
                $("#dhxzqhForDetail").html(selectdata.dhxzqh);
                $("#dhxbForDetail").html("");
                $("#dhxbForDetail").html(selectdata.dhxb);
                $("#dhdhcommonForDetail").html("");
                $("#dhdhcommonForDetail").html(selectdata.dhdh);
                $("#dhgjdzcommonForDetail").html("");
                $("#dhgjdzcommonForDetail").html(selectdata.dhhjdz);


                //典当信息
                $("#dphmForDetail").html("");
                $("#dphmForDetail").html(selectdata.dphm);
                $("#hthForDetail").html("");
                $("#hthForDetail").html(selectdata.hth);
                $("#slrmcForDetail").html("");
                $("#slrmcForDetail").html(selectdata.slrmc);
                $("#cdsjForDetail").html("");
                $("#cdsjForDetail").html(selectdata.slsj);
                $("#ddlxForDetail").html("");
                $("#ddlxForDetail").html(selectdata.zt);
                $("#dqsjForDetail").html("");
                $("#dqsjForDetail").html(selectdata.dqsj);
                $("#dpzzForDetail").html("");
                $("#dpzzForDetail").html(selectdata.dpzz);
                $("#yflForDetail").html("");
                $("#yflForDetail").html(selectdata.yfl);
                $("#yllForDetail").html("");
                $("#yllForDetail").html(selectdata.yll);
                $("#sfjeForDetail").html("");
                $("#sfjeForDetail").html(selectdata.ddjehj);


                $("#wtrmsg").show();
                $("#ddxxmsg").show();
            } else {
                wgdh = true;
                //外国当户
                $("#wgdetail").show();
                $("#ptdetail").hide();
                $("#dwdetail").hide();


                $("#wtrmsg").show();
                $("#ddxxmsg").show();
                //当户信息

                $("#xb").html("");
                $("#xb").html(selectdata.dhxb);
                $("#gj").html("");
                $("#gj").html(selectdata.dhgj);
                $("#lxdhForeign").html("");
                $("#lxdhForeign").html(selectdata.dhdh);
                $("#xxdzForeign").html("");
                $("#xxdzForeign").html(selectdata.dhhjdz);

                //典当信息
                $("#dphmForDetail").html("");
                $("#dphmForDetail").html(selectdata.dphm);
                $("#hthForDetail").html("");
                $("#hthForDetail").html(selectdata.hth);
                $("#slrmcForDetail").html("");
                $("#slrmcForDetail").html(selectdata.slrmc);
                $("#cdsjForDetail").html("");
                $("#cdsjForDetail").html(selectdata.slsj);
                $("#ddlxForDetail").html("");
                $("#ddlxForDetail").html(selectdata.zt);
                $("#dqsjForDetail").html("");
                $("#dqsjForDetail").html(selectdata.dqsj);
                $("#dpzzForDetail").html("");
                $("#dpzzForDetail").html(selectdata.dpzz);
                $("#yflForDetail").html("");
                $("#yflForDetail").html(selectdata.yfl);
                $("#yllForDetail").html("");
                $("#yllForDetail").html(selectdata.yll);
                $("#sfjeForDetail").html("");
                $("#sfjeForDetail").html(selectdata.ddjehj);
            }
            //委托人信息
            if (selectdata.wtrgj == "中国" || selectdata.wtrgj == null) {
                $("#ptwtr").show();
                $("#wgwtr").hide();
                $("#wtrxmForDetail").html("");
                $("#wtrxmForDetail").html(selectdata.wtrxm);
                $("#wtrcyzjForDetail").html("");
                $("#wtrcyzjForDetail").html(selectdata.wtrcyzj);
                $("#wtrzjhmForDetail").html("");
                $("#wtrzjhmForDetail").html(selectdata.wtrzjhm);
                $("#wtrxzqhForDetail").html("");
                $("#wtrxzqhForDetail").html(selectdata.wtrxzqh);
                $("#wtrxbForDetail").html("");
                $("#wtrxbForDetail").html(selectdata.wtrxb);
                $("#wtrdhForDetail").html("");
                $("#wtrdhForDetail").html(selectdata.wtrdh);
                $("#wtrhjdzForDetail").html("");
                $("#wtrhjdzForDetail").html(selectdata.wtrhjdz);
            } else {
                wgwtr = true;
                $("#ptwtr").hide();
                $("#wgwtr").show();

                $("#ywmForergn").html("");
                $("#ywmForergn").html(selectdata.wtrxm);
                $("#ywxForergn").html("");
                $("#ywxForergn").html(selectdata.wtrxm);
                $("#qzhmForergn").html("");
                $("#qzhmForergn").html(selectdata.wtrcyzjlxdm);
                $("#wtrgjForergn").html("");
                $("#wtrgjForergn").html(selectdata.wtrgj);
                $("#wtrxbForergn").html("");
                $("#wtrxbForergn").html(selectdata.wtrxb);
                $("#qzzlForergn").html("");
                $("#qzzlForergn").html(selectdata.wtrcyzj);
                $("#wtrdhForergn").html("");
                $("#wtrdhForergn").html(selectdata.wtrdh);
                $("#wtrhjdzForergn").html("");
                $("#wtrhjdzForergn").html(selectdata.wtrhjdz);
            }

            //var ddxxxq=selectDdxq(selectdata.ddxxid,wgdh);
            var ddxxxq = {};
            selectDdxq(selectdata.ddxxid, wgdh, wgwtr).fail(function () {
                ddxxxq.wgdhxx = null;
                ddxxxq.ddwpxx = [];
            })
                .done(function (data) {
                    ddxxxq = data;
                    if (ddxxxq['wgdhxx'] != null) {
                        $("#ywm").html("");
                        $("#ywm").html(ddxxxq['wgdhxx'].ywm);
                        $("#ywx").html("");
                        $("#ywx").html(ddxxxq['wgdhxx'].ywx);
                        $("#qzzl").html("");
                        $("#qzzl").html(ddxxxq['wgdhxx'].qzzl);
                        $("#qzhm").html("");
                        $("#qzhm").html(ddxxxq['wgdhxx'].qzhm);
                    }
                    //qqq
                    if (ddxxxq['wgwtrxx'] != null) {
                        $("#ywmForergn").html("");
                        $("#ywmForergn").html(ddxxxq['wgwtrxx'].ywmForergn);
                        $("#ywxForergn").html("");
                        $("#ywxForergn").html(ddxxxq['wgwtrxx'].ywxForergn);
                        $("#qzzlForergn").html("");
                        $("#qzzlForergn").html(ddxxxq['wgwtrxx'].qzzlForergn);
                        $("#qzhmForergn").html("");
                        $("#qzhmForergn").html(ddxxxq['wgwtrxx'].qzhmForergn);
                    }
                    getDdwpxtbList(ddxxxq['ddwpxx']);
                })
        } else {
            warnningMsg("请选择一行");
            $("#xq_btn").attr("data-target", "");
        }
    });
}

//当物信息详情按钮
function clickDwxxxq() {
    $("#dwxxxq").unbind();
    $("#dwxxxq").click(function () {
        var selectdata = $("#dwxxtb").bootstrapTable('getSelections');
        if (selectdata.length == 1) {
            $("#dwxxxq").attr("data-target", "#myModalForDetail");

            selectdata = selectdata[0];

            $("#wpdlForDetail").html("");
            $("#wpdlForDetail").html(selectdata.wpdl);
            $("#wpmcForDetail").html("");
            $("#wpmcForDetail").html(selectdata.wpmc);
            $("#slForDetail").html("");
            $("#slForDetail").html(selectdata.sl);
            $("#zlForDetail").html("");
            $("#zlForDetail").html(selectdata.zl);
            $("#bzForDetail").html("");
            $("#bzForDetail").html(selectdata.wybs);
            $("#dwtzForDetail").html("");
            $("#dwtzForDetail").html(selectdata.xztz);
            $("#ppForDetail").html("");
            $("#ppForDetail").html(selectdata.pp);
            $("#xhForDetail").html("");
            $("#xhForDetail").html(selectdata.xh);
            $("#ggForDetail").html("");
            $("#ggForDetail").html(selectdata.gg);
            $("#gjForDetail").html("");
            $("#gjForDetail").html(selectdata.gj);
            $("#zdlForDetail").html("");
            $("#zdlForDetail").html(selectdata.zdl);
            $("#djseForDetail").html("");
            $("#djseForDetail").html(selectdata.djse);
            $("#dwlxForDetail").html("");
            $("#dwlxForDetail").html(selectdata.wpxil);
            $("#dwgslxForDetail").html("");
            $("#dwgslxForDetail").html(selectdata.wpxl);
            $("#dwlyForDetail").html("");
            $("#dwlyForDetail").html(selectdata.lyqksm);
            $("#zmclForDetail").html("");
            $("#zmclForDetail").html(selectdata.fileName);


            $("#download").unbind();
            $("#download").click(function () {
                var sysAttachments = {};
                sysAttachments.tableId = selectdata.ddwpid;
                window.location.href = httpip + '/common/attachmentDownload?tableId=' + sysAttachments.tableId + "&tableName=" + "ddwpxx";
            });
        } else {
            warnningMsg("请选择一行");
            $("#dwxxxq").attr("data-target", "");
        }
    });
}
//多次典当按钮
function clickDcdd() {
    $("#dcdd_btn").unbind();
    $("#dcdd_btn").click(function () {
        var selectdata = $("#table").bootstrapTable('getSelections');
        if (selectdata.length == 1) {
            $("#dcdd_btn").attr("data-target", "#dcddtable");

            selectdata = selectdata[0];

            selectDcdd(selectdata.dhxm, chxundhfl(selectdata))
                .fail(function () {
                    getDcddtbList([]);
                })
                .done(function (dcdddata) {

                    for (var i = 0; i < dcdddata.length; i++) {
                        if (chxundhfl(dcdddata[i]) == "单位当户") {
                            dcdddata[i].dhxm = dcdddata[i].dwmc;
                        }
                        else if (chxundhfl(dcdddata[i]) == "外国当户") {
                            dcdddata[i].dhxm = dcdddata[i].ywm;
                        }
                    }
                    getDcddtbList(dcdddata);
                });
        } else {
            warnningMsg("请选择一行");
            $("#dcdd_btn").attr("data-target", "");
        }
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