<%@page import="bean.CustomerBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<% ArrayList<CustomerBean> aryCus = (ArrayList<CustomerBean>) request.getAttribute("ListCus"); %>
	<% for (CustomerBean cus :aryCus) { %>
	<%=cus.getStrName() %> <br>
	<%=cus.getIntPhone() %><br>
	<%=cus.getStrEmail() %><br>
	<%=cus.getStrPass() %><br>
	<%} %>
</body>
</html>