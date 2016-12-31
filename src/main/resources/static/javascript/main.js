$(function(){
	
	var $questions = $('#questions');
	var $addquestion = $('#add-question');
	var $title = $('#title');
	var $content = $('#content');
	
	var questionTemplate = $('#question-template').html();
	
	function addQuestion(question) {
		$questions.append(Mustache.render(questionTemplate, question));
	};
	
	$.ajax({
		type: 'GET',
		url: '/questions',
		success: function(questions) {
			$.each(questions, function(i, question){
				addQuestion(question);
			});
		}
	});
	
	$addquestion.on('click', function() {
		var questionVO = {
			title: $title.val(),
			content: $content.val(),
		};
		
		$.ajax({
			type: 'POST',
			url: '/questions',
			data: JSON.stringify(questionVO),
			contentType: 'application/json',
			dataType: 'json',
			success: function(questionBO) {
				addQuestion(questionBO);
			},
			error: function(status) {
				console.log(status);
			}
		});
	});
	$questions.delegate('.remove', 'click', function(){
		var $li = $(this).closest('li');
		
		$.ajax({
			type: 'DELETE',
			url: '/questions/' + $(this).attr('data-id'),
			success: function(questionBO) {
				$li.remove();
			},
			error: function(status) {
				console.log(status);
			}
		});
	});
});