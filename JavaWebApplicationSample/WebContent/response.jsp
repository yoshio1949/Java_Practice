<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
// サーブレットから送られてきたテキストを受け取る
String nowHour = (String)request.getAttribute("nowHour");
String nowMinute = (String)request.getAttribute("nowMinute");
String afterHour = (String)request.getAttribute("afterHour");
String afterMinute = (String)request.getAttribute("afterMinute");
%>
<body>
	<!-- 画面に表示する -->
	<p>退勤時刻 <%=nowHour %>:<%=nowMinute %></p>
	<p>帰宅時刻 <%=afterHour %>:<%=afterMinute %></p>
</body>
</html>