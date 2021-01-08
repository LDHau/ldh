package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.CustomerBean;
import connection.Connect;

public class CustomerDao {
	
	public ArrayList<CustomerBean> getAryCus() throws Exception {
		CustomerBean beanCus = null;
		ArrayList<CustomerBean> aryCus = new ArrayList<CustomerBean>();
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		String sql = "SELECT * FROM customers";
		PreparedStatement ps = cn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String strName = rs.getString("name_customers");
			int intPhone = rs.getInt("phone_number");
			String strEmail = rs.getString("e_mail");
			String strPass = rs.getString("password_customers");
			beanCus = new CustomerBean(strName, intPhone, strEmail, strPass);
			aryCus.add(beanCus);
		}
		return aryCus;
	}
	
	
	
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
	
	public void addCus(CustomerBean beanCus) throws Exception {
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		String sql = "INSERT INTO customers (name_customers, phone_number, e_mail, password_customers) VALUE (?,?,?,?)";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1, beanCus.getStrName());
		ps.setInt(2, beanCus.getIntPhone());
		ps.setString(3, beanCus.getStrEmail());
		ps.setString(4, beanCus.getStrPass());
		ps.execute();
		
	}		
	
}
