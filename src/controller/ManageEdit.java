package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookBean;
import bo.BookBo;
import dao.BookDao;

/**
 * Servlet implementation class MANAGE_EDIT
 */
@WebServlet("/manage-edit")
public class ManageEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int idbook = Integer.parseInt(request.getParameter("idbook"));
		String name = request.getParameter("nameb");
		String author = request.getParameter("authorb");
		float amount = Float.parseFloat(request.getParameter("amountb"));
		int number = Integer.parseInt(request.getParameter("numberb"));
		float weight = Float.parseFloat(request.getParameter("weightb"));
		int year = Integer.parseInt(request.getParameter("yearb"));
		String summary = request.getParameter("summaryb");
		String category = request.getParameter("categoryb");
		String status = request.getParameter("statusb");
		BookBean beanBook = new BookBean(idbook, name, author, amount, number, weight, year, summary, category, status);
		BookDao bdao = new BookDao();
		try {
			bdao.editBook(beanBook);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list-book");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
