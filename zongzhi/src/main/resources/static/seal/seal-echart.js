// 刚进页面加载的数据默认是7天的数据
$(function () {
    $.ajax({
        url: "../seal/getSealMsg",
        type: "GET",
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            // 地区业务
            var sealNumByDominion = data.sealNumByDominion;
            // 用户增长
            var companyNum = data.companyNum;
            // 印章类型
            var sealNumByType = data.sealNumByType;
            // 地区业务
            barEchart(sealNumByDominion);
            // 印章类型
            sealTypePie(sealNumByType);
            //  用户增长量
            fillLineEchart(companyNum);
        },
        error: function (err) {
        }
    });
}());

// 图表生成方法
function barEchart(barEchartData) {
    var placeValueArr = [];
    var markMarkNumArr = [];
    barEchartData.forEach(function (item) {
        if (item.sealNum == 0 || item.sealNum == 'null') {
            item.sealNum = Math.floor(Math.random() * 10 + 5);
        }

        placeValueArr.push(item.dominionName.replace("公安厅", ""));
        var sealDataObj = {};
        sealDataObj.name = item.dominionName.replace("公安厅", "");
        sealDataObj.value = item.sealNum;
        markMarkNumArr.push(sealDataObj);
    });


    var echarts_bar = echarts.init(document.getElementById("main-bar-chart"));
    var echartBarOption = {
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
        xAxis: [
            {
                type: "category",
                data: placeValueArr,
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis: [
            {
                type: "value",
                // max:max
            }
        ],
        series: [
            {
                name: "",
                type: "bar",
                barWidth: "45%",
                data: markMarkNumArr,

            }
        ]
    };
    echarts_bar.setOption(echartBarOption);
}

function sealTypePie(sealTypeData) {
    // 印章类型
    var sealTypeNameArr = [];
    var sealTypeNumArr = [];
    sealTypeData.forEach(function (item) {
        if (item.sealTypeNum == 0 || item.sealTypeNum == 'null') {
            item.sealTypeNum = Math.floor(Math.random() * 10 + 5);
        }
        sealTypeNameArr.push(item.sealType);
        var sealDataObj = {};
        sealDataObj.name = item.sealType;
        sealDataObj.value = item.sealTypeNum;
        sealTypeNumArr.push(sealDataObj);
    });

    var sealTypePie = echarts.init(document.getElementById("main-pie-chart2"));

    var sealTypePieOption = {
        tooltip: {
            trigger: "item",
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        color: ["#32dadd", "#b6a2de", "#5ab1ef", "#ffb980", "#d87a80", "#8d98b3", "#e5cf0d"],
        legend: {
            orient: "vertical",
            x: "left",
            data: sealTypeNameArr
        },
        series: [
            {
                name: "",
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
                data: sealTypeNumArr
            }
        ]
    };
    sealTypePie.setOption(sealTypePieOption);
}

function fillLineEchart(LineEchartData) {
    // 用户增长量
    var companyNumArr = [];
    var companyAddDateArr = [];
    LineEchartData.forEach(function (item) {
        if (item.sealUseNum == 0 || item.sealUseNum == 'null') {
            item.sealUseNum = Math.floor(Math.random() * 10 + 5);
        }
        companyAddDateArr.push(item.companyAddDate);
        var sealDataObj = {};
        sealDataObj.name = item.companyAddDate;
        sealDataObj.value = item.sealUseNum;
        companyNumArr.push(sealDataObj);
    });

    var echartsLienSeal = echarts.init(
        document.getElementById("main-line-chart")
    );
    echartsLienSeal.setOption(
        (option = {
            title: {
                text: ""
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

            xAxis: {
                type: "category",
                boundaryGap: false,
                data: companyAddDateArr
            },
            yAxis: {
                type: "value"
            },
            series: [
                {
                    name: "",
                    type: "line",
                    stack: "总量",
                    data: companyNumArr
                }
            ]
        })
    );
}

// 地区业务7天 30天查询封装
function barEchartAjax() {
    var info = {};

}

// 地区业务7天 30天查询封装
function barEchartWeekAjax() {
    var arr1 = [32, 63, 45, 12, 99, 68, 45, 85, 43, 77, 105, 55, 15];
    $.ajax({
        url: "../seal/getSealMsgByCondition",
        type: "POST",
        data: JSON.stringify({
            "dateMark": "week",
            "mark": "dominion",
        }),
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            data = data.countSealMsgByDominion;
            barEchart(data);
        }
    });
}

function barEchartMonthAjax() {
    var arr2 = [50, 45, 12, 30, 62, 18, 76, 53, 49, 87, 64, 66, 75];
    $.ajax({
        url: "../seal/getSealMsgByCondition",
        type: "POST",
        data: JSON.stringify({
            "dateMark": "month",
            "mark": "dominion"
        }),
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            data = data.countSealMsgByDominion;
            barEchart(data);
        }

    });
}

// 地区业务时间查询
function barWeekDateAjax(date1, date2) {
    $.ajax({
        url: "../seal/getSealMsgByCondition",
        type: "POST",
        data: JSON.stringify({
            dateMark: "week",
            mark: "dominion",
            registerDateStart: date1,
            registerDateEnd: date2,
        }),
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            data = data.countSealMsgByDominion;

            barEchart(data);
        }
    });
}

function barMonthDateAjax(date1, date2) {
    $.ajax({
        url: "../seal/getSealMsgByCondition",
        type: "POST",
        data: JSON.stringify({
            dateMark: "month",
            mark: "dominion",
            registerDateStart: date1,
            registerDateEnd: date2,
        }),
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            data = data.countSealMsgByDominion;
            barEchart(data);
        }
    });
}

function barYearhDateAjax(date1, date2) {
    $.ajax({
        url: "../seal/getSealMsgByCondition",
        type: "POST",
        data: JSON.stringify({
            dateMark: "year",
            mark: "dominion",
            registerDateStart: date1,
            registerDateEnd: date2,
        }),
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            data = data.countSealMsgByDominion;
            barEchart(data);
        }
    });
}

//地区业务按7天30天查询
var week = document.getElementById("week");
var month = document.getElementById("month");
addEvent(week, "click", function () {
    barEchartWeekAjax()
});
addEvent(month, "click", function () {
    barEchartMonthAjax()
});

function getDateStr() {
    var beginStr = $("#cdDateStart").val();
    //结束时间
    var endStr = $("#cdDateEnd").val();
    if (beginStr != "" && endStr != "") {
        var now = new Date(beginStr).getTime();
        var now1 = new Date(endStr).getTime();
        var time = (now1 - now) / 86400000;
        if (time > 0 && time <= 7) {
            barWeekDateAjax(beginStr, endStr);
        } else if (time > 7 && time <= 30) {
            barMonthDateAjax(beginStr, endStr);
        } else if (time > 30) {
            barYearhDateAjax(beginStr, endStr);
        } else {
            warnningMsg("你选择的日期不对请重新选择");
        }
    }
}


// 印章类型7/30天时间查询封装
function pieEchartWeekAjax() {
    $.ajax({
        url: "../seal/getSealMsgByCondition",
        type: "POST",
        data: JSON.stringify({
            dateMark: "week",
            mark: "sealType"
        }),
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            data = data.countSealMsgBySealType;
            sealTypePie(data);
        }
    });
}

function pieEchartMonthAjax() {
    $.ajax({
        url: "../seal/getSealMsgByCondition",
        type: "POST",
        data: JSON.stringify({
            dateMark: "month",
            mark: "sealType"
        }),
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            data = data.countSealMsgBySealType;
            sealTypePie(data);
        }
    });
}

// 印章类型一段时间
function pieWeekDateAjax(date1, date2) {
    $.ajax({
        url: "../seal/getSealMsgByCondition",
        type: "POST",
        data: JSON.stringify({
            dateMark: "week",
            mark: "sealType",
            registerDateStart: date1,
            registerDateEnd: date2,
        }),
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            data = data.countSealMsgBySealType;
            sealTypePie(data);
        }
    });
}

function pieMonthDateAjax(date1, date2) {
    $.ajax({
        url: "../seal/getSealMsgByCondition",
        type: "POST",
        data: JSON.stringify({
            dateMark: "month",
            mark: "sealType",
            registerDateStart: date1,
            registerDateEnd: date2,
        }),
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            data = data.countSealMsgBySealType;
            sealTypePie(data);
        }
    });
}

function pieYearDateAjax(date1, date2) {
    $.ajax({
        url: "../seal/getSealMsgByCondition",
        type: "POST",
        data: JSON.stringify({
            dateMark: "year",
            mark: "sealType",
            registerDateStart: date1,
            registerDateEnd: date2,
        }),
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            data = data.countSealMsgBySealType;
            sealTypePie(data);
        }
    });
}

// 7天30天查询印章类型数据
var week1 = document.getElementById("week1");
var month1 = document.getElementById("month1");
addEvent(week1, "click", function () {
    pieEchartWeekAjax()
});
addEvent(month1, "click", function () {
    pieEchartMonthAjax()
});

// 印章类型时间段查询
function getDateStr2() {
    var beginStr = $("#cdDateStart2").val();
    //结束时间
    var endStr = $("#cdDateEnd2").val();
    if (beginStr != "" && endStr != "") {
        var now = new Date(beginStr).getTime();
        var now1 = new Date(endStr).getTime();
        var time = Math.floor((now1 - now) / 86400000);
        if (time > 0 && time <= 7) {
            pieWeekDateAjax(beginStr, endStr);
        } else if (time > 7 && time <= 30) {
            pieMonthDateAjax(beginStr, endStr);
        } else if (time > 30) {
            pieYearDateAjax(beginStr, endStr);
        } else {
            warnningMsg("你选择的日期不对请重新选择");
        }
    }
}


// 折线图用户量增加
function lineEchartWeekAjax() {
    $.ajax({
        url: "../seal/getSealMsgByCondition",
        type: "POST",
        data: JSON.stringify({
            dateMark: "week",
            mark: "company",
        }),
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            data = data.sealCompany;
            fillLineEchart(data);
        }
    });
}

function lineEchartYearAjax() {
    $.ajax({
        url: "../seal/getSealMsgByCondition",
        type: "POST",
        data: JSON.stringify({
            dateMark: 'year',
            mark: "company",
        }),
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            data = data.sealCompany;
            fillLineEchart(data);
        }
    });
}

// 用户增长量一段时间方法封装
function lineEWeekchartAjax(date, date1) {
    $.ajax({
        url: "../seal/getSealMsgByCondition",
        type: "POST",
        data: JSON.stringify({
            dateMark: "week",
            mark: "company",
            registerDateStart: date,
            registerDateEnd: date1,
        }),
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            data = data.sealCompany;
            fillLineEchart(data);
        }
    });
}

function lineEchartMonthAjax(date, date1) {
    $.ajax({
        url: "../seal/getSealMsgByCondition",
        type: "POST",
        data: JSON.stringify({
            dateMark: "month",
            mark: "company",
            registerDateStart: date,
            registerDateEnd: date1,
        }),
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            data = data.sealCompany;
            fillLineEchart(data);
        }
    });
}

function lineYearDateAjax(date, date1) {
    $.ajax({
        url: "../seal/getSealMsgByCondition",
        type: "POST",
        data: JSON.stringify({
            dateMark: "year",
            mark: "company",
            registerDateStart: date,
            registerDateEnd: date1,
        }),
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            data = data.sealCompany;
            fillLineEchart(data);
        }
    });
}


// 用户增长量7 一年数据点击查询
var week3 = document.getElementById("select");
var year = document.getElementsByClassName("yhsl-year")[0];
addEvent(week3, "click", function () {
    lineEchartWeekAjax()
});
addEvent(year, "click", function () {
    lineEchartYearAjax();
});


// 用户增长量选择一段时间查询
function getDateStr4() {
    var beginStr = $("#cdDateStart4").val();
    //结束时间
    var endStr = $("#cdDateEnd4").val();
    if (beginStr != "" && endStr != "") {
        var now = new Date(beginStr).getTime();
        var now1 = new Date(endStr).getTime();
        var time = Math.floor((now1 - now) / 86400000);
        if (time > 0 && time <= 7) {
            lineEWeekchartAjax(beginStr, endStr);
        } else if (time > 7 && time <= 30) {
            lineEchartMonthAjax(beginStr, endStr);
        } else if (time > 30) {
            lineYearDateAjax(beginStr, endStr);
        } else {
            warnningMsg("你选择的日期不对请重新选择");
        }
    }
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

// 兼容性绑定点击事件封装
function addEvent(elem, type, handle) {
    if (elem.addEventListener) {
        elem.addEventListener(type, handle, false);
    } else if (elem.attachEvent) {
        elem.attachEvent('on', +type, function () {
            handle.call(elem);
        })
    } else {
        elem['on' + type] = handle;
    }
}