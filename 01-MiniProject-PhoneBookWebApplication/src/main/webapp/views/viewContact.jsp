<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- deleteConfirm is a user defiend function and confirm() is a predefiend method which is display pop-up for ok or cancle option -->
	<script >
		function deleteConfirm(){                     
			return confirm("are you sure ,you want to delete?");
			}
	</script>

</head>
<body>
	<h1>view contacts here</h1>
	
<font color="green">${deleCont}</font>	
<p>	<a href="/">+Add new contact</a> </p>  
	
	<table  border="1" >
		<tr>
			<td>contact name</td>
			<td>contact mail</td>
			<td>contact number</td>
			<td>Action</td>
		</tr>
		
		<c:forEach items="${contacts}" var="contact">
			<tr>
				<td>${contact.cname}</td>
				<td>${contact.cmail}</td>
				<td>${contact.phno}</td>
				<td>
					<a href="editContact?cid=${contact.cid}">Edit</a>  <!--here cid write in expression tag that is indicate in dto  -->
					<a href="deleteContact?cid=${contact.cid}" onclick="return deleteConfirm()">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>