package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ShoppingCartDao;

/**
 * Servlet implementation class ShoppingCartCtrl
 */
@WebServlet("/shopping-cart-ctrl")
public class ShoppingCartCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String idl = (String) session.getAttribute("idl");
		String idp = (String) session.getAttribute("idp");
		if (idl != null && idp != null) {
			ShoppingCartDao daoShoppingCart = new ShoppingCartDao();
			int idb = Integer.parseInt(request.getParameter("idb"));
			try {
				if (idb != 0) {
					request.setAttribute("lss", daoShoppingCart.addShoppingCart(idb));
					RequestDispatcher rd = request.getRequestDispatcher("ShoppingCart.jsp");
					rd.forward(request, response);
				}
				else {
					request.setAttribute("lss", daoShoppingCart.getShoppingCart());
					RequestDispatcher rd = request.getRequestDispatcher("ShoppingCart.jsp");
					rd.forward(request, response);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			response.sendRedirect("Login.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
