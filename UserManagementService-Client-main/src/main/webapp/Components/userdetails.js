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
  	
	var status = validateUserForm();
	if (status != true)
	{
		 $("#alertError").text(status);
 		 $("#alertError").show();
 		 
         return;
    }
 
	// If valid------------------------
	
	
	var type = ($("#hidUserIDSave").val() == "") ? "POST" : "PUT";

	 $.ajax(
 	 {
 		url : "UserAPI",
 		type : type,
 		data : $("#formUser").serialize(),
 		dataType : "text",
	    complete : function(response, status)
        {
   
      			onUserSaveComplete(response.responseText, status);
	    }
	    
     });
     
});
function onUserSaveComplete(response, status)
{
	if (status == "success")
	{
		 var resultSet = JSON.parse(response);
		 
	 	 if (resultSet.status.trim() == "success")
		 {
 				$("#alertSuccess").text("Successfully saved.");
		    	$("#alertSuccess").show();
 				$("#divUsersGrid").html(resultSet.data);
 			
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

 	$("#hidUserIDSave").val("");
	 $("#formUser")[0].reset();
}



//UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
		var id = event.target.id;
		$("#hidUserIDSave").val(id.substring(0, id.length-1));
 		$("#accountno").val($(this).closest("tr").find('td:eq(0)').text());
 		$("#username").val($(this).closest("tr").find('td:eq(1)').text());
 		$("#useremail").val($(this).closest("tr").find('td:eq(2)').text());
 		$("#userphone").val($(this).closest("tr").find('td:eq(3)').text());
 		$("#useraddress").val($(this).closest("tr").find('td:eq(4)').text());
 		$("#usernic").val($(this).closest("tr").find('td:eq(5)').text());
});


//remove
$(document).on("click", ".btnRemove", function(event)
{
	 $.ajax(
 	{
 		url : "UserAPI",
 		type : "DELETE",
	    data : "userID=" + $(this).data("userid"),
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
 				
			    $("#divItemsGrid").html(resultSet.data);
			    
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





//CLIENTMODEL=========================================================================
function validateUserForm()
{

// NAME
	if ($("#username").val().trim() == "")
    {
		 return "Insert Item Name.";
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
 		return "Insert a numerical value for Item Price.";
 	}
 	
 	
	
    
	// NAME
	if ($("#username").val().trim() == "")
    {
		 return "Insert User Name.";
 	} 
 	

	// PRICE-------------------------------
	if ($("#useremail").val().trim() == "")
    {
 		return "Insert Email.";
 	}
 	
 	
	// PRICE-------------------------------
	if ($("#userphone").val().trim() == "")
    {
 		return "Insert Contact Number.";
 	}
 	
 	
 	
	 	
	// PRICE-------------------------------
	if ($("#useraddress").val().trim() == "")
    {
 		return "Insert User Address.";
 	}
 	
 	
 	
 	
	// DESCRIPTION------------------------
	if ($("#usernic").val().trim() == "")
   {
		 return "Insert User NIC.";
   }
   return true;
}
