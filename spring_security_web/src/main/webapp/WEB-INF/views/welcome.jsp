<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>EMPLOYEE PAGE</title><link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="webjars/jquery/3.0.0/jquery.min.js" ></script>
 <script type="text/javascript"
	src="${pageContext.request.contextPath}/component/js/jquery.min.js">
	</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/component/js/jquery-ui.js">
	</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/component/js/jquery.dataTables.min.js">
	</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/component/js/placeholders.jquery.min.js">
	</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/component/js/placeholders.jquery.min.js">
	</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/component/js/bootstrap.js">
	</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/component/js/bootstrap.min.js">
	</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/component/js/bootstrap-datepicker.js">
	</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/component/js/dataTables.bootstrap.js">
	</script>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Features</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Pricing</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         Our Duties
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
        <security:authorize access="hasAnyRole('ADMIN')">
		<a class="dropdown-item"  href="${pageContext.request.contextPath}/admin/">Admin</a>
		</security:authorize>
		<security:authorize access="hasAnyRole('CEO')">
		<a href="${pageContext.request.contextPath}/ceo/">CEO</a>
		</security:authorize>
		<security:authorize access="hasAnyRole('RND','MANAGER')">
		<a href="${pageContext.request.contextPath}/r&d/">R&D</a> 
		</security:authorize>
        </div>
      </li>
    </ul>
  </div>
</nav>

USER:<security:authentication property="principal.username" />
ROLES:<security:authentication property="principal.authorities" />
<form:form action="${pageContext.request.contextPath}/logout" method="POST">

<input class="btn btn-lg btn-primary btn-block" type="submit" value="logout"> 
</form:form>
</body>
</html>