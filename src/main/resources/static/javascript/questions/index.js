$(function() {
	var qName = "questions";
	var qUrl = 'api/' + qName + '/';
	var qFields = ['title','content'];
	var qTemplate = $('#' + qName + '-template').html();

	new ListAndForm($('#' + qName), qUrl, qFields, qTemplate, function($element) {});

	var tName = "tasks";
	var tUrl = 'api/' + tName + '/';
	var tFields = ['title'];
	var tTemplate = $('#' + tName + '-template').html();

	new List(tUrl, $('#' + tName).find(".list"), tFields, tTemplate, function($element) {});
});