package com.ecommerce.controller;

import com.ecommerce.model.CartItem;
import com.ecommerce.util.DBConnection;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE id=?");
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                CartItem item = new CartItem(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    quantity
                );

                HttpSession session = request.getSession();
                List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
                if(cart == null) {
                    cart = new ArrayList<>();
                }
                cart.add(item);
                session.setAttribute("cart", cart);
            }
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("cart.jsp");
    }
}
