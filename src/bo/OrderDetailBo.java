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
	
	public int CalculateOrderDetail(int price, int quantily, DiscountBean beanDiscount) {
		int percent = 1;
		if(beanDiscount != null) {
			percent = beanDiscount.getIntPercent();
		}
		return price*quantily*percent;
	}
	
	public Boolean addOrderDetail(int idBook, String name, int price, int quantily, int idOrders) throws Exception {
		int n = daoOrderDetail.getOrderDetail().size();
		boolean statusDetail = checkOrderDetail(idBook);
		String discountCode = "Khong ma giam gia";
		if(n == 0) {
			DiscountBean beanDiscount = daoDiscount.getDiscountByIdBook(idBook);
			int into_money = CalculateOrderDetail(price, quantily, beanDiscount);
			if(beanDiscount != null) {
				 discountCode = beanDiscount.getStrDiscountCode();
			}
			OrderDetailBean beanOrderDetail = new OrderDetailBean(idBook, name, price, quantily,
					discountCode, into_money, idOrders);
					daoOrderDetail.insertOrderDetail(beanOrderDetail);
			return true;
		}
		for(int i = 0; i < n; i++) {
			if(daoOrderDetail.getOrderDetail().get(i).getIntIdBook() != idBook && statusDetail == false ) {
				DiscountBean beanDiscount = daoDiscount.getDiscountByIdBook(idBook);
				int into_money = CalculateOrderDetail(price, quantily, beanDiscount);
				if(beanDiscount != null) {
					 discountCode = beanDiscount.getStrDiscountCode();
				}
				OrderDetailBean beanOrderDetail = new OrderDetailBean(idBook, name, price, quantily,
						discountCode, into_money, idOrders);
				daoOrderDetail.insertOrderDetail(beanOrderDetail);
				return true;
			}
		}
		
		if(statusDetail == true) {
			int size = daoOrderDetail.getOrderDetail().size();
			for(int i = 0; i <= size; i++) {
				if(daoOrderDetail.getOrderDetail().get(i).getIntIdBook() == idBook) {
					OrderDetailBean beanOrderDetail = daoOrderDetail.getOrderDetail().get(i);
					beanOrderDetail.setIntQuantity(beanOrderDetail.getIntQuantity());
					daoOrderDetail.addQuantily(beanOrderDetail);
					DiscountBean beanDiscount = daoDiscount.getDiscountByIdBook(idBook);
					int quantityUpdate = daoOrderDetail.getOrderDetail().get(i).getIntQuantity();
					int intoMoney = CalculateOrderDetail(price, quantityUpdate, beanDiscount);
					daoOrderDetail.addIntoMonney(intoMoney, idBook);
					return true;
				}
			}
		}
	return false;
	}
	
}
