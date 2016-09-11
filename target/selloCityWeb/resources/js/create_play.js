// VERTICALLY ALIGN FUNCTION
$(document).ready(vAlign);
function vAlign() {
    var ah = $("#wrapper").height();
    var ph = window.innerHeight;
    var mh = Math.ceil((ph - ah) / 2);
    console.log("mh= " + mh);
    $("#wrapper").css('margin-top', mh);
};
