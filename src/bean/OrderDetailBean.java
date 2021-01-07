package bean;

public class OrderDetailBean {
	private int intIdOrderDetail;
	private int intIdBook;
	private String strNameBook;
	private int intPriceBook;
	private int intQuantity;
	private String strDiscountCode;
	private int intIntoMoney;
	private int intIdOrders;
	
	public OrderDetailBean(int _intIdBook, String _strNameBook, int _intPriceBook,
								int _intQuantity, String _strDiscountCode, int _intIntoMoney, int _intIdOrders) {
		this.intIdBook = _intIdBook;
		this.strNameBook = _strNameBook;
		this.intPriceBook = _intPriceBook;
		this.intQuantity = _intQuantity;
		this.strDiscountCode = _strDiscountCode;
		this.intIntoMoney = _intIntoMoney;
		this.intIdOrders = _intIdOrders;
	}
	
	public OrderDetailBean(int _intIdBook, String _strNameBook, int _intPriceBook,
			int _intQuantity, String _strDiscountCode, int _intIntoMoney) {
		this.intIdBook = _intIdBook;
		this.strNameBook = _strNameBook;
		this.intPriceBook = _intPriceBook;
		this.intQuantity = _intQuantity;
		this.strDiscountCode = _strDiscountCode;
		this.intIntoMoney = _intIntoMoney;
	}

	public int getIntIdOrderDetail() {
		return intIdOrderDetail;
	}

	public void setIntIdOrderDetail(int intIdOrderDetail) {
		this.intIdOrderDetail = intIdOrderDetail;
	}

	public int getIntIdBook() {
		return intIdBook;
	}

	public void setIntIdBook(int intIdBook) {
		this.intIdBook = intIdBook;
	}

	public String getStrNameBook() {
		return strNameBook;
	}

	public void setStrNameBook(String strNameBook) {
		this.strNameBook = strNameBook;
	}

	public int getIntPriceBook() {
		return intPriceBook;
	}

	public void setIntPriceBook(int intPriceBook) {
		this.intPriceBook = intPriceBook;
	}

	public int getIntQuantity() {
		return intQuantity;
	}

	public void setIntQuantity(int intQuantity) {
		this.intQuantity = intQuantity;
	}

	public String getStrDiscountCode() {
		return strDiscountCode;
	}

	public void setStrDiscountCode(String strDiscountCode) {
		this.strDiscountCode = strDiscountCode;
	}

	public int getIntIntoMoney() {
		return intIntoMoney;
	}

	public void setIntIntoMoney(int intIntoMoney) {
		this.intIntoMoney = intIntoMoney;
	}

	public int getIntIdOrders() {
		return intIdOrders;
	}

	public void setIntIdOrders(int intIdOrders) {
		this.intIdOrders = intIdOrders;
	}

}