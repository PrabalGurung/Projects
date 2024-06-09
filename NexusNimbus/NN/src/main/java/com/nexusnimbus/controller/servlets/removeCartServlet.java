package com.nexusnimbus.controller.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nexusnimbus.controller.DatabaseController;
import com.nexusnimbus.utils.StringUtils;


/**
 * Servlet implementation class removeCartServlet
 */
@WebServlet("/removeCartServlet")
public class removeCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController db = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeCartServlet() {
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
        String productId = request.getParameter("productId");
        String sessionId = "";
        HttpSession session = request.getSession();
	    if (session.getAttribute("email") == null) {
	    	response.sendRedirect(request.getContextPath() + StringUtils.LOGIN_PAGE);
	    }else {
	    	 sessionId = (String) session.getAttribute("userId"); 
	    }
        if (productId != null) {
            try {
                int res = db.deleteCartProduct(productId, sessionId);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("/showCartServlet");
                dispatcher.forward(request, response);
                
            } catch (NumberFormatException e) {
            	response.sendRedirect(request.getContextPath()+ StringUtils.SERVER_ERROR);
            }
        } else {
        	response.sendRedirect(request.getContextPath()+ StringUtils.CART_PAGE);
       
        }
        
	}

}
