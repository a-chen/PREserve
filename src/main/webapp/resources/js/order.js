$("#reservation-2").load(function getOrder(){
	var q=1;
	$.ajax({
		type:"GET",
		url: "localhost:9001/order?q="+q,
		succes: function(resp){
			if(resp){
				console.log(resp);
  			}else{
  				renderError(resp);
  			}
		}
	});
});

function renderError(resp){
	$("#output").html("<strong>Does not exist</strong>");
}