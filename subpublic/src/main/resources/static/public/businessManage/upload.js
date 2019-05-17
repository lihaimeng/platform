var fileDtoList = [];
var qyxxid;//获取企业ID
var fileMkmc;
var clickUploadEditButton = false;
$('#uploadEdit1').off("click").on('click', function () {
    $("#FileUploadEdit1").change(function () {
        var fileObj = document.getElementById("FileUploadEdit1").files[0];
        var flag = 'edit';
        var mark = '1';
        fire_ajax_submit(fileObj, flag, mark);
    });
});
$('#uploadEdit2').off("click").on('click', function () {
    $("#FileUploadEdit2").change(function () {
        var fileObj = document.getElementById("FileUploadEdit2").files[0];
        var flag = 'edit';
        var mark = '2';
        fire_ajax_submit(fileObj, flag, mark);
    });
});
$('#uploadEdit3').off("click").on('click', function () {
    $("#FileUploadEdit3").change(function () {
        var fileObj = document.getElementById("FileUploadEdit3").files[0];
        var flag = 'edit';
        var mark = '3';
        fire_ajax_submit(fileObj, flag, mark);
    });
});
$('#uploadEdit4').off("click").on('click', function () {
    $("#FileUploadEdit4").change(function () {
        var fileObj = document.getElementById("FileUploadEdit4").files[0];
        var flag = 'edit';
        var mark = '4';
        fire_ajax_submit(fileObj, flag, mark);
    });
});
$('#uploadEdit5').off("click").on('click', function () {
    $("#FileUploadEdit5").change(function () {
        var fileObj = document.getElementById("FileUploadEdit5").files[0];
        var flag = 'edit';
        var mark = '5';
        fire_ajax_submit(fileObj, flag, mark);
    });
});
$('#uploadEdit6').off("click").on('click', function () {
    $("#FileUploadEdit6").change(function () {
        var fileObj = document.getElementById("FileUploadEdit6").files[0];
        var flag = 'edit';
        var mark = '6';
        fire_ajax_submit(fileObj, flag, mark);
    });
});
$('#upload1').off("click").on('click', function () {
    $("#FileUploadAdd1").change(function () {
        var fileObj = document.getElementById("FileUploadAdd1").files[0];
        var flag = 'add';
        var mark = '1';
        //上传文件
        fire_ajax_submit(fileObj, flag, mark);
    });
});
$('#upload2').off("click").on('click', function (e) {
    $("#FileUploadAdd2").change(function () {
        var fileObj = document.getElementById("FileUploadAdd2").files[0];
        var flag = 'add';
        var mark = '2';
        //上传文件
        fire_ajax_submit(fileObj, flag, mark);
    });
});
$('#upload3').off("click").on('click', function () {
    $("#FileUploadAdd3").change(function () {
        var fileObj = document.getElementById("FileUploadAdd3").files[0];
        var flag = 'add';
        var mark = '3';
        //上传文件
        fire_ajax_submit(fileObj, flag, mark);
    });
});
$('#upload4').off("click").on('click', function () {
    $("#FileUploadAdd4").change(function () {
        var fileObj = document.getElementById("FileUploadAdd4").files[0];
        var flag = 'add';
        var mark = '4';
        //上传文件
        fire_ajax_submit(fileObj, flag, mark);
    });
});
$('#upload5').off("click").on('click', function () {
    $("#FileUploadAdd5").change(function () {
        var fileObj = document.getElementById("FileUploadAdd5").files[0];
        var flag = 'add';
        var mark = '5';
        //上传文件
        fire_ajax_submit(fileObj, flag, mark);
    });
});
$('#upload6').off("click").on('click', function () {
    $("#FileUploadAdd6").change(function () {
        var fileObj = document.getElementById("FileUploadAdd6").files[0];
        var flag = 'add';
        var mark = '6';
        //上传文件
        fire_ajax_submit(fileObj, flag, mark);
    });
});

//上传文件
function fire_ajax_submit(fileObj, flag, mark) {
    if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
        warnningMsg("请选择图片");
        return;
    }
    var formFile = new FormData();
    //formFile.append("extraField", "UploadVMKImagePath");
    formFile.append("action", "UploadVMKImagePath");
    formFile.append("file", fileObj); //加入文件对象
    var data = formFile;
    $.ajax({
        url: "../../common/attachmentUpload",
        data: data,
        type: "POST",
        cache: false,//上传文件无需缓存
        processData: false,//用于对data参数进行序列化处理 这里必须false
        contentType: false, //必须
        timeout: 600000,
        success: function (result) {
            //新增时赋值
            if (flag == 'add') {
                getAddFileMsg(mark, result);
                return;
            }
            //修改后赋值
            if (flag == 'edit') {
                clickUploadEditButton = true;
                getEditFileMsg(mark, result);
            }
        },
        error: function (e) {
            $("#result").text(e.responseText);
            $("#btnSubmit").prop("disabled", false);
        }
    });

}

//获取文件信息
function getAddFileMsg(mark, data) {
    $('#filenameAdd' + mark).val(data.filename);
    $('#downloadFile' + mark).html(data.filename);
    $('#filetypeAdd' + mark).val(data.file_type);
    $('#realpathAdd' + mark).val(data.real_path);
    if (mark == '1') {
        $('#businessLicense').val(data.filename);
    } else if (mark == '2') {
        $('#lawPersonId').val(data.filename);
    } else if (mark == '3') {
        $('#businessPermits').val(data.filename);
    } else if (mark == '4') {
        $('#companyShape').val(data.filename);
    } else if (mark == '5') {
        $('#placeProve').val(data.filename);
    } else if (mark == '6') {
        $('#others').val(data.filename);
    }
    fileAddSubmit(mark);
}

function getEditFileMsg(mark, data) {
    $('#filenameEdit' + mark).val(data.filename);
    $('#filetypeEdit' + mark).val(data.file_type);
    $('#realpathEdit' + mark).val(data.real_path);
    if (mark == '1') {
        $('#businessLicenseEdit').val(data.filename);
    } else if (mark == '2') {
        $('#lawPersonNumIdEdit').val(data.filename);
    } else if (mark == '3') {
        $('#businessPermitsEdit').val(data.filename);
    } else if (mark == '4') {
        $('#companyShapeEdit').val(data.filename);
    } else if (mark == '5') {
        $('#placeProveEdit').val(data.filename);
    } else if (mark == '6') {
        $('#othersEdit').val(data.filename);
    }
    fileEditSubmit(mark);
}

function fileEditSubmit(mark) {
    var fileDto = {};
    var qyid = $('#qyidEdit').val();
    var mkmc = $('#mkmcEdit').val();
    var fileName = $('#filenameEdit' + mark).val();
    var fileType = $('#filetypeEdit' + mark).val();
    var realPath = $('#realpathEdit' + mark).val();
    var fileMark = 'mark' + mark;
    qyxxid = qyid;
    fileMkmc = mkmc;
    fileDto.fileName = fileName;
    fileDto.fileType = fileType;
    fileDto.realPath = realPath;
    fileDto.mark = fileMark;
    fileDtoList.push(fileDto);
    console.info(mark);

}

//将文件信息添加到fileDtoList集合中
function fileAddSubmit(mark) {
    var fileDto = {};
    var qyid = $('#qyid').val();
    var mkmc = $('#mkmc').val();
    var fileName = $('#filenameAdd' + mark).val();
    var fileType = $('#filetypeAdd' + mark).val();
    var realPath = $('#realpathAdd' + mark).val();
    var fileMark = 'mark' + mark;
    qyxxid = qyid;
    fileMkmc = mkmc;
    fileDto.fileName = fileName;
    fileDto.fileType = fileType;
    fileDto.realPath = realPath;
    fileDto.mark = fileMark;
    fileDtoList.push(fileDto);

}

$('#saveFileAdd').off("click").on('click', function () {
    var businessLicense = $('#businessLicense').val();
    var lawPersonId = $('#lawPersonId').val();
    if (businessLicense == null || businessLicense == '' || lawPersonId == null || lawPersonId == '') {
        warnningMsg("资料信息未添加！");
        $('#businessLicense').focus();
        return false;
    }
    if (lawPersonId == null || lawPersonId == '') {
        warnningMsg("资料信息未添加！");
        $('#lawPersonId').focus();
        return false;
    }
    var queryData = JSON.stringify({
        'qyid': qyxxid,
        'mkmc': fileMkmc,
        'fileDtoList': fileDtoList
    });
    $.ajax({
        url: "../../qyjbxx/insertAttachment",
        contentType: "application/json;charset=UTF-8",
        type: "post",
        data: queryData,
        success: function (data) {
            fileDtoList = [];
            if (data.success == "成功") {
                successMsg('操作成功');
                $('#closeMsg').click();
                $('#companyTable').bootstrapTable('refresh', {
                    url: '../../qyjbxx/selectQyjbxxByqyzt'
                });
            } else {
                dangerMsg("操作失败");
                return false;
            }
        },
        error: function (data) {
            dangerMsg(data.errMsg);
        }
    });
});
$('#saveFileEdit').off("click").on('click', function () {
    if (!clickUploadEditButton) {
        successMsg('操作成功');
        $('#closeEdit').click();
        return false;
    }
    var businessLicenseEdit = $('#businessLicenseEdit').val();
    var lawPersonNumIdEdit = $('#lawPersonNumIdEdit').val();
    if (businessLicenseEdit == null || businessLicenseEdit == '' || lawPersonNumIdEdit == null || lawPersonNumIdEdit == '') {
        warnningMsg("资料信息未添加！");
        $('#businessLicenseEdit').focus();
        return false;
    }
    var queryData = JSON.stringify({
        'qyid': qyxxid,
        'mkmc': fileMkmc,
        'fileDtoList': fileDtoList
    });
    $.ajax({
        url: "../../qyjbxx/updateAttachment",
        contentType: "application/json;charset=UTF-8",
        type: "post",
        data: queryData,
        success: function (data) {
            fileDtoList = [];
            if (data.success == "成功") {
                successMsg('操作成功');
                $('#closeEdit').click();
                $('#companyTable').bootstrapTable('refresh', {
                    url: '../../qyjbxx/selectQyjbxxByqyzt'
                });
            } else {
                dangerMsg("操作失败");
                return false;
            }
        },
        error: function (data) {
            dangerMsg(data.errMsg);
        }
    });
});

//文件查询
function selectFileMsg(qyid) {
    var mkmc = $('#mkmc').val();
    $.ajax({
        url: '../../qyjbxx/getFileMsg',
        type: 'POST',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify({
            'tableId': qyid,
            'tableName': mkmc
        }),
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                if (data[i].mark == 'mark1') {
                    $('#businessLicenseEdit').val(data[i].fileName);
                    $('#realpathEdit1').val(data[i].realPath);
                    $('#downloadFile1').html(data[i].fileName);
                } else if (data[i].mark == 'mark2') {
                    $('#lawPersonNumIdEdit').val(data[i].fileName);
                    $('#realpathEdit2').val(data[i].realPath);
                    $('#downloadFile2').html(data[i].fileName);
                } else if (data[i].mark == 'mark3') {
                    $('#businessPermitsEdit').val(data[i].fileName);
                    $('#realpathEdit3').val(data[i].realPath);
                    $('#downloadFile3').html(data[i].fileName);
                } else if (data[i].mark == 'mark4') {
                    $('#companyShapeEdit').val(data[i].fileName);
                    $('#realpathEdit4').val(data[i].realPath);
                    $('#downloadFile4').html(data[i].fileName);
                } else if (data[i].mark == 'mark5') {
                    $('#placeProveEdit').val(data[i].fileName);
                    $('#realpathEdit5').val(data[i].realPath);
                    $('#downloadFile5').html(data[i].fileName);
                } else if (data[i].mark == 'mark6') {
                    $('#othersEdit').val(data[i].fileName);
                    $('#realpathEdit6').val(data[i].realPath);
                    $('#downloadFile6').html(data[i].fileName);
                }
            }
            for (var i = 1; i < 7; i++) {
                var downFile = $('#downloadFile' + i).html();
                if (downFile == null || downFile == "") {
                    $('#download' + i).css("display", "none");
                }
            }
        },
        error: function (data) {
            dangerMsg(data);
        }
    })
}

//删除修改文件
$('#deleteEdit1').off("click").on('click', function () {
    var realpathEdit = $('#realpathEdit1').val();
    deleteFileAjax(realpathEdit, "mark1", "edit");
});
$('#deleteEdit2').off("click").on('click', function () {
    var realpathEdit = $('#realpathEdit2').val();
    deleteFileAjax(realpathEdit, "mark2", "edit");
});
$('#deleteEdit3').off("click").on('click', function () {
    var realpathEdit = $('#realpathEdit3').val();
    deleteFileAjax(realpathEdit, "mark3", "edit");
});
$('#deleteEdit4').off("click").on('click', function () {
    var realpathEdit = $('#realpathEdit4').val();
    deleteFileAjax(realpathEdit, "mark4", "edit");
});
$('#deleteEdit5').off("click").on('click', function () {
    var realpathEdit = $('#realpathEdit5').val();
    deleteFileAjax(realpathEdit, "mark5", "edit");
});
$('#deleteEdit6').off("click").on('click', function () {
    var realpathEdit = $('#realpathEdit6').val();
    deleteFileAjax(realpathEdit, "mark6", "edit");
});
//删除新增文件
$('#deleteAdd1').off("click").on('click', function () {
    var realpathAdd = $('#realpathAdd1').val();
    deleteFileAjax(realpathAdd, "mark1", "add");
});
$('#deleteAdd2').off("click").on('click', function () {
    var realpathAdd = $('#realpathAdd2').val();
    deleteFileAjax(realpathAdd, "mark2", "add");
});
$('#deleteAdd3').off("click").on('click', function () {
    var realpathAdd = $('#realpathAdd3').val();
    deleteFileAjax(realpathAdd, "mark3", "add");
});
$('#deleteAdd4').off("click").on('click', function () {
    var realpathAdd = $('#realpathAdd4').val();
    deleteFileAjax(realpathAdd, "mark4", "add");
});
$('#deleteAdd5').off("click").on('click', function () {
    var realpathAdd = $('#realpathAdd5').val();
    deleteFileAjax(realpathAdd, "mark5", "add");
});
$('#deleteAdd6').off("click").on('click', function () {
    var realpathAdd = $('#realpathAdd6').val();
    deleteFileAjax(realpathAdd, "mark6", "add");
});

function deleteFileAjax(realpath, mark, flag) {
    var qyid = $('#qyidEdit').val();
    var mkmc = $('#mkmcEdit').val();
    //var mark = mark;
    $.ajax({
        url: '../../qyjbxx/deleteFileMsg',
        type: 'POST',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify({
            'realPath': realpath,
            'tableId': qyid,
            'tableName': mkmc,
            'mark': mark
        }),
        success: function (data) {
            if (data.result == "删除成功") {
                if (mark == 'mark1' && flag == 'edit') {
                    $('#businessLicenseEdit').val('');
                } else if (mark == 'mark2' && flag == 'edit') {
                    $('#lawPersonNumIdEdit').val('');
                } else if (mark == 'mark3' && flag == 'edit') {
                    $('#businessPermitsEdit').val('');
                } else if (mark == 'mark4' && flag == 'edit') {
                    $('#companyShapeEdit').val('');
                } else if (mark == 'mark5' && flag == 'edit') {
                    $('#placeProveEdit').val('');
                } else if (mark == 'mark6' && flag == 'edit') {
                    $('#othersEdit').val('');
                } else if (mark == 'mark1' && flag == 'add') {
                    $('#businessLicense').val('');
                } else if (mark == 'mark2' && flag == 'add') {
                    $('#lawPersonId').val('');
                } else if (mark == 'mark3' && flag == 'add') {
                    $('#businessPermits').val('');
                } else if (mark == 'mark4' && flag == 'add') {
                    $('#companyShape').val('');
                } else if (mark == 'mark5' && flag == 'add') {
                    $('#placeProve').val('');
                } else if (mark == 'mark6' && flag == 'add') {
                    $('#others').val('');
                }
                successMsg("删除成功");
            } else {
                dangerMsg("删除失败");
            }
        },
        error: function (data) {
            dangerMsg(data);
        }
    });
}

$('#btn_tabMsg9').click(function () {
    var data = $("#companyTable").bootstrapTable('getSelections')[0];
    if (typeof(data) != 'undefined') {
        var qyid = data.qyid;
        selectFileMsg(qyid);
    }
});
$('#download1').off("click").on('click', function () {
    var qyidMsg = $('#tableId').val();
    var mkmc = $('#tableName').val();
    var mark = $('#mark').val('mark1');
    $("#downloadForm").submit();
});
$('#download2').off("click").on('click', function () {
    var qyidMsg = $('#tableId').val();
    var mkmc = $('#tableName').val();
    var mark = $('#mark').val('mark2');
    $("#downloadForm").submit();
});
$('#download3').off("click").on('click', function () {
    var qyidMsg = $('#tableId').val();
    var mkmc = $('#tableName').val();
    var mark = $('#mark').val('mark3');
    $("#downloadForm").submit();
});
$('#download4').off("click").on('click', function () {
    var qyidMsg = $('#tableId').val();
    var mkmc = $('#tableName').val();
    var mark = $('#mark').val('mark4');
    $("#downloadForm").submit();
});
$('#download5').off("click").on('click', function () {
    var qyidMsg = $('#tableId').val();
    var mkmc = $('#tableName').val();
    var mark = $('#mark').val('mark5');
    $("#downloadForm").submit();
});
$('#download6').off("click").on('click', function () {
    var qyidMsg = $('#tableId').val();
    var mkmc = $('#tableName').val();
    var mark = $('#mark').val('mark6');
    $("#downloadForm").submit();
});

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