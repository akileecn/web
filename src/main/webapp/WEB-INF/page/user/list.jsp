<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User list</title>
</head>
<body>
	用户列表页<br/>
	<table>
		<tr><th>编号</th><th>姓名</th><th>密码</th></tr>
	<c:forEach items="${page}" var="user" varStatus="status">
		<tr><td>${status.index}</td><td>${user.username}</td><td>${user.password}</td></tr>
	</c:forEach>
		<tr><td colspan="3">共${total}条</td></tr>
	</table>
</body>
</html>