window.onload=function(){
	//getting the button for edit profile
	var firstNameBttn = document.getElementById("first-name");
	var lastNameBttn = document.getElementById("last-name");
	var emailBttn = document.getElementById("email");
	var passwordBttn = document.getElementById("password");
	//adding event handlers:
	firstNameBttn.addEventListener("click", firstNameFunction);
	lastNameBttn.addEventListener("click", lastNameFunction);
	emailBttn.addEventListener("click", emailFunction);
	passwordBttn.addEventListener("click", passwordFunction);
}

function firstNameFunction(){
	var firstName = document.getElementById("input-first").value;
	console.log(firstName);
	var myJSON = JSON.stringify(firstName);
	$.ajax({
		  type: "GET",
		  url: "http://localhost:8080/u/change-first-name",
		  contentType: 'json',
		  data: {
			  'first': myJSON
		  },
	  	  success : function(first) {
	  		document.location.href = "http://localhost:8080/u/edit-profile"
	       // do something ... 
	  	  },
		  error : function(e) {
			  document.location.href = "http://localhost:8080/u/edit-profile"
		  }
	  });
	
}

function lastNameFunction(){
	var lastName = document.getElementById("input-last").value;
	console.log(lastName);
	var myJSON = JSON.stringify(lastName);
	$.ajax({
		  type: "GET",
		  url: "http://localhost:8080/u/change-last-name",
		  contentType: 'json',
		  data: {
			  'last': myJSON
		  },
	  	  success : function(last) {
	  		document.location.href = "http://localhost:8080/u/edit-profile"
	       // do something ... 
	  	  },
		  error : function(e) {
			  document.location.href = "http://localhost:8080/u/edit-profile"
		  }
	  });
}

function emailFunction(){
	var email = document.getElementById("input-email").value;
	console.log(email);
	var myJSON = JSON.stringify(email);
	$.ajax({
		  type: "GET",
		  url: "http://localhost:8080/u/change-email",
		  contentType: 'json',
		  data: {
			  'email': myJSON
		  },
	  	  success : function(email) {
	  		document.location.href = "http://localhost:8080/u/edit-profile"
	       // do something ... 
	  	  },
		  error : function(e) {
			  document.location.href = "http://localhost:8080/u/edit-profile"
		  }
	  });
	
}

function passwordFunction(){
		var password = document.getElementById("input-password").value;
		console.log(password);
		var myJSON = JSON.stringify(password);
		$.ajax({
			  type: "GET",
			  url: "http://localhost:8080/u/change-password",
			  contentType: 'json',
			  data: {
				  'password': myJSON
			  },
		  	  success : function(password) {
		  		document.location.href = "http://localhost:8080/u/edit-profile"
		       // do something ... 
		  	  },
			  error : function(e) {
				  document.location.href = "http://localhost:8080/u/edit-profile"
			  }
		  });
}

function unsubscribe(){
	var x = 0;
	var myJSON = JSON.stringify(x);
	$.ajax({
		  type: "GET",
		  url: "http://localhost:8080/u/change-subscription",
		  contentType: 'json',
		  data: {
			  'subscription': myJSON
		  },
	  	  success : function(subscription) {
	  		document.location.href = "http://localhost:8080/u/edit-profile"
	       // do something ... 
	  	  },
		  error : function(e) {
			  document.location.href = "http://localhost:8080/u/edit-profile"
		  }
	  });
}

function subscribe(){
	var x = 1;
	var myJSON = JSON.stringify(x);
	$.ajax({
		  type: "GET",
		  url: "http://localhost:8080/u/change-subscription",
		  contentType: 'json',
		  data: {
			  'subscription': myJSON
		  },
	  	  success : function(subscription) {
	  		document.location.href = "http://localhost:8080/u/edit-profile"
	       // do something ... 
	  	  },
		  error : function(e) {
			  document.location.href = "http://localhost:8080/u/edit-profile"
		  }
	  });
}
