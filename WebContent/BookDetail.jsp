<%@page import="bean.BookBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Book Detail</title>
</head>
<body>
	<% BookBean beanBook = (BookBean) request.getAttribute("BookDetail");%>	
	<form action="order-detail-ctrl" method = "post">
		ID sách:	<input type="text" value="<%=beanBook.getIntIdBook()%>" name="idbook">
		Tên sách:	<input type="text" value="<%=beanBook.getStrName()%>" name="nameb"> <br>
		Tác giả:	<input type="text" value="<%=beanBook.getStrAuthor()%>" name="authorb"> <br>
		Giá:		<input type="text" value="<%=beanBook.getIntPrice()%>" name="priceb"> <br>
		Số trang:	<input type="text" value="<%=beanBook.getIntNumberPages()%>" name="numberb"> <br>
		Cân nặng: 	<input type="text" value="<%=beanBook.getFloWeight()%>" name="weightb"> <br>
		Năm xuất bản: <input type="text" value="<%=beanBook.getIntPublishingYear()%>" name="yearb"> <br>
		Tóm tắt nội dung: <input type="text" value="<%=beanBook.getStrSummary()%>" name="summaryb"> <br>
		Thể loại sách: <input type="text" value="<%=beanBook.getStrIdCategory()%>" name="categoryb"> <br>
		Số lượng: <input type="number" value=1 name="quantilyb">
		
		<input type="hidden" value="<%=(String)session.getAttribute("idlogin") != null ? "1" : null %>" name="idordersb">
		
		<input type="submit" value="ADD TO CART">
	</form>
</body>
</html>