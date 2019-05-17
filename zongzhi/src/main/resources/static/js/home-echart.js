window.onload = function () {
    function getEchartData() {
        $.ajax({
            url: "index/countMsg",
            type: "GET",
            contentType: 'application/json;charset=UTF-8',
            success: function (data) {
                console.log(data);
                var xctgsArr = [], kyqkArr = [];
                $('.zagl').html(data.roleName);
                $('.bm-name').html(data.organizationName);
                $('.xzqy').text(data.organizationParentName);
                //协查通告数据
                xctgsArr = data.xctgs;
                //可以情况数据
                kyqkArr = data.kyqk;
                var notice = $('.notice_info .lists_item ').html("");
                var notice_kyqk = $('.kyqk-notice ul').html("");
                var xctgsList = "";
                var kyqkLists = "";
                // 协查通告信息
                xctgsArr.forEach(function (item, index) {
                    xctgsList += "<li>" + "<a href=''>" + "<span>" + item.bt + ":" + "</span>" + item.fbr + "发布的协查通告" + "</a>" + "</li>";

                });
                //可以情况信息
                kyqkArr.forEach(function (item, index) {
                    kyqkLists += "<li>" + "<a>" + "<span>" + item.kyqklx + ":" + "</span>" + item.ydxxms + "</a>" + "</li>"
                });
                notice.html(xctgsList);
                notice_kyqk.html(kyqkLists);

                //图表数据处理
                var companyPieEacherArr;
                // companyPieEacherArr = "{"+"value:" +data.countLockCompany+"," +"name:" + "'锁业'" + "}" +","+ "{"+"value:" +data.countSealCompany+"," +"name:" + "'印章'" + "}" ;

                // companyPieEacherArr = "["+companyPieEacherArr.join(',')+"]";
                var companyPieValue = [];
                companyPieValue.push(data.countLockCompany, data.countSealCompany);
                // "["+companyPieEacherArr.join(',')+"]";
                console.log(companyPieValue);


                var myChart = echarts.init(document.getElementById("main"));
                var myChart1 = echarts.init(document.getElementById("main1"));
                // 单位
                var option = {
                    tooltip: {
                        show: true,
                        text: "企业"
                    },
                    color: [
                        "#cd0400",
                        "#f38f00",
                        "#f1e000",
                        "#5dc800",
                        "#4ce8de",
                        "#126ae4",
                        "#9b40d8",
                        "#8b531b"
                    ],
                    legend: {
                        show: false,
                        //说明文字的位置
                        data: ["印章", "开锁", "典当", "旧手机", "废旧金属", "机修", "汽车租赁", "旅游"],
                        x: "right",
                        orient: "vertical",
                        y: "bottom"
                    },

                    series: [
                        {
                            name: "销量",
                            type: "pie",
                            radius: "80%",
                            data: companyPieValue,

                            label: {
                                normal: {
                                    formatter: '   {per|{d}%}  ',
                                    borderWidth: 1,
                                    borderRadius: 4,
                                    rich: {
                                        abg: {
                                            backgroundColor: '#333',
                                            width: '100%',
                                            align: 'right',
                                            height: 22,
                                            borderRadius: [4, 4, 0, 0]
                                        },
                                        hr: {
                                            borderColor: '#aaa',
                                            width: '100%',
                                            borderWidth: 0.5,
                                            height: 0
                                        },
                                        b: {
                                            fontSize: 16,
                                            lineHeight: 33
                                        },
                                        per: {
                                            color: '#eee',
                                            backgroundColor: '#334455',
                                            padding: [2, 2],
                                            borderRadius: 2
                                        }
                                    }
                                }
                            }
                        }
                    ]
                };
                myChart.setOption(option);

                // 人员

                var staffPieEchartArr = [];
                staffPieEchartArr.push(data.countLockCompanyStaff, data.countSealCompanyStaff);
                var option1 = {
                    tooltip: {
                        show: true,
                        text: "qiye"
                    },

                    color: [
                        "#cd0400",
                        "#f38f00",
                        "#f1e000",
                        "#5dc800",
                        "#4ce8de",
                        "#126ae4",
                        "#9b40d8",
                        "#8b531b"
                    ],

                    legend: {
                        show: true,
                        //说明文字的位置
                        data: ["印章", "开锁", "典当", "旧手机", "废旧金属", "机修", "汽车租赁", "旅游"],
                        // x: "right",
                        // orient: "horizontal",
                        // y: "bottom"
                    },
                    series: [
                        {
                            center: ["50%", "50%"], //位置
                            name: "销量",
                            type: "pie",

                            radius: "80%", //大小
                            data: staffPieEchartArr,
                            label: {
                                normal: {
                                    formatter: '{per|{d}%}  ',
                                    borderWidth: 1,
                                    borderRadius: 4,
                                    rich: {
                                        a: {
                                            color: '#999',
                                            lineHeight: 20,
                                            align: 'center'
                                        },
                                        abg: {
                                            backgroundColor: '#333',
                                            width: '100%',
                                            align: 'right',
                                            height: 22,
                                            borderRadius: [4, 4, 0, 0]
                                        },
                                        hr: {
                                            borderColor: '#aaa',
                                            width: '100%',
                                            borderWidth: 0.5,
                                            height: 0
                                        },
                                        b: {
                                            fontSize: 16,
                                            lineHeight: 33
                                        },
                                        per: {
                                            color: '#eee',
                                            backgroundColor: '#334455',
                                            padding: [2, 2],
                                            borderRadius: 2
                                        }
                                    }
                                }
                            }
                        }
                    ]

                };
                myChart1.setOption(option1);


                var sumValue = [];
                sumValue.push(data.countLockCompany + data.countSealCompany, data.countLockCompanyStaff + data.countSealCompanyStaff);

                var myChart3 = echarts.init(document.getElementById("main3"));

                // 柱状图
                // 为echarts对象加载数据

                var option3 = {
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                        }
                    },
                    color: ['#308afc'],
                    legend: {
                        data: ['锁业', '印章']
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    xAxis: [
                        {
                            type: 'category',
                            data: ['锁业', '印章'],

                        }
                    ],
                    yAxis: [
                        {
                            type: 'value'
                        }
                    ],
                    series: [
                        {
                            name: '',
                            type: 'bar',
                            data: sumValue,
                            barWidth: '55px'
                        }
                    ]
                };
                myChart3.setOption(option3);


            },
            error: function (err) {
                console.log(err)

            }
        })


    }

    getEchartData();
};




