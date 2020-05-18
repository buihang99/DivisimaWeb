<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
</head>
<body>
	<h3>Product list</h3>
	<p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1"  >
       <tr>
          <th>Code</th>
          <th>Name</th>
          <th>Price</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach var="product" items="${List}" >
          <tr>
             <td>${product.getMaSP()}</td>
             <td>${product.getTenSP()}</td>
             <td>${product.getPrice()}</td>
             <td>
                <a href="#">Edit</a>
             </td>
             <td>
                <a href="#">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="createProduct" >Create Product</a>
 
</body>
</html>