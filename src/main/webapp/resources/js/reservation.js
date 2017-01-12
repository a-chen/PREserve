function getReservation(){
    var q = 1;
    $.ajax({
        type:"GET",
        url:"http://localhost:9001/reservation?q="+q ,
        success: function(resp){
            //console.log(resp);
        }
    });
}   // to be used in customer ajax call
    // TODO in service, make logic to only get the most recent reservation.
function insertReservation() {
    console.log("in table click")
   // var table = $("#all-tables").closest('.table-square');
    //table.css("background-color", "#e0162e");
}
$(function() {
    $('.reserve').on('change paste keyup', function () {
        var date = $('#date').val();
        var time = $('#timepicker1').val();
        var patrons = $("#patrons").val();
        if( date != '' && time != '' && patrons != ''){
            var fullDate= new Date(date + ' ' + time);
            var customer = {id : 1};
            var reservation = {
                date: fullDate,
                customer: customer,
                patrons: patrons
            };
           // console.log(fullDate);
             $.ajax({
                 headers: {
                     'Accept': 'application/json',
                     'Content-Type': 'application/json'
                 },
                 type:"POST",
                 data: JSON.stringify( reservation ),
                 dataType: 'json',
                 url:"http://localhost:9001/reservation/getReservedTables" ,
                 success: function(resp){
                     for( var i = 1; i < 9; i++){
                         $(".table" + i + " a div").css("background-color", "#e0162e");
                     }

                     $.each( resp, function( i, item ) {
                         var tableNum = $(".table" + item.id + " a div").text().replace( /[^\d.]/g, '' );
                         console.log(i);
                         if( tableNum == item.id )
                             $(".table" + item.id + " a div").css("background-color", "#26A65B");
                     });
                 },
                 error: function(resp){
                    console.log("error");
                 }
             });
        }
    });
});

$("#insertReservation").click(function(){
    var customer ={id:              1,
        firstName:                  "Jason",
        lastName:                   "Bourne",
        username:                   "bourne2win",
        email:                      "jasonbourne@gmail.com",
        phone:                      "3829879876"};
    var table = {capacity: 2};
    var reservation = {
        date: new Date(),
        table: table,
        customer: customer};
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type:"POST",
        data: JSON.stringify( reservation ),
        dataType: 'json',
        url:"http://localhost:9001/reservation/insert" ,
        success: function(resp){
            console.log(resp.customer.firstName);
        },
        error: function(resp){
            console.log("error " + new Date());
        }
    });
});

