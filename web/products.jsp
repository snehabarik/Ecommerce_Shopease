<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.ecommerce.model.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<header>SHOPEASE</header>

<nav>
    <a href="index.jsp">Home</a>
    <a href="products.jsp">Products</a>
    <a href="cart.jsp">Cart</a>
    <a href="login.jsp">Login</a>
    <a href="lregister.jsp">Registration</a>
</nav>

<div class="container">
    <h2>Our Products</h2>

    <%
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

        for(Product p : products) {
    %>
    <div class="product">
        <img src="<%=p.getImage()%>" alt="<%=p.getName()%>">
        <h3><%=p.getName()%></h3>
        <p>Price: ₹<%=p.getPrice()%></p>
        <form action="AddToCartServlet" method="post">
            <input type="hidden" name="productId" value="<%=p.getId()%>">
            <button type="submit">Add to Cart</button>
        </form>
    </div>
    <% } %>

    <div style="clear:both;"></div>
</div>

<footer>
    &copy; 2025 SHOPEASE | All Rights Reserved
</footer>

</body>
</html>
