$(function () {
    getCountsOfksxx({flag: "day"});
    //cxbz:查询标识 kslx：开锁类型  wtr：委托人数量 qysj：地区业务数据 qyfb：企业分布
    $("#day1").click(function () {
        getKsxxsOfdate({flag: "day", cxbz: "qysj"});
    });
    $("#month1").click(function () {
        getKsxxsOfdate({flag: "month", cxbz: "qysj"});
    });
});

// 时间段查询
function getDateStr2() {
    var beginStr = $("#cdDateStart").val();
    var endStr = $("#cdDateEnd").val();
    if (beginStr != "" && endStr != "") {
        var now = new Date(beginStr).getTime();
        var now1 = new Date(endStr).getTime();
        var time = (now1 - now) / 86400000;
        if (time < 0) {
            warnningMsg("你选择的日期不对请重新选择");
        } else {
            getKsxxsOfdate({beginStr: beginStr, endStr: endStr, cxbz: "qysj"});
        }

    }
}

// 默认7天数据
function getCountsOfksxx(data, barDyValueArr) {
    $.ajax({
        url: "../echart1/getCountsOfksxx",
        contentType: "application/json;charset=UTF-8",
        type: "GET",
        data: data,
        success: function (data) {
            //地区业务数据情况
            var qysjdata = data.qysjList;
            dqywBar(qysjdata);
            //开锁类型占比情况
            var kslxdata = data.kslxList;
            kslxPie(kslxdata);

            //开锁企业分布
            var qyfbdata = data.qyfbList;
            ksqyfbPie(qyfbdata);
            //委托人数量增长情况
            var wtrdata = data.wtrList;
            wtrValue(wtrdata)
        },
        error: function (data) {
        }
    });
}

// 按时间查询方法
function getKsxxsOfdate(param, arr) {
    $.ajax({
        url: "../echart1/getKsxxsOfdate",
        contentType: "application/json;charset=UTF-8",
        type: "GET",
        data: param,
        success: function (data) {
            if (param.cxbz == "qysj") {
                //地区业务数据情况
                var qysjdata = data.ksxxList;
                dqywBar(qysjdata)
            }
            if (param.cxbz == "kslx") {
                //开锁类型占比情况
                var kslxdata = data.ksxxList;
                kslxPie(kslxdata);
            }
            if (param.cxbz == "qyfb") {
                //开锁企业分布
                var qyfbdata = data.ksxxList;
                ksqyfbPie(qyfbdata)

            }
            if (param.cxbz == "wtr") {
                //委托人数量增长情况
                var wtrdata = data.ksxxList;
                wtrValue(wtrdata)
            }
        },
        error: function (data) {
        }
    });
}

// 开锁类型时间查询数据
$("#day2").click(function () {
    getKsxxsOfdate({flag: "day", cxbz: "kslx"});
});
$("#month2").click(function () {
    getKsxxsOfdate({flag: "month", cxbz: "kslx"});
});

function getDateStr1() {
    var beginStr = $("#cdDateStart2").val();
    var endStr = $("#cdDateEnd2").val();
    if (beginStr != "" && endStr != "") {
        var now = new Date(beginStr).getTime();
        var now1 = new Date(endStr).getTime();
        var time = (now1 - now) / 86400000;
        if (time < 0) {
            warnningMsg("你选择的日期不对请重新选择");
        } else {
            getKsxxsOfdate({beginStr: beginStr, endStr: endStr, cxbz: "kslx"});
        }

    }
}

// 开锁企业分布情况
$("#day3").click(function () {
    getKsxxsOfdate({"flag": "day", "cxbz": "qyfb"});
});
$("#month3").click(function () {
    getKsxxsOfdate({flag: "month", cxbz: "qyfb"});
});

function getDateStr() {
    var beginStr = $("#cdDateStart3").val();
    var endStr = $("#cdDateEnd3").val();
    if (beginStr != "" && endStr != "") {
        var now = new Date(beginStr).getTime();
        var now1 = new Date(endStr).getTime();
        var time = (now1 - now) / 86400000;

        if (time < 0) {
            warnningMsg("你选择的日期不对请重新选择");
        } else {
            getKsxxsOfdate({beginStr: beginStr, endStr: endStr, cxbz: "qyfb"});
        }
    }
}

// 委托人数量
$("#day4").click(function () {
    getKsxxsOfdate({"flag": "day", "cxbz": "wtr"});
});
$(".yhsl-year").click(function () {
    getKsxxsOfdate({flag: "year", cxbz: "wtr"});
});


// 地区业务统计图
function dqywBar(unlocDqywkData) {
    var barDyName = [];
    unlocDqywkData.forEach(function (item) {
        // if (item.value == 0 || item.value == 'null') {
        //     item.value = Math.floor(Math.random() * 10 + 5);
        //     barDyName.push(item.name);
        // } else {
        //     barDyName.push(item.name);
        // }
        barDyName.push(item.name);
    });
    var echarts_bar = echarts.init(
        document.getElementById("echarts-bar-chart")
    );
    var echartBarOption = {
        color: ["#2ec7c9"],
        tooltip: {
            trigger: "axis",
            axisPointer: {
                type: "shadow"
            }
        },
        grid: {
            left: "3%",
            right: "4%",
            bottom: "3%",
            containLabel: true
        },
        xAxis: [
            {
                type: "category",
                data: barDyName,
                // data:['新城区','高新區','雁塔區','蓮湖區','未央區','長安區','碑林區'],
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis: [
            {
                type: "value"
            }
        ],
        series: [
            {
                name: "",
                type: "bar",
                barWidth: "45%",
                data: unlocDqywkData
            }
        ]
    };
    echarts_bar.setOption(echartBarOption);
}

// 开锁类型占比
function kslxPie(unlocKslxkData) {
    var kslxName = [];
    unlocKslxkData.forEach(function (item) {
        // if (item.value == 0 || item.value == 'null') {
        //     item.value = Math.floor(Math.random() * 10 + 5);
        //     kslxName.push(item.name);
        // } else {
        //     kslxName.push(item.name);
        // }
        kslxName.push(item.name);
    });

    var sealTypePie = echarts.init(
        document.getElementById("main-pie-chart2")
    );
    var sealTypePieOption = {
        tooltip: {
            trigger: "item",
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        color: ["#32dadd", "#b6a2de", "#5ab1ef", "#ffb980", "#d87a80", "#8d98b3", "#e5cf0d"],
        legend: {
            orient: "vertical",
            left: "tight",
            data: kslxName
        },
        series: [
            {
                name: "",
                type: "pie",
                radius: "55%",
                center: ["50%", "60%"],
                data: unlocKslxkData,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: "rgba(0, 0, 0, 0.5)"
                    }
                }
            }
        ]
    };
    sealTypePie.setOption(sealTypePieOption);
}

// 开锁企业分布
function ksqyfbPie(unlocKsqyData) {
    var ksqyName = [];
    unlocKsqyData.forEach(function (item) {
        // if (item.value == 0 || item.value == 'null') {
        //     item.value = Math.floor(Math.random() * 10 + 5);
        //     ksqyName.push(item.name);
        // } else {
        //     ksqyName.push(item.name);
        // }
        ksqyName.push(item.name);
    });

    var sealTypePie1 = echarts.init(
        document.getElementById("main-pie-chart3")
    );
    var sealTypePieOption1 = {
        tooltip: {
            trigger: "item",
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        color: ["#32dadd", "#b6a2de", "#5ab1ef", "#ffb980", "#d87a80", "#8d98b3", "#e5cf0d"],
        legend: {
            orient: "vertical",
            left: "tight",
            data: ksqyName
        },
        series: [
            {
                name: "",
                type: "pie",
                radius: "55%",
                center: ["50%", "60%"],
                data: unlocKsqyData,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: "rgba(0, 0, 0, 0.5)"
                    }
                }
            }
        ]
    };
    sealTypePie1.setOption(sealTypePieOption1);
}

// 委托人数量增长
function wtrValue(unlocWtrData) {
    var wtrName = [];
    unlocWtrData.forEach(function (item) {
        // if (item.value == 0 || item.value == 'null') {
        //     item.value = Math.floor(Math.random() * 10 + 5);
        //     wtrName.push(item.name);
        // } else {
        //     wtrName.push(item.name);
        // }
        wtrName.push(item.name);
    });

    var echartsLienSeal = echarts.init(
        document.getElementById("main-line-chart")
    );
    echartsLienSeal.setOption(
        (option = {
            title: {
                //text: '折线图堆叠'
            },
            tooltip: {
                trigger: "axis"
            },
            legend: {
                data: []
            },
            grid: {
                left: "3%",
                right: "4%",
                bottom: "3%",
                containLabel: true
            },
            // toolbox: {
            //   feature: {
            //     saveAsImage: {}
            //   }
            // },
            xAxis: {
                type: "category",
                boundaryGap: false,
                data: wtrName
            },
            yAxis: {
                type: "value"
            },
            series: [
                {
                    name: "",
                    type: "line",
                    stack: "总量",
                    data: unlocWtrData
                }
            ]
        })
    );
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