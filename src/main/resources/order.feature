Feature: Place an order
  As customer
  I can add food to my reservation
  So my meal is prepared in time for my reservation

  # View Menu
  Scenario:
    Given I have placed a reservation
    When  I click on the view menu button
    Then  I view all items

  # Add items
  Scenario:
    Given I am viewing the menu
    When  I chose an item and quantity
    Then  The item is added to my order

  # Update quantity
  Scenario:
    Given I have items in my order
    When  I click update quantity
    Then  I can change the item quantity

  # Delete item
  Scenario:
    Given I have items in my order
    When  I click delete item
    Then  The item is removed from my order