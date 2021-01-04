package bo;

import java.util.ArrayList;

import bean.BookBean;
import dao.BookDao;

public class BookBo {
	BookDao daoBook = new BookDao();
	public ArrayList<BookBean> getDS() throws Exception {
		return daoBook.getBook();
	}
	
	public ArrayList<BookBean> getListByCate(String idCate) throws Exception {
		return daoBook.getListByCate(idCate);
	}
	
	public BookBean getBookById(int idx) throws Exception {			
		return daoBook.getBookById(idx);
	}
	public void editBook(BookBean bbe) throws Exception {
		daoBook.editBook(bbe);
	}
}
