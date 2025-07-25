Feature: Guest user can browse and add products to cart

  Background: User opens the app
    * User makes driver adjustments

  Scenario: Products and features are visible on homepage
    * the app is launched
    * I am not logged in
    * I navigate to the homepage
    * I should see a list of products with name, image, price, and features

  Scenario: Select product size, color, and quantity
    * I am on the product detail page
    * I select size "M"
    * I select color "Red"
    * I enter quantity "2"
    * the selections should be accepted

  Scenario: Add product to cart without registration
    * I have selected valid size, color, and quantity
    * I tap the "Add to Cart" button
    * the product should be added to my cart