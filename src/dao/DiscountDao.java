package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.DiscountBean;
import connection.Connect;

public class DiscountDao {
	public ArrayList<DiscountBean> getDiscount() throws Exception {
		DiscountBean beanDiscount = null;
		ArrayList<DiscountBean> aryDiscount = new ArrayList<DiscountBean>();
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		String sql = "SELECT * FROM discount";
		PreparedStatement ps = cn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String strDiscountCode = rs.getString("discount_code");
			int intPercent = rs.getInt("percent");
			int intIdBook = rs.getInt("id_book");
			int intCartNo = rs.getInt("cart_no");
			beanDiscount = new DiscountBean(strDiscountCode, intPercent, intIdBook, intCartNo);
			aryDiscount.add(beanDiscount);
		}
		return aryDiscount;
	}
	
	public DiscountBean getDiscountByIdBook(int IdBook) throws Exception {
		DiscountBean beanDiscount = null;
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		String sql = "SELECT * FROM discount WHERE id_book = ?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, IdBook);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String strDiscountCode = rs.getString("discount_code");
			int intPercent = rs.getInt("percent");
			int intIdBook = rs.getInt("id_book");
			int intCartNo = rs.getInt("cart_no");
			beanDiscount = new DiscountBean(strDiscountCode, intPercent, intIdBook, intCartNo);
		}
		return beanDiscount;
	}
}
