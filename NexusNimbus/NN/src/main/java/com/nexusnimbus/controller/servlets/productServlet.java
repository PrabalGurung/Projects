package com.nexusnimbus.controller.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nexusnimbus.controller.DatabaseController;
import com.nexusnimbus.model.ProductModel;
import com.nexusnimbus.utils.StringUtils;

@WebServlet(asyncSupported = true, urlPatterns = {"/productServlet"})
@MultipartConfig
public class productServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final DatabaseController dbController = new DatabaseController();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Retrieve form data
        String productID = request.getParameter("Product_Id");
        String productName = request.getParameter("Product_Name");
        String brand = request.getParameter("Brand");
        String price = request.getParameter("Price");
        int parsedPrice = 0;
        try {
            parsedPrice = Integer.parseInt(price);
        } catch (NumberFormatException e) {
            // Handle invalid price
            response.sendRedirect(request.getContextPath() + StringUtils.INPUT_ERROR);
            return;
        }

        String processor = request.getParameter("Processor");
        String gpu = request.getParameter("gpu");
        String display = request.getParameter("Display");
        String memory = request.getParameter("Memory");
        String storage = request.getParameter("Storage");
        Part filePart = request.getPart("Path");
        String fileName = filePart.getSubmittedFileName();

        // Save file to server
        String savePath = "D:/CourseworkJava/NN/src/main/webapp/pages/images/";
        System.out.print(savePath);
        InputStream fileContent = filePart.getInputStream();
        try (FileOutputStream outputStream = new FileOutputStream(new File(savePath, fileName))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileContent.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            // Handle file saving error
            response.sendRedirect(request.getContextPath() + StringUtils.SERVER_ERROR);
            return;
        } finally {
            // Ensure input stream is closed
            if (fileContent != null) {
                fileContent.close();
            }
        }
        
        // Create ProductModel instance
        ProductModel product = new ProductModel(productName, processor, gpu, brand, display, memory, storage, parsedPrice, fileName);

        // Add product to database
        int result = dbController.addProduct(product);

        // Handle result
        if (result == 1) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayProductServlet");
            dispatcher.forward(request, response);
        } else if (result == 0) {
            response.sendRedirect(request.getContextPath() + StringUtils.INPUT_ERROR);
        } else {
            response.sendRedirect(request.getContextPath() + StringUtils.SERVER_ERROR);
        }
    }
}
