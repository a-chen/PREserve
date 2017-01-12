function getReservation(){
    var q = 1;
    $.ajax({
        type:"GET",
        url:"http://localhost:9001/reservation?q="+q ,
        success: function(resp){
        }
    });
}

$(function () {
    $('.reserve').on('change', function () {
        getReserveTables();
    })
    $('.reserve').on('keyup', function () {
        getReserveTables();
    })
})
 function getReserveTables() {
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
                     $(".table" + i + " a").off('click');
                 }

                 $.each( resp, function( i, table ) {
                     // gets only number in a string
                     var tableNum = $(".table" +table.id + " a div").text().replace( /[^\d.]/g, '' );
                     if( tableNum == table.id ) {
                         $(".table" +table.id + " a div").css("background-color", "#26A65B");
                         $(".table" + table.id + " a").on('click', function(){
                             insertReservation(reservation, table);
                         });
                     }
                 });
             },
             error: function(resp){
                console.log("error");
             }
         });
    }
}

function insertReservation(reservation, table){
    reservation.table = table;
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
            $(".table" + resp.table.id + " a div").css("background-color", "#e0162e");
            $(".table" + resp.table.id + " a").off('click');
        },
        error: function(resp){
            console.log('error ');
        }
    });
}

