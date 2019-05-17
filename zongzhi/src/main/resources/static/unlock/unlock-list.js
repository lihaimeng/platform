(function () {
    /**********************
     *开锁信息列表
     **********************/
    $('#exampleTableEvents').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded",//一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
        url: "http://hnadmin.suodun.xin/zong",//要请求数据的文件路径
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination: true,//是否分页
        //   queryParams: queryParams,//请求服务器时所传的参数
        sidePagination: 'client',//指定服务器端分页
        singleSelect: true,
        pageSize: 15,//单页记录数
        pageList: [15, 30],//分页步进值
        clickToSelect: true,    //是否启用点击选中行
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
            },
            {
                field: 'truename',
                title: '开锁人姓名',
                align: 'center'
            },
            {
                field: 'phone',
                title: '开锁人联系电话',
                align: 'center',
                visible: false
            },
            {
                field: 'lockidcard',
                title: '开锁人身份证号',
                align: 'center',
                visible: false
            },
            {
                field: 'name',
                title: '委托人姓名',
                align: 'center'
            },
            {
                field: 'mobilephone',
                title: '委托人联系电话',
                align: 'center',
                visible: false
            },
            {
                field: 'idcard',
                title: '委托人身份证号',
                align: 'center',
            },
            {
                field: 'address',
                title: '开锁地址',
                align: 'center'
            },
            /**   {
                field: 'ksjgmc',
                title: '企业名称',
                align: 'center',
                visible: false
            },
             **/
            {
                field: 'pid',
                title: '开锁类型',
                align: 'center',
                visible: false,
                formatter: function (value, row, index) {
                    if (value == "0") {
                        value = '换锁';
                    } else {
                        value = '开锁'
                    }
                    var remark = value;
                    return remark;
                }
            },
            {
                field: 'lockaddress',
                title: '开锁机构地址',
                align: 'center',
                visible: false
            },
            /**
             {
                 field: 'name',
                 title: '管辖单位',
                 align: 'center',
                 visible: false
             },
             **/
            {
                field: 'time',
                title: '开锁时间',
                align: 'center'
            },
            /**{
                field: 'hjdz',
                title: '户籍地址',
                align: 'center',
                visible: false
            },
             **/
            {
                field: 'price',
                title: '费用',
                align: 'center',
                visible: false
            }
        ]
    });

})();


$('#search').click(function () {
    var name = $("#bksrxm").val().trim();
    var truename = $("#ksrxm").val().trim();
    var beginDate = $("#unlockedBeginTime").val().trim();
    var endDate = $("#unlockedEndTime").val().trim();

    if (Date.parse(endDate) < Date.parse(beginDate)) {
        warnningMsg("结束时间必须大于开始时间！");
        return false;
    }

    $('#exampleTableEvents').bootstrapTable('destroy');
    $('#exampleTableEvents').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded",//一种编码。好像在post请求的时候需要用到。这里用的get请求，注释掉这句话也能拿到数据
        url: "http://hnadmin.suodun.xin/zong/admin",//要请求数据的文件路径
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination: true,//是否分页
        queryParams: queryParams,//请求服务器时所传的参数
        sidePagination: 'client',//指定服务器端分页
        singleSelect: true,
        pageSize: 15,//单页记录数
        pageList: [15, 30],//分页步进值
        clickToSelect: true,    //是否启用点击选中行
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
            },
            {
                field: 'truename',
                title: '开锁人姓名',
                align: 'center'
            },
            {
                field: 'phone',
                title: '开锁人联系电话',
                align: 'center',
                visible: false
            },
            {
                field: 'lockidcard',
                title: '开锁人身份证号',
                align: 'center',
                visible: false
            },
            {
                field: 'name',
                title: '委托人姓名',
                align: 'center'
            },
            {
                field: 'mobilephone',
                title: '委托人联系电话',
                align: 'center',
                visible: false
            },
            {
                field: 'idcard',
                title: '委托人身份证号',
                align: 'center',
            },
            {
                field: 'address',
                title: '开锁地址',
                align: 'center'
            },
            /**   {
                field: 'ksjgmc',
                title: '企业名称',
                align: 'center',
                visible: false
            },
             **/
            {
                field: 'pid',
                title: '开锁类型',
                align: 'center',
                visible: false,
                formatter: function (value, row, index) {
                    if (value == "0") {
                        value = '换锁';
                    } else {
                        value = '开锁'
                    }
                    var remark = value;
                    return remark;
                }
            },
            {
                field: 'lockaddress',
                title: '开锁机构地址',
                align: 'center',
                visible: false
            },
            /**
             {
                 field: 'name',
                 title: '管辖单位',
                 align: 'center',
                 visible: false
             },
             **/
            {
                field: 'time',
                title: '开锁时间',
                align: 'center'

            },
            /**{
                field: 'hjdz',
                title: '户籍地址',
                align: 'center',
                visible: false
            },
             **/
            {
                field: 'price',
                title: '费用',
                align: 'center',
                visible: false
            }
        ]
    });
});


//锁匠用户查询方法

function queryParams(params) {
    var name = $("#bksrxm").val().trim();
    var truename = $("#ksrxm").val().trim();
    var beginDate = $("#unlockedBeginTime").val().trim();
    var endDate = $("#unlockedEndTime").val().trim();
    return {
        // pageSize: params.limit, //每一页的数据行数，默认是上面设置的10(pageSize)
        // pageIndex: params.offset / params.limit + 1, //当前页面,默认是上面设置的1(pageNumber)
        pageSize: 10,
        pageIndex: 20, //当前页面,默认是上面设置的1(pageNumber)
        truename: truename,
        name: name,
        endDate: endDate,
        beginDate: beginDate
    };
}

// console.log(queryParams());
/**********************
 *为详情弹出框赋值
 **********************/
$('#btn_detail').click(function () {
    var obj = $('#exampleTableEvents').bootstrapTable('getSelections')[0];
    if (typeof(obj) != 'undefined') {
        var dz = obj.lockaddress;
        var ksrxm = obj.truename;
        var ksrsfzh = obj.lockidcard;
        var ksrdh = obj.phone;
        //var ksjgmc = obj.ksjgmc;
        //var ksjgdz = obj.ksjgdz;
        var bksrxm = obj.name;
        var bksrdh = obj.mobilephone;
        var bksrsfzh = obj.idcard;
        //var kslx = obj.kslxmc;
        //var ksjgdz = obj.ksjgdz;
        var addtime = obj.addtime;
        var hjdz = obj.hjdz;
        var price = obj.price;
        $('#dz').html(dz);
        $('#ksrxmDetail').html(ksrxm);
        $('#ksrsfzhDetail').html(ksrsfzh);
        $('#ksrdh').html(ksrdh);
        //$('#ksjgmcxq').html(ksjgmc);
        $('#ksjgmcxq').html("昱鑫科技有限公司");
        //$('#ksjgdzxq').html(ksjgdz);
        $('#ksjgdzxq').html("西安市雁塔区电子一路");
        $('#bksrxmxq').html(bksrxm);
        $('#bksrdhxq').html(bksrdh);
        $('#bksrsfzhxq').html(bksrsfzh);
        //$('#kslxxq').html(kslx);
        $('#addtime').html(addtime);
        $('#hjdz').html(hjdz);
        $('#price').html(price);
        console.info(obj.handidphoto);
        if (obj.handidphoto != "") {
            $("#imageHandidphoto").attr("src", 'http://lounck.suodun.xin' + obj.handidphoto);
        } else {
            $("#imageHandidphoto").css('display', "none");
        }
        if (obj.leasecontract != "") {
            $("#imageLeasecontract").attr("src", 'http://lounck.suodun.xin' + obj.leasecontract);
        } else {
            $("#imageLeasecontract").css('display', "none");
        }
        if (obj.otherevidence != "") {
            $("#imageOtherevidence").attr("src", 'http://lounck.suodun.xin' + obj.otherevidence);
        } else {
            $("#imageOtherevidence").css('display', "none");
        }
        if (obj.propertycertificate != "") {
            $("#imagePropertycertificate").attr("src", 'http://lounck.suodun.xin' + obj.propertycertificate);
        } else {
            $("#imagePropertycertificate").css('display', "none");
        }
        if (obj.lockphoto != "") {
            $("#imageLockphoto").attr("src", 'http://lounck.suodun.xin' + obj.lockphoto);
        } else {
            $("#imageLockphoto").css('display', "none");
        }
        //图片的赋值
        /*  var form4pictureCore = new Array();
          function initForm4PictureCore(picAddr) {
              this.picAddr = picAddr;
          }
          var form5pictureCore = new Array();
          function initForm5PictureCore(picAddr) {
              this.picAddr = picAddr;
          }

          var objPic = obj   ;
          var subPicture ="123123"
          if( typeof(objPic.handidphoto) != 'undefined'){
              var handidP=objPic.handidphoto.split(',')
              for(var i = 0;i<handidP.length;i++){
                  form4pictureCore.push(new initForm5PictureCore(subPicture+handidP[i]));
              }
          }
          if(typeof(objPic.leasecontract) != 'undefined'){
              var  leasecontractpP=objPic.leasecontract.split(',')
              for(var i = 0;i<leasecontractpP.length;i++){
                  form4pictureCore.push(new initForm4PictureCore(subPicture+leasecontractpP[i]));
              }
          }
          if(typeof(objPic.lockphoto) != 'undefined'){
              var lockphotoP=objPic.lockphoto.split(',')
              for(var i = 0;i<lockphotoP.length;i++){
                  form5pictureCore.push(new initForm5PictureCore(subPicture+lockphotoP[i]));
              }
          }
          if(typeof(objPic.otherevidence) != 'undefined'){
              var otherevidenceP=objPic.otherevidence.split(',')
              for(var i = 0;i<otherevidenceP.length;i++){
                  form4pictureCore.push(new initForm4PictureCore(subPicture+otherevidenceP[i]));
              }
          }
          if(typeof(objPic.propertycertificate) != 'undefined'){
              var propertycertificateP=objPic.propertycertificate.split(',')
              for(var i = 0;i<propertycertificateP.length;i++){
                  form4pictureCore.push(new initForm4PictureCore(subPicture+propertycertificateP[i]));
              }
          }
          for(var i = 0;i<form4pictureCore.length;i++){
                      console.info(form4pictureCore[i])
          }*/
    } else {
        warnningMsg('请选择一条数据！');
        return false;
    }
});

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