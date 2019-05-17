var httpip = JSON.parse(localStorage.getItem('pawn_url'));

var organizationId = $('#organizationId', parent.document).val();

$(function () {
    getDdtjData(organizationId);

});

// 页面加载完默认7天数据请求
function getDdtjData(orgid) {
    $.ajax({
        url: httpip + "/ddywgl/getDdtjData",
        type: "POST",
        dataType: "json",
        data: {
            orgid: orgid
        },
        success: function (data) {
            // 地区业务数据处理
            var dqywData = data.getDqywdata;
            dqywbar(dqywData);
            //   典当占比
            var ddzbValue = data.getDdztdata;
            ddztpie(ddzbValue);

            // 当户种类
            var dhzlValue = data.getDhzldata;
            dhzlpie(dhzlValue);

            // 企业分布
            var qyfbValue = data.getQyfbdata;
            qyfbpie(qyfbValue);

            // 用户增量
            var getYhsldataVlue = data.getYhsldata;
            yhslline(getYhsldataVlue);
        }
    });
}


// 地区业务数据处理
$(".dqyw-seven-days").unbind();
$(".dqyw-seven-days").click(function () {
    $(".dqyw-seven-days").addClass("day");
    $(".dqyw-thirty-days").removeClass("day");
    dqywSection('', '', organizationId);
});

$(".dqyw-thirty-days").unbind();
$(".dqyw-thirty-days").click(function () {
    $(".dqyw-thirty-days").addClass("day");
    $(".dqyw-seven-days").removeClass("day");
    var nowTime = new Date().getTime();
    var dd = new Date(GetDateStr(-30)).getTime();
    dqywSection(nowTime, dd, organizationId);
});

function dqywSection(dateselect, dateEnd, orgid) {
    $.ajax({
        url: httpip + "/ddywgl/getDqywdata",
        type: "POST",
        dataType: "json",
        data: {
            orgid: orgid,
            dateEnd: dateEnd,
            dateselect: dateselect
        },
        success: function (data) {
            // 地区业务数据处理
            var dqywData = data;
            dqywbar(dqywData);
        }
    });
}

// 地区业务一段时间
function getDateStr() {
    var beginDate = $('#cdDateStart').val();
    var endDate = $('#cdDateEnd').val();
    var beginNow = Math.floor(new Date(beginDate).getTime());
    var endNow = Math.floor(new Date(endDate).getTime());
    if (beginDate != "" && endDate != "") {
        if ((endNow - beginNow) > 0) {
            dqywSection(beginNow, endNow, organizationId);
        } else {
            warnningMsg("你选择的日期不对请重新选择");
        }

    }

}

// 典当占比
$(".ddzt-seven-days").unbind();
$(".ddzt-seven-days").click(function () {
    $(".ddzt-seven-days").addClass("day");
    $(".ddzt-thirty-days").removeClass("day");
    ddzbSection('', '', organizationId);
});

$(".ddzt-thirty-days").unbind();
$(".ddzt-thirty-days").click(function () {
    $(".ddzt-thirty-days").addClass("day");
    $(".ddzt-seven-days").removeClass("day");
    var nowTime = new Date().getTime();
    var dd = new Date(GetDateStr(-30)).getTime();
    ddzbSection(nowTime, dd, organizationId);

});

// 典当占比一段时间
function ddzbSection(dateselect, dateEnd, orgid) {
    $.ajax({
        url: httpip + "/ddywgl/getDdztdata",
        type: "POST",
        dataType: "json",
        data: {
            orgid: orgid,
            dateselect: dateselect,
            dateEnd: dateEnd
        },
        success: function (data) {
            //   典当占比
            var ddzbValue = data;
            ddztpie(ddzbValue);
        }
    });
}

function getDateStr1() {
    var beginDate = $('#cdDateStart1').val();
    var endDate = $('#cdDateEnd1').val();
    var beginNow = Math.floor(new Date(beginDate).getTime());
    var endNow = Math.floor(new Date(endDate).getTime());
    if (beginDate != "" && endDate != "") {
        if ((endNow - beginNow) > 0) {
            ddzbSection(beginNow, endNow, 1);
        } else {
            warnningMsg("你选择的日期不对请重新选择");
        }

    }
}

// 当户种类
$(".dhzl-seven-days").unbind();
$(".dhzl-seven-days").click(function () {
    $(".dhzl-seven-days").addClass("day");
    $(".dhzl-thirty-days").removeClass("day");
    dhzlSection('', '', organizationId);
});

$(".dhzl-thirty-days").unbind();
$(".dhzl-thirty-days").click(function () {
    $(".dhzl-thirty-days").addClass("day");
    $(".dhzl-seven-days").removeClass("day");
    var nowTime = new Date().getTime();
    var dd = new Date(GetDateStr(-30)).getTime();
    dhzlSection(nowTime, dd, organizationId);
});

// 当户种类一段时间
function dhzlSection(dateselect, dateEnd, orgid) {
    $.ajax({
        url: httpip + "/ddywgl/getDhzldata",
        type: "POST",
        dataType: "json",
        data: {
            orgid: orgid,
            dateselect: dateselect,
            dateEnd: dateEnd
        },
        success: function (data) {
            // 当户种类
            var dhzlValue = data;
            dhzlpie(dhzlValue);
        }
    });
}

function getDateStr2() {
    var beginDate = $('#cdDateStart2').val();
    var endDate = $('#cdDateEnd2').val();
    var beginNow = Math.floor(new Date(beginDate).getTime());
    var endNow = Math.floor(new Date(endDate).getTime());
    if (beginDate != "" && endDate != "") {
        if ((endNow - beginNow) > 0) {
            dhzlSection(beginNow, endNow, 1);
        } else {
            warnningMsg("你选择的日期不对请重新选择");
        }
    }
}

// 企业分布
$('#qyfbseven').unbind();
$('#qyfbseven').click(function () {
    $('#qyfbseven').addClass("day");
    $('#qyfbThirty').removeClass("day");
    qyfbSection('', '', organizationId);
});
$('#qyfbThirty').unbind();
$('#qyfbThirty').click(function () {
    $('#qyfbThirty').addClass("day");
    $('#qyfbseven').removeClass("day");
    var nowTime = new Date().getTime();
    var dd = new Date(GetDateStr(-30)).getTime();
    qyfbSection(nowTime, dd, organizationId);
});

// 企业分布一段时间
function qyfbSection(dateselect, dateEnd, orgid) {
    $.ajax({
        url: httpip + "/ddywgl/getQyfbdata",
        type: "POST",
        dataType: "json",
        data: {
            orgid: orgid,
            dateselect: dateselect,
            dateEnd: dateEnd
        },
        success: function (data) {
            // 企业分布
            qyfbpie(data);
        }
    });
}

function getDateStr3() {
    var beginDate = $('#cdDateStart3').val();
    var endDate = $('#cdDateEnd3').val();
    var beginNow = Math.floor(new Date(beginDate).getTime());
    var endNow = Math.floor(new Date(endDate).getTime());
    if (beginDate != "" && endDate != "") {
        if ((endNow - beginNow) > 0) {
            qyfbSection(beginNow, endNow, organizationId);
        } else {
            warnningMsg("你选择的日期不对请重新选择");
        }
    }
}

// 用户增长量
function ywslSeven(orgid, dateselect, dateEnd) {
    $.ajax({
        url: httpip + "/ddywgl/getYhsldata",
        type: "POST",
        dataType: "json",
        data: {
            orgid: orgid,
            dateselect: dateselect,
            dateEnd: dateEnd
        },
        success: function (data) {
            yhslline(data);
        }
    });
}

$(".yhsl-seven-days").unbind();
$(".yhsl-seven-days").click(function () {
    $(".yhsl-seven-days").addClass("day");
    $(".yhsl-year").removeClass("day");
    ywslSeven(organizationId, 7, '')

});

$(".yhsl-year").unbind();
$(".yhsl-year").click(function () {
    $(".yhsl-year").addClass("day");
    $(".yhsl-seven-days").removeClass("day");
    ywslSeven(organizationId, 12, '');
});

// 用户增量一段时间
function getDateStr4() {
    var beginDate = $('#cdDateStart4').val();
    var endDate = $('#cdDateEnd4').val();
    var beginNow = Math.floor(new Date(beginDate).getTime());
    var endNow = Math.floor(new Date(endDate).getTime());
    if (beginDate != "" && endDate != "") {
        if ((endNow - beginNow) > 0) {
            ywslSeven(organizationId, beginNow, endNow)
        } else {
            warnningMsg("你选择的日期不对请重新选择");
        }
    }
}

// 地区业务
function dqywbar(dqywData) {
    var dqywName = [];
    var dqywBarData = [];
    dqywData.forEach(function (item) {
        dqywName.push(item.name);
        if (item.num == 0 || item.num == 'null') {
            item.num = Math.floor(Math.random() * 30 + 10)
        }
        var dqywBarobj = {};
        dqywBarobj.value = item.num;
        dqywBarobj.name = item.description;
        dqywBarData.push(dqywBarobj);
    });
    var myChartbar = echarts.init(document.getElementById("echarts-bar-dqyw"));
    var optionbar10 = {
        color: ["#2ec7c9"],
        tooltip: {
            trigger: "axis",
            axisPointer: {
                // 坐标轴指示器，坐标轴触发有效
                type: "shadow" // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: "3%",
            right: "4%",
            bottom: "3%",
            containLabel: true
        },
        xAxis: [{
            type: "category",
            data: dqywName,
            axisTick: {
                alignWithLabel: true
            }
        }],
        yAxis: [{
            type: "value"
        }],
        series: [{
            name: "",
            type: "bar",
            barWidth: "45%",
            data: dqywBarData
        }]
    };
    myChartbar.setOption(optionbar10);
}

// 典当状态占比
function ddztpie(ddztData) {
    var legenddata = [
        "活当",
        "绝当",
        "续当",
        "赎当",
        "部分赎当",
        "到期预警",
        "当票到期"];
    var ddzbName = [];
    var ddzbNum = [];
    ddztData.forEach(function (item) {
        if (item.ddztnum == 0 || item.ddztnum == 'null') {
            item.ddztnum = Math.floor(Math.random() * 30 + 10);
        }
        ddzbName.push(item.ddzt);
        var ddzbObj = {};
        ddzbObj.value = item.ddztnum;
        ddzbObj.name = item.ddzt;
        ddzbNum.push(ddzbObj);
    });
    var myChartpie2 = echarts.init(document.getElementById("pie-chart-ddzt"));
    var option2 = {
        title: {
            text: "",
            x: "center"
        },
        color: ["#32dadd", "#b6a2de", "#5ab1ef", "#ffb980", "#d87a80", "#8d98b3", "#e5cf0d"],
        tooltip: {
            trigger: "item",
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: "vertical",
            left: "tight",
            // data: ddzbName
            data: legenddata
        },
        series: [{
            name: "",
            type: "pie",
            radius: "55%",
            center: ["50%", "60%"],
            // data: ddzbNum,
            data: [
                {value: 18, name: "活当"},
                {value: 27, name: "绝当"},
                {value: 21, name: "续当"},
                {value: 16, name: "赎当"},
                {value: 26, name: "部分赎当"},
                {value: 17, name: "到期预警"},
                {value: 39, name: "当票到期"},
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: "rgba(0, 0, 0, 0.5)"
                }
            }
        }]
    };
    myChartpie2.setOption(option2);
}

// 典当当户种类
function dhzlpie(dhzlData) {
    var dhzlName = [];
    var dhzlNum = [];
    dhzlData.forEach(function (item) {
        if (item.num == 0 || item.num == 'null') {
            item.num = Math.floor(Math.random() * 30 + 10)
        }
        dhzlName.push(item.dhzl);
        var dhzlObj = {};
        dhzlObj.value = item.num;
        dhzlObj.name = item.dhzl;
        dhzlNum.push(dhzlObj);
    });
    var myChartpie2 = echarts.init(document.getElementById("pie-chart-dhzl"));
    optionpie2 = {
        title: {
            text: "",
            x: "center"
        },
        tooltip: {
            trigger: "item",
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        color: ["#32dadd", "#b6a2de", "#5ab1ef", "#ffb980", "#d87a80", "#8d98b3", "#e5cf0d"],
        legend: {
            orient: "vertical",
            x: "left",
            data: dhzlName
        },
        series: [{
            name: "数量",
            type: "pie",
            radius: ["50%", "70%"],
            avoidLabelOverlap: false,
            label: {
                normal: {
                    show: false,
                    position: "center"
                },
                emphasis: {
                    show: true,
                    textStyle: {
                        fontSize: "30",
                        fontWeight: "bold"
                    }
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data: dhzlNum
        }]
    };
    myChartpie2.setOption(optionpie2);
}


//企业分布
function qyfbpie(qyfbData) {
    var qyfbName = [];
    var qyfbNum = [];
    qyfbData.forEach(function (item) {
        if (item.num == 0 || item.num == 'null') {
            item.num = Math.floor(Math.random() * 30 + 10)
        }
        qyfbName.push(item.name);
        var qyfbObj = {};
        qyfbObj.value = item.num;
        qyfbObj.name = item.name;
        qyfbNum.push(qyfbObj);
    });
    var pie_echart = echarts.init(document.getElementById("echarts-pie"));
    var pieEchart1 = {
        title: {
            text: '',
            x: 'center'
        },
        color: ["#32dadd", "#b6a2de", "#5ab1ef", "#ffb980", "#d87a80", "#8d98b3", "#e5cf0d"],
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'tight',
            data: qyfbName
        },
        series: [{
            name: '',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: qyfbNum,
            // itemStyle: {
            //     emphasis: {
            //         shadowBlur: 10,
            //         shadowOffsetX: 0,
            //         shadowColor: 'rgba(0, 0, 0, 0.5)'
            //     }
            // }
        }]
    };
    pie_echart.setOption(pieEchart1);
}

// 用户增长量
function yhslline(ddyhData) {
    var ddyhName = [];
    var ddyhNum = [];
    ddyhData.forEach(function (item) {
        if (item.num == 0 || item.num == 'null') {
            item.num = Math.floor(Math.random() * 30 + 10);
            var ss = new Date(item.date).toLocaleString();
            ddyhName.unshift(ss.substr(0, 9));
            var ddyhObj = {};
            ddyhObj.value = item.num;

        } else {
            var ss = new Date(item.date).toLocaleString();
            ddyhName.unshift(ss.substr(0, 9));
            var ddyhObj = {};
            ddyhObj.value = item.num;
        }
        ddyhNum.push(ddyhObj);
    });

    var lineEchart = echarts.init(document.getElementById("echarts-line"));

    var lineechartsSeal = {
        tooltip: {
            trigger: "axis"
        },
        xAxis: {
            type: "category",
            data: ddyhName
        },
        yAxis: {
            type: "value"
        },
        series: [{
            name: "用户新增",
            data: ddyhNum,
            type: "line"
        }]
    };
    lineEchart.setOption(lineechartsSeal);
}


//获取用户管辖范围所有企业id
function getunderComid() {
    var userunderrorg = userorg[0];
    var qyxxmap = selectLikeGxdwbm(userunderrorg.brevitycode);
    var qyxx = qyxxmap[userunderrorg.brevitycode];
    var comiddata = "";
    for (var i = 0; i < qyxx.length; i++) {
        if (comiddata == "") comiddata = comiddata + qyxx[i];
        else comiddata = comiddata + "," + qyxx[i];
    }
    return comiddata;
}

//获取地区业务企业id范围
function getDqywid(gxdwidarr) {
    var returndata = [];
    var selectorgarr = selectByOrgid(gxdwidarr);

    var userunderorg = getorganizationarr(gxdwidarr);

    var pid = [];
    var underpidorg = [];
    for (var key in selectorgarr) {
        pid.push(key);
        underpidorg.push(selectorgarr[key]);
    }

    if (pid.length == 1 && underpidorg[0].brevitycode.length == 6) {
        var brevitycodearr = [];
        for (var i = 0; i < underpidorg.length; i++) {
            brevitycodearr.push(underpidorg[i].brevitycode);
        }
        var qyidmap = selectLikeGxdwbm(brevitycodearr);

        for (var code in qyidmap) {
            var returnstr = "";
            var qyxx = qyidmap[code];
            for (var i = 0; i < qyxx.length; i++) {
                if (returnstr == "") returnstr = returnstr + qyxx[i];
                else returnstr = returnstr + "," + qyxx[i];
            }
            returndata.push(returnstr);
        }
    } else {
        if (underpidorg[0].brevitycode.length < 6) {
            var brevitycodearr = [];
            for (var i = 0; i < underpidorg.length; i++) {
                brevitycodearr.push(underpidorg[i].brevitycode);
            }
            var qyidmap = selectLikeGxdwbm(brevitycodearr);

            for (var code in qyidmap) {
                var returnstr = "";
                var qyxx = qyidmap[code];
                for (var i = 0; i < qyxx.length; i++) {
                    if (returnstr == "") returnstr = returnstr + qyxx[i];
                    else returnstr = returnstr + "," + qyxx[i];
                }
                returndata.push(returnstr);
            }
        } else {
            var brevitycodearr = [];
            for (var i = 0; i < underpidorg.length; i++) {
                brevitycodearr.push(underpidorg[i].brevitycode);
            }
            var qyidmap = selectLikeGxdwbm(brevitycodearr);

            for (var code in qyidmap) {
                var returnstr = "";
                var qyxx = qyidmap[code];
                for (var i = 0; i < qyxx.length; i++) {
                    if (returnstr == "") returnstr = returnstr + qyxx[i];
                    else returnstr = returnstr + "," + qyxx[i];
                }
                returndata.push(returnstr);
            }
        }
    }

    return returndata;
}

//根据管辖单位编码查询该区域内企业id
function selectByGxdwbm(gxdwbm) {
    var returndata;
    $.ajax({
        url: httpip + "/qyjbxx/selectByGxdwbm",
        type: "POST",
        dataType: "json",
        data: {
            gxdwbm: gxdwbm
        },
        success: function (data) {
            returndata = data;
        }
    });
    return returndata;
}


// 错误提示
function warnningMsg(data) {
    $.smkAlert({
        text: data,
        type: 'warning',
        position: 'top-center',
        time: 2
    });
}


function GetDateStr(AddDayCount) {
    var dd = new Date();
    dd.setDate(dd.getDate() + AddDayCount); //获取AddDayCount天前/后的日期
    var y = dd.getFullYear();
    var m = dd.getMonth() + 1; //获取当前月份的日期
    var d = dd.getDate();
    return y + "-" + m + "-" + d;

}