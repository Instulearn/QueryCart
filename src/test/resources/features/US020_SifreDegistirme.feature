
Feature: As a registered user, I want to change my password on my dashboard page.

  Background: User opens the app
    Given User makes driver adjustments
          # Kullanıcı sürücü ayarlamalarını yapar

  Scenario: [TC_20.1 -TC_20.2 -TC_20.3 -TC_20.4] Change User Password link visibility and activity test in User Control Panel
    # Ürün üzerindeki favori ikonunun görünürlüğünü ve etkinliğini test ederek istenilen ürünü favori alanına ekleme
    When User clicks on the button with the "Profile" description
    # Kullanıcı ana sayfadaki "Profil" açıklamasına sahip butona tıklar
    And User clicks on the button with the "Sign Up" description
    # Kullanıcı "Kayıt Ol" açıklamasına sahip butona tıklar
    And User clicks on the button with the "*Use Email Instead" description
    # Kullanıcı "Bunun Yerine E-Mail Kullan" açıklamasına sahip düğmeye tıklar
    And User enters "Team159" into the name field
    # Kullanıcı ad alanına "Kerem" yazar
    And The user enters "userdeneme1@abc.com" into the e-mail box.
    # Kullanıcı e-posta kutusuna "userdeneme@abc.com" mail adresini girer. (Bu sekme dinamik değil, otomatik mail üretiyor.Adımdaki maili değiştirmenize gerek yok).
    And The user enters "asd.123456" into the password box.
    # Kullanıcı e-posta kutusuna "asd.123456" mail adresini girer.
    And User clicks the "Sign Up" button
    # Kullanıcı "Kayıt Ol" açıklamasına sahip butona tıklar
    And User should be redirected to the Sign In page
    # Kullanıcı Giriş Yap sayfasına yönlendirilir
    When User enters the same email and password used during registration
    # Kullanıcı kayıt sırasında kullandığı telefon ve şifreyi giriş alanlarına yazar
    And User clicks on the "Sign In" button
    # Kullanıcı "Giriş Yap" butonuna tıklar
    And User should be redirected to the homepage
    # Kullanıcı ana sayfaya yönlendirilir
    When User clicks on the button with the "Profile" description
    # Kullanıcı ana sayfadaki "Profil" açıklamasına sahip butona tıklar
    When User verifies that the "Change Password" button is visible and active
    # Kullanıcı, Change Password düğmesinin görünür ve etkin olduğunu doğrular
    When User clicks on the button with the "Change Password" description
    # Kullanıcı ana sayfadaki "Change Password" açıklamasına sahip butona tıklar
    When User verifies that the "Change Password" button is visible and active
    # Kullanıcı, Change Password düğmesinin görünür ve etkin olduğunu doğrular
    And The user sees the old password, new password, and password checkboxes and tests whether they are active.
    # Kullanıcı eski şifre, yeni şifre ve şifre onay kutularını görüp aktif olduklarını test eder.
    When User verifies that the "Save Changes" button is visible and active
    # Kullanıcı, Save Changes düğmesinin görünür ve etkin olduğunu doğrular
    Then The user enters information in all boxes
    # Kullanıcı bütün kutulara bilgilerini girer
    When User clicks on the button with the "Save Changes" description
    # Kullanıcı ana sayfadaki "Change Password" açıklamasına sahip butona tıklar
    When User verifies that the "Logout" button is visible and active
    # Kullanıcı, Logout düğmesinin görünür ve etkin olduğunu doğrular