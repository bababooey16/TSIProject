Feature: Adding a new Shopper
  As a user I would like to add a new shopper into my table

  Scenario: I successfully add an shopper to my table
    Given I have the shopper information
    When I input the data into the database
    Then I get the success return string


