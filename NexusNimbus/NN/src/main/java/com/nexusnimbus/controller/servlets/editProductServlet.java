package com.nexusnimbus.controller.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nexusnimbus.controller.DatabaseController;
import com.nexusnimbus.model.ProductModel;
import com.nexusnimbus.utils.StringUtils;

/**
 * Servlet implementation class editProductServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/editProductServlet"})
public class editProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DatabaseController dbController = new DatabaseController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editProductServlet() {
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
		// Set response content type
		response.setContentType("text/html");

		// Retrieve form data
		String name = request.getParameter("Name");
		String processor = request.getParameter("Processor");
		String gpu = request.getParameter("gpu");
		String brand = request.getParameter("Brand");
		String display = request.getParameter("Display");
		String memory = request.getParameter("Memory");
		String storage= request.getParameter("Storage");
		String price = request.getParameter("Price");
		int parsedPrice = Integer.parseInt(price);


		ProductModel product = new ProductModel(name, processor, gpu, brand, display, memory, storage, parsedPrice, "NA");

		int result = dbController.editProduct(product);

		if (result == 1) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayProductServlet");
            dispatcher.forward(request, response);
		} else if (result == 0){
			response.sendRedirect(request.getContextPath()+ StringUtils.INPUT_ERROR);
		}else {
			response.sendRedirect(request.getContextPath()+ StringUtils.SERVER_ERROR);
		}
		
	}

}
