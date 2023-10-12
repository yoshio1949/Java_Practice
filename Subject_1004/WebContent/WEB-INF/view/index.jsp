<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String userName = (String) request.getAttribute("userName"); %>
	<% if (userName != null && userName != "") { %>
	<%= userName %> さん、こんにちは！
	<% } else {%>
	<form method="post" action="./HelloServlet">
		名前を入力してください： <input type="text" name="name">
		<button type="submit">送信</button>
	</form>	
	<% } %>
	<% List<String> employeeName = (List<String>)request.getAttribute("employeeName"); %>
	
	<h3>社員名</h3>
	<% for (String name: employeeName) { %>
		<%= name %><br>
	<% } %>
</body>
</html>