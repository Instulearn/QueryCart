
Feature: As a registered user, I want to have a favorite products page on the site and I want to be able to manage this page.

  Background: User opens the app
    Given User makes driver adjustments
          # Kullanıcı sürücü ayarlamalarını yapar

  Scenario: [TC_26.1-TC_26.2-TC26.3-TC26.4] Testing the visibility and activity of the favorite icon on the product and adding the desired product to the favorite area.
    # Ürün üzerindeki favori ikonunun görünürlüğünü ve etkinliğini test ederek istenilen ürünü favori alanına ekleme
    When User clicks on the button with the "Profile" description
    # Kullanıcı ana sayfadaki "Profil" açıklamasına sahip butona tıklar
    And User clicks on the button with the "Sign In" description
    # Kullanıcı "Giriş Yap" açıklamasına sahip butona tıklar
    And User clicks on the button with the "*Use Email Instead" description
    # Kullanıcı "Bunun Yerine E-Mail Kullan" açıklamasına sahip düğmeye tıklar
    Then User enters "keremCustomerMail" address and "customerpassword" password
    # Kullanıcı gecerli bir mail adresi ve sifre girer
    And User clicks on the "Sign In" button
    # Kullanıcı "Giriş Yap" butonuna tıklar
    And User should be redirected to the homepage
    # Kullanıcı ana sayfaya yönlendirilir
    Then User clicks the button with itemName "Floral Print Midi Dress" and "0 (0  Reviews)" and "$100.00" added WishList
    # Kullanıcı, "Çiçek Desenli Midi Elbise" adlı öğenin bulunduğu düğmeye tıklar ve "0 (0 Yorum)" ve "$100.00" İstek Listesine eklenir
    When User verifies that the "Wishlist" button is visible and active
    # Kullanıcı, İstek Listesi düğmesinin görünür ve etkin olduğunu doğrular
    When User clicks on the button with the "Wishlist" description
    # Kullanıcı ana sayfadaki "Favori Liste" açıklamasına sahip butona tıklar
    And User sees Wishlist title and wishlist quantity
    # Kullanıcı İstek Listesi başlığını ve istek listesi miktarını görür
    Then The user clicks on the red heart sign in the upper right corner of the products on the page that opens.
    # Açılan sayfada ürünlerin sağ üst köşesinde bulunan kırmızı kalp işaretine tıklanır.
    And The user confirms that there are no products left in the product quantity.
    # Kullanıcı, ürün miktarında ürün kalmadığını teyit eder.
