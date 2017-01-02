$(function() {
	var name = "questions";
	var mainUrl = 'api/' + name + '/';
	var fields = ['title','content'];
	var template = $('#' + name + '-template').html();

	new ListAndForm($('#' + name), mainUrl, fields, template, function($element) {});
});