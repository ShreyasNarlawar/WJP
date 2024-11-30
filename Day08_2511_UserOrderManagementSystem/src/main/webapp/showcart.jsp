<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.time.LocalDate,java.util.List,com.demo.beans.CartItem"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OrderManageSystem</title>
</head>
<body>
User Name: ${User.username}
Date : <%=LocalDate.now() %>
<table border='2'>
<tr>
<th>Product  pid </th>
<th>Product  pname</th>
<th>Product  qty </th>
<th>Product Price</th>
<th>  Amount     </th>
</tr>

<%double amt=0;
List<CartItem>cart	=(List<CartItem>)session.getAttribute("cart");
for(CartItem ci:cart){
%>
<tr>
<td><%=ci.getPid()%></td>
<td><%=ci.getPname()%></td>
<td><%=ci.getOrdQty()%></td>
<td><%=ci.getPrice()%></td>
<td><%=ci.getPrice()*ci.getOrdQty()%></td>
</tr>
<%amt+=ci.getPrice()*ci.getOrdQty();
}%>
<tr>
<th colspan="4" align="right">Total bill amount</th>
<td><%=amt%></td>
</tr>

</table>
<a href="categories">add more products</a>
<form action="payment.jsp">
   <button type="submit" name="btn" id="btn">Payment</button>
</form>
</body>
</html>