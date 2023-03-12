<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/placeholders.jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/placeholders.jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/dataTables.bootstrap.js"></script>
<link href="${pageContext.request.contextPath}/component/css/bootstrap.css" rel="stylesheet">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
<h1>Search page</h1>
<table style="width: 100%;">
  <div class="row">
<tr >
 <div class="col">
<td style="width: 50%;"> <input type="text" class="form-control" placeholder="User Name" style="width:50%;margin-left: 10%;"></td>
 </div>
  <div class="col">
<td style="width: 50%;"><input type="text" class="form-control" placeholder="Email" style="width:50%;"></td>
  </div>
</tr>
  
</table>

</form>
</body>
</html>