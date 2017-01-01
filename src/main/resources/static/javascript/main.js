$(function() {
	var name = "questions";
	var questions = new List(name);
	new Form(questions, name, new Mapping(['title','content']));
});

function Mapping(fields) {
	this.fields = fields;
}

Mapping.prototype.data = function() {
	var data = {};
	$.each(this.fields, function(i, field) {
		data[field] = $('#' + field).val();
	});
	return data;
};

function List(name) {
	var deleteHandler = function() {
		var $li = $(this).closest('li');
		ajaxDelete('/' + name + '/' + $(this).attr('data-id'), $li)		
	}
	this.template = $('#' + name + '-template').html();
	this.$list = $('#' + name);
	ajaxGet('/' + name, this);
	this.$list.delegate('.remove', 'click', deleteHandler);
}

List.prototype.add = function(object) {
	this.$list.append(Mustache.render(this.template, object));
};

function Form(list, name, questionForm) {	
	var $addquestion = $('#add-' + name);
	$addquestion.on('click', function() {
		var url = '/' + name;
		ajaxPost(url, questionForm.data(), list)	
	});
}