$(document).ready(function() {
	$('.currency').formatCurrency();
	
	$('.currency').unbind("blur").bind("blur", function() {
		$('.currency').formatCurrency();
	});
	
	$('.currencyCN').unbind().bind("blur", function() {
		$("#upperCaseCurrencyId").text($.ftCurrency($(this).val()));
	});
});
