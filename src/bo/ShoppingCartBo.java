package bo;

import java.util.ArrayList;

import bean.BookBean;
import bean.DiscountBean;
import bean.ShoppingCartBean;
import dao.BookDao;
import dao.DiscountDao;
import dao.ShoppingCartDao;

public class ShoppingCartBo {
	ShoppingCartDao daoShoppingCart = new ShoppingCartDao();
	BookDao  daoBook = new BookDao();
	DiscountDao daoDiscount = new DiscountDao();
	
//	ArrayList<ShoppingCartBean> aryShoppingCart = new ArrayList<ShoppingCartBean>();
	
	public ArrayList<ShoppingCartBean> getCart() throws Exception {
		return daoShoppingCart.getShoppingCart();
	}
	
	public Boolean checkShoppingCart(int idBook) throws Exception {	
		int sizeCart = daoShoppingCart.getShoppingCart().size();
		for(int i = 0; i < sizeCart; i++) {
			int test = daoShoppingCart.getShoppingCart().get(i).getIntIdBook();
			if(daoShoppingCart.getShoppingCart().get(i).getIntIdBook() == idBook) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean addShoppingCart(int idBook) throws Exception {
		int n = daoShoppingCart.getShoppingCart().size();
		boolean statusCart = checkShoppingCart(idBook);
		for(int i = 0; i < n; i++) {
			if(daoShoppingCart.getShoppingCart().get(i).getIntIdBook() != idBook && statusCart == false ) {
				BookBean beanBook = daoBook.getBookById(idBook);
				DiscountBean beanDiscount = daoDiscount.getDiscountByIdBook(idBook);
				ShoppingCartBean beanCart = new ShoppingCartBean(beanBook.getIntIdBook(), 
						beanBook.getIntAmount(), 
						_intQuantity, 
						beanDiscount.getIntPercent(), 
						cus);
				
//				ShoppingCartBean beanCart = new  ShoppingCartBean(daoShoppingCart.getShoppingCart().get(i).getIntIdBook(), 
//						daoShoppingCart.getShoppingCart().get(i).getIntUnitPrice(), 
//						daoShoppingCart.getShoppingCart().get(i).getIntQuantity(), 
//						daoShoppingCart.getShoppingCart().get(i).getStrDiscountCode(), 
//						daoShoppingCart.getShoppingCart().get(i).getStrIdCustomers());
				
				daoShoppingCart.insertDBCart(beanCart);
				return true;
			}
		}
		if(statusCart == true) {
			int size = daoShoppingCart.getShoppingCart().size();
			for(int i = 0; i < size; i++) {
				if(daoShoppingCart.getShoppingCart().get(i).getIntIdBook() == idBook) {
					daoShoppingCart.getShoppingCart().get(i).setIntQuantity(daoShoppingCart.getShoppingCart().get(i).getIntQuantity() + 1);
				}
			}
		}
		return false;
	}

}
