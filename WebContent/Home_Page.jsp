<%@page import="bean.CategoryBean"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>HOME PAGE</title>
</head>
<body>

	<% ArrayList<CategoryBean> aryCate = (ArrayList<CategoryBean>) request.getAttribute("cary"); %>
	<% for(CategoryBean ca: aryCate ) {%>
	ID loại sách: <%=ca.getStrIdCategory()%>
	Tên loại sách: <%=ca.getStrNameCategory() %> 
	<a href="list-book?idcate=<%=ca.getStrIdCategory()%>">Danh sách</a><br>
	<%} %>
	<br>
	<a href="add-ctrl">Thêm sách</a>
	<br>
	<form action="#">
		<input type="text" placeholder="Nhap ten sach">
		<input type="submit" value="button">
	</form>
</body>
</html>