$(function() {
	var answersName = "answers";
	var questionUrl = "/api/questions/" + url(-1) + "/";
	append(questionUrl, $("#question"), $("#questions-template").html())
	var answersUrl = questionUrl + answersName + '/';
	var answersFields = ['content'];
	var answersTemplate = $('#' + answersName + '-template').html();

	var commentsName = "comments";
	var commentsFields = ['content'];
	var commentsTemplate = $('#' + commentsName + '-template').html();
	new ListAndForm($('#' + answersName), answersUrl, answersFields, answersTemplate, 
		function($element) {
			var commentsUrl = "/api/commentables/" 
						  + new Mapping($element, answersFields).id() 
						  + "/" + commentsName + "/";

			new ListAndForm($element.find('#comments'), commentsUrl, commentsFields, commentsTemplate,
				function($comment) {}
			);
	});
});

function append(url, $div, template) {
	ajaxGet(url, function(object) {
		$div.append(Mustache.render(template, object));
	});
}