$(function() {
	var taskId = url(-1);
	var mainUrl = "/api/tasks/" + taskId;
	ajaxGet(mainUrl, function(task) {
		var source = []
		var $taskElement = $("#task");
		$taskElement.append(Mustache.render($("#task-template").html(), task));
		var mapping = new Mapping($taskElement, ["title"], "span");
		var questionList = new List($("#questions"), $("#questions-template").html(), 
			function($element) {
				if ($("#main").hasClass("edit")) {
					$element.find("input").autocomplete({ 
							source: source,
							select: function(event, ui) {
								$element.attr("data-id", ui.item.id);
							}
						});
				}
			}, function() {});
		$.each(task.questionIds, function(i, questionId) {
			ajaxGet("/api/questions/" + questionId, function(question) {
				questionList.add(question);
			});
		});

		new Editable($("#main"), ["title"],
			function(editable) {
				ajaxGet("/api/questions/", function(questions) {
					for (i in questions) {
						var question = questions[i];
						question["value"] = question.title;
						source.push(question);
					}
					console.log(source);
					
					editable.set(mapping.data());
					$.each($(".question"), function(i, question) {
						var $question = $(question);
						var mapping = new Mapping($question, ["title"], 'span');
						var qEditable = new Editable($question, ["title"], 
							function(editable) {},
							function(data) {});
						qEditable.set(mapping.data());
						$question.find("input").autocomplete({ 
							source: source,
							select: function(event, ui) {
								$question.attr("data-id", ui.item.id);
							}
						});
					});
				});
			},
			function(data) {
				var questionIds = [];
				$.each($("#questions").find(".question"), function(i, question) {
					var id = new Identity($(question)).id();
					if (id)
						questionIds[i] = id;
				});
				data["questionIds"] = questionIds;
				ajaxPut(mainUrl, data, function(received) {
					mapping.set(received);
					$("#questions").empty();
					$.each(received.questionIds, function(i, questionId) {
						ajaxGet("/api/questions/" + questionId, function(question) {
							questionList.add(question);
						});
					});
				});
				source = [];
			},
			function() {
				$.each($("#questions").find(".question"), function(i, question) {
					var $question = $(question);
					if (new Identity($question).id())
						$question.find("input").autocomplete('instance').destroy();
					else
						$question.remove();
				});
				source = [];
			});
		$('#add-question').on('click', function() {
			var question = {
				title: "New question"
			}
			questionList.add(question);
		});
	});
	
});
