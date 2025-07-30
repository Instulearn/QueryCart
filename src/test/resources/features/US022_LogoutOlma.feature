@test22
Feature: US_022 - User can log out of the system securely

  Background:
    * User makes driver adjustments
    * User confirms to be on the homepage

  Scenario: Kullanici login olur
    When User clicks the button with description "Profile"
    And User clicks the button with description "Sign In"
    And As a user, I want to use the Use email instead option to log in with my email and password.
    And As a user muss be "cananCustomerMail" mail and "customerpassword" password Login

  Scenario: Logout seçeneği görünür ve aktif olmalı
    * User clicks the button with description "Profile"
    * User verifies the buttonn with description "Logout"
    * User clicks the button withh description "Logout"