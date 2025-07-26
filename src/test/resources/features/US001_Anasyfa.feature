Feature: Access and visibility on the Home Page

  As a user
  I want to access the home page when the app is launched
  So that I can see the site logo and start using the app

  Scenario: Home page is displayed upon app launch
    Given the app is installed and launched
    When the user opens the app
    Then the home page should be visible
    And the site logo should be displayed on the home page

