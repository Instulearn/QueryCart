
Feature: US015 As a registered user, I would like to be able to see the categories
  and products of the Women menu on the home page.

  Background:
    * User makes driver adjustments
    * User fast confirms to be on the homepage


  Scenario: Women category window and subcategories should be displayed in the body section of the home page.
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * As a user, I want to use the Use email instead option to log in with my email and password.
    * As a user muss be "lutfiCustomerMail" mail and "customerpassword" password Login
    * Women Category Visibility and Functionality on Homepage
    * User "1" times click the Back Key.


  Scenario: The products on the Women category page should be able to perform actions (add to cart, add to favorites list and view).
    * User clicks the button with description "Women"
    * Taps on the first product inside the Women category
    * The user adds the first product to the cart
    * User "2" times click the Back Key.


  Scenario: Filtering icons should be visible and active
    * User clicks the button with description "Women"
    * User checks and clicks the filter button in Women category
    * Driver turns off
