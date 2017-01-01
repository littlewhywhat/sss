$(function() {
	var name = "questions";
	var mainUrl = '/' + name + '/';
	var questions = new List(mainUrl, name);
	new Form(mainUrl, questions, name, new Mapping(['title','content']));
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

function List(mainUrl, name) {
	var deleteHandler = function() {
		var $li = $(this).closest('li');
		ajaxDelete(mainUrl + $(this).attr('data-id'), $li)		
	}
	this.template = $('#' + name + '-template').html();
	this.$list = $('#' + name);
	ajaxGet(mainUrl, this);
	this.$list.delegate('.remove', 'click', deleteHandler);
}

List.prototype.add = function(object) {
	this.$list.append(Mustache.render(this.template, object));
};

function Form(mainUrl, list, name, questionForm) {	
	var $addquestion = $('#add-' + name);
	$addquestion.on('click', function() {
		ajaxPost(mainUrl, questionForm.data(), list)	
	});
}