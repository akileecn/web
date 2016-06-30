<@bootstrap.head>
<title>用户列表页</title>
</@bootstrap.head>
<@bootstrap.body>
<div class="container">
	<table class="table">
		<tr><th>编号</th><th>姓名</th><th>密码</th></tr>
		<#list page as user>
		<tr><td>${user?index+1}</td><td>${user.username}</td><td>${user.password}</td></tr>
		</#list>
		<tr><td colspan="3">共${page?size}条</td></tr>
	</table>
	<form action="<@spring.url "/user/test"/>">
		名称<input type="text" name="roles[0].name" />备注<input type="text" name="roles[0].remark" /></br>
		名称<input type="text" name="roles[1].name" />备注<input type="text" name="roles[1].remark" />
		<input type="submit" value="提交"/>
	</form>
</div>
</@bootstrap.body>