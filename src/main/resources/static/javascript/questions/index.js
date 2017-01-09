$(function() {
	var qName = "questions";
	var qUrl = 'api/' + qName + '/';
	var qFields = ['title','content'];
	var qTemplate = $('#' + qName + '-template').html();

	new ListAndForm($('#' + qName), qUrl, qFields, qTemplate, function($element) {});

	var tName = "tasks";
	var tUrl = 'api/' + tName + '/';
	var tTemplate = $('#' + tName + '-template').html();

	var tasks = new List($('#' + tName).find(".list"), tTemplate, 
		function($element) {},
		function($wrapper) {
			var identity = new Identity($wrapper);
			ajaxDelete(tUrl + identity.id(), 
				function() {
					$wrapper.remove();
				});
		});
	ajaxGet(tUrl, function(data) {
		$.each(data, function(i, object){
			tasks.add(object);
		});
	});
	$("#create-task").on("click", function() {
		ajaxPost("/api/tasks/", {
			title: "new task",
			questionIds: []
		}, function(element) {
				tasks.add(element);
			});
		});
});