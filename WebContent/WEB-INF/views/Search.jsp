<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<link rel="stylesheet" type="text/css" href="css/java_tech_css.css">
</head>
<body>
	<img width="915" height="200" alt="logo" src="img/customLogo.jpg">
	<div>
		<h3 class="Visitor">Search Visitor</h3>
	</div>
	<div>
		<form method="POST"
			action="${pageContext.request.contextPath}/FindPerson">
			<td>First name</td>
			<td><input type="text" name="FirstName"></td>
			<button>Search...</button>
		</form>
	</div>
	<div>
		<button>
			<a href="InsertPerson">add Person</a>
		</button>
		<table cellspacing="2" cellpadding="2" border="1">
			<tr class="list">
				<th style="width: 10%">First name</th>
				<th style="width: 10%">Last name</th>
				<th style="width: 10%">Gender</th>
				<th style="width: 10%">Telephone</th>
				<th style="width: 10%">You're in</th>
				<th style="width: 10%">Hobbies</th>
				<th style="width: 30%">Description</th>
			</tr>
			<c:forEach items="${personList}" var="person">
				<tr>
					<td><a href="EditPerson?personID=${person.personID}">${person.firstName}</a>
					</td>
					<td>${person.lastName}</td>
					<td>${person.gender}</td>
					<td>${person.phoneNumber}</td>
					<td>${person.address}</td>
					<td>${person.hobbies}</td>
					<td>${person.description}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>