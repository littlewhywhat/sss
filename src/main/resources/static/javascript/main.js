$(function() {
	var name = "questions";
	var mainUrl = 'api/' + name + '/';
	var fields = ['title','content'];
	var template = $('#' + name + '-template').html();
	var $list = $('#' + name);
	var $form = $('#' + name + '-form');

	var questions = new List(mainUrl, $list, fields, template, 'li');
	new Form(mainUrl, $form, fields, function(received) {
		questions.add(received);
	});
});

function Mapping($element, fields) {
	this.$element = $element;
	this.fields = fields;
}

Mapping.prototype.editMode = function() {
	var $element = this.$element;
	$.each(this.fields, function(i, field) {
		$element.find('input.' + field).val($element.find('span.' + field).html());
	});
    $element.addClass('edit');
}

Mapping.prototype.noeditMode = function() {
	this.$element.removeClass('edit');
}

Mapping.prototype.saveEdit = function(received) {
	var $element = this.$element;
	$.each(this.fields, function(i, field) {
		$element.find('span.' + field).html(received[field]);
	});
}

Mapping.prototype.data = function() {
	var $element = this.$element;
	var data = {};
	$.each(this.fields, function(i, field) {
		data[field] = $element.find('input.' + field).val();
	});
	return data;
};

Mapping.prototype.id = function() {
	return this.$element.attr('data-id');
}

Mapping.prototype.remove = function() {
	this.$element.remove();
}

function List(mainUrl, $list, fields, template, wrapperTag) {
	this.$list = $list;
	this.template = template;
	var getWrapper = function(element, fields) {
		return new Mapping($(element).closest(wrapperTag), fields);
	}
	var deleteHandler = function() {
		var mapping = getWrapper(this, fields);
		ajaxDelete(mainUrl + mapping.id(), 
			function() {
				mapping.remove();
			});
	}
	var goToEditMode = function() {
		getWrapper(this, fields).editMode();
	}
	var cancelEditMode = function() {
		getWrapper(this, fields).noeditMode();
	}
	var saveHandler = function() {
		var mapping = getWrapper(this, fields);
		ajaxPut(mainUrl + mapping.id(), 
			mapping.data(), 
			function(received) {
				mapping.saveEdit(received);
			});
		mapping.noeditMode();
	}
	ajaxGet(mainUrl, function(data) {
		$.each(data, function(i, object){
			this.add(object);
		});
	});
	this.$list.delegate('.remove', 'click', deleteHandler);
	this.$list.delegate('.editButton', 'click', goToEditMode);
	this.$list.delegate('.cancelEdit', 'click', cancelEditMode);
	this.$list.delegate('.saveEdit', 'click', saveHandler);

}

List.prototype.add = function(object) {
	this.$list.append(Mustache.render(this.template, object));
};

function Form(mainUrl, $form, fields, receive) {	
	var $addquestion = $form.find('#add');
	var mapping = new Mapping($form, fields);
	$addquestion.on('click', function() {
		ajaxPost(mainUrl, 
			mapping.data(), 
			function(received) {
				receive(received);
			});	
	});
}