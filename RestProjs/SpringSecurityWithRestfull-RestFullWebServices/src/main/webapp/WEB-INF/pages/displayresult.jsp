<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
body {
	position:fixed;
	text-align: center;
	background-color: rgb(0, 0, 0, 20);
	background-image: url("/assets/images/emp.png");
	right:20%;
}

img {
	position: fixed;
	right: 25%;
	width: 70%;
}
</style>
<body>

	<table border="1">
		<tr>
			<th>EMP ID</th>
			<th>EMP COMPANY</th>
			<th>EMP DEPT</th>
			<th>EMP NAME</th>
			<th>EMP ROLE</th>
			<th>EMP SLARY</th>
		</tr>
		<c:forEach items="${empData}" var='data'>
			<tr>
				<td><c:out value="${data.id}"></c:out></td>
				<td><c:out value="${data.company}"></c:out></td>
				<td><c:out value="${data.deptname}"></c:out></td>
				<td><c:out value="${data.name}"></c:out></td>
				<td><c:out value="${data.role}"></c:out></td>
				<td><c:out value="${data.salary}"></c:out></td>
		</c:forEach>
		<tr>
	</table>
	<img src="<c:url value='/assets/images/Empmgt.png'/>">
</body>
</html>
