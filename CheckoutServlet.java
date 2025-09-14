package com.ecommerce.controller;

import com.ecommerce.model.CartItem;
import com.ecommerce.util.DBConnection;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        Integer userId = (Integer) session.getAttribute("userId");
        String address = request.getParameter("address");
        String paymentMethod = request.getParameter("paymentMethod");

        if (cart == null || cart.isEmpty() || userId == null) {
            response.sendRedirect("cart.jsp");
            return;
        }

        Connection con = null;
        try {
            con = DBConnection.getConnection();
            con.setAutoCommit(false);

            // Insert into orders
            PreparedStatement orderPs = con.prepareStatement(
                "INSERT INTO orders(user_id, address, payment_method, status) VALUES(?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );
            orderPs.setInt(1, userId);
            orderPs.setString(2, address);
            orderPs.setString(3, paymentMethod);
            orderPs.setString(4, "Pending");
            orderPs.executeUpdate();

            ResultSet keys = orderPs.getGeneratedKeys();
            int orderId = 0;
            if (keys.next()) {
                orderId = keys.getInt(1);
            }

            // Insert order items
            PreparedStatement itemPs = con.prepareStatement(
                "INSERT INTO order_items(order_id, product_id, quantity, price) VALUES(?, ?, ?, ?)"
            );

            for (CartItem item : cart) {
                itemPs.setInt(1, orderId);
                itemPs.setInt(2, item.getId());
                itemPs.setInt(3, item.getQuantity());
                itemPs.setDouble(4, item.getPrice());
                itemPs.addBatch();
            }
            itemPs.executeBatch();

            con.commit();
            session.removeAttribute("cart"); // Clear cart after success
            response.sendRedirect("index.jsp?orderSuccess=1");

        } catch (Exception e) {
            e.printStackTrace();
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            response.sendRedirect("checkout.jsp?error=1");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
