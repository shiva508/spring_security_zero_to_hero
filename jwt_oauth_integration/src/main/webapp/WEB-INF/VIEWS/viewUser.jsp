<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Uiew</title>
<spring:url var="jquery" value="${pageContext.request.contextPath }/components/js/jquery.min.js"></spring:url>
<spring:url var="bootstrapminjs" value="${pageContext.request.contextPath }/components/js/bootstrap.min.js"></spring:url>
<spring:url var="bootstrapjs" value="${pageContext.request.contextPath }/components/js/bootstrap.js"></spring:url>
<spring:url var="bootstrapdatepickerjs"
	value="${pageContext.request.contextPath }/components/js/bootstrap-datepicker.js"></spring:url>
<spring:url var="jqueryuijs" value="${pageContext.request.contextPath }/components/js/jquery-ui.js"></spring:url>
<spring:url var="jquerydataTablesminjs"
	value="${pageContext.request.contextPath }/components/js/jquery.dataTables.min.js"></spring:url>
<spring:url var="select2minjs" value="${pageContext.request.contextPath }/components/js/select2.min.js"></spring:url>
<spring:url var="sweetalertminjs"
	value="${pageContext.request.contextPath }/components/js/sweetalert.min.js"></spring:url>

<spring:url var="bootstrapthemecss"
	value="${pageContext.request.contextPath }/components/css/bootstrap-theme.css"></spring:url>
<spring:url var="bootstrapthememincss"
	value="${pageContext.request.contextPath }/components/css/bootstrap-theme.min.css"></spring:url>
<spring:url var="bootstrapcss" value="${pageContext.request.contextPath }/components/css/bootstrap.css"></spring:url>
<spring:url var="bootstrapcssmap"
	value="${pageContext.request.contextPath }/components/css/bootstrap.css.maps"></spring:url>
<spring:url var="bootstrapmincss"
	value="${pageContext.request.contextPath }/components/css/bootstrap.min.css"></spring:url>
<spring:url var="dataTablesbootstrapcss"
	value="${pageContext.request.contextPath }/components/css/dataTables.bootstrap.css"></spring:url>
<spring:url var="datepickercss" value="${pageContext.request.contextPath }/components/css/datepicker.css"></spring:url>
<spring:url var="select2mincss" value="${pageContext.request.contextPath }/components/css/select2.min.css"></spring:url>
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
</head>
<body>
<jsp:include page="header.jsp" flush="true"></jsp:include>
<div class="container">

		<div class="row">
			<h1>View User</h1>
		</div>
		
		<div class="row">
		<table class="table table-striped">
		<tr><td><div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputFirstName">User ID:</label> 
					</div>
				</div></td>
				<td><div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputFirstName"><c:out value="${user.userId}"></c:out></label> 
					</div>
				</div>
				</td>
				<td><div class="col-sm-6">
					<div class="form-group">
							<label for="exampleInputFirstName">First Name:</label>
					</div>
				</div>
				</td>
				<td><div class="col-sm-6">
					<div class="form-group">
							<label for="exampleInputFirstName"><c:out value="${user.firstName}"></c:out></label>
					</div>
				</div>
				</td>
				</tr>
				<tr>
				<td><div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputLastName">Last Name:</label>
					</div>
				</div></td>
				<td><div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputFirstName"><c:out value="${user.lastName}"></c:out> </label> 
					</div>
				</div>
				</td>
				<td><div class="col-sm-6">
					<div class="form-group">
							<label for="exampleInputFatherName">Father Name:</label>
					</div>
				</div>
				</td>
				<td><div class="col-sm-6">
					<div class="form-group">
							<label for="exampleInputFirstName"><c:out value="${user.fatherName}"></c:out> </label>
					</div>
				</div>
				</td>
				</tr>
				
				<tr>
				<td><div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputFatherName">Mother Name:</label> 
					</div>
				</div></td>
				<td><div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputFirstName"><c:out value="${user.motherName}"></c:out> </label> 
					</div>
				</div>
				</td>
				<td><div class="col-sm-6">
					<div class="form-group">
							<label for="exampleInputFatherName">Adhar Number:</label>
					</div>
				</div>
				</td>
				<td><div class="col-sm-6">
					<div class="form-group">
							<label for="exampleInputFirstName"><c:out value="${user.adharNumber}"></c:out>  </label>
					</div>
				</div>
				</td>
				</tr>
				
				<tr>
				<td><div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputFatherName">Phone Number:</label>
					</div>
				</div></td>
				<td><div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputFirstName"><c:out value="${user.phoneNumber}"></c:out> </label> 
					</div>
				</div>
				</td>
				<td><div class="col-sm-6">
					<div class="form-group">
							<label for="exampleInputEmail1">Email Address:</label> 
					</div>
				</div>
				</td>
				<td><div class="col-sm-6">
					<div class="form-group">
							<label for="exampleInputFirstName"><c:out value="${user.userName}"></c:out></label>
					</div>
				</div>
				</td>
				</tr>
				
				<tr>
				<td><div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputPassword1">Password:</label>
					</div>
				</div></td>
				<td><div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputFirstName"><c:out value="${user.password}"/></label> 
					</div>
				</div>
				</td>
				<td><div class="col-sm-6">
					<div class="form-group">
							<label for="exampleInputPassword1">Gender:</label>
					</div>
				</div>
				</td>
				<td><div class="col-sm-6">
					<div class="form-group">
							<label for="exampleInputFirstName"> <c:out value="${user.gender}"></c:out></label>
					</div>
				</div>
				</td>
				</tr>
		</table>

		</div>
	</div>
</body>
</html>