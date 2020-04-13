<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
ul {
	margin: 10px;
	padding: 5px;
	text-align: center;
}

body {
	background-color: powderblue;
}
h1{
  top:2%;
}
input[type=text] {
	position: relative;
	left: 140px;
	bottom: 20px;
	border-radious: 3px;
}

lable {
	width: 50%;
	bottom: 40%:
}

nav {
	text-align: center;
}

img {
	position:absolute;;
	right:15%;
	width:35%;
	top:25%;
}

h1 {
	text-align:center;
}

p.getdata{
	postion:fixed;
	bottom:0;
	right:0:
}
</style>
<body>
<div class="jumbotron">
    <div class="container">

	<h1>Welcome to Emp Management</h1>
	<p class="getdata"><a href="getAllData">GetData</a></p>

	<img src="<c:url value='/assets/images/emp.png' />" alt="..."
		class="img-thumbnail">
	<form action="getdetails" method="GET">

		<lable for="id">EMP ID</lable>
		<br> <input type="text" name="id"><br> <label
			for="cname">COMPANYNAME</label><BR> <input type="text"
			name="comanyname"> <br> <label for="deptname">Deptname</label><BR>
		<input type="text" name="deptname"><br> <label
			for="empname">Emp name</label> <BR> <input type="text"
			name="empname"><br> <label for="role">Emp Role</label><BR>
		<input type="text" name="role"><br> <label for="salary">Emp
			Salary</label><BR> <input type="text" name="salary"><br> <input
			type="submit" value="submit" title="submit">
	</form>
	Employee Status:${txstatus}
	<nav>
		<a href="/html/">about us</a> | <a href="ContactUS.jsp">ContactUS</a>
		| <a href="/js/">polices</a> | <a href="/jquery/">privacy</a>
	</nav>
	    </div>
</div>
</body>
</html>
