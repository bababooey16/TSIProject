Feature: Find a shopper
  as a user I would like to find a shopper by id from my table

  Scenario: I successfully find the shopper from my table
    Given I have the shopper id number
    When I input the id into the search
    Then I get the returned shoppers information