<!DOCTYPE html>
<html lang="en">
<head>
<title>File Upload</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="${pageContext.request.contextPath}/js/api-call.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>
	<h3>Upload File</h3>
	<form onsubmit="return false">
		<input type="file" id="file" required> <input type="submit" id="submit"
			value="submit" onclick="sentFileData()"> <input type="reset"
			id="reset" value="reset">
	</form>
	<script type="text/javascript">
		function sentFileData() {
			var file = document.querySelector('#file').files[0];
			var reader = new FileReader();
			reader.readAsDataURL(file);
			reader.onload = function() {
				saveFileData(file.name, reader.result, file.type);
			};
			reader.onerror = function(error) {
				alert('Please select valid file');
				console.log('Error: ', error);
			};

		}
	</script>
</body>
</html>