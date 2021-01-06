package bean;

public class CustomerBean {
	private String strName;
	private int intPhone;
	private String strEmail;
	private String strPass;
	
	public CustomerBean(String _strName, int _intPhone, String _strEmail, String _strPass) {
		this.strName = _strName;
		this.intPhone = _intPhone;
		this.strEmail = _strEmail;
		this.strPass = _strPass;
	}

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}

	public int getIntPhone() {
		return intPhone;
	}

	public void setIntPhone(int intPhone) {
		this.intPhone = intPhone;
	}

	public String getStrEmail() {
		return strEmail;
	}

	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
	}

	public String getStrPass() {
		return strPass;
	}

	public void setStrPass(String strPass) {
		this.strPass = strPass;
	}

}
