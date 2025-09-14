package com.ecommerce.controller;

import com.ecommerce.util.DBConnection;
import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO products(name, description, price) VALUES(?, ?, ?)"
            );
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setDouble(3, price);
            ps.executeUpdate();
            response.sendRedirect("admin/manage_products.jsp");
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
            response.sendRedirect("admin/manage_products.jsp?error=1");
        }
    }
}
