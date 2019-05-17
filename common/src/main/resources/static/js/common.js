/*
name:cqy  20180725
* */
$('.xcNavSm').hover(function () {
    var w = document.documentElement.clientWidth || window.innerWidth;
    if (w <= 1134) {
        $('.xcConLog').css('width', "62%");
        $(this).css({
            'width': "38%",
            // "position": "absolute",
            "z-index": "9",
        })
    }
}, function () {
    var w = document.documentElement.clientWidth || window.innerWidth;
    if(w <= 1134) {
        $('.xcConLog').css('width', "83.33%");
        $(this).css({
            'width': "18%",
            "position": "relative",
            "z-index": "0",
        })
    }

});
