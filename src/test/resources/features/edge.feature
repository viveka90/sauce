@edge @saucedemo
Feature: Edge Case Scenarios

  Scenario: Empty username and password
    Given User is on login page
    When User enters username "" and password ""
    And User clicks login
    Then User should see error message "Epic sadface: Username is required"

  Scenario: Only username entered
    Given User is on login page
    When User enters username "standard_user" and password ""
    And User clicks login
    Then User should see error message "Epic sadface: Password is required"

  Scenario: Only password entered
    Given User is on login page
    When User enters username "" and password "fdsasd"
    And User clicks login
    Then User should see error message "Epic sadface: Username is required"
