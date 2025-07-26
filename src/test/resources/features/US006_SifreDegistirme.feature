Feature: Password reset for registered users

  Background:
    Given User opens the app
    And User navigates to the SignIn page

  Scenario: Forgot Password link is visible and active on SignIn page
    Then The "Forgot Password" link should be visible and clickable

  Scenario: User can reset password with valid email or phone number
    When User clicks the "Forgot Password" link
    And User enters a valid email or phone number
    Then User should be able to reset the password

  Scenario: Get OTP button is visible and active on Forgot Password page
    When User navigates to the Forgot Password page
    Then The "Get OTP" button should be visible and clickable

  Scenario: Back to sign in link is visible and active on Forgot Password page
    When User navigates to the Forgot Password page
    Then The "Back to sign in" link should be visible and clickable
