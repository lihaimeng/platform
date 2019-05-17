$("#companyStaff").click(function () {
    $("#pie1").css("display", "none");
    $("#pie2").css("display", "block");
});
$("#company").click(function () {
    $("#pie2").css("display", "none");
    $("#pie1").css("display", "block");
});
$(document).ready(function () {
    $.ajax({
        url: "../index/countMsg",
        type: "GET",
        success: function (countNum) {
            var returnData;
            returnData = countNum;
            $("#organizationName").html(countNum.organizationName);
            $("#roleName").html(countNum.roleName);
            $("#organizationParentName").html(countNum.organizationParentName);
            var kyqkData = countNum.kyqk;
            for (var i = 0; i < kyqkData.length; i++) {
                $("#kyqkMsg").append(
                    // "<a href='../dailyManage/suspiciousManage/suspiciousManage.html' style='display: block'><li class='liMsg' style='overflow: hidden;white-space: nowrap;text-overflow: ellipsis;'>" +
                    //   countNum.kyqk[i].hylb +
                    //   ">" +
                    //   countNum.kyqk[i].qymc +
                    //   ">" +
                    //   countNum.kyqk[i].kyqklx +
                    //   "</li></a>"
                    '<a class="title"  onclick=\'kxqkDetile("' + kyqkData[i].kyqkid + ',' + kyqkData[i].kyqklx + ',' + kyqkData[i].tbrbh + ',' + kyqkData[i].tbrxm + ',' + kyqkData[i].ydxxms + ',' + kyqkData[i].clzt + ',' + kyqkData[i].tbsj + '");\' data-toggle="modal" data-target="#myModal1">' + kyqkData[i].hylb + ':' + kyqkData[i].qymc + kyqkData[i].kyqklx + '</a><br/>'
                );
            }
            var data = countNum.xctgs;
            for (var i = 0; i < data.length; i++) {
                $("#xctgMsg").append(
                    '<a class="title"  onclick=\'detile("' + data[i].fbr + ',' + data[i].fbsj + ',' + data[i].fbdw + ',' + data[i].bt + ',' + data[i].fbnr + '");\' data-toggle="modal" data-target="#myModal">' + data[i].bt + ':' + data[i].fbnr + '</a><br/>'



                    // "<a href='' class='title' onclick='openModal(`${}`)' style='display: block' data-toggle=\"modal\" data-target=\"#myModal\">
                    // <li style='overflow: hidden;white-space: nowrap;text-overflow: ellipsis;'>" +
                    //   countNum.xctgs[i].sxhylbmc +
                    //   ">" +
                    //   countNum.xctgs[i].bt +
                    //   ">" +
                    //   countNum.xctgs[i].fbnr +
                    //   "</li></a>"
                );
            }


            var myChartbar = echarts.init(document.getElementById("bar"));
            var optionbar = {
                title: {
                    text: "各行业业务数量情况",
                    x: "left"
                },
                tooltip: {
                    trigger: "axis",
                    axisPointer: {
                        // 坐标轴指示器，坐标轴触发有效
                        type: "shadow" // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                legend: {
                    data: ["总量", "今日新增"]
                },
                grid: {
                    left: "3%",
                    right: "4%",
                    bottom: "3%",
                    containLabel: true
                },
                yAxis: {
                    type: "value"
                },
                xAxis: {
                    type: "category",
                    data: [
                        "印章行业",
                        "开锁行业",
                        "典当行业",
                        "旧手机行业",
                        "废旧金属行业",
                        "机修行业",
                        "汽车租赁行业",
                        "旅游行业"
                    ]
                },
                series: [
                    {
                        itemStyle: {normal: {color: "#2ec7c9"}},
                        name: "总量",
                        type: "bar",
                        stack: "1",

                        label: {
                            normal: {
                                show: true,
                                position: "insideRight"
                            }
                        },
                        data: [
                            countNum.countSeal,
                            countNum.countLock,
                            120,
                            100,
                            99,
                            89,
                            75,
                            65
                        ]
                    },
                    {
                        itemStyle: {normal: {color: "rgb(237,125,49)"}},
                        name: "今日新增",
                        type: "bar",
                        stack: "1",
                        label: {
                            normal: {
                                show: true
                                // position: 'insideRight',
                                // formatter: function (params) {
                                //     for (var i = 0, l = optionbar.xAxis.data.length; i < l; i++) {
                                //         if (optionbar.xAxis.data[i] == params.name) {
                                //             return optionbar.series[0].data[i] + params.value;
                                //         }
                                //     }
                                // }
                            }
                        },
                        barWidth: "50%",
                        data: [/*countNum.countSealByDay*/ 20, 9, 20, 15, 9, 18, 26, 19]
                    }
                ]
            };
            myChartbar.setOption(optionbar);
            var myChartpie1 = echarts.init(document.getElementById("pie1"));
            optionpie1 = {
                title: {
                    text: "行业企业数量占比",
                    x: "center"
                },
                color: [
                    "#32dadd",
                    "#b6a2de",
                    "#5ab1ef",
                    "#ffb980",
                    "#32da96",
                    "#d87a80",
                    "#8d98b3",
                    "#e5cf0d"
                ],
                tooltip: {
                    trigger: "item",
                    formatter: "{a} <br/>{b}: {c} ({d}%)"
                },
                legend: {
                    orient: "vertical",
                    x: "left",
                    data: [
                        "印章",
                        "开锁",
                        "典当",
                        "旧手机",
                        "废旧金属",
                        "机修",
                        "汽车租赁",
                        "旅游"
                    ]
                },
                series: [
                    {
                        name: "访问来源",
                        type: "pie",
                        radius: ["40%", "65%"],
                        avoidLabelOverlap: false,
                        label: {
                            normal: {
                                show: false,
                                position: "center"
                            },
                            emphasis: {
                                show: true,
                                textStyle: {
                                    fontSize: "25",
                                    fontWeight: "bold"
                                }
                            }
                        },
                        labelLine: {
                            normal: {
                                show: false
                            }
                        },
                        data: [
                            {value: countNum.countSealCompany, name: "印章"},
                            {value: countNum.countLockCompany, name: "开锁"},
                            {value: 100, name: "典当"},
                            {value: 100, name: "旧手机"},
                            {value: 200, name: "废旧金属"},
                            {value: 120, name: "机修"},
                            {value: 150, name: "汽车租赁"},
                            {value: 190, name: "旅游"}
                        ]
                    }
                ]
            };
            myChartpie1.setOption(optionpie1);
            var myChartpie2 = echarts.init(document.getElementById("pie2"));
            optionpie2 = {
                title: {
                    text: "各行业从业人员占比",
                    x: "center"
                },
                color: [
                    "#32dadd",
                    "#b6a2de",
                    "#5ab1ef",
                    "#ffb980",
                    "#32da96",
                    "#d87a80",
                    "#8d98b3",
                    "#e5cf0d"
                ],
                tooltip: {
                    trigger: "item",
                    formatter: "{a} <br/>{b}: {c} ({d}%)"
                },
                legend: {
                    orient: "vertical",
                    x: "left",
                    data: [
                        "印章",
                        "开锁",
                        "典当",
                        "旧手机",
                        "废旧金属",
                        "机修",
                        "汽车租赁",
                        "旅游"
                    ]
                },
                series: [
                    {
                        name: "",
                        type: "pie",
                        radius: ["40%", "65%"],
                        avoidLabelOverlap: false,
                        label: {
                            normal: {
                                show: false,
                                position: "center"
                            },
                            emphasis: {
                                show: true,
                                textStyle: {
                                    fontSize: "25",
                                    fontWeight: "bold"
                                }
                            }
                        },
                        labelLine: {
                            normal: {
                                show: false
                            }
                        },
                        data: [
                            {value: countNum.countSealCompanyStaff, name: "印章"},
                            {value: countNum.countLockCompanyStaff, name: "开锁"},
                            {value: 100, name: "典当"},
                            {value: 300, name: "旧手机"},
                            {value: 150, name: "废旧金属"},
                            {value: 80, name: "机修"},
                            {value: 100, name: "汽车租赁"},
                            {value: 100, name: "旅游"}
                        ]
                    }
                ]
            };
            myChartpie2.setOption(optionpie2);
            window.onresize = function () {
                myChartpie2.resize();
                myChartbar.resize();
                myChartpie2.resize();
            };
            return returnData;
        },
        error: function (data) {
            dangerMsg(data);
        }
    });
});

/**
 * 成功提示信息
 * @param data 信息
 * @returns
 */
function successMsg(data) {
    $.smkAlert({
        text: data,
        type: "success",
        position: "top-center",
        time: 2
    });
}

/**
 * 警告提示信息
 * @param data 信息
 * @returns
 */
function warnningMsg(data) {
    $.smkAlert({
        text: data,
        type: "warning",
        position: "top-center",
        time: 2
    });
}

/**
 * 错误提示信息
 * @param data 信息
 * @returns
 */
function dangerMsg(data) {
    $.smkAlert({
        text: data,
        type: "danger",
        position: "top-center",
        time: 2
    });
}

/**
 * 正常提示信息
 * @param data 信息
 * @returns
 */
function infoMsg(data) {
    $.smkAlert({
        text: data,
        type: "info",
        position: "top-center",
        time: 2
    });
}
