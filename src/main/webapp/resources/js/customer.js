$(function(){
    var q = 1;
    $.ajax({
        type:"GET",
        url:"http://localhost:9001/customer?q="+q ,
        success: function(resp){
            console.log(resp);
        }
    });
});