@positive @saucedemo
Feature: Positive Test Scenarios

  Scenario Outline: Successful login and logout for user <userName>
    Given User is on login page
    When User enters username "<userName>" and password "secret_sauce"
    And User clicks login
    Then User should see products page
    And User clicks logout
    Examples:
      | userName                |
      | standard_user           |
      | problem_user            |
      | performance_glitch_user |
      | error_user              |
      | visual_user             |

  #defect scenarios - Remove button still enabled even after reset app state
  Scenario Outline: Successful reset app state for user <userName>
    Given User is logged in with "<userName>" and "secret_sauce"
    When User adds product to cart
    Then Cart badge should show "1"
    And User clicks reset
    Then User verify reset state
    Examples: Bug - Remove button still enabled even after reset app state
      | userName                |
      | standard_user           |
      | problem_user            |
      | performance_glitch_user |
      | error_user              |
      | visual_user             |

  Scenario Outline: Verify About page for user <userName>
    Given User is logged in with "<userName>" and "secret_sauce"
    And User clicks about
    And verify page title "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing"
    Examples:
      | userName                |
      | standard_user           |
      | performance_glitch_user |
      | error_user              |
      | visual_user             |
    #defect scenario wrong about page for problem_user
    Examples: Bug - wrong about page for problem_user
      | userName     |
      | problem_user |

  Scenario Outline: Verify all Items for user <userName>
    Given User is logged in with "<userName>" and "secret_sauce"
    When User adds product to cart
    And User open cart page
    Then Cart badge should show "1"
    And User clicks All item
    Then verify page title "Swag Labs"
    Examples:
      | userName                |
      | standard_user           |
      | problem_user            |
      | performance_glitch_user |
      | error_user              |
      | visual_user             |

  Scenario Outline: Add product to cart and remove it from product page for user <userName>
    Given User is logged in with "<userName>" and "secret_sauce"
    When User adds product to cart
    Then Cart badge should show "1"
    When User remove product in product page
    Then Cart badge should show ""
    Examples:
      | userName                |
      | standard_user           |
      | performance_glitch_user |
      | visual_user             |
    #defect scenario - Remove button not enabled in product page
    Examples: Bug - Remove button not enabled in product page
      | userName     |
      | problem_user |
      | error_user   |

  Scenario Outline: Add product to cart and remove it from product details page for user <userName>
    Given User is logged in with "<userName>" and "secret_sauce"
    When User add product "Sauce Labs Backpack" in cart from product page
    Then Cart badge should show "1"
    When User remove product from cart in product details page
    Then Cart badge should show ""
    Examples:
      | userName                |
      | standard_user           |
      | performance_glitch_user |
      | visual_user             |
    #defect scenario - Remove button not enabled in product page
    Examples: Bug - Remove button not enabled in product page
      | userName     |
      | problem_user |
      | error_user   |

  @checkout
  Scenario Outline: Add first product from product page and checkout for user <user>
    Given User add product and proceed to cart for user "<userName>"
    When User proceeds to checkout with below details
      | firstName | vivek              |
      | lastName  | text               |
      | zip       | 600095             |
      | title     | Checkout: Overview |
      | product   |                    |
    Then User should see order confirmation
    Examples:
      | userName                |
      | standard_user           |
      | performance_glitch_user |
      | visual_user             |
    #defect scenario - Finish button not clickable in Checkout overview page
    Examples: Bug - Finish button not clickable in Checkout overview page
      | userName     |
      | problem_user |
      | error_user   |

  @checkout
  Scenario Outline: Add a particular product <product> and checkout from product details page for user <userName>
    Given User add product "Sauce Labs Backpack" and proceed to cart for user "<userName>"
    When User proceeds to checkout with below details
      | firstName | vivek               |
      | lastName  | text                |
      | zip       | 600095              |
      | title     | Checkout: Overview  |
      | product   | Sauce Labs Backpack |
    Then User should see order confirmation
    Examples:
      | userName                |
      | standard_user           |
      | performance_glitch_user |
      | visual_user             |
    #defect scenario - Finish button not clickable in Checkout overview page
    Examples: Bug - Finish button not clickable in Checkout overview page
      | userName     |
      | problem_user |
      | error_user   |

