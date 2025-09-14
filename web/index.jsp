<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<header>WELCOME TO SHOPEASE</header>

<nav>
    <a href="index.jsp">Home</a>
    <a href="products.jsp">Products</a>
    <a href="cart.jsp">Cart</a>
    <a href="login.jsp">Login</a>
    <a href="register.jsp">Registration</a>
</nav>

<!-- Hero Section -->
<div class="hero-section">
    <%-- Randomly pick an image from pp1.jpg to pp4.jpg --%>
    <%
        String[] images = {"pp1.jpg", "pp2.jpg", "pp3.jpg", "pp4.jpg"};
        int index = (int) (Math.random() * images.length);
    %>
    <div class="hero-section" style="background-image: url('images/<%= images[index] %>');">
        <div class="hero-text">
            <h1>Welcome to <span>ShopEase</span></h1>
            <p>Discover the best products at amazing prices!</p>
            <a href="products.jsp" class="shop-btn">Start Shopping</a>
        </div>
    </div>
</div>

<footer>
    &copy; 2025 ShopEase | All Rights Reserved
</footer>

</body>
</html>