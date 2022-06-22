Feature: Add a new shopper through webpage
  As a user I would like to submit my information through the webpage

  Scenario: I successfully submit my information through the website
    Given The service is running
    When  The buy page is open
    And The submit button is clicked
    Then Redirected to success page
