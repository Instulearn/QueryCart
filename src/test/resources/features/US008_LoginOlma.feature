@furkan
Feature: US008 Login Olma
  Kayıtlı bir kullanici olarak siteye kaydoldugum (email/telefon ve password) bilgilerimle login olabilmek istiyorum.

  Background:
    * User makes driver adjustments
    * User fast confirms to be on the homepage

  @login
  Scenario: Ana sayfada profile linki görünür olmalı ve Sign In sayfasına yönlendirmeli
    * User verifies the button with description "Profile"
    * User clicks the button with description "Profile"
    * User verifies the button with description "Sign In"
    * User clicks the button with description "Sign In"
    * User "1" times click the Back Key.

  @login
  Scenario: Login sayfasinda SignIn butonu gorunur ve aktif olmali.
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * User verifies the button with description "Sign In"
    * User "1" times click the Back Key.

  @login
  Scenario: Giris yapilan bilgilerin hatirlanmasi icin Remember me checkBox'i secilebilir olmali.
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * The user taps the "Remember me" checkbox
    * User "1" times click the Back Key.

  @login
  Scenario: Login sayfasindan Forgot Password sayfasina gecis yapilabilmeli.
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * User verifies the button with description "Forgot Password"
    * User clicks the button with description "Forgot Password"
    * User "2" times click the Back Key.

  @login
  Scenario: Login sayfasindan Register sayfasina gecis yapilabilmeli.
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * User verifies the button with description "Sign Up"
    * User clicks the button with description "Sign Up"
    * User "2" times click the Back Key.

  @login
  Scenario: Login formuna gecersiz bilgiler girilip signIn butonuna tiklandiginda hata mesajlari goruntulenmeli.
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * As a user, I want to use the Use email instead option to log in with my email and password.
    * As a user muss be "wrongmail" mail and "wrongpassword" password Login
    * User verifies the button with description "Sign In"
    * User "1" times click the Back Key.

  @login
  Scenario: Login formuna gecerli bilgiler girilip signIn butonuna tiklandiginda sisteme giris yapilabilmeli.
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * As a user, I want to use the Use email instead option to log in with my email and password.
    * As a user muss be "furkanCustomerMail" mail and "customerpassword" password Login
    * Driver turns off