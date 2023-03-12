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

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Full-width input fields */

/* Add Zoom Animation */
/* .animate {
  -webkit-animation: animatezoom 0.6s;
  animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
  from {-webkit-transform: scale(0)} 
  to {-webkit-transform: scale(1)}
}
  
@keyframes animatezoom {
  from {transform: scale(0)} 
  to {transform: scale(1)}
} */

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
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
			<div class="col-sm-6 ">
				<div class="imgcontainer">
					<span class="border border-danger"> <img
						src="${pageContext.request.contextPath}/components/images/mns2.png"
						class="img-rounded" alt="Cinque Terre" width="304" height="236"></img>
						<form action="/login" method="post">
							<c:if test="${param.error != null}">
								<p style='color: red'>Invalid username and password.</p>
							</c:if>
							<c:if test="${param.logout != null}">
								<p style='color: blue'>You have been logged out.</p>
							</c:if>
							<div class="form-group">
								<label for="username">Username</label> <input type="text"
									class="form-control" id="username" name="username"
									aria-describedby="emailHelp" placeholder="Enter email">
								<small id="emailHelp" class="form-text text-muted">We'll
									never share your email with anyone else.</small>
							</div>
							<div class="form-group">
								<label for="password">Password</label> <input
									type="password" class="form-control" id="password" name="password"
									placeholder="Password">
							</div>
							
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
							<button type="submit" class="btn btn-success">Submit</button>
						</form>
					</span>
				</div>
			</div>
			<div class="col-sm-6">
			<div class="col-sm-6">
			<img
					src="${pageContext.request.contextPath}/components/images/mns2.png"
					 alt="Cinque Terre" width="304" height="236"></img>
					
			</div>
			<div class="col-sm-6"><a class="btn btn-success" href="${pageContext.request.contextPath}/registraion/">Register</a></div>
					
			</div>
		</div>
	</div>



	<script>
		// Get the modal
		var modal = document.getElementById('id01');

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>

</body>
</html>
