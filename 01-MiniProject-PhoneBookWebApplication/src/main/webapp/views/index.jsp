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
<h1>WELCOME TO PHONEBOOK APPLICATION</h1>

	<font color="green">${succMsg}</font>
	<font color="red">${errMsg}</font>

	<form:form action="saveContact"  method="POST"  modelAttribute="contact">
			
	<table>
		<tr>
			<td>CONTACT NAME</td>
			<td><form:input path="cname"/></td>
			<form:hidden path="cid"/>
		</tr>
		
		<tr>
			<td>CONTACT MAIL</td>
			<td><form:input path="cmail"/></td>
		</tr>
		
		<tr>
			<td>CONTACT phno</td>
			<td><form:input path="phno"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="submit here"></td>
		</tr>
	</table>
	</form:form>
	
	<a href="viewContacts" >view all contacts</a>
	
</body>
</html>