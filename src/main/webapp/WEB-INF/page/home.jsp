<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>主页</title>
	</head>
<body>
	主页<a href='<c:url value="/user/login"/>'>登录</a><a href='<c:url value="/user/register"/>'>注册</a>
</body>
</html>