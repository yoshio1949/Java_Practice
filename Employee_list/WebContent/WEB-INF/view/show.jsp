<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Employee"%>
<% ArrayList<Employee> list = (ArrayList<Employee>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員詳細</title>
</head>
<body>
	<h1>社員詳細</h1>
	<form action="./ShowController" method="post">
	<table border=1>
		<% for (int i = 0; i < list.size(); i++) { %>
			<tr><th>社員ID</th><td><%=list.get(i).getEmployeeId()%></td></tr>
			<tr><th>社員名</th><td><input type="text" value="<%=list.get(i).getEmployeeName()%>"></td></tr>
			<tr><th>年齢</th><td><%=list.get(i).getAge()%></td></tr>
			<tr><th>住所</th><td><input type="text" value="<%=list.get(i).getAddress()%>"></td></tr>
			<tr><th>入社年月日</th><td><%=list.get(i).getDate()%></td></tr>
		<% } %>
	</table>
	<input type="submit" value="更新">
	</form>
</body>
</html>