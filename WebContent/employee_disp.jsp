<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.EmployeeDispBean" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BeanStartWebApp</title>
</head>
<body>
従業員情報を表示します<br>

<%=bean.getEmployeeID() %> <br>
<%=bean.getEmployeeName() %> <br>
<%=bean.getHeight() %> <br>
<%=bean.geteMail() %> <br>
<%=bean.getWeight() %> <br>
<%=bean.getHireFiscalYear() %> <br>
<%=bean.getBirthday() %> <br>
<%=bean.getBloodType() %>

</body>
</html>