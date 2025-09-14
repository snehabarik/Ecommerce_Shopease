<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<header>SHOPEASE</header>

<nav>
    <a href="index.jsp">Home</a>
    <a href="products.jsp">Products</a>
    <a href="cart.jsp">Cart</a>
    <a href="login.jsp">Login</a>
    <a href="register.jsp">Registration</a>
</nav>

<div class="login-container">
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        <!-- Match LoginServlet.java (expects email + password) -->
        <input type="text" name="email" placeholder="Email" required><br>
        <input type="password" name="password" placeholder="Password" required><br>
        <button type="submit">Login</button>
    </form>

    <%-- Show error if login failed --%>
    <%
        String error = request.getParameter("error");
        if ("1".equals(error)) {
    %>
        <p style="color:red; text-align:center;">Invalid email or password. Please try again.</p>
    <% } %>
</div>

<footer>
    &copy; 2025 SHOPEASE | All Rights Reserved
</footer>

</body>
</html>
