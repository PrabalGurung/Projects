package com.nexusnimbus.controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nexusnimbus.controller.DatabaseController;
import com.nexusnimbus.model.UserModel;
import com.nexusnimbus.utils.StringUtils;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {StringUtils.REGISTER_SERVLET})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DatabaseController dbController = new DatabaseController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter(StringUtils.FIRST_NAME);
		String lastName = request.getParameter(StringUtils.LAST_NAME);
		String phoneNumber = request.getParameter(StringUtils.PHONE_NUMBER);
		String address = request.getParameter(StringUtils.ADDRESS);
		String email = request.getParameter(StringUtils.EMAIL);
		String password = request.getParameter(StringUtils.PASSWORD);
		String confirmPassword = request.getParameter(StringUtils.CONFIRM_PASSWORD);
		
		UserModel userModel = new UserModel(firstName, lastName, phoneNumber, address, email, password);
		int result = dbController.addUser(userModel);
		
		if(password.equals(confirmPassword)) {
			switch(result) {
				case 1 ->{
					request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESS_REGISTER_MESSAGE);
					response.sendRedirect(request.getContextPath() + StringUtils.HOME_PAGE);
				}
				case 0->{
					request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.REGISTER_ERROR_MESSAGE);
					request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
				}
				case -1 ->{
					request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
					request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
				}
				case -2 ->{
					request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.EMAIL_ERROR_MESSAGE);
					request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
				}
				case -3 ->{
					request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.PHONENO_ERROR_MESSAGE);
					request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
				}
				default ->{
					request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
					request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
				}
			}
		}else {
			request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.PASSWORD_UNMATCHED_ERROR_MESSAGE);
			request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
		}
	}

}
