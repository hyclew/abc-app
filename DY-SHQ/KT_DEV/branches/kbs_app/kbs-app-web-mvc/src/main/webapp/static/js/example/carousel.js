$(document).ready(function() {
	$("#carousel").rcarousel({
		visible : 5,
		step : 5,
		width : 100,
		height : 100,
	});
	$("#ui-carousel-next").add("#ui-carousel-prev").hover(function() {
		$(this).css("opacity", 0.7);
	}, function() {
		$(this).css("opacity", 1.0);
	});
});