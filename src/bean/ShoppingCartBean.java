package bean;

public class ShoppingCartBean {
	private int intCartNo;
	private int intIdBook;
	private int intUnitPrice;
	private int intQuantity;
	private String strDiscountCode;
	private String strIdCustomers;
	
	public ShoppingCartBean (int _intIdBook, int _intUnitPrice, int _intQuantity,
								String _strDiscountCode, String _strIdCustomers) {
		this.intIdBook = _intIdBook;
		this.intUnitPrice = _intUnitPrice;
		this.intQuantity = _intQuantity;
		this.strDiscountCode = _strDiscountCode;
		this.strIdCustomers = _strIdCustomers;
	}

	public int getIntCartNo() {
		return intCartNo;
	}

	public void setIntCartNo(int intCartNo) {
		this.intCartNo = intCartNo;
	}

	public int getIntIdBook() {
		return intIdBook;
	}

	public void setIntIdBook(int intIdBook) {
		this.intIdBook = intIdBook;
	}

	public int getIntUnitPrice() {
		return intUnitPrice;
	}

	public void setIntUnitPrice(int intUnitPrice) {
		this.intUnitPrice = intUnitPrice;
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

	public String getStrIdCustomers() {
		return strIdCustomers;
	}

	public void setStrIdCustomers(String strIdCustomers) {
		this.strIdCustomers = strIdCustomers;
	}

}