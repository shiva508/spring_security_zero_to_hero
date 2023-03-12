<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Please sign in</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
  </head>
  <body>
     <div class="container">
      <form:form class="form-signin" method="post" action="${pageContext.request.contextPath}/login">
        <h2 class="form-signin-heading">Please sign in to INFINITY</h2>
        <c:if test="${param.error !=null}">
        <div class="alert alert-danger" role="alert">Bad credentials</div> 
        </c:if>
        <c:if test="${param.logout !=null}">
        <div class="alert alert-success" role="alert">You have been signed out</div>
        </c:if>
       
 <p>
          <label for="username" class="sr-only">Username</label>
          <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        </p>
        <p>
          <label for="password" class="sr-only">Password</label>
          <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
<!-- <input name="_csrf" type="hidden" value="3a0aeed0-04cd-4de9-90e5-a4e741ac954e" />-->
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button> 
      </form:form>
</div>
</body></html>