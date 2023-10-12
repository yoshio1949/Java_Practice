<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Memo</title>
</head>
<body>
	<h2>Memo</h2>
	メモをつける
	<form method="post" action="./CreateMemo">
		<input type="text" name="memo">
		<input type="submit">
	</form>
	<h2>Memo</h2>
	<% List<String> list = new ArrayList<String>(); %>
	<% list = (List<String>)request.getAttribute("list"); %>
	<% if (list != null) { %>
    	<% for (String str : list) { %>
        	<%= str %><br>
    	<% } %>
    <% } else { %>
    	何もないよ
    	<% request.setAttribute(name, o) %>>
    <% } %>
</body>
</html>