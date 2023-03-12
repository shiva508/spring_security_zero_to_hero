<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
</head>
<body>
<jsp:include page="header.jsp" flush="true"></jsp:include>

<div class="row" layout:fragment="content">
<h2 class="indigo-text center">Upload</h2>
<form:form action="${pageContext.request.contextPath}/upload/uploadprofilepic" method="post" enctype="multipart/form-data"
class="col m8 s12 offset-m2">
<div class="input-field col s6">
<input type="file" id="file" name="file"/>
</div>
<div class="col s6 center">
<button class="btn indigo waves-effect waves-light" type="submit"
name="save" value="Upload">Submit
<i class="mdi-content-send right"></i>
</button>
</div>
</form:form>
</div>
</body>
</html>