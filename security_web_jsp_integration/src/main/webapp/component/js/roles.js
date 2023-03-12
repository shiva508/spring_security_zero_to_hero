$(document)
			.ready(
					function() {
						var phoneNumbers = [];
						$("#savebtn")
								.click(
										function() {
											$("#maintable tbody tr")
													.each(
															function() {
																var mobileNumberType = $(this).find(".mobileNumberType").val();
																var mobileNumber = $(this).find(".mobileNumber").val();
																console.log(mobileNumber);
																var obj = {};
																obj.mobileNumberType = mobileNumberType;
																obj.mobileNumber = mobileNumber;
																phoneNumbers.push(obj);
															})
											console.log(phoneNumbers)
											document.userModel.submit();
									
										});
						$(".add-row")
								.click(
										function() {
											/*   var name = $("#name").val();
											  var email = $("#email").val(); */
											var index = $('#maintable tbody tr').length;
											var markup = "<tr><td><input type='checkbox' name='record'></td><td><input type='text' id='mobileNumberType' name='dummayList["+index+"].mobileNumberType' class='mobileNumberType' path='dummayList["+index+"].mobileNumberType'/></td>";
											markup += "<td><input type='text' id='mobileNumber' name='dummayList["+index+"].mobileNumber' class='mobileNumber' path='dummayList["+index+"].mobileNumber'/></td></tr>"
											$("table tbody").append(markup);
										});

						$(".delete-row").click(
								function() {
									$("table tbody").find(
											'input[name="record"]').each(
											function() {
												if ($(this).is(":checked")) {
													$(this).parents("tr")
															.remove();
												}
											});
								});
						/* $("#add_new").click(function() {

							$("#maintable").each(function() {
								
								var tds = '<tr>';
								jQuery.each($('tr:last td', this), function() {
									tds += '<td>' + $(this).html() + '</td>';
								});
								tds += '</tr>';
								if ($('tbody', this).length > 0) {
									$('tbody', this).append(tds);
								} else {
									$(this).append(tds);
								}
							});
						}); */
					});