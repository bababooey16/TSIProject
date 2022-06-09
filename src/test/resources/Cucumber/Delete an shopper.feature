Feature: Delete a shopper
  as a user I would like to delete a shopper from my table

  Scenario: I successfully delete a shopper from my table
    Given I have the shopper information for deletion
    When I send the delete request
    Then I get the deleted return string