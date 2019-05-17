window.onload = function () {
    $(function () {
        $.ajax({

            url: '../echart1/getCountsOfGxqy',
            contentType: 'application/json;charset=UTF-8',
            type: 'GET',
            data: {"maps": 1},
            success: function (data) {
                // console.log(data)
                var barDyValueArr = [];
                var barDyName = [];
                for (var prop in data) {

                    barDyName.push(prop);
                    barDyValueArr.push(data[prop])
                }
                // console.log(barDyName);
                // 区域统计数量
                var echarts_bar = echarts.init(document.getElementById('echarts-bar-chart'));
                var echartBarOption = {
                    color: ['#3398DB'],
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                        }
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
                            data: barDyName,
                            axisTick: {
                                alignWithLabel: true
                            }
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value',
                            max: 10,
                        }
                    ],
                    series: [
                        {
                            name: '',
                            type: 'bar',
                            barWidth: '60%',
                            data: barDyValueArr
                        }
                    ]
                };
                echarts_bar.setOption(echartBarOption)
            },
            error: function (data) {
            }
        });
    }());


    $(function () {
        $.ajax({

            url: '/echart1/getCountsOfWtr',
            contentType: 'application/json;charset=UTF-8',
            type: 'GET',
            data: {"maps": 1},
            success: function (data) {
                // console.log(data)
                var pieDyValueArr = [];
                var pieDyName = [];
                for (var prop in data) {
                    pieDyName.push(prop);
                    pieDyValueArr.push(data[prop])
                }
                //
                var echartsPieSeal = echarts.init(document.getElementById('pie-chart'));
                var echartsSeal = {
                    title: {
                        text: '区域统计印章业务数量',

                        x: 'center'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'tight',
                        data: pieDyName
                    },
                    series: [
                        {
                            name: '',
                            type: 'pie',
                            radius: '55%',
                            center: ['50%', '60%'],
                            data: pieDyValueArr,
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };
                echartsPieSeal.setOption(echartsSeal)
            },
            error: function (data) {
            }
        });
    }());


    $(function () {
        $.ajax({

            url: '/echart1/getCountsOfkslx',
            contentType: 'application/json;charset=UTF-8',
            type: 'GET',
            data: {"maps": 1},
            success: function (data) {
                // console.log(data)
                var unlockPieDyName = [];
                var unlockPieDyValueArr = [];
                for (var prop in data) {

                    unlockPieDyName.push(prop);
                    unlockPieDyValueArr.push(data[prop])
                }
                // 区域统计数量
                var unlockTypePie = echarts.init(document.getElementById('pie-chart1'));

                var unlockypePieOption = {
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b}: {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        x: 'left',
                        data: unlockPieDyName
                    },
                    series: [
                        {
                            name: '',
                            type: 'pie',
                            radius: ['50%', '70%'],
                            avoidLabelOverlap: false,
                            label: {
                                normal: {
                                    show: false,
                                    position: 'center'
                                },
                                emphasis: {
                                    show: true,
                                    textStyle: {
                                        fontSize: '30',
                                        fontWeight: 'bold'
                                    }
                                }
                            },
                            labelLine: {
                                normal: {
                                    show: false
                                }
                            },
                            data: unlockPieDyValueArr
                        }
                    ]
                };
                unlockTypePie.setOption(unlockypePieOption)
            },
            error: function (data) {
            }
        });
    }());


    // $(function () {
    //     $.ajax({
    //
    //         url: '../echart1/getCountsOfGxqy',
    //         contentType:'application/json;charset=UTF-8',
    //         type: 'GET',
    //         data:{"maps":1},
    //         success:function(data){
    //             console.log(data)
    //             var barDyValueArr = [];
    //             var barDyName = [];
    //             for (var prop in data){
    //
    //                 barDyName.push(prop);
    //                 barDyValueArr.push(data[prop])
    //             }
    //             console.log(barDyName);
    //             // 区域统计数量
    //             var echarts_bar = echarts.init(document.getElementById('echarts-bar-chart'));
    //             var echartBarOption={
    //                 color: ['#3398DB'],
    //                 tooltip : {
    //                     trigger: 'axis',
    //                     axisPointer : {            // 坐标轴指示器，坐标轴触发有效
    //                         type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
    //                     }
    //                 },
    //                 grid: {
    //                     left: '3%',
    //                     right: '4%',
    //                     bottom: '3%',
    //                     containLabel: true
    //                 },
    //                 xAxis : [
    //                     {
    //                         type : 'category',
    //                         data : barDyName,
    //                         axisTick: {
    //                             alignWithLabel: true
    //                         }
    //                     }
    //                 ],
    //                 yAxis : [
    //                     {
    //                         type : 'value',
    //                         max:10,
    //                     }
    //                 ],
    //                 series : [
    //                     {
    //                         name:'',
    //                         type:'bar',
    //                         barWidth: '60%',
    //                         data:barDyValueArr
    //                     }
    //                 ]
    //             }
    //             echarts_bar.setOption(echartBarOption)
    //         },
    //         error:function(data){
    //         }
    //     });
    // }())


    var lineEchart = echarts.init(document.getElementById('echarts_line'));
    var lineOption = {
        title: {
            text: 'Beijing AQI'
        },
        tooltip: {
            trigger: 'axis'
        },
        xAxis: {
            data: []
        },
        yAxis: {
            splitLine: {
                show: false
            }
        },
        toolbox: {
            left: 'center',
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                restore: {},
                saveAsImage: {}
            }
        },
        dataZoom: [{
            startValue: '2017-06-01'
        }, {
            type: 'inside'
        }],
        visualMap: {
            top: 10,
            right: 10,
            pieces: [],
            outOfRange: {
                color: '#999'
            }
        },
        series: {
            name: '折线图',
            type: 'line',
            data: [{value: 100}, {value: 100}, {value: 100}, {value: 100}, {value: 100}, {value: 100}, {value: 100}, {value: 100}, {value: 100}, {value: 100}],
            markLine: {
                silent: true,
                data: [{
                    yAxis: 50
                }, {
                    yAxis: 100
                }, {
                    yAxis: 150
                }, {
                    yAxis: 200
                }, {
                    yAxis: 300
                }]
            }
        }
    };
    lineEchart.setOption(lineOption);

};