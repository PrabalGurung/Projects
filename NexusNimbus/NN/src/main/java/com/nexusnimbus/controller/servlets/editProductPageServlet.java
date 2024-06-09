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
 * Servlet implementation class editProductPage
 */
@WebServlet("/editProductPageServlet")
public class editProductPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController db = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editProductPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("productId");
		System.out.print(id);
		System.out.print("-------");
		List<ProductModel> products = db.getProductsEdit(id);
		System.out.print("---yaya----");
		request.setAttribute("products", products);
		request.getRequestDispatcher("/pages/admin/editProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
