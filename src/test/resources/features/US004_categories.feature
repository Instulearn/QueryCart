Feature: US_04 Categories

  Background: User opens the app
    * User makes driver adjustments
  @04
  Scenario:  Verify Categories are Visible and Selectable on Homepage
    * User clicks the button with description "Categories"
    * Verify all the categories are visible under the Categories heading.
    * Select "Toys" category.
    * Verify that the product listing for the selected category is displayed.
    * Select "45cm Anime POKEMON Pikachu Large Stuffed Dolls Soft Plush Animal Toy Gift" from the category.
    * Verify that the product details page for the selected product is displayed.
