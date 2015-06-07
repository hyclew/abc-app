/* 弹出层 */	
function show_popup(popupname, shadename, closename) {
    var sh = $(window).scrollTop(), dw = $(window).width(),
	dy = $(window).height(), w = $(popupname).width(),
	y = $(popupname).height(), bh = $('body').height();

    $('<div/>').prependTo('body').addClass('shade').fadeIn(300).css('height', bh - dy > 0 ? bh : dy + 'px');
    $(popupname).is(':visible') ? $(popupname).hide() : $(popupname).show();
    $(popupname).show().css({
        'left': (dw / 2 - w / 2) + 'px',
        'top': (dy / 2 - y / 2)+ 'px'
    });
   // if ($.browser.msie && $.browser.version == '6.0') {  //expired after jquery 1.9
    if('undefined'==typeof(document.body.style.maxHeight)){
        var timeout = false;
        $(window).scroll(function () {
            if (timeout) {
                clearTimeout(timeout);
            }
            function t(){
                //do   
                var scroll_sh = $(window).scrollTop(), scroll_bh = $('body').height();
                $(popupname).css({ 'position': 'absolute', 'top': (scroll_bh / 2 - y / 2 - scroll_sh) + 'px' });
            };
            timeout = setTimeout(t, 100);
        });
    }
    $(closename).click(function (){
        $(shadename).remove();
        $(popupname).hide();
        return false;
    });
};
function hide_popup(popupname, shadename) {
    $(shadename).remove();
    $(popupname).hide();
}