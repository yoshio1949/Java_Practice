<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<style type="text/css">
    *{padding:5px; margin:0px;}
    body{text-align:center;}
    table{width:800px; background:white; border:2px black solid; border-collapse:collapse; margin:auto;}
    th{border:1px black solid; background:#CCFFFF;}
    td{border:1px black solid; text-align:right; padding:5px 20px 5px 20px;}
    br{line-height:1em;}
</style>
<head>
<meta charset="UTF-8">
<title>カレンダー</title>
</head>
<body>
	<h3><%= request.getAttribute("year") %>年<%= request.getAttribute("month") %>月のカレンダー</h3>
	<br/>
	<br/>
	<%= request.getAttribute("calendar") %>
	<br/>
	<div style="text-align:center;">
		<form action="CalendarAccess" method="get">
			<select id="year" name="year">
			<%
				int year = Integer.parseInt(request.getAttribute("year").toString());
				int month = Integer.parseInt(request.getAttribute("month").toString());
				for (int i = year-10; i <= year+10; i++) {
			%>
				<option value="<%=i %>">
					<% if (i == year) { %>
					=>
					<% } %>
					<%=i %>
					年
				</option>
			<% } %>
			</select>
			<select id="month" name="month">
			<%
				for (int i = 1; i <= 12; i++) {
			%>
				<option value="<%=i %>">
					<% if (i == month) { %>
					=>
					<% } %>
					<%=i %>
					月
				</option>
			<% } %>
			</select>
			<br/>
			<br/>
			<input type="submit" id="ok" name="ok" value="送信">
		</form>
	</div>
</body>
</html>