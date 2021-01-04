package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.CategoryBean;
import connection.Connect;

public class CategoryDao {
	public ArrayList<CategoryBean> getCategory() throws Exception {
		
		ArrayList<CategoryBean> aryCategory = new ArrayList<CategoryBean>();
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		String sql = "SELECT * FROM category_books";
		PreparedStatement ps = cn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String strId_category = rs.getString("id_category");
			String strName_category = rs.getString("name_category");
			CategoryBean category = new CategoryBean(strId_category, strName_category);
			aryCategory.add(category);
		}
		
		return aryCategory;
	}
}
