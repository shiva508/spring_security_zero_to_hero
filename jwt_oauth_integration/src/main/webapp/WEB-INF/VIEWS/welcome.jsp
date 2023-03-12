<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<spring:url var="jquery"
	value="${pageContext.request.contextPath }/components/js/jquery.min.js"></spring:url>
<spring:url var="bootstrapminjs"
	value="${pageContext.request.contextPath }/components/js/bootstrap.min.js"></spring:url>
<spring:url var="bootstrapjs"
	value="${pageContext.request.contextPath }/components/js/bootstrap.js"></spring:url>
<spring:url var="bootstrapdatepickerjs"
	value="${pageContext.request.contextPath }/components/js/bootstrap-datepicker.js"></spring:url>
<spring:url var="jqueryuijs"
	value="${pageContext.request.contextPath }/components/js/jquery-ui.js"></spring:url>
<spring:url var="jquerydataTablesminjs"
	value="${pageContext.request.contextPath }/components/js/jquery.dataTables.min.js"></spring:url>
<spring:url var="select2minjs"
	value="${pageContext.request.contextPath }/components/js/select2.min.js"></spring:url>
<spring:url var="sweetalertminjs"
	value="${pageContext.request.contextPath }/components/js/sweetalert.min.js"></spring:url>

<spring:url var="bootstrapthemecss"
	value="${pageContext.request.contextPath }/components/css/bootstrap-theme.css"></spring:url>
<spring:url var="bootstrapthememincss"
	value="${pageContext.request.contextPath }/components/css/bootstrap-theme.min.css"></spring:url>
<spring:url var="bootstrapcss"
	value="${pageContext.request.contextPath }/components/css/bootstrap.css"></spring:url>
<spring:url var="bootstrapcssmap"
	value="${pageContext.request.contextPath }/components/css/bootstrap.css.maps"></spring:url>
<spring:url var="bootstrapmincss"
	value="${pageContext.request.contextPath }/components/css/bootstrap.min.css"></spring:url>
<spring:url var="dataTablesbootstrapcss"
	value="${pageContext.request.contextPath }/components/css/dataTables.bootstrap.css"></spring:url>
<spring:url var="datepickercss"
	value="${pageContext.request.contextPath }/components/css/datepicker.css"></spring:url>
<spring:url var="select2mincss"
	value="${pageContext.request.contextPath }/components/css/select2.min.css"></spring:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<div class="container">

		<div class="row">
			<h1>Registration Form</h1>
		</div>
		<div class="row">
			<form:form
				action="${pageContext.request.contextPath }/registraion/formregistration"
				method="POST" modelAttribute="registration">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputFirstName">First Name</label>
						<form:input path="firstName" style="width: 271px" type="text"
							class="form-control" id="firstName" aria-describedby=""
							placeholder="Enter First Name" />
						<form:errors path="firstName" cssClass="error"></form:errors>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputLastName">Last Name</label>
						<form:input path="lastName" style="width: 271px" type="text"
							class="form-control" id="lastName" aria-describedby=""
							placeholder="Enter Last Name" />
						<form:errors path="lastName"></form:errors>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputFatherName">Father Name</label>
						<form:input path="fatherName" style="width: 271px" type="text"
							class="form-control" id="fatherName" aria-describedby=""
							placeholder="Enter Father Name" />
						<form:errors path="fatherName"></form:errors>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputFatherName">Mother Name</label>
						<form:input path="motherName" style="width: 271px" type="text"
							class="form-control" id="motherName" aria-describedby=""
							placeholder="Enter Mother Name" />
						<form:errors path="motherName"></form:errors>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputFatherName">Adhar Number</label>
						<form:input path="adharNumber" style="width: 271px" type="text"
							class="form-control" id="adharNumkber" aria-describedby=""
							placeholder="Enter Adhar Number" />
						<form:errors path="adharNumber"></form:errors>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputFatherName">Phone Number</label>
						<form:input path="phoneNumber" style="width: 271px" type="text"
							class="form-control" id="phoneNumkber" aria-describedby=""
							placeholder="Enter Phone Number" />
						<form:errors path="phoneNumber"></form:errors>
					</div>
				</div>

				<div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label>
						<form:input path="userName" style="width: 271px" type="email"
							class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" placeholder="Enter email" />
						<small id="emailHelp" class="form-text text-muted">We'll
							never share your email with anyone else.</small>
						<form:errors path="userName"></form:errors>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label>
						<form:input path="password" style="width: 271px" type="password"
							class="form-control" id="exampleInputPassword1"
							placeholder="Password" />
						<form:errors path="password"></form:errors>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputPassword1">Roles</label>
						<form:select class="js-example-basic-single" path="dummyRoles">
							<option value="USER">User</option>
							<option value="ADMIN">Admin</option>
						</form:select>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputPassword1">Gender</label>
						<form:select class="js-example-basic-single" path="gender">
							<option value="male">Male</option>
							<option value="feMale">Female</option>
						</form:select>
					</div>
				</div>

				<button type="submit" class="btn btn-primary">Submit</button>
			</form:form>
		</div>
	</div>
</body>
<script src="${jquery}" type="text/javascript"></script>
<script src="${bootstrapminjs}" type="text/javascript"></script>
<script src="${bootstrapjs}" type="text/javascript"></script>
<script src="${bootstrapdatepickerjs}" type="text/javascript"></script>
<script src="${jqueryuijs}" type="text/javascript"></script>
<script src="${jquerydataTablesminjs}" type="text/javascript"></script>
<script src="${select2minjs}" type="text/javascript"></script>
<script src="${sweetalertminjs}" type="text/javascript"></script>

<link href="${bootstrapthemecss}" rel="stylesheet" type="text/css" />
<link href="${bootstrapthemecssmap}" rel="stylesheet" type="text/css" />
<link href="${bootstrapthememincss}" rel="stylesheet" type="text/css" />
<link href="${bootstrapcss}" rel="stylesheet" type="text/css" />
<link href="${bootstrapmincss}" rel="stylesheet" type="text/css" />
<link href="${dataTablesbootstrapcss}" rel="stylesheet" type="text/css" />
<link href="${datepickercss}" rel="stylesheet" type="text/css" />
<link href="${select2mincss}" rel="stylesheet" type="text/css" />




<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
<script>
	$(document).ready(function() {
		$(document).ready(function() {
			$('.js-example-basic-single').select2();
		});
		$("#datepicker").datepicker({
			autoclose : true,
			todayHighlight : true
		}).datepicker();
	});
</script>
</html>