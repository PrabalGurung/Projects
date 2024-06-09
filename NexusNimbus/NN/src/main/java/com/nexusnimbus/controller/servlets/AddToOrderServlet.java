package com.nexusnimbus.controller.servlets;

import java.io.IOException;
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
 * Servlet implementation class AddToOrderServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/AddToOrderServlet" })
public class AddToOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	DatabaseController dbController = new DatabaseController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		 HttpSession session = request.getSession();
		    if (session.getAttribute("email") == null) {
		    	response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
		    }else {
				String totalAmt = request.getParameter("amount");
				String userId = (String) session.getAttribute("userId");
				int id = Integer.parseInt(userId);
				
				System.out.print(userId);
				
				int result = dbController.addOrder(totalAmt, id);

				if (result == 1) {    	
					response.sendRedirect(request.getContextPath() + StringUtils.CART_PAGE);
				}else if(result == 0) {
					response.sendRedirect(request.getContextPath()+ StringUtils.SERVER_ERROR);
				}else {
					response.sendRedirect(request.getContextPath()+ StringUtils.SERVER_ERROR);
		    }
		
	}
	}
}

