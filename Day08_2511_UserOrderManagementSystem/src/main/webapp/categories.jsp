<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OrderManageSystem</title>
</head>
<body>
<h2>Select Category</h2>
<form action="getProducts"><select name="cid" id="cid"> 
<c:forEach var="c" items="${clist}" >
<option value="${c.cid}"> ${c.cname}</option>
</c:forEach>
</select>
<button type="submit" name="btn" id="btn">Show Products</button>
</form>
<a href="showcart.jsp">Show Cart</a>
</body>
</html>