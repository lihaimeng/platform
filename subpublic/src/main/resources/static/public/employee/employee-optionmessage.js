(function () {
    var cords = "003,012,015,016,017,023";
    $.ajax({
        url: "../../dictionary/selectOptions",
        type: 'GET',
        data: {"code": cords},
        success: function (data) {
            for (var i = 0; i < data.result003.length; i++) {
                $('#xb').append("<option value=" + data.result003[i].dicCode + ">" + data.result003[i].dicName + "</option>");
                $('#xbxg').append("<option value=" + data.result003[i].dicCode + ">" + data.result003[i].dicName + "</option>");
                $('#xb1').append("<option value=" + data.result003[i].dicCode + ">" + data.result003[i].dicName + "</option>");
            }
            for (var i = 0; i < data.result012.length; i++) {
                $('#cyzj').append("<option value=" + data.result012[i].dicCode + ">" + data.result012[i].dicName + "</option>");
                $('#cyzjxg').append("<option value=" + data.result012[i].dicCode + ">" + data.result012[i].dicName + "</option>");
            }
            for (var i = 0; i < data.result015.length; i++) {
                $('#whcdxg').append("<option value=" + data.result015[i].dicCode + ">" + data.result015[i].dicName + "</option>");
                $('#whcd').append("<option value=" + data.result015[i].dicCode + ">" + data.result015[i].dicName + "</option>");
            }
            for (var i = 0; i < data.result016.length; i++) {
                $('#minzu').append("<option value=" + data.result016[i].dicCode + ">" + data.result016[i].dicName + "</option>");
                $('#minzuxg').append("<option value=" + data.result016[i].dicCode + ">" + data.result016[i].dicName + "</option>");
            }
            for (var i = 0; i < data.result017.length; i++) {
                $('#ryzt').append("<option value=" + data.result017[i].dicCode + ">" + data.result017[i].dicName + "</option>");
                $('#cyryzt').append("<option value=" + data.result017[i].dicCode + ">" + data.result017[i].dicName + "</option>");
                $('#cyryztxg').append("<option value=" + data.result017[i].dicCode + ">" + data.result017[i].dicName + "</option>");
            }
            for (var i = 0; i < data.result023.length; i++) {
                $('#roleName').append("<option value=" + data.result023[i].dicCode + ">" + data.result023[i].dicName + "</option>");
                $('#roleNamexg').append("<option value=" + data.result023[i].dicCode + ">" + data.result023[i].dicName + "</option>");
            }
        },
        error: function (data) {
            dangerMsg(data);
        }
    });

})();





