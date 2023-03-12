<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/component/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/component/js/jquery-ui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/component/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/component/js/placeholders.jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/component/js/placeholders.jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/component/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/component/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/component/js/bootstrap-datepicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/component/js/dataTables.bootstrap.js"></script>
<link
	href="${pageContext.request.contextPath}/component/css/bootstrap.css"
	rel="stylesheet">
<style>
<!--
body {
	background-color: #525252;
}

.centered-form {
	margin-top: 60px;
}

.centered-form .panel {
	background: rgba(255, 255, 255, 0.8);
	box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
}
-->
</style>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body
	background="${pageContext.request.contextPath}/component/images/1.jpg">
	<div class="container">
		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							Please sign up <small>It's free!</small>
						</h3>
					</div>
					<div class="panel-body">
						<form:form role="form" action="${pageContext.request.contextPath}/register" method="POST"
							modelAttribute="userRegistration">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<form:label path="">First Name</form:label>
										<form:input path="firstName" type="text" id="first_name"
											class="form-control input-sm" placeholder="First Name" />
										<form:errors></form:errors>
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<form:label path="lastName">Last Name</form:label>
										<form:input path="lastName" id="last_name"
											class="form-control input-sm" placeholder="Last Name" />
									</div>
								</div>
							</div>
							<div class="form-group">
							<form:label path="email">Email</form:label>
						<form:input path="email" type="email" name="email" id="email"
									class="form-control input-sm" placeholder="Email Address"/>
							
							</div>

							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
									<form:label path="password">Password</form:label>
									<form:password path="password" id="password"
											class="form-control input-sm" placeholder="Password"/>
									</div>
								</div>
								<!-- <div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="password" name="password_confirmation"
											id="password_confirmation" class="form-control input-sm"
											placeholder="Confirm Password">
									</div>
								</div> -->
							</div>
							<input type="submit" value="Register"
								class="btn btn-info btn-block"/>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>