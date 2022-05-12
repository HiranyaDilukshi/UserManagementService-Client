$(document).ready(function()
{

	$("#alertSuccess").hide();
	$("#alertError").hide();
});



// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
	// Clear alerts---------------------

	
	 $("#alertSuccess").text("");
 	 $("#alertSuccess").hide();
 	 $("#alertError").text("");
 	 $("#alertError").hide();
 	 
 	 
   	// Form validation-------------------
  	
	var status = validateAccountForm();
	if (status != true)
	{
		 $("#alertError").text(status);
 		 $("#alertError").show();
 		 
         return;
    }
 
	// If valid------------------------
	
	
	var type = ($("#hidAccountIDSave").val() == "") ? "POST" : "PUT";

	 $.ajax(
 	 {
 		url : "AccountAPI",
 		type : type,
 		data : $("#formAccount").serialize(),
 		dataType : "text",
	    complete : function(response, status)
        {
   
      			onAccountSaveComplete(response.responseText, status);
	    }
	    
     });
     
});
function onAccountSaveComplete(response, status)
{
	if (status == "success")
	{
		 var resultSet = JSON.parse(response);
		 
	 	 if (resultSet.status.trim() == "success")
		 {
 				$("#alertSuccess").text("Successfully saved.");
		    	$("#alertSuccess").show();
 				$("#divAccountsGrid").html(resultSet.data);
 			
 	 	  } else if (resultSet.status.trim() == "error")
 	 	  {
 	 
 				$("#alertError").text(resultSet.data);
 				$("#alertError").show();
		  }
		  
    } else if (status == "error")
    {
 			$("#alertError").text("Error while saving.");
 			$("#alertError").show();
 			
 	} else
 	{
 			$("#alertError").text("Unknown error while saving..");
 			$("#alertError").show();
    } 

 	$("#hidAccountIDSave").val("");
	 $("#formAccount")[0].reset();
}



//UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
	var id = event.target.id;
		$("#hidAccountIDSave").val(id.substring(0, id.length-1));
 		$("#accountno").val($(this).closest("tr").find('td:eq(0)').text());
 		$("#premisesid").val($(this).closest("tr").find('td:eq(1)').text());
 		$("#areaoffice").val($(this).closest("tr").find('td:eq(2)').text());
 		$("#tarifftype").val($(this).closest("tr").find('td:eq(3)').text());
 	
 		
});


//remove
$(document).on("click", ".btnRemove", function(event)
{
	 $.ajax(
 	{
 		url : "AccountAPI",
 		type : "DELETE",
	    data : "accountID=" + $(this).data("accountid"),
 		dataType : "text",
 		complete : function(response, status)
		{
			 onUserDeleteComplete(response.responseText, status);
 		}
	 });
});





function onUserDeleteComplete(response, status)
{
	if (status == "success")
    {
 			var resultSet = JSON.parse(response);
 			
		   if (resultSet.status.trim() == "success")
 		   {
 		   
 				$("#alertSuccess").text("Successfully deleted.");
 				$("#alertSuccess").show();
 				
			    $("#divAccountsGrid").html(resultSet.data);
			    
			    setTimeout( (function(){alert(43)}, 1000));
 			} else if (resultSet.status.trim() == "error")
 			{
				 $("#alertError").text(resultSet.data);
 				 $("#alertError").show();
		    }
 	} else if (status == "error")
    {
		 $("#alertError").text("Error while deleting.");
 		 $("#alertError").show();
    } else
    {
 		$("#alertError").text("Unknown error while deleting..");
 		$("#alertError").show();
 	}
}





//ACCOUNTTMODEL=========================================================================
function validateAccountForm()
{

// NAME
	if ($("#premisesid").val().trim() == "")
    {
		 return "Insert Premises ID";
 	} 
	// CODE
	if ($("#accountno").val().trim() == "")
 	{
		 return "Insert Account Number.";
    }
    
    	// is numerical value
	var tmpAccountno = $("#accountno").val().trim();
	if (!$.isNumeric( tmpAccountno))
 	{
 		return "Insert a numerical value for Account Number.";
 	}
 	
 	
	
    
	// NAME
	if ($("#areaoffice").val().trim() == "")
    {
		 return "Insert Area Office.";
 	} 
 	

	// PRICE-------------------------------
	if ($("#tarifftype").val().trim() == "")
    {
 		return "Insert Tariff Type.";
 	}
 	
 	
	
   return true;
}
