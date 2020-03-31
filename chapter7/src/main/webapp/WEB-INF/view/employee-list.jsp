<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
    <title>Employee List</title>
</head>
<body>
<div align="center">
    <h1 style="background-color: lightgreen; color:darkgreen">Employee List</h1>
    <h2>
        <a href="${pageContext.request.contextPath}/employee/addEmployee" >Add Employee</a>
    </h2>
    <table cellspacing="0" cellpadding="6" border="1">
        <tr bgcolor="grey" style="color: white">
            <th>No</th>
            <th><spring:message code="employee.first.name" text="default" /></th>
            <th><spring:message code="employee.last.name" text="default" /></th>
            <th><spring:message code="employee.job.title" text="default" /></th>
            <th><spring:message code="employee.department" text="default" /></th>
            <th><spring:message code="employee.salary" text="default" /></th>
            <th><spring:message code="details" text="default" /></th>
            <th><spring:message code="delete" text="default" /></th>
        </tr>
        <c:forEach var="employee" items="${employees}" varStatus="status">
            <tr bgcolor="lightyellow">
                <td>
                    <b>${status.index + 1}</b>
                </td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.jobTitle}</td>
                <td>${employee.department}</td>
                <td>${employee.salary}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/employee/${employee.id}">
                        <spring:message code="details" text="default" />
                    </a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/employee/delete?id=${employee.id}">
                        <spring:message code="delete" text="default" />
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout" />
    </form:form>
    </p>
</div>
</body>
</html>