$(function() {
	new ExtendableList($("#questions"), $("#questions-template"));
});

function ExtendableList($list, $eltemplate) {
	function addQuestion() {
		console.log('clicked');
		if ($list.children().length == 0)
			$list.html($eltemplate.html());
		else
			$list.append($eltemplate.html());
		$list.children().last().find(".remove").on("click", function() {
			console.log("fired");
			this.closest("li").remove();
		})
	}
	$("#create-task").on("click", addQuestion);
}