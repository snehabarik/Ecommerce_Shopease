package com.ecommerce.controller;

import com.ecommerce.model.CartItem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;

@WebServlet("/RemoveFromCartServlet")   // ✅ Correct mapping
public class RemoveFromCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int productId = Integer.parseInt(request.getParameter("productId"));

        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (cart != null) {
            Iterator<CartItem> iterator = cart.iterator();
            while (iterator.hasNext()) {
                CartItem item = iterator.next();
                if (item.getId() == productId) {
                    iterator.remove();   // ✅ Remove from cart
                    break;
                }
            }
            session.setAttribute("cart", cart);
        }

        // Redirect back to cart
        response.sendRedirect("cart.jsp");
    }
}
