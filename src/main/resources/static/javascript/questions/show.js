$(function() {
	console.log("api/questions/" + url(-1));
	ajaxGet("/api/questions/" + url(-1), function(object) {
		$(".question").append(Mustache.render($("#questions-template").html(), object));
	});
});