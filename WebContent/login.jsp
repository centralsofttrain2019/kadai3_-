<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.LoginBean" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ID入力画面</title>
</head>
<body>
ログイン情報 <%=bean.getLoginInfo() %>

<form  method="POST" action="EmployeeDispServlet">
従業員のIDを入力してください。<br>
	ID<input name="id" type="text" ><br>

	<input type="submit" value="IDでの検索">
</form>
<form  method="POST" action="EmployeeListDispServlet">
	<input type="submit" value="全従業員表示">
</form>

</body>
</html>