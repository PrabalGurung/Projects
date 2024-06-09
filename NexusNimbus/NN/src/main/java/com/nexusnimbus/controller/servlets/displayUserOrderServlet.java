package com.nexusnimbus.controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nexusnimbus.controller.DatabaseController;
import com.nexusnimbus.model.OrderModel;
import com.nexusnimbus.utils.StringUtils;

/**
 * Servlet implementation class displayUserOrderServlet
 */
@WebServlet("/displayUserOrderServlet")
public class displayUserOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController db = new DatabaseController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayUserOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 if (session.getAttribute("email") == null) {
		     response.sendRedirect(request.getContextPath() + StringUtils.LOGIN_PAGE);
		 }else {
			 String sessionId = (String) session.getAttribute("userId"); 
			 System.out.print(sessionId);
			List<OrderModel> orders = db.getUserOrders(sessionId);
			if(orders != null) {
				request.setAttribute("orders", orders);
				request.getRequestDispatcher("/pages/orderHistory.jsp").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath()+ StringUtils.SERVER_ERROR);
			}
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
