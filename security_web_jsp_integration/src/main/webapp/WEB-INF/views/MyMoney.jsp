<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>{}'s Wallet</title>
</head>
<body>
<jsp:include page="StudentHeader.jsp" flush="true"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/component/js/studentheader.js"></script>
<div class="container">
<div class="row" style="padding-left: 199px;margin-top: -524px;margin-left: -19px;">

<div class="col-md-6 col-lg-12" style="background-color: ;box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;height:523px"">


<div class="panel panel-primary" style="width:971px;margin-left: -14px;"> 
<div class="panel-heading"> 
<h3 class="panel-title">My Money Manager </h3> 
</div> 
<div class="panel panel-success" > 
<div class="panel-heading"> 
<h3 class="panel-title">Add Entry</h3> 
</div>
<div class="panel-body"> 
<form role="form"> 

<div class="form-group"> 
<div class="form-group has-success" style="margin-top: 17px;padding-left: 39px;float: initial;"> 
<label class="col-sm-4 control-label" for="inputSuccess"> Amount </label> 
<div class="col-sm-2" style="float: inherit">
<input type="hidden" id="expenditureid"> 
<input type="text" class="form-control" id="amount">
</div> 
</div>
<div style="padding-left:200px;margin-top:-74px;float:left;">
<label for="name">Details</label> 
<textarea class="form-control" rows="2" style="width: 182px;" id="amountParticulars">
</textarea>
</div>

<div style="margin-top: -31px;">
<input class="datepicker" id="entrydate">

</div>
</div>
<div style="float: right;padding-right: 166px;margin-top: -46px;">
<label class="checkbox-inline"> 
<input type="radio" name="optionsRadiosinline" id="optionsRadios3" value="1" checked> Debit 
</label> 
<label class="checkbox-inline"> 
<input type="radio" name="optionsRadiosinline" id="optionsRadios4" value="2"> Credit </label>
<label class="checkbox-inline"> 
<input type="radio" name="optionsRadiosinline" id="optionsRadios4" value="3"> Income </label>
</div>

<div style="float: right;margin-top: -48px;padding-right:96px;">
<button type="button" onclick="saveMoney()" class="btn btn-success">Add</button>
</div>
 
</form>
</div> 
</div>
<div class="panel-body">
<table class="table">Final balance amount:<h1 style="margin-top: -31px;padding-left: 128px;" id="finalbalance"></h1> 
<thead> 
<tr> 
<th>Date</th> 
<th>Amount</th> 
<th>Details</th> 
<th>Type</th>
<th>Action</th>
</tr> 
</thead> 
<tbody id="expenditureTable"> 
 
 </tbody>
 </table>
 
</div>
 </div>
</div>
</div>
</div>
</div>
</body>
</html>