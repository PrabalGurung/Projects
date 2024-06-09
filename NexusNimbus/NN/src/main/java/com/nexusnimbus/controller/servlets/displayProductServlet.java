package com.nexusnimbus.controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nexusnimbus.controller.DatabaseController;
import com.nexusnimbus.model.ProductModel;

/**
 * Servlet implementation class displayProductServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/displayProductServlet"})
public class displayProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DatabaseController dbController = new DatabaseController();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public displayProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ProductModel> products = dbController.getProducts();
		request.setAttribute("products", products);
		request.getRequestDispatcher("/pages/admin/product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
