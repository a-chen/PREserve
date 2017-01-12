$(document).ready(function () {
	$("#initial-reservation-selector .table3").click(function() {
		alert("Table 3 selected.");
	});
});
$(document).ready(function () {
	$("#reservation-1 .table3").click(function() {
		alert("Table 3 selected.");
	});
});

$("#reservation").click(function () {
    $.ajax({
        method: "GET",
        url: "http://localhost:9001/reservation",
        success: function (resp) {
            console.log(resp);
        }
    });
});

// Timepicker initialization
$(function () {
    $('.time-input').timepicker({
        'minTime': '9:00am',
        'maxTime': '11:00pm',
        'forceRoundTime': true,
        'timeFormat': 'h:i A'
    });
});

// Loads external html
$(function () {
    $(".load-table-selector").load("tableSelector.html");
});
