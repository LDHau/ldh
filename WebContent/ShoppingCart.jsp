<%@page import="java.util.ArrayList"%>
<%@page import="bean.ShoppingCartBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Shopping Cart</title>
</head>
<body>
	<% ArrayList<ShoppingCartBean> aryShoppingCart = (ArrayList<ShoppingCartBean>) request.getAttribute("lss"); %>
	<% for(ShoppingCartBean scb: aryShoppingCart) { %>
	<%=scb.getStrIdCustomers() %> <br>
	<%=scb.getIntCartNo() %><br>
	<%=scb.getIntIdBook() %><br>
	<%=scb.getIntUnitPrice() %><br>
	<%=scb.getIntQuantity() %><br>
	<%=scb.getStrDiscountCode() %><br>
	Total = <%=scb.getIntUnitPrice() %> * <%=scb.getIntQuantity() %><br>
	<%} %>
</body>
</html>