$(document).ready(function () {
    console.log("order1 ready");

    /*$("#loadOrderButton").click(function () {
        console.log("loadOrderButton clicked");
        loadOrder(1);
        loadMenu(1);
    });*/

    $('.reservation.row .panel-title').on('click', function () {
        var id = $(this).closest($('.reservation.row')).attr('id').replace( /[^\d.]/g, '' );
        console.log("Clicked reservation's id: " + id);

        loadOrder(id);
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
                console.log("Printing orders");
                console.log(data);

                populatePreorderedList(reservationId, data);
                loadMenu(reservationId);
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

        console.log("Starting populatePreorderedList with id: " + reservationId);

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
            // console.log(order);
      /*      console.log(order.orderItems);
            $.each(order.orderItems, function (key1, orderItem) {
                console.log('order: ' + orderItem);
            });*/
            if (order.reservation.id == reservationId) {
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

        //e.g. $("#reservation-1 .table-selector")
        $("#reservation-" + reservationId + " .preordered-items-list-stub").after(preorderedItems);
    } // /populatePreorderedList

    //Populates the menu with items
    function loadMenu(reservationAndOrderId) {
        console.log("Starting loadMenu with id: " + reservationAndOrderId);

        $.ajax({
            url: '/items',
            dataType: 'json',
            success: function (response) {
                console.log("Items retrieved");
                console.log("Printing items");
                console.log(response);
                populateMenu(reservationAndOrderId, response);
            },
            error: function (response) {
                console.log('Failed to get item list');
            }
        });
    } // /loadMenu

    function populateMenu(reservationAndOrderId, data) {

        console.log("Starting populateMenu with id: " + reservationAndOrderId);

        var menuListHTML = '' +
            '<!-- Order Menu List --> ' +
            '<div id="order-' + reservationAndOrderId + '" class="row"> ' +
            '<div class="col-md-12"> ' +
            '<div class="panel panel-default"> ' +
            '<div class="panel-heading">' +
            '<h4 class="panel-title" data-toggle="collapse" data-target="#collapse-order-' + reservationAndOrderId + '" href="#collapse-order-' + reservationAndOrderId +  '">' +
            '<!-- also set the collapse num equal to same num as above--> ' +
            '<a>Order</a> ' +
            '</h4> ' +
            '</div> ' +
            '<!-- here too, set collapse num = same as above 2--> ' +
            '<div id="collapse-order-' + reservationAndOrderId + '" class="panel-collapse collapse in"> ' +
            '<!-- Panel content here --> ' +
            '<div class="panel-body"> ' +
            '<div class="row"> ' +
            '<h3>Menu</h3> ' +
            '<!-- will populate items from database --> ' +
            '<table class="table order-menu"> ' +
            '<tr> ' +
            '<th>Price</th> ' +
            '<th>Name</th> ' +
            '<th>Description</th> ' +
            '</tr> ';

        $.each(data, function (index, item) {
            console.log(item);
            menuListHTML += '' +
                '<!-- set item number with item number from db --> ' +
                '<!-- upon click anywhere on a table row, will add that item to order, can figure out which order it belongs to by finding nearest identifiable parent--> ' +
                '<tr class="item-' + item.id + '"> ' +
                    '<td>' + item.price + '</td> ' +
                    '<td>' + item.name + '</td> ' +
                    '<td>' + item.description + '</td> ' +
                '</tr> ';
        });

        menuListHTML += '' +
            '</table> ' +
            '</div> ' +
            '</div><!-- /Panel content --> ' +
            '</div> ' +
            '</div> ' +
            '</div> ' +
            '</div> <!-- /order -->';

        $("#reservation-" + reservationAndOrderId + " .menu-list-stub").after(menuListHTML);
        // console.log(menuListHTML);
    } // /populateMenu
});