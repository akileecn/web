<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<c:url var="doLoginUrl" value="/user/doLogin.do"/>
	<span>${error}</span>
	<form action="${doLoginUrl}" method="post">
		<label for="username">用户名:</label><input type="text" name="username"/><br/>
		<label for="password">密码:</label><input type="password" name="password"/><br/>
		<input type="submit" value="登录"/>
		<input type="button" value="注册"/>
	</form>
</body>
</html>