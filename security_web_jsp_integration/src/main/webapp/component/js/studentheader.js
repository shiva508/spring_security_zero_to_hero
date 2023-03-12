var expenditureList=[];
$(function () 
		{ 
	getAllExpediturs();
	$(".datepicker").datepicker({
		dateFormate:'yy-mm-yyyy'
	});
	$("#moneymodel").click(function(){
		$('#myModal').modal({keyboard: true });
	})

		});

function dateFornater(date){
	var sampeleDate=date;
	var tes=sampeleDate.split("/");
	var formatedDate=tes[2]+"-"+tes[0]+"-"+tes[1];
	return formatedDate;
}
function dateReFornater(date){
	var sampeleDate=date;
	var tes=sampeleDate.split("-");
	var formatedDate=tes[1]+"/"+tes[2]+"/"+tes[0];
	return formatedDate;
}
function updateExpenditure(expenditureid){
	for(var i=0;i<expenditureList.length;i++){
		if(expenditureList[i].expenditureId==expenditureid){	
			$("#amount").val(expenditureList[i].amount);
			$("#entrydate").val('');
			$("#entrydate").val(dateReFornater(expenditureList[i].entryDate))
			$("#amountParticulars").val(expenditureList[i].details);
			$("#expenditureid").val(expenditureList[i].expenditureId);
		}
		
	}
}
function deleteExpenditure(expenditureid){
	var userid=$("#userId").val();
	if(userid !=""){
		$.ajax({
			type : "DELETE",
			url :"deleteExpediturebyid/"+expenditureid+"/"+userid,
			contentType : 'application/json',
			dataType : 'json',
			cache: false,
			success : function(data) {
				expenditureList=data;
				displayExpenditureTable(data);
			},
			error : function(data) {
				//sdisplayExpenditureTable(data);
			}
		});	
	}

}
function displayExpenditureTable(data){
	var income=0;
	var credit=0;
	var debit=0;
	var content='';
	for(var i=0;i<data.length;i++){
		content+='<tr class="active"><td>'+data[i].entryDate+'</td>  <td>'+data[i].amount+'</td> <td>'+data[i].details+'</td>';
		if(data[i].typeOfExpence==1){
			debit+=parseInt(data[i].amount);
			content+='<td>Debit</td>';
		}else if(data[i].typeOfExpence==2){
			credit+=parseInt(data[i].amount);
			content+='<td>Credit</td>';
		}else if(data[i].typeOfExpence==3){
			income+=parseInt(data[i].amount);
			content+='<td>Income</td>';
		}
		content+='<td><button type="button" onclick="deleteExpenditure('+data[i].expenditureId+')" class="btn btn-danger">Delete</button>';
		content+='<button type="button"  onclick="updateExpenditure('+data[i].expenditureId+')" class="btn btn-info">Update</button></td>';
		content+='</tr>';
	}
	var total=income-debit-credit;
	$("#finalbalance").html(total);
	$("#expenditureTable").empty();
	$("#expenditureTable").append(content);
}
function getAllExpediturs(){
	var userid=$("#userId").val();
	if(userid !=""){
		$.ajax({
			type : "GET",
			url :"expenditure/"+userid,
			contentType : 'application/json',
			dataType : 'json',
			cache: false,
			success : function(data) {
				expenditureList=data;
				displayExpenditureTable(data);
			},
			error : function(data) {
				//sdisplayExpenditureTable(data);
				
			
			}
		});	
	}

	
}
function saveMoney(){
	var formatedDate=dateFornater($("#entrydate").val());	
	if($("#amount").val()=="" || $("#entrydate").val()=="" ){
		 return false;
	}
	else{
		var userid=$("#userId").val();
		var expenditure={};
		expenditure.amount=$("#amount").val();
		expenditure.details=$("#amountParticulars").val();
		expenditure.entryDate=formatedDate;
		expenditure.typeOfExpence=$("input[name='optionsRadiosinline']:checked").val();
		expenditure.userId=userid;
		expenditure.expenditureId=$("#expenditureid").val();
		$.ajax({
			type : "POST",
			url :"saveexpenditure",
			contentType : 'application/json',
			data : JSON.stringify(expenditure),
			dataType : 'json',
			cache: false,
			success : function(data) {
				getAllExpediturs();
				$("#amount").val("");
				$("#amountParticulars").val("");
			},
			error : function(data) {
				//sdisplayExpenditureTable(data);
				
			
			}
		});
	}
	
}