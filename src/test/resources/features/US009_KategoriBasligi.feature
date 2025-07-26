Feature: Viewing all categories under the Categories heading

  Background:
    Given The user is on the homepage
    And The "Category" icon in the navbar is visible and clickable

  Scenario: User clicks the "Category" icon to go to categories section
    When The user clicks the "Category" icon in the navbar
    Then The user should see the categories page or section

  Scenario: Men, Women, and Junior headings are visible and clickable
    Given The user is on the categories page or section
    Then The "Men", "Women", and "Junior" headings should be visible and clickable

  Scenario Outline: User clicks on category headings to explore products
    Given The user is on the categories page or section
    When The user clicks on the "<category>" heading
    Then The "<category>" category products should be displayed

    Examples:
      | category |
      | Men      |
      | Women    |
      | Junior   |

  Scenario: Filtering icons are visible and active
    Given The user is on the categories page or section
    Then The filtering icons should be visible and active

