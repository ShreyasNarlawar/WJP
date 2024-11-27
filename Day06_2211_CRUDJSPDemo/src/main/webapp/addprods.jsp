<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addProduct">
		Product id : <input type="text" name="pid" id ="pid"> <br>
		Product Name : <input type="text" name="pname" id ="pname"> <br>
		Qty : <input type="text" name="qty" id ="qty"> <br>
		Price : <input type="text" name="price" id ="price"> <br>
		Date : <input type="text" name="date" id ="date"> <br>
		Category id : <input type="text" name="cid" id ="cid"> <br>
		
		<button type="submit" name="btn" id="btn" value="add">Add New Product</button>
	
	</form> <br>
</body>
</html>