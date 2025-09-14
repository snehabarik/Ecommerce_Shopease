<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*, com.ecommerce.util.DBConnection" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Products</title>
</head>
<body>
    <h2>Product Management</h2>
    <form action="ProductServlet" method="post">
        Name: <input type="text" name="name" required>
        Desc: <input type="text" name="description" required>
        Price: <input type="number" name="price" step="0.01" required>
        <input type="submit" value="Add Product">
    </form>

    <h3>Existing Products</h3>
    <table border="1" cellpadding="10">
        <tr><th>ID</th><th>Name</th><th>Price</th></tr>
        <%
            try {
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM products");
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("id") %></td>
            <td><%= rs.getString("name") %></td>
            <td>₹<%= rs.getDouble("price") %></td>
        </tr>
        <%  }
                con.close();
            } catch(Exception e) {
                out.println("Error: " + e.getMessage());
            }
        %>
    </table>
</body>
</html>
