<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="${pageContext.request.contextPath}/component/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/component/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/popper.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/bootstrap.min.js"></script>
<body>
<form:form method="Post" action="${pageContext.request.contextPath}/admin/saveroles" modelAttribute="role">
<form:label path="roleName">Role</form:label>
<form:input path="roleName"/>
<button class="btn btn-lg btn-primary btn-block" style="width: 100px;margin-left: 45%;"  type="submit">Add Role</button> 
</form:form>
</body>
</html>