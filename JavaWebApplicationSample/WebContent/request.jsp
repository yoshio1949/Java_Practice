<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method='get' action='HelloServlet'>
		<!-- textNameという名前でテキストをサーバーに送る -->
		<p><input type="text" name="nowHour">:<input type="text" name="nowMinute"></p>
		<!-- サーバーにデータを送るためのボタン -->
		<input type="submit" value="送信">
	</form>
</body>
</html>