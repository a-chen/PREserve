$(document).ready(function () {
    console.log("order1 ready");

    $("#loadOrderButton").click(function () {
        console.log("loadOrderButton clicked");
        loadOrder(1)
    });

    function loadOrder(reservationId) {
        console.log("loadOrder starting with id: " + reservationId);

        // var response = [Order{id:1, reservation:1, customer:1, orderItems:[OrderItem [order:1, item:2, quantity:1]]}];

        //disabled for now until figure out why stack overflow
        /*$.ajax({
            method: "POST",
            url: ("/reservation?=" + reservationId),
            success: function (data) {
                console.log("Reservations retrieved");
                response = data;
            },
            error: function(data){
                console.log("Fetching reservations failed");
            }
        });*/

        var preorderedItems = '<!-- Pre-ordered items --> ' +
            '<div class="ordered-items-container"> ' +
            '<h3>Ordered items</h3> ' +
            '<table class="table ordered-items"> ' +
            '<tr> ' +
            '<th>Price</th> ' +
            '<th>Name</th> ' +
            '<th>Description</th> ' +
            '</tr> ' +
            '<!-- set item number with item number from db --> ' +
            '<!-- upon click anywhere on a table row, will add that item to order --> ';

        //[Order{id=22, reservation=1, customer=1, orderItems=[]},
        // Order{id=1, reservation=1, customer=1, orderItems=[OrderItem [order=1, item=2, quantity=1]]}]
        //first loops through orders
        $.each(response, function (key, order) {
            if(order.reservation === reservationId) {
                $.each(order.orderItems, function (key1, orderItem) {
                    preorderedItems +=  '<tr class="item-" + orderItem.item.id> ' +
                        '<td></td> ' +
                        '<td>Anchovy Pizza</td> ' +
                        '<td>Raw fish</td> ' +
                        '</tr> ';
                });
            }
        });

        /*'<tr class="item-1"> ' +
        '<td></td> ' +
        '<td>Anchovy Pizza</td> ' +
        '<td>Raw fish</td> ' +
        '</tr> ' +*/


        preorderedItems += '</table> ' +
            '<!-- auto update this every time something is added to #ordered-items --> ' +
            '<h5>Total: <span class="menu-total">12</span></h5> ' +
            '</div>';

        //e.g. $("#reservation-1 .table-selector")
        $("#reservation-" + reservationId + " .table-selector").after('')
    }

});