<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Checkout</title>
</head>
<body>
    <h2>Checkout</h2>
    <form action="CheckoutServlet" method="post">
        Address: <input type="text" name="address" required><br>
        Payment Method:
        <select name="paymentMethod">
            <option value="COD">Cash on Delivery</option>
            <option value="Card">Credit/Debit Card</option>
        </select><br>
        <input type="submit" value="Place Order">
    </form>
</body>
</html>
