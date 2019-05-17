$(function () {
    $('#exampleTableEvents').bootstrapTable({
        url: "../js/pageJs/mechanical/mechanical-select.json",
        pagination: true,                         //设置为 true 会在表格底部显示分页条
        pageSize: 15,								//如果设置了分页，页面数据条数
        pageList: [15, 30],				//如果设置了分页，设置可供选择的页面数据条数。设置为 All 或者 Unlimited，则显示所有记录。
        toolbar: '#exampleTableEventsToolbar'		//一个jQuery 选择器，指明自定义的toolbar 例如:#toolbar, .toolbar. 
    });

    //为弹出框头部添加样式
    $('#btn_tabMsg1')[0].style.backgroundColor = '#1ab394';
    $("#tab2").css("display", 'none');
    $("#tab3").css("display", 'none');
    $("#tab4").css("display", 'none');
    $("#tab5").css("display", 'none');
    $("#tab6").css("display", 'none');
    console.log($('#btn_tabMsg1')[0].style.backgroundColor);
});

function changeMsg1() {
    $("#tab1").css("display", 'block');
    $("#tab2").css("display", 'none');
    $("#tab3").css("display", 'none');
    $("#tab4").css("display", 'none');
    $("#tab5").css("display", 'none');
    $("#tab6").css("display", 'none');
    $("#btn_tabMsg1").css("background-color", 'rgb(26, 179, 148)');
    $("#btn_tabMsg2").css("background-color", '');
    $("#btn_tabMsg3").css("background-color", '');
    $("#btn_tabMsg4").css("background-color", '');
    $("#btn_tabMsg5").css("background-color", '');
    $("#btn_tabMsg6").css("background-color", '');
}

function changeMsg2() {
    $("#tab2").css("display", 'block');
    $("#tab1").css("display", 'none');
    $("#tab3").css("display", 'none');
    $("#tab4").css("display", 'none');
    $("#tab5").css("display", 'none');
    $("#tab6").css("display", 'none');
    $("#btn_tabMsg2").css("background-color", 'rgb(26, 179, 148)');
    $("#btn_tabMsg1").css("background-color", '');
    $("#btn_tabMsg3").css("background-color", '');
    $("#btn_tabMsg4").css("background-color", '');
    $("#btn_tabMsg5").css("background-color", '');
    $("#btn_tabMsg6").css("background-color", '');
}

function changeMsg3() {
    $("#tab3").css("display", 'block');
    $("#tab1").css("display", 'none');
    $("#tab2").css("display", 'none');
    $("#tab4").css("display", 'none');
    $("#tab5").css("display", 'none');
    $("#tab6").css("display", 'none');
    $("#btn_tabMsg3").css("background-color", 'rgb(26, 179, 148)');
    $("#btn_tabMsg1").css("background-color", '');
    $("#btn_tabMsg2").css("background-color", '');
    $("#btn_tabMsg4").css("background-color", '');
    $("#btn_tabMsg5").css("background-color", '');
    $("#btn_tabMsg6").css("background-color", '');
}

function changeMsg4() {
    $("#tab4").css("display", 'block');
    $("#tab1").css("display", 'none');
    $("#tab2").css("display", 'none');
    $("#tab3").css("display", 'none');
    $("#tab5").css("display", 'none');
    $("#tab6").css("display", 'none');
    $("#btn_tabMsg4").css("background-color", 'rgb(26, 179, 148)');
    $("#btn_tabMsg1").css("background-color", '');
    $("#btn_tabMsg2").css("background-color", '');
    $("#btn_tabMsg3").css("background-color", '');
    $("#btn_tabMsg5").css("background-color", '');
    $("#btn_tabMsg6").css("background-color", '');
}

function changeMsg5() {
    $("#tab5").css("display", 'block');
    $("#tab1").css("display", 'none');
    $("#tab2").css("display", 'none');
    $("#tab3").css("display", 'none');
    $("#tab4").css("display", 'none');
    $("#tab6").css("display", 'none');
    $("#btn_tabMsg5").css("background-color", 'rgb(26, 179, 148)');
    $("#btn_tabMsg1").css("background-color", '');
    $("#btn_tabMsg2").css("background-color", '');
    $("#btn_tabMsg3").css("background-color", '');
    $("#btn_tabMsg4").css("background-color", '');
    $("#btn_tabMsg6").css("background-color", '');
}

function changeMsg6() {
    $("#tab6").css("display", 'block');
    $("#tab1").css("display", 'none');
    $("#tab2").css("display", 'none');
    $("#tab3").css("display", 'none');
    $("#tab4").css("display", 'none');
    $("#tab5").css("display", 'none');
    $("#btn_tabMsg6").css("background-color", 'rgb(26, 179, 148)');
    $("#btn_tabMsg1").css("background-color", '');
    $("#btn_tabMsg2").css("background-color", '');
    $("#btn_tabMsg3").css("background-color", '');
    $("#btn_tabMsg4").css("background-color", '');
    $("#btn_tabMsg5").css("background-color", '');
}

