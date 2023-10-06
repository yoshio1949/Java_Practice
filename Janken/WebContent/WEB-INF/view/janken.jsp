<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>じゃんけんゲーム</title>
</head>
<body>

	<h1>じゃんけんゲーム！！</h1>
	<h2>最初はぐー！じゃんけんっ！！</h2>
	<form method="post" action="./Janken">
		<input type="radio" id="0" name="syoubu" value="0" checked><label for="0">グー</label>
		<input type="radio" id="1" name="syoubu" value="1"><label for="1">チョキ</label>
		<input type="radio" id="2" name="syoubu" value="2"><label for="2">パー</label>
		<input type="submit" value="勝負!!">
	</form>
	<% String chand = (String) request.getAttribute("chand"); %>
	<% String result = (String) request.getAttribute("result"); %>
	<%if (chand != null) { %>
	<h3>相手は ${chand}</h3>
	<h2>${result }</h2>
	<% } %>
</body>
</html>