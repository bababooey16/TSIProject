Feature: Update an actor
  as a user I would like to update an actors information in my table

  Scenario: I successfully update an actor in my table
    Given I have the actor information to update
    When I send the update request
    Then I get the updated return string