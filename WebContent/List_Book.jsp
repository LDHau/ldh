<%@page import="bean.BookBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>LIST BOOK</title>
</head>
<body>
	<% ArrayList<BookBean> aryBook = (ArrayList<BookBean>) request.getAttribute("ltb"); %>
	<% int count = 1; for(BookBean bo: aryBook) { %>
	<%=count %> <br>
	Tên sách:	<%=bo.getStrName() %> <br>
	Giá tiền:	<%=bo.getIntPrice() %> <br>
	<%count++; %>
	<a href="book-detail-ctrl?idb=<%=bo.getIntIdBook()%>">Detail Book</a><br>
	<a href="edit-ctrl?idb=<%=bo.getIntIdBook()%>">EDIT</a> <br>
	<a href="del-ctrl?idb=<%=bo.getIntIdBook()%>">DELETE</a> <br>

	<%} %>
---------------------------------------------------	<br>
	
	<br>
	<a href="home-page">Trang chủ</a>
</body>
</html>