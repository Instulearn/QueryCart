Feature: US011 Wish List
  As a registered user, I would like to be able to create a favorites list on the site

  Background:
    * User makes driver adjustments
    * User confirms to be on the homepage

  @TC_011.01
  Scenario:As a registered user, I would like to be able to create a favorites list on the site
    When User clicks the button with description "Profile"
    And User clicks the button with description "Sign In"
    And As a user, I want to use the Use email instead option to log in with my email and password.
    And As a user muss be "tugbaCustomerMail" mail and "customerpassword" password Login
    Then Verify that Wishlist button is displayed and enabled

  @TC_011.02
  Scenario:As a registered user, I would like to be able to create a favorites list on the site
    When User clicks the button with description "Profile"
    And User clicks the button with description "Sign In"
    And As a user, I want to use the Use email instead option to log in with my email and password.
    And As a user muss be "tugbaCustomerMail" mail and "customerpassword" password Login
    And User adds some products to wishlist
    And Click Wishlist button
    Then verify that selected products are displayed in wishlist