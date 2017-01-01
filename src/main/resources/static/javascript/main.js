$(function() {
	var name = "questions";
	var mainUrl = '/' + name + '/';
	var mapping = new Mapping(['title','content']);
	var questions = new List(mainUrl, name, mapping);
	new Form(mainUrl, questions, name, mapping);
});

function Mapping(fields) {
	this.fields = fields;
}

Mapping.prototype.editMode = function($li) {
	$.each(this.fields, function(i, field) {
		$li.find('input.' + field).val($li.find('span.' + field).html());
	});
}

Mapping.prototype.saveEdit = function($li, received) {
	$.each(this.fields, function(i, field) {
		$li.find('span.' + field).html(received[field]);
	});
}

Mapping.prototype.data = function($element, prefix) {
	var data = {};
	$.each(this.fields, function(i, field) {
		data[field] = $element.find(prefix + '.' + field).val();
	});
	return data;
};

function List(mainUrl, name, mapping) {
	var deleteHandler = function() {
		var $li = $(this).closest('li');
		ajaxDelete(mainUrl + $li.attr('data-id'), $li)		
	}
	var goToEditMode = function() {
		var $li = $(this).closest('li');
		mapping.editMode($li);
		$li.addClass('edit');
	}
	var cancelEditMode = function() {
		var $li = $(this).closest('li');
		$li.removeClass('edit');
	}
	var saveHandler = function() {
		var $li = $(this).closest('li');
		ajaxPut(mainUrl + $li.attr('data-id'), mapping.data($li, 'input'), function(received) {
			mapping.saveEdit($li, received);
		});
		$li.removeClass('edit');
	}
	this.template = $('#' + name + '-template').html();
	this.$list = $('#' + name);
	ajaxGet(mainUrl, this);
	this.$list.delegate('.remove', 'click', deleteHandler);
	this.$list.delegate('.editButton', 'click', goToEditMode);
	this.$list.delegate('.cancelEdit', 'click', cancelEditMode);
	this.$list.delegate('.saveEdit', 'click', saveHandler);

}

List.prototype.add = function(object) {
	this.$list.append(Mustache.render(this.template, object));
};

function Form(mainUrl, list, name, mapping) {	
	var $form = $('#' + name + '-form');
	var $addquestion = $form.find('#add-' + name);
	$addquestion.on('click', function() {
		ajaxPost(mainUrl, mapping.data($form, 'input'), list)	
	});
}