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

@WebServlet(asyncSupported = true, urlPatterns = {"/deleteProduct"})
public class deleteProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    DatabaseController db = new DatabaseController();
    
    public deleteProduct() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        System.out.println(productId);

        if (productId != null) {
            try {
            	int res = db.deleteProduct(productId);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/displayProductServlet");
                dispatcher.forward(request, response);
                
            } catch (NumberFormatException e) {
            	response.sendRedirect(request.getContextPath()+ StringUtils.SERVER_ERROR);
            }
        } else {
        	response.sendRedirect(request.getContextPath()+ StringUtils.SERVER_ERROR); 
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
}
