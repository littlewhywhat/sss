function ajaxDelete(url, success) {
	$.ajax({
			type: 'DELETE',
			url: url,
			success: function() {
				success();
			},
			error: function(status) {
				console.log(status);
			}
		});
}

function ajaxGet(url, container) {
	$.ajax({
			type: 'GET',
			url: url,
			success: function(data) {
					$.each(data, function(i, object){
						container.add(object);
					});
				},
			error: function(status) {
				console.log(status);
			}
		});
}

function ajaxPost(url, tosend, success) {
	$.ajax({
			type: 'POST',
			url: url,
			data: JSON.stringify(tosend),
			contentType: 'application/json',
			dataType: 'json',
			success: function(received) {
				success(received)
			},
			error: function(status) {
				console.log(status);
			}
	});
}

function ajaxPut(url, tosend, success) {
	$.ajax({
			type: 'PUT',
			url: url,
			data: JSON.stringify(tosend),
			contentType: 'application/json',
			dataType: 'json',
			success: function(received) {
				success(received);
			},
			error: function(status) {
				console.log(status);
			}
	});
}