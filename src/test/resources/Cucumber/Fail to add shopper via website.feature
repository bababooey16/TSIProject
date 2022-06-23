 Feature: fail to add new shopper through webpage
  As a user I will attempt to submit incorrect information through the webpage

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

   #paramiter testing