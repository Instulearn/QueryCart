@furkan
Feature: US018
  Kayitli bir kullanici olarak Dashboard panelimde alisveris gecmisimi goruntuleyebilecegim bir sayfanin olmasini istiyorum

  Background:
    * User makes driver adjustments
    * User fast confirms to be on the homepage

  @login
  Scenario: Kayitli bir kullanici olarak Dashboard panelimde alisveris gecmisimi goruntuleyebilecegim bir sayfanin olmasini istiyorum
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * As a user, I want to use the Use email instead option to log in with my email and password.
    * As a user muss be "furkanCustomerMail" mail and "customerpassword" password Login
    * User clicks the button with description "Profile"
    * User clicks the button with description "Order History"
    * User clicks the first order
    * User verifies the button with description "Order Canceled"
    * User swipe the button with description "Download Receipt"
    * Driver turns off