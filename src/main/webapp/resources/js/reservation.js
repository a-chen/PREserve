$("#reservation").click(function() {
    $.ajax({
        method: "GET",
        url: "http://localhost:9001/reservation",
        success: function (resp) {
            console.log(resp);
        }
    });
})
