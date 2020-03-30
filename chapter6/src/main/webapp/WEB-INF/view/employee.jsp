<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Add Employee</title>
</head>
<body>
<div align="center">
    <h1 style="background-color: lightgreen; color:darkgreen">Add New Employee Page</h1>
</div>

<div align="center">
    <table cellspacing="0" cellpadding="6" border="1" widht="60%">
        <tr>
            <td colspan="8" style="background-color: lightblue; color:darkgreen; font-size: 16pt" align="center">Employee Information</td>
        </tr>
        <tr>
            <td>
                <form:form method="POST" action="/employee" modelAttribute="employeeCommand" >
                    <form:hidden path="id"/>

                    <table widht="100%">
                        <tr>
                            <td>
                                <form:label path="firstName">
                                    <spring:message code="employee.first.name" text="default" />
                                </form:label>
                            </td>
                            <td align="left" width="70%">
                                <form:input path="firstName"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="lastName">
                                    <spring:message code="employee.last.name" text="default" />
                                </form:label>
                            </td>
                            <td align="left">
                                <form:input path="lastName"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="jobTitle">
                                    <spring:message code="employee.job.title" text="default" />
                                </form:label>
                            </td>
                            <td align="left">
                                <form:input path="jobTitle"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="department">
                                    <spring:message code="employee.department" text="default" />
                                </form:label>
                            </td>
                            <td align="left">
                                <form:input path="department"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="salary">
                                    <spring:message code="employee.salary" text="default" />
                                </form:label>
                            </td>
                            <td align="left">
                                <form:input path="salary"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" value="Submit"/></td>
                        </tr>
                    </table>
                </form:form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
