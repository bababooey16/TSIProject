Feature: Find an address
  as a user I would like to find an address by id from my table

  Scenario: I successfully find the address from my table
    Given I have the address id number
    When I input the address id into the search
    Then I get the returned address information