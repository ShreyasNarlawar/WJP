<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="hello" uri="/mytaglib" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Custom Tag Demo</title>
</head>
<body>
<%
    String fnm = "shreyas";
    String lnm = "mulay";
%>
<h1>Custom Tag Demo</h1>
<hello:myhello fname="<%=fnm%>" lname="<%=lnm %>"></hello:myhello>
<hello:calculate num1='<%= Integer.parseInt(request.getParameter("num1")) %>' num2='<%= Integer.parseInt(request.getParameter("num2")) %>'></hello:calculate>
</body>
</html>
