package com.nexusnimbus.controller.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nexusnimbus.controller.DatabaseController;
import com.nexusnimbus.utils.StringUtils;

/**
 * Servlet implementation class changeOrderStatusServlet
 */
@WebServlet("/changeOrderStatusServlet")
public class changeOrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController db = new DatabaseController();
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeOrderStatusServlet() {
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
	    String orderStatus = request.getParameter("orderStatus");
	    String id = request.getParameter("orderId");
	    
	    System.out.println("Order Status: " + orderStatus);
	    System.out.println("Order Status: " + id);
	    
	    int result = db.changeOrderStatus(id, orderStatus);
	    
	    if (result == 1) {    
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/displayOrderServlet");
            dispatcher.forward(request, response);
		}else if(result == 0) {
			response.sendRedirect(request.getContextPath()+ StringUtils.INPUT_ERROR);
		}else {
			response.sendRedirect(request.getContextPath()+ StringUtils.SERVER_ERROR);
		}
	    
	    
	}


}
