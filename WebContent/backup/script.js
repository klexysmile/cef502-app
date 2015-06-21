
$(document).ready(function() {
	loadFaculties();
	loadHallSelection();
	loadLecturers();
    //Stops the submit request
    $("#myAjaxRequestForm").submit(function(e){
           e.preventDefault();
    });    
    $("#faculty").change(function(){
    	loadDepartmentsOfFaculty();
    });
    $("#department").change(function(){
    	loadCourses()
    });
    //checks for the button click event    
    $("#myButton").click(function(){
    	submitTimeSlot();
    });
 
});

function loadCourses(){
	//the variable below determins the type of list that will be loaded
	$.ajax({
        type: "POST",
        url: "loaderController",
        data: {
        	loadId : 1,
        	loadname : "courses",
        	dep_id : $("#department").val()
        		},
        dataType: "json",
        
        //if received a response from the server
        success: function( data, textStatus, jqXHR) {
            //our country code was correct so we have some information to display
             if(data.success){
                 $("#course").html("");
                 $("#course").append(data.selectionList.html);
                 //alert("course id: " + $("#course").val());
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
                 $("#faculty").html("");
                 $("#faculty").append(data.selectionList.html);
                 loadDepartmentsOfFaculty();
                 loadLecturers();
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

//Load Departments of faculty
function loadDepartmentsOfFaculty(){
	//the variable below determins the type of list that will be loaded
	$.ajax({
        type: "POST",
        url: "loaderController",
        data: {
        	loadId : 5,
        	loadname : "departments",
        	fac_id : $("#faculty").val()
        		},
        dataType: "json",
        
        //if received a response from the server
        success: function( data, textStatus, jqXHR) {
            //our country code was correct so we have some information to display
             if(data.success){
                 $("#department").html("");
                 $("#department").append(data.selectionList.html);
                 loadCourses();
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

//Load halls into the selection
function loadHallSelection(){
	//the variable below determins the type of list that will be loaded
	$.ajax({
        type: "POST",
        url: "loaderController",
        data: {
        	loadId : 3,
        	loadname : "halls"
        		},
        dataType: "json",
        
        //if received a response from the server
        success: function( data, textStatus, jqXHR) {
            //our country code was correct so we have some information to display
             if(data.success){
                 $("#hall").html("");
                 $("#hall").append(data.selectionList.html);
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

//Load Lecturers of faculty
function loadLecturers(){
	//the variable below determins the type of list that will be loaded
	
	$.ajax({
        type: "POST",
        url: "loaderController",
        data: {
        	loadId : 2,
        	loadname : "lecturers",
        	fac_id : $("#faculty").val()
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

function submitTimeSlot(){
	$.ajax({
        type: "POST",
        url: "manageSlot",
        data: {
        	fac_id : $("#faculty").val(),
        	dep_id : $("#department").val(),
        	day : $("#day").val(),
        	hall : $("#hall").val(),
        	lec : $("#lec").val(),
        	course : $("#course").val(), 
        	slot : $("#slot").val()
        		},
        dataType: "json",
        
        //if received a response from the server
        success: function( data, textStatus, jqXHR) {
            //our country code was correct so we have some information to display
             if(data.success){
                 $("#ajaxResponse").html("");
                 $("#ajaxResponse").append(data.successState.html);
             }
             //display error message
             else {
                 $("#ajaxResponse").html("<div><b>Unable to </b></div>");
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