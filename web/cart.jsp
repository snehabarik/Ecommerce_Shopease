<%@ page import="java.util.*,com.ecommerce.model.CartItem" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Cart</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header>SHOPEASE</header>

<h2 style="text-align:center;">🛒 Your Cart</h2>

<%
    List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
    double total = 0;
    if (cart != null && !cart.isEmpty()) {
%>
    <table class="cart-table">
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
            <th>Action</th>
        </tr>
        <%
            for (CartItem item : cart) {
                double itemTotal = item.getPrice() * item.getQuantity();
                total += itemTotal;
        %>
        <tr>
            <td><%= item.getName() %></td>
            <td>₹<%= item.getPrice() %></td>
            <td><%= item.getQuantity() %></td>
            <td>₹<%= itemTotal %></td>
            <td>
                <form action="RemoveFromCartServlet" method="post" style="display:inline;">
                    <input type="hidden" name="productId" value="<%= item.getId() %>">
                    <button type="submit" class="remove-btn">Remove</button>
                </form>
            </td>
        </tr>
        <% } %>
        <tr>
            <td colspan="3" align="right"><b>Grand Total:</b></td>
            <td colspan="2">₹<%= total %></td>
        </tr>
    </table>
    <br>
    <form action="OrderServlet" method="post" style="text-align:center;">
        <button type="submit" class="checkout-btn">Proceed to Checkout</button>
    </form>
<% } else { %>
    <p style="text-align:center;">Your cart is empty.</p>
<% } %>

<footer>&copy; 2025 SHOPEASE | All Rights Reserved</footer>
</body>
</html>
