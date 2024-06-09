package com.nexusnimbus.controller.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nexusnimbus.controller.DatabaseController;
import com.nexusnimbus.model.CartModel;
import com.nexusnimbus.model.ProductModel;
import com.nexusnimbus.utils.StringUtils;


/**
 * Servlet implementation class showServletCart
 */
@WebServlet("/showCartServlet")
public class showCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController db = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showCartServlet() {
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
	    String id = (String) session.getAttribute("userId");
	    int customerId = Integer.parseInt(id);
	    List<ProductModel> products = db.cartProduct(customerId);
	 
		request.setAttribute("products", products);
		request.getRequestDispatcher("/pages/cart.jsp").forward(request, response);
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
