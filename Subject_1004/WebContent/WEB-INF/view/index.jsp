<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<% ArrayList<String[]> list = (ArrayList<String[]>)request.getAttribute("data"); %>
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
	
	<table border=1>
		<tr>
			<td>社員ID</td>
			<td>社員名</td>
			<td>年齢</td>
			<td>住所</td>
			<td>入社年月日</td>
		</tr>
		<%
			for (int i = 0; i < list.size(); i++) {
				String[] data = list.get(i);
				out.print("<tr><td>" + data[0] + "</td>"); //社員ID
				out.print("<td>" + data[1] + "</td>"); //社員名
				out.print("<td>" + data[2] + "</td>"); //年齢
				out.print("<td>" + data[3] + "</td>"); //住所
				out.print("<td>" + data[5] + "</td>"); //入社年月日
			}
		%>
	</table>
</body>
</html>