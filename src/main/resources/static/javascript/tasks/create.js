$(function() {
	var list = new ExtendableList($("#questions"), $("#questions-template"));
	ajaxGet("/api/questions", function(questions) {
		$.each(questions, function(i, question){
			list.addQuestion(question);
		});
	});

	$("#create-task").on("click", function() {
		var data = {};
		data["title"] = $("#task-title").val();
		data["questionIds"] = list.getQuestionIds();
		console.log(data);
		ajaxPost("/api/tasks", data, function() {
			ajaxGet("/", function() {});
		});
	});
});

function ExtendableList($list, $eltemplate) {
	this.$list = $list;
	this.$eltemplate = $eltemplate;
}

ExtendableList.prototype.addQuestion = function(question) {
	console.log('clicked');
	if (this.$list.children().length == 0)
		this.$list.html(Mustache.render(this.$eltemplate.html(), question));
	else
		this.$list.append(Mustache.render(this.$eltemplate.html(), question));
	this.$list.children().last().find(".remove").on("click", function() {
		console.log("fired");
		this.closest("li").remove();
	});
}

ExtendableList.prototype.getQuestionIds = function() {
	var questionIds = [];
	$.each(this.$list.find(".question"), function(i, li) {
		questionIds[i] = $(li).attr('data-id');
	});	
	return questionIds;
}