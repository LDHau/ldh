package bo;

import java.util.ArrayList;

import bean.DiscountBean;
import bean.OrderDetailBean;
import dao.BookDao;
import dao.DiscountDao;
import dao.OrderDetailDao;

public class OrderDetailBo {
	OrderDetailDao daoOrderDetail = new OrderDetailDao();
	BookDao  daoBook = new BookDao();
	DiscountDao daoDiscount = new DiscountDao();
		
	public ArrayList<OrderDetailBean> getDetail() throws Exception {
		return daoOrderDetail.getOrderDetail();
	}
	
	public Boolean checkOrderDetail(int idBook) throws Exception {	
		int sizeCart = daoOrderDetail.getOrderDetail().size();
			for(int i = 0; i < sizeCart; i++) {
				if(daoOrderDetail.getOrderDetail().get(i).getIntIdBook() == idBook) {
					return true;
				}
			}
		return false;
	}
	
	public Boolean addOrderDetail(int idBook, String name, int price, int quantily, int idOrders) throws Exception {
		int n = daoOrderDetail.getOrderDetail().size();
		boolean statusDetail = checkOrderDetail(idBook);
		if(n == 0) {
			DiscountBean beanDiscount = daoDiscount.getDiscountByIdBook(idBook);
			OrderDetailBean beanOrderDetail = new OrderDetailBean(idBook, name, price, quantily,
					beanDiscount.getStrDiscountCode(), price * quantily, idOrders);
					daoOrderDetail.insertOrderDetail(beanOrderDetail);
			return true;
		}
		for(int i = 0; i < n; i++) {
			if(daoOrderDetail.getOrderDetail().get(i).getIntIdBook() != idBook && statusDetail == false ) {
				DiscountBean beanDiscount = daoDiscount.getDiscountByIdBook(idBook);
				OrderDetailBean beanOrderDetail = new OrderDetailBean(idBook, name, price, quantily,
														beanDiscount.getStrDiscountCode(), price * quantily, idOrders);
				daoOrderDetail.insertOrderDetail(beanOrderDetail);
				return true;
			}
		}
		
		if(statusDetail == true) {
			int size = daoOrderDetail.getOrderDetail().size();
			for(int i = 0; i <= size; i++) {
				if(daoOrderDetail.getOrderDetail().get(i).getIntIdBook() == idBook) {
					int tt = daoOrderDetail.getOrderDetail().get(i).getIntQuantity();
					
					daoOrderDetail.getOrderDetail().get(i).setIntQuantity(daoOrderDetail.getOrderDetail().get(i).getIntQuantity() + 1);
					
//					daoOrderDetail.addQuantily(idBook, daoOrderDetail.getOrderDetail().get(i).getIntQuantity());
//					int tt2 = daoOrderDetail.getOrderDetail().get(i).getIntQuantity();
					return true;
				}
			}
		}
	return false;
	}
	
}
