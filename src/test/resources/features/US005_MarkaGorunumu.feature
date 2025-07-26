Feature: Display popular brands on the homepage

  Scenario: User should see brands listed under the Popular Brands section
    Given The user launches the application
    And The homepage is fully loaded
    When The user scrolls to the "Popular Brands" section
    Then The user should see brands displayed under the "Popular Brands" heading
