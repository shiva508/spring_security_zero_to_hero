<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>h! <security:authentication property="principal.username" /></title>
</head>

<body>
<jsp:include page="header.jsp" flush="true"></jsp:include>
	<br>
	<%-- <h1>Welcome to INFINITY <security:authentication property="principal.username" /> </h1> --%>
	<nav id="sidebar-wrapper">
	<ul class="sidebar-nav">
		<li class="sidebar-brand"><a class="js-scroll-trigger"
			href="${pageContext.request.contextPath}/userform">Create new
				user</a></li>
		<li class="sidebar-nav-item"><a class="js-scroll-trigger"
			href="${pageContext.request.contextPath}/userlist">Show all users</a>
		</li>
	</ul>
	</nav>

	<%-- <security:authorize access="hasAnyRole('ADMIN')">
		<a class="btn btn-lg btn-primary btn-block"
			style="width: 100px; height: 50px"
			href="${pageContext.request.contextPath}/admin/">Admin</a>
	</security:authorize>
	<security:authorize access="hasAnyRole('CEO')">
		<a class="btn btn-lg btn-primary btn-block"
			style="width: 100px; height: 50px"
			href="${pageContext.request.contextPath}/ceo/">CEO</a>
	</security:authorize>
	<security:authorize access="hasAnyRole('RND','MANAGER')">
		<a class="btn btn-lg btn-primary btn-block"
			style="width: 100px; height: 50px"
			href="${pageContext.request.contextPath}/r&d/">R&D</a>
	</security:authorize> --%>
	<%-- USER:
	<security:authentication property="principal.username" />
	ROLES:
	<security:authentication property="principal.authorities" /> --%>
	<jsp:include page="Footer.jsp" flush="true"></jsp:include>
</body>
</html>