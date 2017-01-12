$(document).ready(function () {
    console.log("order1 ready");

    $("#loadOrderButton").click(function () {
        console.log("loadOrderButton clicked");
        loadOrder(1)
    });

    // Populates existing items for given order
    function loadOrder(reservationId) {
        console.log("loadOrder starting with id: " + reservationId);

        $.ajax({
            type: 'GET',
            url: '/order?q=' + reservationId,
            dataType: 'json',
            success: function (data) {
                console.log("Order retrieved");

                populatePreorderedList(reservationId, data);

                /*$.each(response, function (index, order) {
                    // console.log(order.reservation);
                 console.log(order);
                 $.each(order.orderItems, function (index1, orderItem) {
                 console.log(orderItem.item);
                 })
                 })*/
            },
            error: function (data) {
                console.log("Fetching reservations failed");
            }
        });

        //Example
        /*$.ajax({
         type: 'GET',
         url: 'http://example/functions.php',
         data: { get_param: 'value' },
         dataType: 'json',
         success: function (data) {
         $.each(data, function(index, element) {
         $('body').append($('<div>', {
         text: element.name
         }));
         });
         }
         });*/
    } // /loadOrder

    function populatePreorderedList(reservationId, response) {

        var preorderedItems;

        preorderedItems = '<!-- Pre-ordered items --> ' +
            '<div class="ordered-items-container"> ' +
                '<h3>Ordered items</h3> ' +
                '<table class="table ordered-items"> ' +
                    '<tr> ' +
                        '<th>Quantity</th>' +
                        '<th>Price</th> ' +
                        '<th>Name</th> ' +
                        '<th>Description</th> ' +
                    '</tr> ' +
                    '<!-- set item number with item number from db --> ' +
                    '<!-- upon click anywhere on a table row, will add that item to order --> ';

        $.each(response, function (index, order) {
            console.log("order.reservation.id:" + order.reservation.id + ", order.reservation: " + reservationId);
            if (order.reservation.id === reservationId) {
                $.each(order.orderItems, function (key1, orderItem) {
                    preorderedItems +=
                        '<tr class="item-" + orderItem.item.id> ' +
                            '<td>' + orderItem.quantity + '</td>' +
                            '<td>' + orderItem.item.price + '</td> ' +
                            '<td>' + orderItem.item.name + '</td> ' +
                            '<td>' + orderItem.item.description + '</td> ' +
                        '</tr> ';
                });
            }
        });

        preorderedItems +=
                '</table> ' +
                '<!-- auto update this every time something is added to #ordered-items --> ' +
                '<h5>Total: <span class="menu-total">12</span></h5> ' +
            '</div>';

        console.log(preorderedItems);

        //e.g. $("#reservation-1 .table-selector")
        $("#reservation-" + reservationId + " .table-selector").after(preorderedItems);
    } // /populatePreorderedList

    //Populates menus with items
    function loadMenu() {



    }



});