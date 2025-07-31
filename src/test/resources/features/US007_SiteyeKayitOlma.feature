@lutfi
Feature: US007 Registration
  As a user, I would like to be able to register on the site to take advantage of its functions

  Background:
    * User makes driver adjustments
    * User confirms to be on the homepage

  Scenario: The profile icon should be visible and active at the bottom bar of the home page.
    * User verifies the button with description "Profile"

  Scenario: SignUp button should be visible and active under the SignUp form.
    * User clicks the button with description "Profile"
    * User verifies the button with description "Sign Up"
    * User clicks the button with description "Sign Up"
    * User verifies the button with description "Sign Up"
    * User "2" times click the Back Key.

  Scenario: The SignUp form must have fields that cannot be left blank (Firstname, Email or Phone, Password).
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign Up"
    * User clicks the button with description Sign Up
    * User is warned that the firstname, phone and password fields cannot be left blank
    * User "2" times click the Back Key.

  Scenario: It should be mandatory to enter at least 7 digit number to register with phone number.
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign Up"
    * User enters "lutfi" as username and "Query.151224" as password , but their "123456" as incomplete phone number
    * User clicks the button with description Sign Up
    * The user is warned with an error message.
    * User "2" times click the Back Key.

  Scenario: The email entered for email entry must meet the valid email criteria
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign Up"
    * As a user, I want to use the Use email instead option to log in with my email and password.
    * When a valid e-mail address is entered, an incorrect e-mail address warning should not appear
    * User "2" times click the Back Key.

  Scenario: It must meet the criteria of valid password (minimum 6 characters) entered for password entry.
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign Up"
    * User enters 7 digits password without password digit alert
    * User "2" times click the Back Key.

  Scenario: It should be possible to switch from SignUp page to signIn page.
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign Up"
    * User clicks the button with description "Sign In"
    * User validate the page is Sign In Page.
    * User "2" times click the Back Key.


