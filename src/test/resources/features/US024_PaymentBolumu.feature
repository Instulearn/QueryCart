@canan
Feature: US_024 - As a registered user, I want to have a payment page where I can pay for my orders that I control.


  Background:
    * User makes driver adjustments
    * User confirms to be on the homepage

 Scenario: Odeme Yontemi kismina sorunsuz gecis yapilabilmeli

   * User clicks the button with description "Profile"
   * User clicks the button with description "Sign In"
   * As a user, I want to use the Use email instead option to log in with my email and password.
   * As a user muss be "cananCustomerMail" mail and "customerpassword" password Login
   * User clicks the button with description "Men"
   * Taps on the first product inside the Men category
   * The user adds the first product to the cart
   * User clicks the Shopping Cart button
   * User clicks the button with description "Proceed to Checkout"
   * User clicks the 1st address
   * User swipe the button with description "Save & Pay"
   * User clicks the button with description "Save & Pay"

  Scenario: Ödeme yapılmalı ve sipariş detayları görüntülenebilmeli
    * User clicks the button with description "Save & Pay"
    * User verifies the button with description "Select Payment Method"
    * Select "Stripe" as the payment method
    * Click on the Confirm Order button
    * Enter valid card number, expiry date,CVC and ZIP
    * Click on the Confirm button
    * Click on Go to order details
    * Click on last order
    * Verify that "Thank You" text is visible
    * User "5" times click the Back Key.

