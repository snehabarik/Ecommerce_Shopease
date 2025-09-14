<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<header>SHOPEASE</header>

<nav>
    <a href="index.jsp">Home</a>
    <a href="products.jsp">Products</a>
    <a href="cart.jsp">Cart</a>
    <a href="login.jsp">Login</a>
    <a href="register.jsp">Register</a>
</nav>

<div class="register-container">
    <h2>Register</h2>
    <form action="RegisterServlet" method="post">
        <input type="text" name="name" placeholder="Full Name" required><br>
        <input type="email" name="email" placeholder="Email" required><br>
        <input type="password" name="password" placeholder="Password" required><br>
        <input type="password" name="confirmPassword" placeholder="Confirm Password" required><br>
        <button type="submit">Register</button>
    </form>
</div>

<footer>
    &copy; 2025 SHOPEASE | All Rights Reserved
</footer>

</body>
</html>
