<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<style>
  body{
    text-align:center;
  }
  p.img{
       width:200px;
       height:200px;
  }
</style>
<p><img class="img" src="/WEB-INF/images/emp"></p>
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
		<tr>
			<c:forEach items="${empData}" var='data'>
				<td><c:out value="${data.id}"></c:out></td>
				<td><c:out value="${data.company}"></c:out></td>
				<td><c:out value="${data.deptname}"></c:out></td>
				<td><c:out value="${data.name}"></c:out></td>
				<td><c:out value="${data.role}"></c:out></td>
				<td><c:out value="${data.salary}"></c:out></td>
			</c:forEach>
		<tr>
	</table>
</body>
</html>
