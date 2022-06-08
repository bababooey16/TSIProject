Feature: Adding a new Actor
  As a user I would like to add a new actor into my table

  Scenario: I successfully add an actor to my table
    Given I have the actor information
    When I input the data into the database
    Then I get the success return string

#  Scenario: I dont have enough information
#    Given I have an actors first name
#    And I dont have their last name
#    When I try to add them into the databse
#    Then I get an error message
