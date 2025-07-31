
Feature: US_021 - Edit Profile Functionality

  Background:
    * User makes driver adjustments
    * User confirms to be on the homepage

  Scenario: Kullanici login olur
    When User clicks the button with description "Profile"
    And User clicks the button with description "Sign In"
    And As a user, I want to use the Use email instead option to log in with my email and password.
    And As a user muss be "cananCustomerMail" mail and "customerpassword" password Login


  Scenario: Kullanici profilindeki bilgileri duzenleyebilmeli ve kaydedebilmeli
    * User clicks on "Profile" button
    * Verify that the "Edit Profile" link is visible and active on the Dashboard page
    * Click on the "Edit Profile" link
    * Verify that "Full Name", "Email", and "Phone" fields are editable
    * Enter new valid values into Full Name, Email, and Phone fields
    * Verify that the "Save Changes" button is visible and active
    * Click the "Save Changes" button


