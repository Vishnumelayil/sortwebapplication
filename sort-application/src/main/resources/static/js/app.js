/**
 * 
 */

$(document).ready(function(){
  $("#sortButton").click(validateAndSendTheData);
  $("#historyButton").click(callApiTofetchAllData);
   $("#clearButton").click(clearData);
});

function clearData() {
  $('#sortData').val('');
  $("#result").html('');
  $('#valComma').html("Please enter comma seperated interger values");
  $('#valComma').removeClass('label-danger').addClass('label-warning');
  $('#valLimit').html("User can enter max of 50 no's between 0 to 100");
	$('#valLimit').removeClass('label-danger').addClass('label-warning');
    
}

function validateAndSendTheData() {
  
  var value = $.trim($("#sortData").val());
  var vaildation=false;
  var regex = /^[0-9]+(,[0-9]+)*$/;
	 if(regex.test(value)){
		var to_intarray = value.split(',');
		if(to_intarray.length<50 && to_intarray.length>0 )
		{
		for(var i=0;i<to_intarray.length;i++){
			if(to_intarray[i]>=0 && to_intarray[i]<=100){
				validation=true;
			}
			else{
        validation=false;
        $('#sortData').val('');
				$('#valLimit').html("Please enter the nos between 0 and 100");
				$('#valLimit').removeClass('label-warning').addClass('label-danger');
			}
    }
    if(validation){
      callApiToProcessData();
    }
	}else{
    $('#sortData').val('');
		$('#valLimit').html("User can enter only Max 50 nos");
		$('#valLimit').removeClass('label-warning').addClass('label-danger');
	}
	}
	else{
    $('#sortData').val('');
		$('#valComma').html("Please enter the comma seperated integer values");
		$('#valComma').removeClass('label-warning').addClass('label-danger');
	}
}


function callApiTofetchAllData() {
   $("#history").html('');
$.ajax({
      type : "GET",
      url : "/historyDataApi",
      success: function(result){
        if(result[0].listOfnumbers.length>0){
          $("#history").append('<h4 class="d-flex justify-content-between align-items-center mb-3">'+
			 '<span class="text-muted">History data</span></h4> <div id="historyinnner"> </div>')
          $.each(result, function(i, result){
                $("#historyinnner").append('<ul><li class="list-group-item d-flex justify-content-between lh-condensed">'+
				'<span class="text-muted " style="word-wrap: break-word">'+
				'Before Sort :	'+result.listOfnumbers +'	</span></li>'+
				'<li class="list-group-item d-flex justify-content-between lh-condensed">'+
				'<span class="text-muted " style="word-wrap: break-word">'+
				'After Sort :'+ result.afterSort+' </span></li>'+
				'<li class="list-group-item d-flex justify-content-between lh-condensed">'+
				'<span class="text-muted " style="word-wrap: break-word">'+
				'Time taken to Sort : '+ result.timeTakenToSort+' </span></li>'+
				'<li class="list-group-item d-flex justify-content-between lh-condensed">'+
				'<span class="text-muted " style="word-wrap: break-word">'+
        'No of positions changed : '+result.noSteps +'  </span></li></ul>')
              });
            }
            else{
              $("#history").html('<h4 class="d-flex justify-content-between align-items-center mb-3">'+
			      '<span class="text-muted">No data found</span></h4>')
            }

      },
      error : function(e) {
        $("#getResultDiv").html("<strong>Error</strong>");
        console.log("ERROR: ", e);
      }
    });  

}

function callApiToProcessData() {
	var value = $.trim($("#sortData").val()).toString();
	 var formData = {
        listOfnumbers : value,
      }
      $.ajax({
      type : "POST",
      contentType : "application/json",
      url : "/sortDataApi",
      data : JSON.stringify(formData),
      dataType : 'json',
      success : function(result) {
        if(result.listOfnumbers.length >0){
		   $("#result").html('<h4 class="d-flex justify-content-between align-items-center mb-3">'+
			 '<span class="text-muted">Result data</span></h4>'+
			 '<div><ul><li class="list-group-item d-flex justify-content-between lh-condensed">'+
				'<span class="text-muted " style="word-wrap: break-word">'+
				'Before Sort :	'+result.listOfnumbers +'	</span></li>'+
				'<li class="list-group-item d-flex justify-content-between lh-condensed">'+
				'<span class="text-muted " style="word-wrap: break-word">'+
				'After Sort :'+ result.afterSort+' </span></li>'+
				'<li class="list-group-item d-flex justify-content-between lh-condensed">'+
				'<span class="text-muted " style="word-wrap: break-word">'+
				'Time taken to Sort : '+ result.timeTakenToSort+' </span></li>'+
				'<li class="list-group-item d-flex justify-content-between lh-condensed">'+
				'<span class="text-muted " style="word-wrap: break-word">'+
        'No of positions changed : '+result.noSteps +'  </span></li></ul></div>')
        }
        else{
          $("#result").html("<strong>Error</strong>");
        }
      },
      error : function(e) {
        alert("Error! not processed")
        console.log("ERROR: ", e);
      }
    });

	}