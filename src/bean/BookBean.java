package bean;

public class BookBean {
	private int intIdBook;
	private String strName;
	private String strAuthor;
	private int intPrice;
	private int intNumberPages;
	private float floWeight;
	private int intPublishingYear;
	private String strSummary;
	private String strIdCategory;
	
	public BookBean(int _intIdBook, String _strName, String _strAuthor, int _intPrice, int _intNumberPages, float _floWeight,
						int _intPublishingYear, String _strSummary, String _strIdCategory) {
		this.intIdBook = _intIdBook;
		this.strName = _strName;
		this.strAuthor  = _strAuthor;
		this.intPrice = _intPrice;
		this.intNumberPages = _intNumberPages;
		this.floWeight  = _floWeight;
		this.intPublishingYear = _intPublishingYear;
		this.strSummary = _strSummary;
		this.strIdCategory = _strIdCategory;
	}

	public BookBean(String _strName, String _strAuthor, int _intPrice, int _intNumberPages, float _floWeight,
			int _intPublishingYear, String _strSummary, String _strIdCategory) {
		this.strName = _strName;
		this.strAuthor  = _strAuthor;
		this.intPrice  = _intPrice;
		this.intNumberPages = _intNumberPages;
		this.floWeight  = _floWeight;
		this.intPublishingYear = _intPublishingYear;
		this.strSummary = _strSummary;
		this.strIdCategory = _strIdCategory;
	}

	public int getIntIdBook() {
		return intIdBook;
	}

	public void setIntIdBook(int intIdBook) {
		this.intIdBook = intIdBook;
	}

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}

	public String getStrAuthor() {
		return strAuthor;
	}

	public void setStrAuthor(String strAuthor) {
		this.strAuthor = strAuthor;
	}

	public int getIntPrice() {
		return intPrice;
	}

	public void setIntPrice(int intPrice) {
		this.intPrice = intPrice;
	}

	public int getIntNumberPages() {
		return intNumberPages;
	}

	public void setIntNumberPages(int intNumberPages) {
		this.intNumberPages = intNumberPages;
	}

	public float getFloWeight() {
		return floWeight;
	}

	public void setFloWeight(float floWeight) {
		this.floWeight = floWeight;
	}

	public int getIntPublishingYear() {
		return intPublishingYear;
	}

	public void setIntPublishingYear(int intPublishingYear) {
		this.intPublishingYear = intPublishingYear;
	}

	public String getStrSummary() {
		return strSummary;
	}

	public void setStrSummary(String strSummary) {
		this.strSummary = strSummary;
	}

	public String getStrIdCategory() {
		return strIdCategory;
	}

	public void setStrIdCategory(String strIdCategory) {
		this.strIdCategory = strIdCategory;
	}	
}
