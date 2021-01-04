package bo;

import java.util.ArrayList;

import bean.CategoryBean;
import dao.CategoryDao;

public class CategoryBo {
	CategoryDao daoCate = new CategoryDao();
	public ArrayList<CategoryBean> getCategory() throws Exception {
		return daoCate.getCategory();
	}
}
