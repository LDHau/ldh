package dao;

import java.sql.Connection
;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			int intPrice   = rs.getInt("price");
			int intNumberPages = rs.getInt("number_pages");
			float floWeight   = rs.getFloat("weight");
			int intPublishingYear = rs.getInt("publishing_year");
			String strSummary = rs.getString("summary");
			String strIdCategory = rs.getString("id_category");
			BookBean beanBook = new BookBean(intIdBook, strName, strAuthor, intPrice, intNumberPages, floWeight, intPublishingYear, strSummary, strIdCategory);
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
			int intPrice   = rs.getInt("price");
			int intNumberPages = rs.getInt("number_pages");
			float floWeight   = rs.getFloat("weight");
			int intPublishingYear = rs.getInt("publishing_year");
			String strSummary = rs.getString("summary");
			String strIdCategory = rs.getString("id_category");

			beanBook = new BookBean(intIdBook, strName, strAuthor, intPrice, intNumberPages, floWeight, intPublishingYear, strSummary, strIdCategory);	
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
			int intPrice = rs.getInt("price");
			int intNumberPages = rs.getInt("number_pages");
			float floWeight   = rs.getFloat("weight");
			int intPublishingYear = rs.getInt("publishing_year");
			String strSummary = rs.getString("summary");
			String strIdCategory = rs.getString("id_category");

			beanBook = new BookBean(intIdBook, strName, strAuthor, intPrice, intNumberPages, floWeight, intPublishingYear, strSummary, strIdCategory);	
		}
		return beanBook;
	}
	
	public void editBook(BookBean bnbook) throws Exception {
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		String sql = "UPDATE books SET name = ?, author = ?, price = ?, number_pages = ?, weight = ?, publishing_year = ?, summary = ?, id_category = ? WHERE id_book = ?";
		PreparedStatement ps = cn.prepareStatement(sql);
		
		ps.setString(1, bnbook.getStrName());
		ps.setString(2, bnbook.getStrAuthor());
		ps.setInt(3, bnbook.getIntPrice());
		ps.setInt(4, bnbook.getIntNumberPages());
		ps.setFloat(5, bnbook.getFloWeight());
		ps.setInt(6, bnbook.getIntPublishingYear());
		ps.setString(7, bnbook.getStrSummary());
		ps.setString(8, bnbook.getStrIdCategory());
		ps.setInt(9, bnbook.getIntIdBook());
		ps.execute();
	}
	
	public void addBook(BookBean bnbook) throws Exception {
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		String sql = "INSERT INTO books (name, author, price, number_pages, weight, publishing_year, summary, id_category) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1, bnbook.getStrName());
		ps.setString(2, bnbook.getStrAuthor());
		ps.setInt(3, bnbook.getIntPrice());
		ps.setInt(4, bnbook.getIntNumberPages());
		ps.setFloat(5, bnbook.getFloWeight());
		ps.setInt(6, bnbook.getIntPublishingYear());
		ps.setString(7, bnbook.getStrSummary());
		ps.setString(8, bnbook.getStrIdCategory());
		ps.execute();
	}
	
	public void delBook(int bnbook) throws Exception {
		Connect ct = new Connect();
		Connection cn = ct.getConnect();
		String sql = "DELETE FROM books WHERE id_book = ?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, bnbook);
		ps.execute();
	}
}
