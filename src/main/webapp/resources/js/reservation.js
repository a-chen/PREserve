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
                     $(".table-square1").css("background-color", "#e0162e");
                     $(".table-square2").css("background-color", "#e0162e");
                     $(".table-square3").css("background-color", "#e0162e");
                     $(".table-square4").css("background-color", "#e0162e");
                     $(".table-square5").css("background-color", "#e0162e");
                     $(".table-square6").css("background-color", "#e0162e");
                     $(".table-square7").css("background-color", "#e0162e");
                     $(".table-square8").css("background-color", "#e0162e");

                     $.each( resp, function( i, item ) {
                         //console.log(item)
                         //$(".table-square1").css("background-color", "#e0162e");
                         var tableNum = $(".table-square1").text().replace( /[^\d.]/g, '' );
                         if( tableNum == item.id ) {
                             $(".table-square1").css("background-color", "#26A65B");
                             console.log(tableNum + " " + item.id)
                         }

                         tableNum = $(".table-square2").text().replace( /[^\d.]/g, '' );
                         if( tableNum == item.id ) {
                             $(".table-square2").css("background-color", "#26A65B");
                             console.log(tableNum + " " + item.id)
                         }

                         tableNum = $(".table-square3").text().replace( /[^\d.]/g, '' );
                         if( tableNum == item.id ) {
                             $(".table-square3").css("background-color", "#26A65B");
                             console.log(tableNum + " " + item.id)
                         }

                         tableNum = $(".table-square4").text().replace( /[^\d.]/g, '' );
                         if( tableNum == item.id ) {
                             $(".table-square4").css("background-color", "#26A65B");
                             console.log(tableNum + " " + item.id)
                         }

                         tableNum = $(".table-square5").text().replace( /[^\d.]/g, '' );
                         if( tableNum == item.id ) {
                             $(".table-square5").css("background-color", "#26A65B");
                             console.log(tableNum + " " + item.id)
                         }

                         tableNum = $(".table-square6").text().replace( /[^\d.]/g, '' );
                         if( tableNum == item.id ) {
                             $(".table-square6").css("background-color", "#26A65B");
                             console.log(tableNum + " " + item.id)
                         }

                         tableNum = $(".table-square7").text().replace( /[^\d.]/g, '' );
                         if( tableNum == item.id ) {
                             $(".table-square7").css("background-color", "#26A65B");
                             console.log(tableNum + " " + item.id)
                         }

                         tableNum = $(".table-square8").text().replace( /[^\d.]/g, '' );
                         if( tableNum == item.id ) {
                             $(".table-square8").css("background-color", "#26A65B");
                             console.log(tableNum + " " + item.id)
                         }

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

