<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>
	<title>Index page</title>
</head>

<body>
<h1 style="color: green; text-align: center;">Welcome to the Main Page</h1>

<table align="center" border="1">
	<tr>
		<td><b style="color: brown">Language</b></td>
		<td><a href="?lang=en">English</a>|</td>
		<td><a href="?lang=ru">Russian</a></td>
	</tr>
</table>

<table align="center" cellspacing="10">
	<tr style="color: blue; font-style: italic; font-size:14pt">
		<td align="left">Click Here</td>

		<td align="right" bgcolor="lightgreen">
			<a href="${pageContext.request.contextPath}/employee">List Of Employees</a>
		</td>

	</tr>
</table>

</body>

</html>









