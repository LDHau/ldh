<%@page import="bean.BookBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>EDIT BOOK</title>
</head>
<body>
	<% BookBean beanBook = (BookBean) request.getAttribute("lsbid");%>	
	<form action="manage-edit" method = "post">
		ID sách:	<input type="text" placeholder="Nhập ID sách" value="<%=beanBook.getIntIdBook()%>" name="idbook">
		Tên sách:	<input type="text" placeholder="Nhập tên sách" value="<%=beanBook.getStrName()%>" name="nameb"> <br>
		Tác giả:	<input type="text" placeholder="Nhập tên tác giả" value="<%=beanBook.getStrAuthor()%>" name="authorb"> <br>
		Giá:		<input type="text" placeholder="Nhập giá sách"    value="<%=beanBook.getIntAmount()%>" name="amountb"> <br>
		Số trang:	<input type="text" placeholder="Nhập số trang sách" value="<%=beanBook.getIntNumberPages()%>" name="numberb"> <br>
		Cân nặng: 	<input type="text" placeholder="Nhập cân nặng của sách" value="<%=beanBook.getFloWeight()%>" name="weightb"> <br>
		Năm xuất bản: <input type="text" placeholder="Nhập năm xuất bản" value="<%=beanBook.getIntPublishingYear()%>" name="yearb"> <br>
		Tóm tắt nội dung: <input type="text" placeholder="Nhập tóm tắt nội dung sách" value="<%=beanBook.getStrSummary()%>" name="summaryb"> <br>
		Thể loại sách: <input type="text" placeholder="Nhập thể loại sách" value="<%=beanBook.getStrIdCategory()%>" name="categoryb"> <br>
		Tình trạng: <input type="text" placeholder="Nhập tình trạng của sách trong kho" value="<%=beanBook.getStrStatus()%>" name="statusb"> <br>
		<input type="submit" value="button">
	</form>
</body>
</html>