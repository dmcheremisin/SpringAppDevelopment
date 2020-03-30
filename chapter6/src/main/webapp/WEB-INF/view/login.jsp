<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<h2 style="color: orange">Login to Employee CRM</h2>

<c:if test="${loginFailed}">
    <div style="color:red">
        <p>Login failed. Please, verify your credentials</p>
    </div>
</c:if>
<c:if test="${logoutSuccess}">
    <div style="color:green">
        <p>You successfully logged out.</p>
    </div>
</c:if>


<form:form method="POST" action="/login">

    <table frame="box" cellpadding="0" cellspacing="6">
        <tr>
            <td>Username:</td>
            <td><input type='text' name='username'/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password'></td>
        </tr>
        <tr>
            <td colspan='2'>
                <input name="submit" type="submit" value="Submit">
            </td>
        </tr>
    </table>

</form:form>

</body>
</html>