<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Employee details</title>
</head>
<body>
<h1 style="color: green; text-align: center;">Employee details</h1>

<table align="center" border="1">
    <tr>
        <td><b style="color: brown">Language</b></td>
        <td><a href="?lang=en">English</a>|</td>
        <td><a href="?lang=ru">Russian</a></td>
    </tr>
</table>

<h2 style="color: orange; text-align: center;">
    <spring:message code="employee.first.name" text="default text" />: ${employee.firstName}
</h2>
<h2 style="color: orange; text-align: center;">
    <spring:message code="employee.last.name" text="default text" />: ${employee.lastName}
</h2>

</body>
</html>