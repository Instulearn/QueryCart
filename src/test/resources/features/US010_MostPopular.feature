Feature: US010 Most Popular
  As a user, I would like to have a page where I can follow the latest products on the site where I shop.

  Background:
    * User makes driver adjustments
    * User confirms to be on the homepage

    @TC_010.01
Scenario: As a user, I would like to have a page where I can follow the latest products on the site where I shop.
      * The user verifies that the Most Popular title is visible on the homepage
      * The user verifies that the See All button is visible and enabled
      * List Current products under Most Popular
      * Click the back button
      * User verifies the button with description "Home"
