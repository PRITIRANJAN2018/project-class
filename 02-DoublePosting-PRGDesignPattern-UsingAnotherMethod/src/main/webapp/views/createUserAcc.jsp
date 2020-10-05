<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>WELCOME TO CREATE USER ACCOUNT</h1>

	<font color="green">${msg}</font>


	<form:form action="create"  method="POST" modelAttribute="usermodel">
	<table>
		<tr>
			<td>user name</td>
			<td><form:input path="uname"/></td>
		</tr>
		
		<tr>
			<td>email</td>
			<td><form:input path="email"/></td>
		</tr>
		
		<tr>
			<td>phone number</td>
			<td><form:input path="phno"/></td>
		</tr>
		
		<tr>
			<td><input type="reset" value="reset here"></td>
			<td><input type="submit" value="submit here"></td>
		</tr>
	</table>
	
	</form:form>
	
</body>
</html>