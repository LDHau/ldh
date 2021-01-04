package bean;

public class CategoryBean {
	private String strIdCategory;
	private String strNameCategory;
	
	public CategoryBean(String _strIdCategory, String _strNameCategory) {
		this.strIdCategory   = _strIdCategory;
		this.strNameCategory = _strNameCategory;
	}

	public String getStrIdCategory() {
		return strIdCategory;
	}

	public void setStrIdCategory(String strIdCategory) {
		this.strIdCategory = strIdCategory;
	}

	public String getStrNameCategory() {
		return strNameCategory;
	}

	public void setStrNameCategory(String strNameCategory) {
		this.strNameCategory = strNameCategory;
	}
	
}
