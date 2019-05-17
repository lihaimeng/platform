$.ajax({
    url: '../../qyjbxx/selectByQYBM',
    type: 'POST',
    success: function (data) {
        var qyjbxx = data;

        var qyid = qyjbxx.qyid;
        console.log("企业id:" + qyid);

        $.ajax({
            url: '../../baryxx/selectByQyid',
            type: 'GET',
            dataType: "json",
            data: {"qyid": qyid},
            success: function (data) {
                getDataList(data);
            }
        });
        $.ajax({
            url: '../../bldsjksb/selectBldsjksb',
            type: 'GET',
            dataType: "json",
            data: {"qyid": qyid},
            success: function (data) {
                getDataList1(data);
            }
        });
        $.ajax({
            url: '../../jfsbxx/selectJfsbxx',
            type: 'GET',
            dataType: "json",
            data: {"qyid": qyid},
            success: function (data) {
                getDataList2(data);
            }
        });
    }
});


/**
 *获取安保人员表格数据
 */
function getDataList(data) {
    $('#securityTable').bootstrapTable('destroy');
    $('#securityTable').bootstrapTable({
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,
        pageSize: 15,								//如果设置了分页，页面数据条数
        pageList: [15, 30, 45, 60],				//如果设置了分页，设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录。
        clickToSelect: true,
        singleSelect: true,
        data: data,
        sortable: true,
        columns: [
            {
                field: 'qyxh',
                title: '序号',
                align: 'center',
                width: 20,
                formatter: function (value, row, index) {
                    return index + 1;
                }
            }, {
                field: 'xm',
                title: '姓名',
            }, {
                field: 'gmsfhm',
                title: '证件号',
            }, {
                field: 'hjdxz',
                title: '户籍所在地',

            }, {
                field: 'sgrq',
                title: '上岗日期',

            }, {
                field: 'balx',
                title: '保安类型',

            }
        ]
    });
}

/**
 *结束 获取安保人员表格数据
 */
/**
 *获取监控设备表格数据
 */
function getDataList1(data) {
    $('#monitoringTable').bootstrapTable('destroy');
    $('#monitoringTable').bootstrapTable({
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,
        pageSize: 15,								//如果设置了分页，页面数据条数
        pageList: [15, 30, 45, 60],				//如果设置了分页，设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录。
        clickToSelect: true,
        singleSelect: true,
        data: data,
        sortable: true,
        columns: [
            {
                field: 'qyxh',
                title: '序号',
                align: 'center',
                width: 20,
                formatter: function (value, row, index) {
                    return index + 1;
                }
            }, {
                field: 'sbmc',
                title: '设备名称',
            }, {
                field: 'sccsmc',
                title: '生产厂商',
            }, {
                field: 'ggxh',
                title: '规格型号',

            }, {
                field: 'sbjcjgmc',
                title: '检测机构名称',

            }, {
                field: 'wlcslxmc',
                title: '网络传输类型',

            }
        ]
    });
}

/**
 *结束 获取监控设备表格数据
 */
/**
 *获取技防设备表格数据
 */
function getDataList2(data) {
    $('#technicalTable').bootstrapTable('destroy');
    $('#technicalTable').bootstrapTable({
        pagination: true,//设置为 true 会在表格底部显示分页条
        pageNumber: 1,
        pageSize: 15,							//如果设置了分页，页面数据条数
        pageList: [15, 30, 45, 60],				//如果设置了分页，设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录。
        clickToSelect: true,
        singleSelect: true,
        data: data,
        sortable: true,
        columns: [
            {
                field: 'qyxh',
                title: '序号',
                align: 'center',
                width: 20,
                formatter: function (value, row, index) {
                    return index + 1;
                }
            }, {
                field: 'sbmc',
                title: '设备名称',
            }, {
                field: 'sccsmc',
                title: '生产厂商',
            }, {
                field: 'ggxh',
                title: '规格型号',

            }, {
                field: 'zl',
                title: '技防设备种类',

            }, {
                field: 'sl',
                title: '数量',

            }
        ]
    });
}

/**
 *结束 获取技防设备表格数据
 */