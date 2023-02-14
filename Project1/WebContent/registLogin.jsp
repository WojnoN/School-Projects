<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Page</title>
<style>
	table{
		border-collapse:collapse;
		margin-left:5%;
	}
	span{
		color:red;
		margin-left:5%;
	}
	td, th{
		padding:5px;
	}
	th{
		font-weight:bold;
	}
</style>
</head>
<body>
<form action="./loginSSNServlet" method="post">
	<table border="1">
		<tr>
			<th colspan="2">USER LOGIN</th>
		</tr>
		<tr>
			<td>SSN:</td>
			<td><input type="text" name="ssn" maxlength="9"/></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:center"><input type="submit" value="SUBMIT"/></td>
		</tr>
	</table>
</form>
</body>