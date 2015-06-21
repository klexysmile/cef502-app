$(document).ready(function(){
	
	loadFaculties();
	$("#myButton").click(function(){
		
	});
	
	$("#fac_id2").change(function(){
		loadLecturers();
	});
	loadLecturers();
	
});

//Load faculty
function loadFaculties(){
	
	//the variable loadId below determins the type of list that will be loaded
	$.ajax({
        type: "POST",
        url: "loaderController",
        data: {
        	loadId : 4,
        	loadname : "faculties"
        		},
        dataType: "json",
        
        //if received a response from the server
        success: function( data, textStatus, jqXHR) {
            //our country code was correct so we have some information to display
             if(data.success){
                 $("#fac_id").html("");
                 $("#fac_id").append(data.selectionList.html);
                 $("#fac_id1").html("");
                 $("#fac_id1").append(data.selectionList.html);
                 $("#fac_id2").html("");
                 $("#fac_id2").append(data.selectionList.html);
             }
             //display error message
             else {
                 $("#ajaxResponse").html("<div><b>Country code in Invalid!</b></div>");
             }
        },
        
        //If there was no resonse from the server
        error: function(jqXHR, textStatus, errorThrown){
             console.log("Something really bad happened " + textStatus);
              $("#ajaxResponse").html(jqXHR.responseText);
              alert("Fail");
        },
        
        //capture the request before it was sent to server
        beforeSend: function(jqXHR, settings){
            //adding some Dummy data to the request
            settings.data += "&dummyData=whatever";
            //disable the button until we get the response
            $('#myButton').attr("disabled", true);
        },
        
        //this is called after the response or error functions are finsihed
        //so that we can take some action
        complete: function(jqXHR, textStatus){
            //enable the button
            $('#myButton').attr("disabled", false);
        }

    }); 
}

//Load Lecturers of faculty
function loadLecturers(){
	//the variable below determins the type of list that will be loaded
	
	$.ajax({
        type: "POST",
        url: "loaderController",
        data: {
        	loadId : 2,
        	loadname : "lecturers",
        	fac_id : $("#fac_id2").val()
        		},
        dataType: "json",
        
        //if received a response from the server
        success: function( data, textStatus, jqXHR) {
            //our country code was correct so we have some information to display
             if(data.success){
                 $("#lec").html("");
                 $("#lec").append(data.selectionList.html);
             }
             //display error message
             else {
                 $("#ajaxResponse").html("<div><b>Country code in Invalid!</b></div>");
             }
        },
        
        //If there was no resonse from the server
        error: function(jqXHR, textStatus, errorThrown){
             console.log("Something really bad happened " + textStatus);
              $("#ajaxResponse").html(jqXHR.responseText);
        },
        
        //capture the request before it was sent to server
        beforeSend: function(jqXHR, settings){
            //adding some Dummy data to the request
            settings.data += "&dummyData=whatever";
            //disable the button until we get the response
            $('#myButton').attr("disabled", true);
        },
        
        //this is called after the response or error functions are finsihed
        //so that we can take some action
        complete: function(jqXHR, textStatus){
            //enable the button
            $('#myButton').attr("disabled", false);
        }

    }); 
}
