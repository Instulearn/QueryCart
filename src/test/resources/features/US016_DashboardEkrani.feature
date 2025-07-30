@furkan
Feature: US016
  Kayitli bir kullanici olarak sitedeki islemlerimi ve ayarlarimi kontrol etmek icin sitede bana özel bir dashboard sayfasinin olmasini istiyorum.

  Background:
    * User makes driver adjustments
    * User fast confirms to be on the homepage

  @login
  Scenario: Ana sayfada Profile ikonu gorunur ve aktif olmali ve profile ikonuna tıklandıgında dashboard sayfasına gecilmeli
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * As a user, I want to use the Use email instead option to log in with my email and password.
    * As a user muss be "furkanCustomerMail" mail and "customerpassword" password Login
    * User clicks the button with description "Profile"
    * User clicks the button with description "My Account"
    * User verifies the button with description "Total Orders"
    * User verifies the button with description "Total Completed"
    * User verifies the button with description "Total Returnd"
    * User verifies the button with description "Wallet Balance"
    * User verifies the button with description "Order History"
    * Driver turns off