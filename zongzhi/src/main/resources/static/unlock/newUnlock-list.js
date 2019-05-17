(function () {
    userInit = localStorage.getItem('user');
    user = JSON.parse(userInit);
    var organizationId = user.organizationId;
    zongzhiUrl = JSON.parse(localStorage.getItem('zongzhi_url'))
    /**********************
     *获取管辖单位
     **********************/
    var josnOrganization = localStorage.getItem("organization");
    var organizationList = JSON.parse(josnOrganization);
    console.info(organizationList)
    for (var i = 0; i < organizationList.length; i++) {
        if (organizationList[i].code != "") {
            $('#dominion').append("<option value=" + organizationList[i].brevitycode + ">" + organizationList[i].name + "</option>");
        }
    }
    $('#dominion').trigger('chosen:updated');
    //管辖单位下拉列表选中事件
    $('#dominion').change(function () {
        var dominionValue = $("#dominion").val();
        $("#dominion option[value=dominionValue]").attr("selected", true);
    });

    /**********************
     *开锁信息列表
     **********************/
    var initDominion = $('#dominion').val().trim();
    if (initDominion == '0') {
        initDominion = "";
    }
    //var qymc = $('#searchKsqymc').val().trim();//单位名称
    var qymc = null;//单位名称
    var gxdw = initDominion;//管辖单位编号
    var wtrxm = $('#searchWtrxm').val().trim();//法人姓名
    var ksrxm = $('#searchkKsrxm').val().trim();//法人证件号码
    var wtrzjhm = $('#searchWtrzjhm').val().trim();//营业执照编号
    var initRegisterTimeStart = $('#registerTimeStart').val().trim();
    var initRegisterTimeEnd = $('#registerTimeEnd').val().trim();
    var organizationCode = JSON.parse(localStorage.getItem('organizationCode'));
    $.ajax({
        url: '..//sub/lock/order/searchList',
        type: 'POST',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify({
            'qymc': qymc,
            'gxdw': gxdw,
            'wtrxm': wtrxm,
            'ksrxm': ksrxm,
            'wtrzjhm': wtrzjhm,
            'ddh': "",
            'registerTimeStart': initRegisterTimeStart,
            'registerTimeEnd': initRegisterTimeEnd,
            'organizationCode':organizationCode
            //   'organizationId': organizationId
        }),
        success: function (data) {
            getDataList(data);
        },
        error: function (data) {
            dangerMsg(data);
        }
    });

    function getDataList(data) {
        $('#exampleTableEvents').bootstrapTable('destroy');
        $('#exampleTableEvents').bootstrapTable({
            pageNumber: 1, //初始化加载第一页，默认第一页
            pagination: true,//是否分页
            data: data,
            pageSize: 15,//单页记录数
            pageList: [15, 30],//分页步进值
            clickToSelect: true,
            singleSelect: true,
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
                }, {
                    field: 'gxdw',
                    title: '管辖单位',
                    align: 'center',
                    formatter: function (value, row, index) {
                        for (var i = 0; i < organizationList.length; i++) {
                            if (organizationList[i].brevitycode == value) {
                                return organizationList[i].name;
                            }
                        }
                    },
                    visible:false
                }, {
                    field: 'qymc',
                    title: '开锁企业名称',
                    align: 'center',
                    visible:false
                }, {
                    field: 'ksrxm',
                    title: '开锁人姓名',
                    align: 'center'
                }, {
                    field: 'wtrxm',
                    title: '委托人姓名',
                    align: 'center'
                }, {
                    field: 'wtrzjhm',
                    title: '委托人证件号码',
                    align: 'center'
                },
                {
                    field: 'kslx',
                    title: '开锁类型',
                    align: 'center'
                },
                {
                    field: 'kssj',
                    title: '开锁时间',
                    align: 'center'
                },
                {
                    field: 'ksdz',
                    title: '开锁地址',
                    align: 'center'
                }

            ]
        });
    }


    $('#search').click(function () {
        var searchDominion = $('#dominion').val().trim();
        if (searchDominion == '0') {
            searchDominion = "";
        }
        //var qymc = $('#searchKsqymc').val().trim();//单位名称
        var qymc = null;//单位名称
        var gxdw = searchDominion;//管辖单位编号
        var wtrxm = $('#searchWtrxm').val().trim();//法人姓名
        var ksrxm = $('#searchkKsrxm').val().trim();//法人证件号码
        var wtrzjhm = $('#searchWtrzjhm').val().trim();//营业执照编号
        var initRegisterTimeStart = $('#registerTimeStart').val().trim();
        var initRegisterTimeEnd = $('#registerTimeEnd').val().trim();
        var organizationCode = JSON.parse(localStorage.getItem('organizationCode'))
        if (Date.parse(initRegisterTimeEnd) < Date.parse(initRegisterTimeStart)) {
            warnningMsg("结束时间必须大于开始时间！");
            return false;
        }

        $.ajax({
            url: '..//sub/lock/order/searchList',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({
                'qymc': qymc,
                'gxdw': gxdw,
                'wtrxm': wtrxm,
                'ksrxm': ksrxm,
                'wtrzjhm': wtrzjhm,
                'ddh': "",
                'registerTimeStart': initRegisterTimeStart,
                'registerTimeEnd': initRegisterTimeEnd,
                'organizationCode':organizationCode
            }),
            success: function (data) {
                getDataList(data);
            },
            error: function (data) {
                dangerMsg(data);
            }
        })
    });

    /**********************
     *为详情弹出框赋值
     ***********************/
    $('#btn_detail').click(function () {
        $("#zmclzp").attr("src", "");
        $("#kszp").attr("src", "");
        $("#zmclDiv").css('display', "none");
        $("#kszpDiv").css('display', "none");

        var obj = $('#exampleTableEvents').bootstrapTable('getSelections')[0];
        if (typeof(obj) != 'undefined') {
            $("#ksrxm").html(obj.ksrxm);
            $("#zjlx").html(obj.ksrzjlx);
            $("#ksrsfzh").html(obj.ksrzjhm);
                                    $("#ksrzp").html(obj.ksrzp);
                                    $("#ksrImage").click(function () {
                                        var name = "ks" + obj.id;
                                        var http = zongzhiUrl + "/sub/lock/order/images?name=" + name;
                                        $("#showImage").attr("src", http);
                                    })

            $("#ksrdh").html(obj.ksrlxdh);
            $("#ksjgmcxq").html(obj.qymc);
            $("#ksjgdzxq").html(obj.qydz);

            $("#wtrxm").html(obj.wtrxm);
            $("#wtrzjlx").html(obj.wtrzjlx);
            $("#wtrzjhm").html(obj.wtrzjhm);
                                    $("#wtrzp").html(obj.wtrzp);
                                    $("#wtrImage").click(function () {
                                        var name = "wt" + obj.id;
                                        var http = zongzhiUrl + "/sub/lock/order/images?name=" + name;
                                        $("#showImage").attr("src", http);
                                    })
/*                                    if (obj.wtrzp != "") {
                                        var name = "wt" + obj.id;
                                        var http = zongzhiUrl + "/sub/lock/order/images?name=" + name;
                                        $("#wtrzp").attr("src", http);
                                        $("#zmclDiv").css('display', "");
                                        $("#zmclzp").css('display', "");
                                    }*/
            $("#bksrdhxq").html(obj.wtrlxdh);
            $("#wtrhjdz").html(obj.wtrhjdz);

            $("#addtime").html(obj.kssj);
            $("#kslxxq").html(obj.kslx);
            $("#dz").html(obj.ksdz);
            $("#djr").html(obj.djr);
            $("#remark").html(obj.bz);

            if (obj.zmclzp != "") {
                var name = "zm" + obj.id;
                var http = zongzhiUrl + "/sub/lock/order/images?name=" + name;
                $("#zmclzp").attr("src", http);
                $("#zmclDiv").css('display', "");
                $("#zmclzp").css('display', "");
            }
            if (obj.kszp != "") {
                var name = "kr" + obj.id;
                var http = zongzhiUrl + "/sub/lock/order/images?name=" + name;
                $("#kszp").attr("src", http);
                $("#kszpDiv").css('display', "");
                $("#kszp").css('display', "");
            }
        } else {
            warnningMsg('请选择一条数据！');
            return false;
        }
    });

})();

/**********************
 *模态框相关
 **********************/

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