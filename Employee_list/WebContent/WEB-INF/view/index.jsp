<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Employee"%>
<% ArrayList<Employee> list = (ArrayList<Employee>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>社員一覧</h1>
	<form action="./IndexController" method="get">
		<input type="text" name="keyword"> 
		<input type="submit" value="検索">
	</form>
	<table border=1>
		<tr>
			<td>社員ID</td>
			<td>社員名</td>
			<td>年齢</td>
			<td>住所</td>
			<td>入社年月日</td>
		</tr>
		<% for (int i = 0; i < list.size(); i++) { %>
		<tr>
			<td><%=list.get(i).getEmployeeId()%></td>
			<td><a href="/employee-list/employee/<%=list.get(i).getEmployeeId()%>" name="employeeId"><%=list.get(i).getEmployeeName()%></a></td>
			<td><%=list.get(i).getAge()%></td>
			<td><%=list.get(i).getAddress()%></td>
			<td><%=list.get(i).getDate()%></td>
			<%-- <td>
					<a href="/Subject_1004/Update?id=<%=employee.getID()%>">更新</a>
					<a href="/Subject_1004/Delete?id=<%=employee.getID()%>">削除</a>
					<a href="/employee-list/IndexController/<%= list.get(i).getEmployeeId() %>">
				</td> --%>
		</tr>
		<% } %>
	</table>
</body>
</html>