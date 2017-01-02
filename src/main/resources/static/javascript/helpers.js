function ListAndForm($div, mainUrl, fields, template, onAdd) {
	var questions = new List(mainUrl, $div.find('.list'), fields, template, onAdd);
	new Form(mainUrl, $div.find('.form'), fields, function(received) {
		questions.add(received);
	});
}

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

function List(mainUrl, $list, fields, template, onAdd) {
	var self = this;
	this.$list = $list;
	this.template = template;
	this.onAdd = onAdd;
	var getWrapper = function(element, fields) {
		return new Mapping($(element).closest('.wrapper'), fields);
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
			self.add(object);
		});
	});
	this.$list.delegate('.remove-button', 'click', deleteHandler);
	this.$list.delegate('.edit-button', 'click', goToEditMode);
	this.$list.delegate('.cancel-edit-button', 'click', cancelEditMode);
	this.$list.delegate('.save-edit-button', 'click', saveHandler);

}

List.prototype.add = function(object) {
	var rendered = Mustache.render(this.template, object)
	this.$list.append(rendered);
	this.onAdd(this.$list.last());
};

function Form(mainUrl, $form, fields, receive) {	
	var $addButton = $form.find('.add-button');
	var mapping = new Mapping($form, fields);
	$addButton.on('click', function() {
		ajaxPost(mainUrl, 
			mapping.data(), 
			function(received) {
				receive(received);
			});	
	});
}