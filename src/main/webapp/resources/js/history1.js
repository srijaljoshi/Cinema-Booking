function refund(){
	if(confirm("Do you want to cancel your order?")){
		console.log("canceling");
		var x = event.target.nextSibling.nextSibling.textContent;
		console.log(x);
		$.ajax({
			  type: "GET",
			  url: "http://localhost:8080/u/refund",
			  contentType: 'json',
			  data: {
				  'bookingId': x
			  },
		  	  success : function(resource) {
		  		document.location.href = "http://localhost:8080/u/order-history"
		       // do something ... 
		  	  },
			  error : function(e) {
				  document.location.href = "http://localhost:8080/u/order-history"
			  }
		  });
	}
}

function print(){
	var x = event.target.nextSibling.nextSibling.nextSibling.nextSibling.textContent;
	console.log(x);
	var prtContent = document.getElementById(""+x);
	var WinPrint = window.open('', '', 'left=0,top=0,width=800,height=900,toolbar=0,scrollbars=0,status=0');
	WinPrint.document.write(prtContent.innerHTML);
	WinPrint.document.close();
	WinPrint.focus();
	WinPrint.print();
	WinPrint.close();
}