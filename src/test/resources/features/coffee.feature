Feature: Get coffee by coffee name
  Scenario: client makes call to GET /coffees/Espresso
    Given the customer wants Espresso
    When the client makes a call to /coffees
    Then the client receives status code of 200
    And  the client receives message as Here is your Espresso
  Scenario: client makes call to GET /coffees/Cappuccino
    Given the customer wants Cappuccino
    When the client makes a call to /coffees
    Then the client receives status code of 200
    And  the client receives message as Here is your Cappuccino
  Scenario: client makes call to GET /coffees/Latte
    Given the customer wants Latte
    When the client makes a call to /coffees
    Then the client receives status code of 200
    And  the client receives message as Here is your Latte