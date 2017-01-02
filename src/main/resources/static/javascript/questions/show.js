$(function() {
	var questionId = url(-1);
	var answersName = "answers";
	var questionUrl = "/api/questions/" + questionId + "/";
	var $questionDiv = $("#question");

	var commentsName = "comments";
	var commentsFields = ['content'];
	var commentsTemplate = $('#' + commentsName + '-template').html();
	var qCommentsUrl = "/api/commentables/" 
						  + questionId
						  + "/" + commentsName + "/";
	ajaxGet(questionUrl, function(object) {
		$questionDiv.append(Mustache.render($("#questions-template").html(), object));
		new ListAndForm($questionDiv.find('.comments'), qCommentsUrl, commentsFields, commentsTemplate,
			function($comment) {}
		);
	});
	
	var answersUrl = questionUrl + answersName + '/';
	var answersFields = ['content'];
	var answersTemplate = $('#' + answersName + '-template').html();

	
	new ListAndForm($('#' + answersName), answersUrl, answersFields, answersTemplate, 
		function($element) {
			var commentsUrl = "/api/commentables/" 
						  + new Mapping($element, answersFields).id() 
						  + "/" + commentsName + "/";

			new ListAndForm($element.find('.comments'), commentsUrl, commentsFields, commentsTemplate,
				function($comment) {}
			);
	});
});
