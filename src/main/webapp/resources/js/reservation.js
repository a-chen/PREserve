function getReservation(){
    var q = 1;
    $.ajax({
        type:"GET",
        url:"http://localhost:9001/reservation?q="+q ,
        success: function(resp){
            console.log(resp);
        }
    });
} // to be used in customer ajax call


/*$("#insertReservation").click(function(){
    var customer ={};
    var table = {};
    var reservation = {};
    $.ajax({
        type:"GET",
        data: JSON.stringify( reservation ),
        url:"http://localhost:9001/reservation/insert" ,
        success: function(resp){
            console.log("in get reserve");
        }
    });
});*/
