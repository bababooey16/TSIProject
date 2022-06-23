Feature: Add a new shopper through webpage
  As a user I would like to submit my information through the webpage

  Scenario: I successfully submit my information through the website
    Given The service is running
    When  The buy page is open
    And The submit button is clicked
    Then Redirected to success page


       #paramiter testing

  Scenario Outline: I fail to submit my information through the website
    Given The service is currently running
    When The buy page is currently open
    And I enter "<name>", "<card>", "<expiry>", "<cvc>"
    And The submit button is pressed
    Then A validation error will show "<inputs>"

    Examples:
      | name    | card             | expiry | cvc | inputs |
      |         | 5454545454545454 | 0505   | 803 | input1 |
      | Joe Joe |                  | 0505   | 803 | input2 |
      | Joe Joe | 5454545454545454 |        | 803 | input3 |
      | Joe Joe | 5454545454545454 | 0505   |     | input4 |



  Scenario Outline: I fail to to submit my data through the website
    Given The API is currently running
    When The buy page is presently open
    And I input "<name>", "<card>", "<expiry>", "<cvc>"
    And I press the submit button
    Then a validation format error will show "<inputs>"
    Examples:
      | name    | card             | expiry | cvc | inputs |
      | 123123  | 5454545454545454 | 0505   | 803 | input1 |
      | Joe Joe | abcdefg          | 0505   | 803 | input2 |
      | Joe Joe | 5454545454545454 | abcd   | 803 | input3 |
      | Joe Joe | 5454545454545454 | 0505   | abc | input4 |
