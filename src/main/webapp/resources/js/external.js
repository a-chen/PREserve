$(function() {
    $('#timepicker1').timepicker({
        'minTime': '9:00am',
        'maxTime': '11:00pm',
        'forceRoundTime': true,
        'timeFormat': 'h:i A'
    });
});

$("#reservation").click(function() {
    $.ajax({
        method: "GET",
        url: "http://localhost:9001/reservation",
        success: function (resp) {
            console.log(resp);
        }
    });
});
