var amount;
var copy;
var children;
var adult;
var senior;

window.onload=function(){
	children = 0;
	adult = 0;
	senior = 0;
	amount = sessionStorage.getItem("amount");
	console.log(amount);
	copy = amount
  //add event handler to both increment and decrement
  var decrementList = document.getElementsByClassName("decrement");
  var listLength = decrementList.length;
  for(var i = 0; i < listLength; ++i){
    decrementList[i].addEventListener("click", decrementFunction);
  }
  var incrementList = document.getElementsByClassName("increment");
  listLength = incrementList.length;
  for(var i = 0; i < listLength; ++i){
    incrementList[i].addEventListener("click", incrementFunction);
  }

  var continueButton = document.getElementById("submit");
  continueButton.addEventListener("click", nextPage);
}

function incrementFunction() {
	  var categoryAmount = event.target.previousSibling.textContent;
	  var integerValue = parseInt(categoryAmount);
	  if(amount > 0){
	    amount--;
	    var newNumber = parseInt(categoryAmount) + 1;
	    var compare = event.target.id;
	    console.log("" + compare);
	    if(event.target.id == "adultPlus"){
	      adult = newNumber;
	      console.log("adult");
	    }
	    else if(event.target.id == "seniorPlus"){
	    	senior = newNumber;
	    }
	    else{
	      children = newNumber;
	      console.log("child");
	    }
	    event.target.previousSibling.textContent = newNumber;
	  }
	}

function decrementFunction(eve){
	  var categoryAmount = event.target.nextSibling.textContent;
	  var integerValue = parseInt(categoryAmount);
	  if(amount < copy && integerValue > 0){
	    amount++;
	    var newNumber = parseInt(categoryAmount) - 1;
	    if(event.target.id == "adultMinus"){
		      adult = newNumber;
		      console.log("adult");
		}
	    else if(event.target.id == "seniorMinus"){
	    	senior = newNumber;
	    }
		else{
	      children = newNumber;
	      console.log("child");
	    }
	    event.target.nextSibling.textContent = newNumber;
	  } 
}

function nextPage(){
	sessionStorage.setItem("child", children);
	sessionStorage.setItem("adult", adult);
	sessionStorage.setItem("senior", senior);
	//document.location.href = "http://localhost:8080/u/order-summary";
	$.ajax({
		  type: "GET",
		  url: "http://localhost:8080/u/calculate",
		  contentType: 'json',
		  data: {
			  'child': children,
			  'adult': adult,
			  'senior': senior
		  },
	  	  success : function(resource) {
	  		document.location.href = "http://localhost:8080/u/order-summary"
	       // do something ... 
	  	  },
		  error : function(e) {
			  document.location.href = "http://localhost:8080/u/order-summary"
		  }
	  });
}