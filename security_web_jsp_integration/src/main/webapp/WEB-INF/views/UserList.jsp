<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/placeholders.jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/placeholders.jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/dataTables.bootstrap.js"></script>
<link href="${pageContext.request.contextPath}/component/css/bootstrap.css" rel="stylesheet">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users List</title>
</head>
<body>
<h1 style="text-align: center;">Users List</h1>
<a class="btn btn-primary" href="${pageContext.request.contextPath }/userform">Create new user</a>
<table class="table table-hover">
<thead class="thead-dark">
<tr>
<th scope="col">User Name</th>
<th scope="col">Edit</th>
<th scope="col">Delete</th>
</tr>

</thead>
<tbody>
<c:forEach items="${userList}" var="user">
<tr>
 <td>${user.userName}</td> 
<td><a class="btn btn-primary" href="${pageContext.request.contextPath}/edituserpage/${user.id}">Edit</a></td>
<td><a class="btn btn-primary" href="${pageContext.request.contextPath}/deleteuser/${user.id}">Delete</a></td>
</tr>

</c:forEach>
</tbody>
</table>
</body>
</html>