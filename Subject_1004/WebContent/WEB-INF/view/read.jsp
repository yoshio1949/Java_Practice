<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<% List<Employee> list = (List<Employee>)request.getAttribute("list") %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/Subject_1004/Create">新規登録</a>
	<% if(list != null && list.size() > 0){ %>
		<table border=1>
			<tr>
				<td>社員ID</td>
				<td>社員名</td>
				<td>年齢</td>
				<td>住所</td>
				<td>入社年月日</td>
			</tr>
			<% for(Employee p:list){ %>
			<tr>
				<td><%= p.getId() %></td>
				<td><%= p.getName() %></td>
				<td><%= p.getAge() %></td>
				<td><%= p.getAddress() %></td>
				<td><%= p.getDate() %></td>
				<td>
					<a href="/Subject_1004/Update?id=<%=p.getID()%>">更新</a>
					<a href="/Subject_1004/Delete?id=<%=p.getID()%>">削除</a>
				</td>
			</tr>
			<% } %>
		</table>
	<% } %>
</body>
</html>