package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.CustomerBean;
import connection.Connect;

public class CustomerDao {
	public CustomerBean getCus(String idlog, String pass) throws Exception {
		CustomerBean beanCus = null;
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		String sql = "SELECT * FROM customers WHERE e_mail = ? AND password_customers = ?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1, idlog);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String strName = rs.getString("name_customers");
			int intPhone = rs.getInt("phone_number");
			String strEmail = rs.getString("e_mail");
			String strPass = rs.getString("password_customers");
			beanCus = new CustomerBean(strName, intPhone, strEmail, strPass);
		}
		return beanCus;
	}
}
