$(function() {
	var list = new ExtendableList($("#questions"), $("#questions-template"));
	ajaxGet("/api/questions", function(questions) {
		$.each(questions, function(i, question){
			list.extend(question);
		});
	});

	$("#create-task").on("click", function() {
		var data = {};
		data["title"] = $("#task-title").val();
		data["questionIds"] = list.getElementsIds();
		console.log(data);
		ajaxPost("/api/tasks", data, function() {
			ajaxGet("/", function() {});
		});
	});
});

function ExtendableList($list, $template) {
	this.$list = $list;
	this.$template = $template;
	this.getLast = function () {
		return this.$list.children().last();
	}
}

ExtendableList.prototype.isEmpty = function() {
	return this.$list.children().length == 0;
}

ExtendableList.prototype.extend = function(element) {
	$li = Mustache.render(this.$template.html(), element);
	if (this.isEmpty())
		this.$list.html($li);
	else
		this.$list.append($li);
	this.getLast().find(".remove").on("click", function() {
		console.log("fired");
		this.closest("li").remove();
	});
}

ExtendableList.prototype.getElementsIds = function() {
	var elementsIds = [];
	$.each(this.$list.find(".li"), function(i, li) {
		elementsIds[i] = $(li).attr('data-id');
	});	
	return elementsIds;
}