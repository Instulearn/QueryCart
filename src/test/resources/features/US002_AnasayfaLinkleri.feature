Feature: Home Page UI elements and navigation

  As a user
  I want to see key UI components on the home page
  And be able to navigate using the bottom bar and search for items

  Background:
    Given the app is launched
    And the user is on the home page

  Scenario: Bottom navigation links are visible
    Then the bottom navigation bar should be visible
    And it should contain links for Home, Category, Wishlist, Cart, and Profile

  Scenario Outline: Navigation link redirects to correct page
    When the user taps on the "<link>" button in the bottom navigation bar
    Then the "<page>" page should be displayed

    Examples:
      | link     | page     |
      | Home     | Home     |
      | Category | Category |
      | Wishlist | Wishlist |
      | Cart     | Cart     |
      | Profile  | Profile  |

  Scenario: Search text box is visible
    Then the search box should be displayed on the home page

  Scenario: User can perform a search
    When the user enters "laptop" into the search box
    And the user taps the search button
    Then the search results for "laptop" should be displayed
