<%@page import="java.util.ArrayList"%>
<%@page import="bean.OrderDetailBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Shopping Cart</title>
</head>
<body>

	<% ArrayList<OrderDetailBean> aryOrderDetail = (ArrayList<OrderDetailBean>) request.getAttribute("OrderBook");%>
	<% for(OrderDetailBean detail: aryOrderDetail) {%>
	<%=detail.getStrNameBook() %> <br>
	<%=detail.getIntPriceBook() %><br>
	<%=detail.getIntQuantity() %><br>
	<%=detail.getStrDiscountCode() %><br>
	<%=detail.getIntIntoMoney() %><br>
	<%} %>
	<a href="list-book">List Book</a>

</body>
</html>