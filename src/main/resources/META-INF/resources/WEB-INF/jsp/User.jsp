<!DOCTYPE html>
<html lang="en">
<head>
<title>User Details</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/api-call.js"></script>
</head>
<body>
	<h3>Add User Details</h3>
	<table>
		<tr>
			<th>Name</th>
			<td><input type="text" id="name" required></td>
		</tr>
		<tr>
			<th>Date of birth</th>
			<td><input type="text" id="dob" required><span>dd-mmm-yyyy</span></td>
		</tr>
		<tr>
			<th>Account Number</th>
			<td><input type="text" id="accountNumber" required></td>
		</tr>
		<tr>
			<td><input type="button" value="submit" id="save-user"></td>
			<td><input type="button" value="reset" id="reset-user"></td>
		</tr>
	</table>
	<script>
		$("#save-user").click(function() {
			var name = $('#name').val();
			var dob = $('#dob').val();
			var accountNumber = $('#accountNumber').val();
			if (name == '' || dob == '' || accountNumber == '') {
				alert('Please Enter Valid Details')
			} else {
				saveUserDetails(name, dob, accountNumber);
			}
		});
	</script>
</body>
</html>