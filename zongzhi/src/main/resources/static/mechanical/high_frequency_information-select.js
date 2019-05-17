$(function () {
    $('input[name="myCheckbox"]').click(function () {
        var myCheckboxLength = $('input[name="myCheckbox"]').length;
        var myCheckboxs = $('input[name="myCheckbox"]');
        var obj = this;
        if (obj.checked) {
            var objID = obj.id;
            for (var i = 0; i < myCheckboxLength; i++) {
                if (objID != myCheckboxs[i].id) {
                    var unid = myCheckboxs[i].id;
                    $("#" + unid).attr("checked", false);
                }
            }
        }
    });
    $('#exampleTableEvents').bootstrapTable({
        url: "../js/pageJs/mechanical/high_frequency_information-select.json",
        pagination: true,                         //设置为 true 会在表格底部显示分页条
        pageSize: 15,								//如果设置了分页，页面数据条数
        pageList: [15, 30],				//如果设置了分页，设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录。
        toolbar: '#exampleTableEventsToolbar'		//一个jQuery 选择器，指明自定义的toolbar 例如:#toolbar, .toolbar. 
    });
});
	
