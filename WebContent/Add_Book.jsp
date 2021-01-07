<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="add-ctrl" method = "post">
		Tên sách:	<input type="text" placeholder="Nhập tên sách"  name="nameb"> <br>
		Tác giả:	<input type="text" placeholder="Nhập tên tác giả"  name="authorb"> <br>
		Giá:		<input type="text" placeholder="Nhập giá sách" name="priceb"> <br>
		Số trang:	<input type="text" placeholder="Nhập số trang sách"  name="numberb"> <br>
		Cân nặng: 	<input type="text" placeholder="Nhập cân nặng của sách"  name="weightb"> <br>
		Năm xuất bản: <input type="text" placeholder="Nhập năm xuất bản"  name="yearb"> <br>
		Tóm tắt nội dung: <input type="text" placeholder="Nhập tóm tắt nội dung sách"  name="summaryb"> <br>
		Thể loại sách: <input type="text" placeholder="Nhập thể loại sách"  name="categoryb"> <br>
		Tình trạng: <input type="text" placeholder="Nhập tình trạng của sách trong kho"  name="statusb"> <br>
		<input type="submit" value="button">
	</form>
</body>
</html>