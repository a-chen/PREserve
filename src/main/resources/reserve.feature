Feature:  Reserve Table
  As a customer
  I can pick a table
  So I can make a reservation

  # Create reservation
  Scenario: Success
    Given I picked a date and time
    And   Chose a number of patrons
    And   the table is available
    When  I click on a table
    Then  I receive confirmation

  # Failed to create reservation
  Scenario: Failure
    Given I picked a date and time
    And   Chose a number of patrons
    But   the table is not available
    When  I click on a table
    Then  I receive a failure message
    And   alternative time slots

  # Update patrons
  Scenario:
    Given I have a reservation
    When  I click update patrons
    Then  I can choose a number of patrons
    And   pick an available table

  # Update reservation table
  Scenario:
    Given I have a reservation
    When  I click update table
    Then  I can choose an available table

  # Update time slot
  Scenario:
    Given I have a reservation
    When  I click update time slot
    Then  I can choose other available time slots
    And   pick an available table

  # Delete reservation
  Scenario:
    Given I have items in my order
    When  I click delete item
    Then  The item is removed from my order