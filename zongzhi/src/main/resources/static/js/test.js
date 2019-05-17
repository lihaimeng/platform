window.onload = function () {


    function test() {
        var httpip = 'http://192.168.0.202:8080/zongzhi';
        $.ajax({
            url: "/index/countMsg",
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
                    xctgsList += "<li>" + "<span>" + item.bt + ":" + "</span>" + item.fbr + "发布的协查通告" + "</li>";

                });
                //可以情况信息
                kyqkArr.forEach(function (item, index) {
                    kyqkLists += "<li>" + "<span>" + item.kyqklx + ":" + "</span>" + item.ydxxms + "</li>"
                });
                notice.html(xctgsList);
                notice_kyqk.html(kyqkLists);

                //图表数据处理
                var companyPieEacherArr = [];
                companyPieEacherArr.push(data.countLockCompany, data.countLockCompany);

                var myChart = echarts.init(document.getElementById("main"));
                var myChart1 = echarts.init(document.getElementById("main1"));
                // 单位
                var option = {
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
                        show: false,
                        //说明文字的位置
                        data: ["印章", "开锁", "典当", "旧手机", "废旧金属", "机修", "汽车租赁", "旅游"],
                        // x: "right",
                        orient: "horizontal",
                        y: "bottom"
                    },

                    series: [
                        {
                            name: "销量",
                            type: "pie",
                            radius: "80%",
                            data: companyPieEacherArr,
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
                staffPieEchartArr.push(data.countLockCompanyStaff, data.countLockCompanyStaff);
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
                        show: false,
                        //说明文字的位置
                        data: ["印章", "开锁", "典当", "旧手机", "废旧金属", "机修", "汽车租赁", "旅游"],
                        // x: "right",
                        orient: "horizontal",
                        y: "bottom"
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
            },
            error: function (err) {
                console.log(err)

            }
        });


        // var myChart = echarts.init(document.getElementById("main"));
        // var myChart1 = echarts.init(document.getElementById("main1"));
        var myChart3 = echarts.init(document.getElementById("main3"));
        //
        // var option = {
        //     tooltip: {
        //         show: true,
        //         text: "qiye"
        //     },
        //     color: [
        //         "#cd0400",
        //         "#f38f00",
        //         "#f1e000",
        //         "#5dc800",
        //         "#4ce8de",
        //         "#126ae4",
        //         "#9b40d8",
        //         "#8b531b"
        //     ],
        //     legend: {
        //         show : false,
        //         //说明文字的位置
        //         data: ["印章","开锁","典当","旧手机","废旧金属","机修","汽车租赁","旅游"],
        //         // x: "right",
        //         orient: "horizontal",
        //         y: "bottom"
        //     },
        //
        //     series: [
        //         {
        //             name: "销量",
        //             type: "pie",
        //             radius: "80%",
        //             data: [
        //                 { value: 200,name:"印章" },
        //                 { value: 300, name:"开锁" },
        //                 { value: 500, name:"典当" },
        //                 { value: 400, name:"旧手机" },
        //                 { value: 100, name:"废旧金属" },
        //                 { value: 700, name:"机修" },
        //                 { value: 560, name:"汽车租赁" },
        //                 { value: 600,name:"旅游" }
        //             ],
        //             label: {
        //                 normal: {
        //                     formatter: '   {per|{d}%}  ',
        //                     // backgroundColor: '#eee',
        //                     // borderColor: '#aaa',
        //                     borderWidth: 1,
        //                     borderRadius: 4,
        //                     // shadowBlur:3,
        //                     // shadowOffsetX: 2,
        //                     // shadowOffsetY: 2,
        //                     // shadowColor: '#999',
        //                     // padding: [0, 7],
        //                     rich: {
        //                         // a: {
        //                         //     color: '#999',
        //                         //     lineHeight: 20,
        //                         //     align: 'center'
        //                         // },
        //                         abg: {
        //                             backgroundColor: '#333',
        //                             width: '100%',
        //                             align: 'right',
        //                             height: 22,
        //                             borderRadius: [4, 4, 0, 0]
        //                         },
        //                         hr: {
        //                             borderColor: '#aaa',
        //                             width: '100%',
        //                             borderWidth: 0.5,
        //                             height: 0
        //                         },
        //                         b: {
        //                             fontSize: 16,
        //                             lineHeight: 33
        //                         },
        //                         per: {
        //                             color: '#eee',
        //                             backgroundColor: '#334455',
        //                             padding: [2, 2],
        //                             borderRadius: 2
        //                         }
        //                     }
        //                 }
        //             }
        //         }
        //     ]
        // };
        //
        //
        //
        //
        //
        //
        //
        //
        // var option1 = {
        //     tooltip: {
        //         show: true,
        //         text: "qiye"
        //     },
        //
        //     color: [
        //         "#cd0400",
        //         "#f38f00",
        //         "#f1e000",
        //         "#5dc800",
        //         "#4ce8de",
        //         "#126ae4",
        //         "#9b40d8",
        //         "#8b531b"
        //     ],
        //
        //     legend: {
        //         show : false,
        //         //说明文字的位置
        //         data: ["印章","开锁","典当","旧手机","废旧金属","机修","汽车租赁","旅游"],
        //         // x: "right",
        //         orient: "horizontal",
        //         y: "bottom"
        //     },
        //     series: [
        //         {
        //             center: ["50%", "50%"], //位置
        //             name: "销量",
        //             type: "pie",
        //
        //             radius: "80%", //大小
        //             data: [
        //                 { value: 50 , name:"印章"},
        //                 { value: 300 , name:"开锁"},
        //                 { value: 500 , name:"典当"},
        //                 { value: 400 , name:"旧手机"},
        //                 { value: 100 , name:"废旧金属"},
        //                 { value: 300 , name:"机修"},
        //                 { value: 560 , name:"汽车租赁"},
        //                 { value: 600, name:"旅游" }
        //             ],
        //             label: {
        //                 normal: {
        //                     formatter: '{per|{d}%}  ',
        //                     // backgroundColor: '#eee',
        //                     // borderColor: '#aaa',
        //                     borderWidth: 1,
        //                     borderRadius: 4,
        //                     // shadowBlur:3,
        //                     // shadowOffsetX: 2,
        //                     // shadowOffsetY: 2,
        //                     // shadowColor: '#999',
        //                     // padding: [0, 7],
        //                     rich: {
        //                         a: {
        //                             color: '#999',
        //                             lineHeight: 20,
        //                             align: 'center'
        //                         },
        //                         abg: {
        //                             backgroundColor: '#333',
        //                             width: '100%',
        //                             align: 'right',
        //                             height: 22,
        //                             borderRadius: [4, 4, 0, 0]
        //                         },
        //                         hr: {
        //                             borderColor: '#aaa',
        //                             width: '100%',
        //                             borderWidth: 0.5,
        //                             height: 0
        //                         },
        //                         b: {
        //                             fontSize: 16,
        //                             lineHeight: 33
        //                         },
        //                         per: {
        //                             color: '#eee',
        //                             backgroundColor: '#334455',
        //                             padding: [2, 2],
        //                             borderRadius: 2
        //                         }
        //                     }
        //                 }
        //             }
        //         }
        //     ]
        //
        // };
        // 柱状图
        var labelOption = {
            normal: {
                show: true,
                // position: app.config.position,
                // distance: app.config.distance,
                // align: app.config.align,
                // verticalAlign: app.config.verticalAlign,
                // rotate: app.config.rotate,
                // formatter: '{c}  {name|{a}}',

                fontSize: 15,
                rich: {
                    name: {
                        textBorderColor: "#1a1a1a"
                    }
                }
            }
        };
        var option3 = {
            tooltip: {
                show: true
            },
            color: ["#308afc", "#ffcf4d"],
            legend: {
                //说明文字的位置
                data: ["总量", "今日新增"],
                x: "right",
                orient: "vertical",
                y: "top",
                width: 150,
                top: 300
            },
            xAxis: [
                {
                    align: "left",
                    type: "category",
                    data: [
                        "印章",
                        "开锁",
                        "典当",
                        "旧手机",
                        "废旧金属",
                        "机修",
                        "汽车租赁",
                        "旅游"
                    ],
                    axisTick: {
                        inside: true,
                        axisLabel: true
                    }
                }
            ],
            yAxis: [
                {
                    name: "今日新增",
                    nameLocation: "end",
                    type: "value",
                    data: [
                        "0",
                        "500",
                        "1000",
                        "1500",
                        "2000",
                        "2500",
                        "3000",
                        "3500",
                        "4000"
                    ],
                    max: "4000",
                    minInterval: 1,
                    silent: false,
                    axisLine: {
                        show: false
                    }
                }
            ],
            series: [
                {
                    // name: "总量",
                    label: labelOption,
                    type: "bar",
                    stack: "two",
                    barWidth: "75", //柱状图宽度
                    data: [
                        {value: 2000},
                        {value: 3000},
                        {value: 2400},
                        {value: 4000},
                        {value: 100},
                        {value: 700},
                        {value: 560},
                        {value: 600}
                    ]
                },
                {
                    // name: "今日新增",
                    label: labelOption,
                    barWidth: "60%",
                    stack: "two", //柱状图叠加效果
                    type: "bar",
                    data: [
                        {value: 100},
                        {value: 200},
                        {value: 400},
                        {value: 300},
                        {value: 600},
                        {value: 50},
                        {value: 70},
                        {value: 200}
                    ]
                }
            ]
        };
        // 为echarts对象加载数据

        // myChart1.setOption(option1);
        myChart3.setOption(option3);

    }

    test();
};




