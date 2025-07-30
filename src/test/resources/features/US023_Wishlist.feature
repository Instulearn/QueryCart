Feature: As a user, I want to create a favorite list with the products I like without registering.

  Background: User opens the app
    Given User makes driver adjustments
          # Kullanıcı sürücü ayarlamalarını yapar

  Scenario: [TC_23.1] Testing the visibility and activity of the favorite icon on the products on the site
          # Sitedeki ürünlerde favori ikonunun görünürlüğünün ve etkinliğinin test edilmesi
    Then Then The "Most Popular" header should be visible on the page
    # Most Popular başlığı altında 2 ürün listelenmiş olmalı
    And Each product has a favorite heart icon on the top right corner
    # Her ürünün sağ üst köşesinde favori (kalp) ikonu olmalı
    And Favorite icons must be clickable
    # Favori ikonları tıklanabilir durumda olmalı
    # And Driver turns off
    # Driver kapatılır



  Scenario: [TC_23.2] To register a product, go to the Sign-in page and Sign up/Sign-in test.
    When User clicks on the button with the "Profile" description
    # Kullanıcı ana sayfadaki "Profil" açıklamasına sahip butona tıklar
    And User clicks on the button with the "Sign Up" description
    # Kullanıcı "Kayıt Ol" açıklamasına sahip butona tıklar
    And User clicks on the button with the "*Use Email Instead" description
    # Kullanıcı "Bunun Yerine E-Mail Kullan" açıklamasına sahip düğmeye tıklar
    And User enters "Kerem" into the name field
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
    # And Driver turns off
    # Driver kapanır, uygulama sonlandırılır