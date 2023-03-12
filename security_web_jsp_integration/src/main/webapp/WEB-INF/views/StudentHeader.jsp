<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="JSHead.jsp" flush="true"></jsp:include>
<body>
<div class="container">
<div class="row">
<div class="col-md-12" style="background-color: ; box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;height:84px">
<img src="${pageContext.request.contextPath}/component/images/shiva.jpg" class="img-circle" style="height:79px;width:85px">
<p class="text-left" style="padding-left:98px;margin-top: -59px;font-family: cursive"><b>H! ${user.userName}</b></p>
<input type="hidden"  id="userId" value="${user.userId}">
<div style="padding-left: 168px;    margin-top: -41px;">
<a href="#"><span class="badge">50</span></a>
</div>
</div>
</div>
<div class="row">
<div class="col-md-6 col-lg-2" style="background-color: ;box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;height:523px"> 
<ul class="nav nav-pills nav-stacked" style="max-width: 260px;"> 
<li class="active"> 
<a href="${pageContext.request.contextPath}/"> <span class="badge pull-right">508</span> Home </a> 
</li> 
<li><a href="#">Profile</a>
</li> 
<li> <a href="#">
 <span class="badge pull-right">3</span> Messages
 </a> 
 </li> 
 <li> <a href="${pageContext.request.contextPath}/mymoney/">
 <span class="badge pull-right">3</span> My Money
 </a> 
 </li> 
 </ul>
</div>
</div>
</div>
</body>
</html>