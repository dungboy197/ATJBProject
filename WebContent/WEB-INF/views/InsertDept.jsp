<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Department</title>
</head>
<body>
	<div>
		<h3>Add Department</h3>
	</div>
	<div>
		<table class="center">
			<form method="POST"
				action="${pageContext.request.contextPath}/InsertDept">
				<tr>
					<td>Department Name</td>
					<td><input type="text" name="DeptName"
						value="${department.deptName}"></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><textarea name="Description" rows="6" cols="30"
							value="${department.description}"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<button style="text-align: center;">Save</button>
						<button> <a href="ListDept">Cancel</a></button>
					</td>
				</tr>
			</form>
		</table>
</body>
</html>