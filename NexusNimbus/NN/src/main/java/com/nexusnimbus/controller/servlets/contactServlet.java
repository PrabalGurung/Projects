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
 * Servlet implementation class contactServlet
 */
@WebServlet("/contactServlet")
public class contactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DatabaseController db = new DatabaseController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contactServlet() {
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
		 String name = request.getParameter("name");
		 String email = request.getParameter("email");
		 String message = request.getParameter("message");

		    int loginResult = db.addMessage(name, email, message);
		    
		    if (loginResult == 1) {  
		    	response.sendRedirect(request.getContextPath()+ "/pages/Contact.jsp");
			}else if(loginResult == 0) {
				response.sendRedirect(request.getContextPath()+ StringUtils.SERVER_ERROR);
			}else {
				response.sendRedirect(request.getContextPath()+ StringUtils.SERVER_ERROR);
			}
	}

}
