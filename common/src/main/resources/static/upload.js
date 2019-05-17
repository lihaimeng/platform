$(document).ready(function () {

    $("#btnSubmit").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

    $("input[type=file]").change(function (e) {
        fire_ajax_submit();

    })

});

function fire_ajax_submit() {

    // Get form
    var form = $('#fileUploadForm')[0];
    var fileObj = document.getElementById("FileUpload").files[0]; // js 获取文件对象
    if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
        alert("请选择图片");
        return;
    }
    var formFile = new FormData();
    formFile.append("extraField", "UploadVMKImagePath");
    formFile.append("files", fileObj); //加入文件对象
    // var data = new FormData(form);
    var data = formFile;
    //data.append("CustomField", "This is some extra data, testing");

    $("#btnSubmit").prop("disabled", true);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "upload/uploadFileMulti",
        data: data,
        //http://api.jquery.com/jQuery.ajax/
        //http://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {

            $("#result").text(data);
            console.log("SUCCESS : ", data.filename);
            $("#btnSubmit").prop("disabled", false);
            $("#image1").attr('src', 'upload/images?filename=' + data.filename);
        },
        error: function (e) {

            $("#result").text(e.responseText);
            console.log("ERROR : ", e);
            $("#btnSubmit").prop("disabled", false);

        }
    });

}