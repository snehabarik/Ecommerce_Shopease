package com.ecommerce.controller;

import com.ecommerce.model.CartItem;
import com.ecommerce.util.DBConnection;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/OrderServlet")   // <-- Add this
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (cart != null && !cart.isEmpty()) {
            try {
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO orders (product_id, product_name, price, quantity) VALUES (?, ?, ?, ?)"
                );

                for (CartItem item : cart) {
                    ps.setInt(1, item.getId());
                    ps.setString(2, item.getName());
                    ps.setDouble(3, item.getPrice());
                    ps.setInt(4, item.getQuantity());
                    ps.executeUpdate();
                }

                con.close();

                // Clear cart after placing order
                session.removeAttribute("cart");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect("thankyou.jsp");
    }
}
