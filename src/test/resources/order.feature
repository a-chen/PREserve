Feature: Place an order
  As a customer
  I can add food to my reservation
  So that my meal is prepared in time for my reservation
  
Background: Context for all tests
	Given: I have this order
	| Item						|	quantity	|
	|	Classic Pizza		|	2					|
	| Anchovy Pizza		| 3				 	|
	| Hawaiian Pizza	| 1				 	|
	
  # View Menu
  Scenario: Customer can view all menu items
    Given I have placed a reservation
    When  I click on the view menu button
    Then  I view all items

  # Add items
  Scenario: Customer can add an item to the order
    Given I am viewing the menu
    When  I choose an item and quantity
    Then  The item is added to my order

  # Update quantity
  Scenario: Customer can edit the item quantity
    Given I have items in my order
    When  I click update quantity
    Then  I can change the item quantity
      
  # Delete item
  Scenario: Customer can delete an item from the order
    Given I have items in my order
    When  I click delete item
    Then  The item is removed from my order
 	