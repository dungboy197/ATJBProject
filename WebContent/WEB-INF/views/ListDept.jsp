<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Department</title>
<style>
table,tr,td,th{
	border-collapse: collapse;
}
</style>
</head>
<body>
	<div>
		<h3 style="text-align: center">Department List</h3>
	</div>
	<form method="POST"
		action="${pageContext.request.contextPath}/FindDept">
		<td>Department Name:</td>
		<td><input type="text" name="DeptName"></td>
		<button>Search</button>
	</form>
	<div>
		<button style="text-align: center;">
			<a href="InsertDept">Add Person</a>
		</button>
		<button onclick="return(chk());">
			<a id="link" href="#">Amend</a>
		</button>
	</div>
	<table cellspacing="2" cellpadding="2" border="1">
		<tr>
			<th></th>
			<th>Departmnet Name</th>
			<th>Description</th>
		</tr>
		<c:forEach items="${deptList}" var="dept">
		<tr>
			<td><input type="radio" name="DeptID" value="${dept.deptID}" onclick="getlink()">
			</td>
			<td><label for="DeptID"><c:out value="${dept.deptName}"></c:out></label>
			</td>
			<td><label for="DeptID"><c:out
					value="${dept.description}"></c:out></label></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
<script>
function chk(){
	if(document.querySelector('input[name="DeptID"]:checked')==null){
		alert("Please choosen Department Name Amend ");
		return false;
	}else{
		return true;
	}
}
function getlink(){
	var link ="EditDept?DeptID=" + document.querySelector('input[name="DeptID"]:checked').value;
	document.getElementById("link").href=link; 
}
</script>