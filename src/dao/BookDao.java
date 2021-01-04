package dao;

import java.sql.Connection
;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.BookBean;
import connection.Connect;

public class BookDao {
	public ArrayList<BookBean> getBook() throws Exception {
		ArrayList<BookBean> aryBook = new ArrayList<BookBean>();
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		PreparedStatement ps = cn.prepareStatement("SELECT * FROM books");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int intIdBook = rs.getInt("id_book");
			String strName    = rs.getString("name");
			String strAuthor  = rs.getString("author");
			float floAmount   = rs.getFloat("amount");
			int intNumberPages = rs.getInt("number_pages");
			float floWeight   = rs.getFloat("weight");
			int intPublishingYear = rs.getInt("publishing_year");
			String strSummary = rs.getString("summary");
			String strIdCategory = rs.getString("id_category");
			String strStatus  = rs.getString("status");
			BookBean beanBook = new BookBean(intIdBook, strName, strAuthor, floAmount, intNumberPages, floWeight, intPublishingYear, strSummary, strIdCategory, strStatus);
			aryBook.add(beanBook);
			
		}
		return aryBook;
	}
	
	public ArrayList<BookBean> getListByCate(String idCate) throws Exception {
		ArrayList<BookBean> aryBook = new ArrayList<BookBean>();
		BookBean beanBook = null;
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		PreparedStatement ps = cn.prepareStatement("SELECT * FROM books WHERE id_category = ?");
		ps.setString(1, idCate);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {	
			int intIdBook = rs.getInt("id_book");
			String strName    = rs.getString("name");
			String strAuthor  = rs.getString("author");
			float floAmount   = rs.getFloat("amount");
			int intNumberPages = rs.getInt("number_pages");
			float floWeight   = rs.getFloat("weight");
			int intPublishingYear = rs.getInt("publishing_year");
			String strSummary = rs.getString("summary");
			String strIdCategory = rs.getString("id_category");
			String strStatus  = rs.getString("status");
			beanBook = new BookBean(intIdBook, strName, strAuthor, floAmount, intNumberPages, floWeight, intPublishingYear, strSummary, strIdCategory, strStatus);	
			aryBook.add(beanBook);
		}
		return aryBook;
	}
	
	public BookBean getBookById(int idx) throws Exception {
		BookBean beanBook = null;
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		PreparedStatement ps = cn.prepareStatement("SELECT * FROM books WHERE id_book = ?");
		ps.setInt(1, idx);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {	
			int intIdBook = rs.getInt("id_book");
			String strName    = rs.getString("name");
			String strAuthor  = rs.getString("author");
			float floAmount   = rs.getFloat("amount");
			int intNumberPages = rs.getInt("number_pages");
			float floWeight   = rs.getFloat("weight");
			int intPublishingYear = rs.getInt("publishing_year");
			String strSummary = rs.getString("summary");
			String strIdCategory = rs.getString("id_category");
			String strStatus  = rs.getString("status");
			beanBook = new BookBean(intIdBook, strName, strAuthor, floAmount, intNumberPages, floWeight, intPublishingYear, strSummary, strIdCategory, strStatus);	
		}
		return beanBook;
	}
	
	public void editBook(BookBean bnbook) throws Exception {
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		String sql = "UPDATE books SET name = ?, author = ?, amount = ?, number_pages = ?, weight = ?, publishing_year = ?, summary = ?, id_category = ?, status = ? WHERE id_book = ?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1, bnbook.getStrName());
		ps.setString(2, bnbook.getStrAuthor());
		ps.setFloat(3, bnbook.getFloWeight());
		ps.setInt(4, bnbook.getIntNumberPages());
		ps.setFloat(5, bnbook.getFloWeight());
		ps.setInt(6, bnbook.getIntPublishingYear());
		ps.setString(7, bnbook.getStrSummary());
		ps.setString(8, bnbook.getStrIdCategory());
		ps.setString(9, bnbook.getStrStatus());
		ps.setInt(10, bnbook.getIntIdBook());
		ps.execute();
	}
	
	public void addBook(BookBean bnbook) throws Exception {
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		String sql = "INSERT INTO books (name, author, amount, number_pages, weight, publishing_year, summary, ) VALUES ";
	}
		
}
