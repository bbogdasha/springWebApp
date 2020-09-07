jQuery(function($) {
    var element = $(".hidden-logo"), display;
    $(window).scroll(function () {
    display = $(this).scrollTop() >= 180;
    display != element.css('opacity') && element.stop().animate({ 'opacity': display }, 500);
    });
 });