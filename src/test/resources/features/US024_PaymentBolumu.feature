
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

  Scenario: Ödeme yöntemi seçilebilmeli ve odeme yapilabilmelidir
    * User clicks the button with description "Save & Pay"
    * User verifies the button with description "Select Payment Method"
    * Select "Stripe" as the payment method
    * Enter valid card number, expiry date,CVC and ZIP
    * Verify that the Confirm Order button is visible and active
    * Click on the "Confirm Order" button

  Scenario: Sipariş detayları ve fatura görüntülenebilmeli
    * Click on Go to order details
    * Verify that Download Receipt button is visible
    * Click on Download Receipt
    * Verify that Print Invoice button is visible
