package com.nexusnimbus.controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nexusnimbus.controller.DatabaseController;
import com.nexusnimbus.utils.StringUtils;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { StringUtils.LOGIN_SERVLET})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	DatabaseController dbController = new DatabaseController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String email = request.getParameter("Email");
	    String password = request.getParameter("Password");
	    int loginResult = dbController.getUserLoginInfo(email, password);
	    
	    if (loginResult == 1) {    	
	    	String userId = dbController.getUserId(email);
	    	HttpSession session = request.getSession();
	    	session.setAttribute("email", email);
	    	session.setAttribute("userId", userId);
	    	session.setMaxInactiveInterval(30*60);
	    	
	    	System.out.print(userId);
	    	
	    	boolean isAdmin = dbController.isAdmin(email);
	    	
	    	if(isAdmin) {
	    		session.setAttribute("role", "admin");
	    		request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_LOGIN_MESSAGE);
	    		response.sendRedirect(request.getContextPath() + "/pages/admin/dashBoard.jsp");
	    	}else {
	    		session.setAttribute("role", "user");
	    		request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_LOGIN_MESSAGE);
	    		request.getRequestDispatcher(StringUtils.HOME_PAGE).forward(request, response);
	    	}
	    }else if(loginResult == 0) {
	    	request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.LOGIN_ERROR_MESSAGE);
	    	request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
	    }else {
	    	request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
			request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
	    }
	}

}
