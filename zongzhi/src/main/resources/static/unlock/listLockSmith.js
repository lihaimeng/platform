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
    var gxdw = initDominion;//管辖单位编号
    var idcard = $('#searchidcard').val().trim();//身份证号码
    var name = $('#searchname').val().trim();//锁匠姓名
    var licensenumber = $('#searchlicensenumber').val().trim();//上岗证编号
    var initRegisterTimeStart = $('#registerTimeStart').val().trim();
    var initRegisterTimeEnd = $('#registerTimeEnd').val().trim();
    var organizationCode = JSON.parse(localStorage.getItem('organizationCode'))
    $.ajax({
        url: '../sd/lock/smith/findSdLockSmithList',
        type: 'POST',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify({
            'idcard': idcard,
            'name': name,
            'gxdw': gxdw,
            'licensenumber': licensenumber,
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
                    width: 22,
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
                    field: 'name',
                    title: '锁匠名称',
                    align: 'center'
                }, {
                    field: 'idcard',
                    title: '身份证号码',
                    align: 'center'
                }, {
                    field: 'mobile',
                    title: '电话',
                    align: 'center'
                },
                {
                    field: 'addtime',
                    title: '登记时间',
                    align: 'center'
                },
                {
                    field: 'address',
                    title: '锁匠地址',
                    align: 'center'
                }

            ]
        });
    }
/* {
                    field: 'licensenumber',
                    title: '上岗证编号',
                    align: 'center'
                },
                {
                    field: 'licenseendtime',
                    title: '上岗证到期时间',
                    align: 'center'
                },*/

    $('#search').click(function () {
        var searchDominion = $('#dominion').val().trim();
        if (searchDominion == '0') {
            searchDominion = "";
        }
        var gxdw = searchDominion;//管辖单位编号
        var idcard = $('#searchidcard').val().trim();//身份证号码
        var name = $('#searchname').val().trim();//锁匠姓名
        var licensenumber = $('#searchlicensenumber').val().trim();//上岗证编号
        var initRegisterTimeStart = $('#registerTimeStart').val().trim();
        var initRegisterTimeEnd = $('#registerTimeEnd').val().trim();
        var organizationCode = JSON.parse(localStorage.getItem('organizationCode'))
        if (Date.parse(initRegisterTimeEnd) < Date.parse(initRegisterTimeStart)) {
            warnningMsg("结束时间必须大于开始时间！");
            return false;
        }

        $.ajax({
            url: '../sd/lock/smith/findSdLockSmithList',
            type: 'POST',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify({
                'idcard': idcard,
                'name': name,
                'gxdw': gxdw,
                'licensenumber': licensenumber,
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
        var obj = $('#exampleTableEvents').bootstrapTable('getSelections')[0];
        if (typeof(obj) != 'undefined') {
            $("#name").html(obj.name);
            $("#idcard").html(obj.idcard);
            $("#mobile").html(obj.mobile);
            $("#licensenumber").html(obj.licensenumber);
            $("#licenseendtime").html(obj.licenseendtime);
            $("#addtime").html(obj.addtime);
            $("#address").html(obj.address);
            $("#locksmithImage").click(function () {
                var name = "ls" + obj.lid;
                var http = zongzhiUrl + "/sd/lock/smith/images?name=" + name;
                $("#showImage").attr("src", http);
            })
            $("#idcardImage").click(function () {
                var name = "ic" + obj.lid;
                var http = zongzhiUrl + "/sd/lock/smith/images?name=" + name;
                $("#showImage").attr("src", http);
            })
            $("#workImage").click(function () {
                var name = "wo" + obj.lid;
                var http = zongzhiUrl + "/sd/lock/smith/images?name=" + name;
                $("#showImage").attr("src", http);
            })
            $("#businessImage").click(function () {
                var name = "bu" + obj.lid;
                var http = zongzhiUrl + "/sd/lock/smith/images?name=" + name;
                $("#showImage").attr("src", http);
            })
            $("#handcardImage").click(function () {
                var name = "hc" + obj.lid;
                var http = zongzhiUrl + "/sd/lock/smith/images?name=" + name;
                $("#showImage").attr("src", http);
            })

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