@furkan
Feature: US017
  Kayıtlı bir kullanıcı olarak sitede adres bilgilerimi yönetebilecegim bir sayfa olmasını istiyorum

  Background:
    * User makes driver adjustments
    * User fast confirms to be on the homepage

  @login
  Scenario: Kayıtlı bir kullanıcı olarak sitede adres bilgilerimi yönetebilecegim bir sayfa olmasını istiyorum
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * As a user, I want to use the Use email instead option to log in with my email and password.
    * As a user muss be "furkanCustomerMail" mail and "customerpassword" password Login
    * User clicks the button with description "Profile"
    * User clicks the button with description "Address"
    * User swipe the button with description "Add New Address"
    * User verifies the button with description "Add New Address"
    * User clicks the button with description "Add New Address"
    * User create an address
    * Driver turns off