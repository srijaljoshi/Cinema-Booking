
var totalTickets;
var seatArray = new Array(9);

window.onload=function(){
	for(var start = 0; start < 9; ++start)
		seatArray[start] = "null";
	totalTickets = 0;
	var seatOpenList = document.getElementsByClassName("available");
	var seatListLength = seatOpenList.length;
	for(var i = 0; i < seatListLength; ++i){
		seatOpenList[i].addEventListener("click", select);
		console.log("adding event listener")
	}
	var continueButton = document.getElementById("continue");
	continueButton.addEventListener("click", nextPage);
}

function select(){
	seatArray[totalTickets] = event.target.textContent;
	console.log(seatArray[totalTickets]);
	++totalTickets;
	if(totalTickets > 0){
		var button = document.getElementById("continue");
		button.disabled = false;
	}
	event.target.removeEventListener("click", select);
	event.target.addEventListener("click", unselect);
	event.target.className = "taken";
	//add 
}

function unselect(element){
	removeTicket(event.target.textContent);
	if(totalTickets == 0){
		var button = document.getElementById("continue");
		button.disabled = true;
	}
    event.target.className = "available";
    event.target.removeEventListener("click", unselect);
    event.target.addEventListener("click", select);
}

function removeTicket(location){
	for(var i = 0; i < totalTickets; ++i){
		if(location == seatArray[i]){
			console.log(seatArray[i]);
			seatArray[i] = "remove";
			console.log("removing");
			break;
		}
	}
	for(; i < totalTickets; ++i){
		seatArray[i] = seatArray[i + 1];
	}
	--totalTickets;
	for(var j = 0; j < totalTickets; ++j){
		console.log(seatArray[j])
	}
}

function nextPage(){
	  //window.sessionStorage.setItem("locations", JSON.stringify(seatArray))
		console.log("got here");
		var array = new Array(totalTickets);
		for(var k = 0; k < totalTickets; ++k)
			array[k] = "" + seatArray[k];
		var myJson = JSON.stringify(array);
		sessionStorage.setItem("locations", myJson);
		sessionStorage.setItem("amount", totalTickets);
		//document.location.href = "http://localhost:8080/u/ticket-category";
	  $.ajax({
		  type: "GET",
		  url: "http://localhost:8080/u//tickets",
		  contentType: 'json',
		  data: {
			  myArray: myJson,
			  total: totalTickets
		  },
	  	  success : function(resource) {
	  		document.location.href = "http://localhost:8080/u/ticket-category"
	       // do something ... 
	  	  },
		  error : function(e) {
			  document.location.href = "http://localhost:8080/u/ticket-category"
		  }
	  });
}


