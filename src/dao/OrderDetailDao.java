package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.OrderDetailBean;
import connection.Connect;

public class OrderDetailDao {
	public ArrayList<OrderDetailBean> getOrderDetail() throws Exception {
		ArrayList<OrderDetailBean> aryOrderDetail = new ArrayList<OrderDetailBean>();
		OrderDetailBean beanOrderDetail = null;
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		String sql = "SELECT * FROM order_detail";
		PreparedStatement ps = cn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
				
		while(rs.next()) {
			int intIdBook = rs.getInt("id_book");
			String strNameBook = rs.getString("name_book");
			int intPriceBook = rs.getInt("price_book");
			int intQuantity = rs.getInt("quantity");
			String strDiscountCode = rs.getString("discount_code");
			int intIntoMoney = rs.getInt("into_money");
			int intIdOrders = rs.getInt("id_orders");
			beanOrderDetail = new OrderDetailBean(intIdBook, strNameBook, intPriceBook, intQuantity, strDiscountCode, intIntoMoney, intIdOrders);
			aryOrderDetail.add(beanOrderDetail);
		}
		return aryOrderDetail;
	}
	
	public void insertOrderDetail(OrderDetailBean beanDetail) throws Exception {
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		String sql = "INSERT INTO order_detail (id_book, name_book, price_book, quantity, discount_code, into_money, id_orders) VALUE (?,?,?,?,?,?,?)";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, beanDetail.getIntIdBook());
		ps.setString(2, beanDetail.getStrNameBook());
		ps.setInt(3, beanDetail.getIntPriceBook());
		ps.setInt(4, beanDetail.getIntQuantity());
		ps.setString(5, beanDetail.getStrDiscountCode());
		ps.setInt(6, beanDetail.getIntIntoMoney());
		ps.setInt(7, beanDetail.getIntIdOrders());
		ps.execute();
	}		
	
	public void addQuantily(OrderDetailBean beanOrderDetail) throws Exception {
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		String sql = "UPDATE order_detail SET quantity = ? WHERE id_book = ?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, beanOrderDetail.getIntQuantity() + 1);
		ps.setInt(2, beanOrderDetail.getIntIdBook());
		ps.execute();
	}
	
	public void addIntoMonney(int money, int idBook) throws Exception {
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		String sql = "UPDATE order_detail SET into_money = ? WHERE id_book = ?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, money);
		ps.setInt(2, idBook);
		ps.execute();
	}
	
}
