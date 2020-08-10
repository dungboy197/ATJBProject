<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="author" content="DungDA5">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Person screen</title>
	<link rel="stylesheet" type="text/css" href="css/java_tech_css.css">
	<script src="http://code.jquery.com/jquery-1.4.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/validate.js"></script>
</head>
<body>
	<img width="915" height="200" alt="logo" src="img/customLogo.jpg">
	<div>
		<h3 class="Visitor">Visitor information</h3>
	</div>
	<div >
		<table class="center">
			<form method="POST" action="${pageContext.request.contextPath}/EditPerson">
				<tr>
					<td>First name</td>
					<td>
					<input type="hidden" name="PersonID" value="${person.personID}">
						<input type="text" name="FirstName" value="${person.firstName}">
					</td>
				</tr>
				<tr>
					<td>Last name</td>
					<td>
						<input type="text" name="LastName" value="${person.lastName}" >
					</td>
				</tr>
				<tr>
					<td>Gender</td>
					<td>
						<select name="Gender" >
							<option value="Male">Male</option>
							<option value="Female">Female</option>
							<option value="Other">Other</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Telephone</td>
					<td>
						<input type="text" name="PhoneNumber" value="${person.phoneNumber}">
					</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>
						<input type="text" name="Email" value="${person.email}">
					</td>
				</tr>
				<tr>
					<td>You are in</td>
					<td>
						<input type="radio" id="Europe" name="Address" value="Europe">
						<label for="Europe">Europe</label>

						<input type="radio" id="Africa" name="Address" value="Africa">
						<label for="Africa">Africa</label><br>

						<input type="radio" id="Australia" name="Address" value="Australia">
						<label for="Australia">Australia</label>

						<input type="radio" id="Asia" name="Address" value="Asia">
						<label for="Asia">Asia</label>

						<input type="radio" id="America" name="Address" value="America">
						<label for="America">America</label><br>
					</td>
				</tr>
				<tr>
					<td>What are your hobbies</td>
					<td>
						<input type="checkbox" id="Swimming" name="Hobbies" value="Swimming">
						<label for="Swimming">Swimming</label>

						<input type="checkbox" id="Cooking" name="Hobbies" value="Cooking">
						<label for="Cooking">Cooking</label>

						<input type="checkbox" id="Shopping" name="Hobbies" value="Shopping">
						<label for="Shopping">Shopping</label><br>

						<input type="checkbox" id="Sport" name="Hobbies" value="Sport">
						<label for="Sport">Sport</label>

						<input type="checkbox" id="Dance" name="Hobbies" value="Dance">
						<label for="Dance">Dance</label>

						<input type="checkbox" id="Sing" name="Hobbies" value="Sing">
						<label for="Sing">Sing</label><br>
					</td>
				</tr>
				<tr>
					<td>Description</td>
					<td>
						<textarea name="Description" rows="6" cols="30"><c:out value="${person.description}"/></textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
					<button style="text-align: center;" onclick="return(validate());">Save</button>
					<button><a href= "DeletePerson?PersonID=${person.personID}">Delete</a></button>
					<button><a href= "ListPerson">Cancel</a></button>
					</td>
				</tr>
			</form>
		</table>
        </div>
	</div>
</body>
</html>
