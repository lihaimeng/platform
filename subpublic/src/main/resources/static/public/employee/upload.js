$(document).ready(function () {
    $('#FileUploadAddBtn').click(function () {
        document.getElementById("FileUploadAdd").click();
    });
    $('#FileUploadEditBtn').click(function () {
        document.getElementById("FileUploadEdit").click();
    });
    $("#FileUploadAdd").change(function (e) {
        var fileObj = document.getElementById("FileUploadAdd").files[0];
        var flag = 'add';
        fire_ajax_submit(fileObj, flag);
    });
    $("#FileUploadEdit").change(function (e) {
        var fileObj = document.getElementById("FileUploadEdit").files[0];
        var flag = 'edit';
        fire_ajax_submit(fileObj, flag);
    })
});

function fire_ajax_submit(fileObj, flag) {
    if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
        warnningMsg("请选择图片");
        return;
    }
    var formFile = new FormData();
    formFile.append("action", "UploadVMKImagePath");
    formFile.append("file", fileObj); //加入文件对象
    var data = formFile;
    $.ajax({
        url: '../../common/attachmentUpload',
        data: data,
        type: "Post",
        cache: false,//上传文件无需缓存
        processData: false,//用于对data参数进行序列化处理 这里必须false
        contentType: false, //必须
        timeout: 600000,
        success: function (data) {
            console.log("SUCCESS : ", data.filename);
            //新增时赋值
            if (flag == 'add') {
                $('#filenameAdd').val(data.filename);
                $('#filetypeAdd').val(data.file_type);
                $('#realpathAdd').val(data.real_path);
                $('#realpathAdd').val(data.real_path);
                $("#imageAdd1").attr('src', '../../common/images?filename=' + data.newname);
            }
            //修改后赋值
            if (flag == 'edit') {
                $('#filenameEdit').val(data.filename);
                $('#filetypeEdit').val(data.file_type);
                $('#realpathEdit').val(data.real_path);
                $("#imageEdit1").attr('src', '../../common/images?filename=' + data.newname);
            }
        },
        error: function (e) {
            $("#result").text(e.responseText);
            console.log("ERROR : ", e);
            $("#btnSubmit").prop("disabled", false);
        }
    });

}

/*警告提示信息*/
function warnningMsg(data) {
    $.smkAlert({
        text: data,
        type: 'warning',
        position: 'top-center',
        time: 1
    });
}