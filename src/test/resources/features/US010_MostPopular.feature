Feature: US010 Most Popular
  As a user, I would like to have a page where I can follow the latest products on the site where I shop.

  Background:
    * User makes driver adjustments
    * User confirms to be on the homepage

  @TugbaLogin
  Scenario: Login olarak siteye giris
      When User clicks the button with description "Profile"
      And User clicks the button with description "Sign In"
      And As a user, I want to use the Use email instead option to log in with my email and password.
      And As a user muss be "tugbaCustomerMail" mail and "customerpassword" password Login

    @TC_010.01
Scenario:
      * The user verifies that the Most Popular title is visible on the homepage
      * The user verifies that the See All button is visible and enabled
      * List Current products under Most Popular
      * Click the back button
      * User verifies the button with description "Home"

  @TC_010.02
  Scenario:
    When