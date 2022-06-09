Feature: Update a shopper
  as a user I would like to update a shoppers information in my table

  Scenario: I successfully update shopper in my table
    Given I have the shopper information to update
    When I send the update request
    Then I get the updated return string