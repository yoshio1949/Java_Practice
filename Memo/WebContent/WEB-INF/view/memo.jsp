<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<% ArrayList<String[]> list = (ArrayList<String[]>)request.getAttribute("data"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>7ちゃんねる</title>
</head>
<body style="width:800px;margin:auto;">
	<h2>７ちゃんねる</h2>
	<form method="post" action="./CreateMemo">
		<input type="text" name="memo_text">
		<input type="submit" value="投稿">
	</form>
	<%
		for (int i = 0; i < list.size(); i++) {
			String[] data = list.get(i);
			out.print(data[0] + ". create_at:" + data[2] + "<br>");
			out.print( data[1] + "<br><br>");
		}
	%>
</body>
</html>