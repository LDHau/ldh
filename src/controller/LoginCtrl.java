package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CustomerBean;
import dao.CustomerDao;

/**
 * Servlet implementation class LoginCtrl
 */
@WebServlet("/login-ctrl")
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idlog = request.getParameter("idlog");
		String pass  = request.getParameter("pass");

		CustomerDao daoCus = new CustomerDao();

		try {
			CustomerBean beanCus = daoCus.getCus(idlog, pass);
			if(idlog.equals(beanCus.getStrEmail()) && pass.equals(beanCus.getStrPass())) {
				HttpSession session = request.getSession();
				session.setAttribute("idl", beanCus.getStrEmail());
				session.setAttribute("idp", beanCus.getStrPass());
				response.sendRedirect("list-book");
				return;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("Showuser.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
