package com.ecommerce.controller;

import com.ecommerce.model.Product;
import com.ecommerce.model.CartItem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;

@WebServlet("/AddToCartServlet")   // ✅ Servlet mapping
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int productId = Integer.parseInt(request.getParameter("productId"));

        // ✅ Product list (same as products.jsp)
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Pink High Heel", 499, "images/pp5.jpg"));
        products.add(new Product(2, "Fairy Long Gown", 699, "images/pp6.jpg"));
        products.add(new Product(3, "Harry Potter Book Set", 899, "images/pp7.jpg"));
        products.add(new Product(4, "Black Leather Jacket", 1299, "images/pp8.jpg"));
        products.add(new Product(5, "Golden Watch", 1599, "images/pp9.jpg"));
        products.add(new Product(6, "Duck Plushie", 399, "images/pp10.jpg"));
        products.add(new Product(7, "Wall Hanging Decor", 799, "images/pp11.jpg"));
        products.add(new Product(8, "Sports Shoes", 999, "images/pp12.jpg"));
        products.add(new Product(9, "Sunglasses", 349, "images/pp13.jpg"));
        products.add(new Product(10, "Travel Backpack", 1199, "images/pp14.jpg"));

        // ✅ Find product by ID
        Product selectedProduct = null;
        for (Product p : products) {
            if (p.getId() == productId) {
                selectedProduct = p;
                break;
            }
        }

        if (selectedProduct != null) {
            HttpSession session = request.getSession();
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

            if (cart == null) {
                cart = new ArrayList<>();
            }

            // Check if product already exists in cart → increase qty
            boolean found = false;
            for (CartItem item : cart) {
                if (item.getId() == selectedProduct.getId()) {
                    item.setQuantity(item.getQuantity() + 1);
                    found = true;
                    break;
                }
            }

            // If not found, add new cart item
            if (!found) {
                cart.add(new CartItem(selectedProduct, 1));
            }

            session.setAttribute("cart", cart);
        }

        // ✅ Redirect back to cart
        response.sendRedirect("cart.jsp");
    }
}
