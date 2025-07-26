Feature: US010 Most Popular
  As a user, I would like to have a page where I can follow the latest products on the site where I shop.

  Background:
    Given User makes driver adjustments
    Given User confirms to be on the homepage

  @deneme
  Scenario: Ana sayfada profile linki görünür olmalı ve Sign In sayfasına yönlendirmeli
      Given User verifies the button with description "Profile"
      When User clicks the button with description "Profile"
      And User verifies the button with description "Sign In"
      And User clicks the button with description "Sign In"