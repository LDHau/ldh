package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.OrderDetailBo;
import dao.OrderDetailDao;

/**
 * Servlet implementation class ShoppingCartCtrl
 */
@WebServlet("/order-detail-ctrl")
public class OrderDetailCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailCtrl() {
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
		String idlogin = (String) session.getAttribute("idlogin");
		String idpass = (String) session.getAttribute("idpass");
		
		if (idlogin != null && idpass != null) {
			OrderDetailBo boShoppingCart = new OrderDetailBo();
			
			int idBook = Integer.parseInt(request.getParameter("idbook"));
			String name = request.getParameter("nameb");
			int price = Integer.parseInt(request.getParameter("priceb"));
			int quantily = Integer.parseInt(request.getParameter("quantilyb"));
			int idOrders = Integer.parseInt(request.getParameter("idordersb"));
			
			try {
				
//				request.setAttribute("OrderBook", boShoppingCart.addOrderDetail(idBook, name, price, quantily, idOrders));
				
				boolean statis = boShoppingCart.addOrderDetail(idBook, name, price, quantily, idOrders);
				
				request.setAttribute("OrderBook", boShoppingCart.getDetail());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			response.sendRedirect("Login.jsp");
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("OrderDetail.jsp");
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
