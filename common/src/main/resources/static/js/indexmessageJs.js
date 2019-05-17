//生成bootstrapTable  
//bootstrapTable表格属性参考http://bootstrap-table.wenzhixin.net.cn/zh-cn/documentation/
(function () {
    $('#exampleTableEvents').bootstrapTable({
        url: "js/bootstrap_table_indexmessageJs.json",
        pagination: true,                         //设置为 true 会在表格底部显示分页条
        pageSize: 15,								//如果设置了分页，页面数据条数
        pageList: [15, 30, 45, 60],				//如果设置了分页，设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录。
        toolbar: '#exampleTableEventsToolbar'		//一个jQuery 选择器，指明自定义的toolbar 例如:#toolbar, .toolbar.
    });
})();
