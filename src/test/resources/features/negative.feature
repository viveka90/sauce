@negative @saucedemo
Feature: Negative Test Scenarios

  Scenario: Invalid login
    Given User is on login page
    When User enters username "invalid_user" and password "wrong_pass"
    And User clicks login
    Then User should see error message "Epic sadface: Username and password do not match any user in this service"

  Scenario: Locked user login
    Given User is on login page
    When User enters username "locked_out_user" and password "secret_sauce"
    And User clicks login
    Then User should see error message "Epic sadface: Sorry, this user has been locked out."
