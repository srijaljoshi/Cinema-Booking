var promoCode;

window.onload=function(){
	//add functionality to continue and apply buttons
	promoCode = -1;
	var checkoutButton = document.getElementById("checkout");
	checkoutButton.addEventListener("click", checkout);
	
}

function checkout(){
	document.location.href = "http://localhost:8080/u/checkout";
}