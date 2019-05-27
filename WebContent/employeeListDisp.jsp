<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.EmployeeListDispBean" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>全従業員表示画面</title>
</head>
<body>
<strong> 従業員情報</strong>
<table>
<tr>
 <td>EmployeeID </td>
 <td>EmployeeName </td>
 <td>Height </td>
 <td>Weight</td>
 <td>HireFiscalYear</td>
 <td>Birthday</td>
 <td>BloodType</td>
</tr>


<% for( bean.EmployeeDispBean rb: bean.getEmpList() ){%>
<tr>
 <td> <%=rb.getEmployeeID() %> </td>
 <td> <%=rb.getEmployeeName() %> </td>
 <td>  <%=rb.getHeight() %> </td>
 <td> <%=rb.getWeight() %> </td>
 <td> <%=rb.getHireFiscalYear() %> </td>
 <td>  <%=rb.getBirthday() %> </td>
 <td>  <%=rb.getBloodType() %> </td>
</tr>
<%}%>

</table>
</body>
</html>