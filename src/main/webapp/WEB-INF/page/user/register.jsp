<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<c:url value="/resources/jquery/jquery-1.12.3.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jquery/jquery.form.js" />"></script>
<title>注册</title>
</head>
<body>
	<form id="form" action="<c:url value="/user/register"/>" method="POST" enctype="multipart/form-data">
		<c:if test="${not empty message}">
			<div id="message" class="success">${message}</div>	  		
  		</c:if>
		<label for="file">头像</label>
		<input id="file" type="file" name="file" /><br/>
		<label for="username">用户名:</label>
		<input type="text" name="username"/><br/>
		<label for="password">密码:</label>
		<input type="password" name="password"/><br/>
		<input type="submit" value="注册"/>
	</form>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		$("#form").ajaxForm({
			success:function(text){
				if(text){
					alert(text.message);
				}
			}
		});
	});
</script>
</html>