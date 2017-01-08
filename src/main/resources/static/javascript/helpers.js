function ListAndForm($div, mainUrl, fields, template, onAdd) {

	var list = new List($div.find('.list'), template, 
		function($element) {
			var identity = new Identity($element);
			var mapping = new Mapping($element, fields, 'span');
			new Editable($element, fields, 
					function(editable) {
						editable.set(mapping.data())
					},
					function(data) {
						ajaxPut(mainUrl + identity.id(), 
								data, 
								function(received) {
									mapping.set(received);
								});
					});
			onAdd($element);
		},
		function($wrapper) {
			var identity = new Identity($wrapper);
			ajaxDelete(mainUrl + identity.id(), 
			function() {
				$wrapper.remove();
			});
		});

	ajaxGet(mainUrl, function(data) {
		$.each(data, function(i, object){
			list.add(object);
		});
	});
	new Form($div.find('.form'), fields, function(data) {
		ajaxPost(mainUrl, data, function(received) {
			list.add(received);
		});
	});
}

function Editable($element, fields, onStartEdit, onSaveEdit) {
	var that = this;
	this.$element = $element;
	this.fields = fields;
	this.onStartEdit = onStartEdit;
	this.onSaveEdit = onSaveEdit;
	this.findInput = function(field) {
		return that.$element.find('input.' + field).first();
	}
	this.setInput = function(field, value) {
		that.findInput(field).val(value);
	}
	$element.find('.edit-button').click(function() {
		that.editMode();
	});
	$element.find('.cancel-edit-button').click(function() {
		that.noEditMode();
	});
	$element.find('.save-edit-button').click(function() {
		that.saveEdit();
	});
}

Editable.prototype.editMode = function() {
	var that = this;
	that.onStartEdit(that);
	that.$element.addClass('edit');
}

Editable.prototype.set = function(data) {
	for (var field in data)
		this.setInput(field, data[field]);
}

Editable.prototype.data = function() {
	var that = this;
	var data = {};
	$.each(this.fields, function(i, field) {
		data[field] = that.findInput(field).val();
	});
	return data;
};

Editable.prototype.noEditMode = function() {
	this.$element.removeClass('edit');
}

Editable.prototype.saveEdit = function() {
	var that = this;
	that.onSaveEdit(that.data())
	that.noEditMode();
}

function Mapping($element, fields, tag) {
	this.$element = $element;
	this.fields = fields;
	this.findSpan = function(field) {
		return this.$element.find(tag + '.' + field).first();
	}
}

Mapping.prototype.data = function() {
	var self = this;
	var data = {};
	$.each(this.fields, function(i, field) {
		data[field] = self.val(field);
	});
	return data;
};

Mapping.prototype.val = function(field) {
	return this.findSpan(field).html();
}

Mapping.prototype.set = function(object) {
	var self = this;
	$.each(this.fields, function(i, field) {
		self.findSpan(field).html(object[field]);
	});
}

function Identity($element) {
	this.$element = $element;
}

Identity.prototype.id = function() {
	return this.$element.attr('data-id');
}

function List($list, template, onAdd, onDelete) {
	var self = this;
	this.$list = $list;
	this.template = template;
	this.onAdd = onAdd;
	this.onDelete = onDelete;
}

List.prototype.add = function(object) {
	var self = this;
	var getWrapper = function(element) {
		return $(element).closest('.wrapper');
	}
	var deleteHandler = function() {
		var $wrapper = getWrapper(this);
		self.onDelete(getWrapper(this));
		$wrapper.closest('li').remove();
	}
	var rendered = Mustache.render(self.template, object)
	this.$list.append(rendered);
	var $appended = this.$list.children().last();
	$appended.find('.remove-button').click(deleteHandler);
	this.onAdd($appended);
};

function Form($form, fields, onSubmit) {	
	var mapping = new Editable($form, fields, function() {}, function() {});
	$form.find('.add-button').on('click', function() {
		console.log(mapping.data());
		onSubmit(mapping.data());
	});
}