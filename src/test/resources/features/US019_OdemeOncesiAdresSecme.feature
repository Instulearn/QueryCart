@furkan
Feature: US019 Odeme Oncesi Adres
  Kayıtlı bir kullanıcı olarak sitede odemeyi tamamlamadan önce adres bilgilerimi secip yonetebilecegim bir sayfa olmasını istiyorum


  Background:
    * User makes driver adjustments
    * User fast confirms to be on the homepage

  @furkan
  Scenario: Kayıtlı bir kullanıcı olarak sitede odemeyi tamamlamadan önce adres bilgilerimi secip yonetebilecegim bir sayfa olmasını istiyorum
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * As a user, I want to use the Use email instead option to log in with my email and password.
    * As a user muss be "furkanCustomerMail" mail and "customerpassword" password Login
    * User clicks the button with description "Men"
    * Taps on the first product inside the Men category
    * The user adds the first product to the cart
    * User clicks the Shopping Cart button
    * User clicks the button with description "Proceed to Checkout"
    * User verifies the button with description "Delivery"
    * User verifies the button with description "Pick Up"
    * User clicks the button with description "Delivery"
    * User verifies the button with description "Shipping Address"
    * User verifies the button with description "Edit"
    * User verifies the button with description "Add"
    * User clicks the button with description "Add"
    * User create an address
    * User clicks the button with description "Edit"
    * User "1" times click the Back Key.
    * User clicks the first address
    * User swipe the button with description "Order Summary"
    * User verifies the button with description "Order Summary"
    * User swipe the button with description "Total"
    * User verifies the button with description "Total"
    * User swipe the button with description "Save & Pay"
    * User clicks the button with description "Save & Pay"
    * Driver turns off