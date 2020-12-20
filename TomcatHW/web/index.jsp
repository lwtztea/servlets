<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form name="loginForm" method="post" action="">
    Username: <input type="text" name="username"/> <br/>
    Password: <input type="password" name="password"/> <br/>
    <input type="submit" value="Login"/>
    <a href="${pageContext.request.contextPath}/registration.jsp">or register</a>
</form>
</body>
</html>
