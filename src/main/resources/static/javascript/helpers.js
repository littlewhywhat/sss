function ListAndForm($div, mainUrl, fields, template, onAdd) {
	var list = new List($div.find('.list'), fields, template, onAdd,
		function(mapping) {
			ajaxPut(mainUrl + mapping.id(), 
			mapping.data(), 
			function(received) {
				mapping.saveEdit(received);
			});
		},
		function(mapping) {
			ajaxDelete(mainUrl + mapping.id(), 
			function() {
				mapping.remove();
			});
		});
	ajaxGet(mainUrl, function(data) {
		$.each(data, function(i, object){
			list.add(object);
		});
	});
	new Form(mainUrl, $div.find('.form'), fields, function(received) {
		list.add(received);
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

Mapping.prototype.element = function() {
	return this.$element;
}

function List($list, fields, template, onAdd, onSave, onDelete) {
	var self = this;
	this.$list = $list;
	this.template = template;
	this.onAdd = onAdd;
	this.onSave = onSave;
	this.onDelete = onDelete;
	this.fields = fields;
}

List.prototype.add = function(object) {
	var self = this;
	var getWrapper = function(element) {
		return new Mapping($(element).closest('.wrapper'), self.fields);
	}
	var deleteHandler = function() {
		var mapping = getWrapper(this);
		self.onDelete(mapping);
	}
	var goToEditMode = function() {
		getWrapper(this).editMode();
	}
	var cancelEditMode = function() {
		getWrapper(this).noeditMode();
	}
	var saveHandler = function() {
		var mapping = getWrapper(this);
		self.onSave(mapping);
		mapping.noeditMode();
	}
	var rendered = Mustache.render(this.template, object)
	this.$list.append(rendered);
	var $appended = this.$list.children().last();
	$appended.find('.remove-button').click(deleteHandler);
	$appended.find('.edit-button').click(goToEditMode);
	$appended.find('.cancel-edit-button').click(cancelEditMode);
	$appended.find('.save-edit-button').click(saveHandler);
	this.onAdd($appended);
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