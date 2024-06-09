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
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {StringUtils.UPDATE_PROFILE_SERVLET})
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DatabaseController dbController = new DatabaseController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileServlet() {
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
		String firstName = request.getParameter(StringUtils.FIRST_NAME);
		String lastName = request.getParameter(StringUtils.LAST_NAME);
		String phoneNumber = request.getParameter(StringUtils.PHONE_NUMBER);
		String address = request.getParameter(StringUtils.ADDRESS);
		String email = request.getParameter(StringUtils.EMAIL);
		String newPassword = request.getParameter("updatedpassword");
		
		UserModel userModel = new UserModel(firstName, lastName, phoneNumber, address, email, newPassword);
		int res = dbController.updateUser(userModel, request);
		
		
			switch(res) {
				case 1->{
					response.sendRedirect(request.getContextPath()+ StringUtils.EDIT_PROFILE_PAGE);
				}
				case 0->{
					response.sendRedirect(request.getContextPath()+ StringUtils.INPUT_ERROR);
				}
				case -1 ->{
					response.sendRedirect(request.getContextPath()+ StringUtils.SERVER_ERROR);
				}
				case -2 ->{
					response.sendRedirect(request.getContextPath()+ StringUtils.PHONE_NUMBER_PAGE);
				}
				default ->{
					response.sendRedirect(request.getContextPath()+ StringUtils.SERVER_ERROR);
				}
				
			}
	}

}
