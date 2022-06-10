Feature: Find a customer
  as a user I would like to find a customer by id from my table

  Scenario: I successfully find the customer from my table
    Given I have the customer id number
    When I input the id into the customer search
    Then I get the returned customers information