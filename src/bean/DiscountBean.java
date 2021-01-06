package bean;

public class DiscountBean {
	private String strDiscountCode;
	private int intPercent;
	private int intIdBook;
	private int intCartNo;
	
	public DiscountBean(String _strDiscountCode, int _intPercent, int _intIdBook, int _intCartNo) {
		this.strDiscountCode = _strDiscountCode;
		this.intPercent = _intPercent;
		this.intIdBook = _intIdBook;
		this.intCartNo = _intCartNo;
	}

	public String getStrDiscountCode() {
		return strDiscountCode;
	}

	public void setStrDiscountCode(String strDiscountCode) {
		this.strDiscountCode = strDiscountCode;
	}

	public int getIntPercent() {
		return intPercent;
	}

	public void setIntPercent(int intPercent) {
		this.intPercent = intPercent;
	}

	public int getIntIdBook() {
		return intIdBook;
	}

	public void setIntIdBook(int intIdBook) {
		this.intIdBook = intIdBook;
	}

	public int getIntCartNo() {
		return intCartNo;
	}

	public void setIntCartNo(int intCartNo) {
		this.intCartNo = intCartNo;
	}
	
}
