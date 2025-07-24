Feature: US008 Login Olma
  Kayıtlı bir kullanici olarak siteye kaydoldugum (email/telefon ve password) bilgilerimle login olabilmek istiyorum.

  Background: 
    * User makes driver adjustments
    * User confirms to be on the homepage

  @login
  Scenario: Başarılı giriş yapma
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * As a user, I want to use the Use email instead option to log in with my email and password.
    * As a user muss be "furkanManagerMail" mail and "managerpassword" password Login