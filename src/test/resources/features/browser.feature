Feature: Browser

  Background: User opens the app
    * User makes driver adjustments
  @browser
  Scenario: browser
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * As a user muss be "phoneNumber" phone and "password" password Login
    * Switching from Query Cart application to Google Chrome
    * Go to the Query Cart url and log in with admin information
    * Returns to the Query Cart app as the user