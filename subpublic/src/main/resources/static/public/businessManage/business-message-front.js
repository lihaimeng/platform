$(function () {
    //查询企业信息
    $.ajax({
        url: '../../qyjbxx/selectByQYBM',
        type: 'POST',
        success: function (data) {
            var qyjbxx = data;
            //console.log(qyjbxx);

            $("#hylb").html(qyjbxx.hylb);//企业类别
            $("#gxdwmc").html(qyjbxx.gxdwmc);//管辖单位
            $("#qybm").html(qyjbxx.qybm); //企业编号
            $("#qymc").html(qyjbxx.qymc); //企业名称
            $("#yyzzbh").html(qyjbxx.yyzzbh); //营业执照编号
            $("#frdb").html(qyjbxx.frdb); //法人姓名
            $("#frdbzjhm").html(qyjbxx.frdbzjhm);//法人证件号
            $("#lxdh").html(qyjbxx.lxdh);//单位联系方式
            $("#jydz").html(qyjbxx.jydz);//单位地址
            $("#jyfwzy").html(qyjbxx.jyfwzy);//经营范围

        }
    });
});