<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit user Form</title>
</head>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
<body>
	<form:form method="POST"
		action="${pageContext.request.contextPath }/updateuser" modelAttribute="userModel">
		<!-- <form> -->
		<form:input path="id" disabled="true"/>
		<div class="form-group">
			<form:label path="userName"></form:label>
			<form:input type="text" path="userName" class="form-control"
				id="exampleFormControlInput1"/>
		</div>
		<div class="form-group">
		<form:label path="emailAddress"></form:label>
		<form:input path="emailAddress" type="email" class="form-control" id="exampleFormControlInput1"/>
		</div>
		<div class="form-group">
			<form:label path="language">Select Language</form:label>
			<form:select path="language" class="form-control"
				id="exampleFormControlSelect1">
				<form:option value="NONE" label="select"></form:option>
				<form:options items="${languageList}"></form:options>
			</form:select>
		</div>
		<div class="form-group">
			<form:label path="aboutYourSelf">ABOUT YOURSELF</form:label>
			<form:textarea path="aboutYourSelf" class="form-control"
				id="exampleFormControlTextarea1" rows="3" />
		</div>
		<button type="submit" class="btn btn-primary">Update User Info</button>
	</form:form>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WELCOME PAGE</title>
</head>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">


<body>
	<h1>WELCOME TO WEB APPLICATION DEMO</h1>
	 <nav id="sidebar-wrapper">
      <ul class="sidebar-nav">
        <li class="sidebar-brand">
          <a class="js-scroll-trigger" href="${pageContext.request.contextPath}/userform">Create new user</a>
        </li>
        <li class="sidebar-nav-item">
          <a class="js-scroll-trigger" href="${pageContext.request.contextPath}/userlist">Show all users</a>
        </li>
      </ul>
    </nav>
</body>
</html>