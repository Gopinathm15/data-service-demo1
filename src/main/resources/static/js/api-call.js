function saveUserDetails(name, dob, accountNumber) {
	var requestData = {
		'name' : name,
		'dob' : dob,
		'accountNumber' : accountNumber
	};

	$.ajax({
		url : 'http://localhost:8080/user-service/add',
		type : 'POST',
		dataType : 'json',
		data : JSON.stringify(requestData),
		contentType : 'application/json',
		success : function(response) {
			if (response.status == "SUCCESS")
				alert('SUCCESS');
			// else
			// alert(response:response.error);
		},
		error : function(error) {
			alert('Something went wrong! Please try after some time');
		}
	});
}

function saveFileData(name, content, type) {
	var requestData = {
		'name' : name,
		'content' : content,
		'type' : type
	};

	$.ajax({
		url : 'http://localhost:8080/file-service/add',
		type : 'POST',
		dataType : 'json',
		data : JSON.stringify(requestData),
		contentType : 'application/json',
		success : function(response) {
			if (response.status == "SUCCESS")
				alert('Successfully uploaded file');
			// else
			// alert(response:response.error);
		},
		error : function(error) {
			alert('Something went wrong! Please try after some time');
		}
	});
}
