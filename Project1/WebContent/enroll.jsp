<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enroll</title>
</head>
<body>
<form action="./enrollClassServlet" method="post">
<label for="course">Courses:</label>
<select name="course" id="course">
	${courseList}
	</select>
<label for="grade">Grade:</label>
<select name="grade" id="grade">
	<option value = "A">A</option>
	<option value = "B">B</option>
	<option value = "C">C</option>
	<option value = "D">D</option>
	<option value = "F">F</option>
</select>
<button type="submit">Enroll</button>
<button type="submit" formaction="./dropServlet">Drop</button>
</form>
<a href="./myRegist.jsp"><button>Exit</button></a>
</body>
</html>