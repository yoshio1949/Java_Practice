<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Integer count = (Integer)request.getAttribute("textCount"); %>
	<h1>下のテキストの長さを表示します</h1>
	<form method="post" action="./CountLength">
		<textarea name="phrase" rows="4" cols="60">テキストを入力してください</textarea>
		<input type="submit" value="送信">
	</form>
	<% if (count != null ) {%>
	<h2>テキストの長さは <%=count %> です!!!</h2>
	<% } %>
</body>
</html>