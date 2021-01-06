package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ShoppingCartBean;
import connection.Connect;

public class ShoppingCartDao {
	public ArrayList<ShoppingCartBean> getShoppingCart() throws Exception {
		ArrayList<ShoppingCartBean> aryShopCart = new ArrayList<ShoppingCartBean>();
		ShoppingCartBean beanCart = null;
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		String sql = "SELECT * FROM shopping_cart";
		PreparedStatement ps = cn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int intIdBook = rs.getInt("id_book");
			int intUnitPrice = rs.getInt("intUnitPrice");
			int intQuantity = rs.getInt("quantity");
			String strDiscountCode = rs.getString("discount_code");
			String strIdCustomers = rs.getString("id_customers");
			beanCart = new ShoppingCartBean(intIdBook, intUnitPrice, intQuantity, strDiscountCode, strIdCustomers);
			aryShopCart.add(beanCart);
		}
		return aryShopCart;
	}
	
	public void insertDBCart(ShoppingCartBean beanCart) throws Exception {
		
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		String sql = "INSERT INTO shopping_cart (id_book, unit_price, quantity, discount_code, id_customers) VALUE (?,?,?,?,?)";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, beanCart.getIntIdBook());
		ps.setInt(2, beanCart.getIntUnitPrice());
		ps.setInt(3, beanCart.getIntQuantity());
		ps.setString(4, beanCart.getStrDiscountCode());
		ps.setString(5, beanCart.getStrIdCustomers());	
		ps.execute();
	}
	
	public Boolean checkShoppingCart(int idBook) throws Exception {	
		int sizeAry = getShoppingCart().size();
		for(int i = 0; i < sizeAry; i++) {
			if(getShoppingCart().get(i).getIntIdBook() == idBook) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean addShoppingCart(int idBook) throws Exception {
		int n = getShoppingCart().size();
		boolean statusCart = addShoppingCart(idBook);
		for(int i = 0; i < n; i++) {
			if(getShoppingCart().get(i).getIntIdBook() == idBook && statusCart == false) {
				ShoppingCartBean beanCart = new ShoppingCartBean(getShoppingCart().get(i).getIntIdBook(), 
					getShoppingCart().get(i).getIntUnitPrice(), getShoppingCart().get(i).getIntQuantity(), 
					getShoppingCart().get(i).getStrDiscountCode(), getShoppingCart().get(i).getStrIdCustomers());
				insertDBCart(beanCart);
				return true;
			}
		}
		if(statusCart == true) {
			int size = getShoppingCart().size();
			for(int i = 0; i < size; i++) {
				if(getShoppingCart().get(i).getIntIdBook() == idBook) {
					getShoppingCart().get(i).setIntQuantity(getShoppingCart().get(i).getIntQuantity() + 1);
				}
			}
		}
		return false;
	}

	
	
	
}
