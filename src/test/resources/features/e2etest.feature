Feature: E2E Test Bu testin amacı Bu testin amacı, son kullanıcı perspektifinden uçtan uca (E2E) bir alışveriş sürecinin doğru bir şekilde işleyip işlemediğini doğrulamaktır.

  @e2e
  Scenario: E2E

   # Kullanıcı kendisine saat almaya karar verir.
     # Daha önce alışveriş yaptığı QueryCart sitesine girer ve kendine hesap oluşturarak giriş yapar. +
       # Şifresinin kolay olduğunu düşündüğü için dashboard üzerinden şifresini değiştirir. +
         # Daha sonra Women Watch kategorisine girerek kadın kol saatlerini inceler. +
           # İki ürünü çok beğenir ve her ikisini de favorilere ekler. +
             # Ancak pahalı olan ürüne bütçesi yetmediğinden, onu favorilerden kaldırır. +
               # Kalan üründen iki adet almaya karar verir. +
                 # Saatlerden birini diğer evine göndermek istediği için yeni bir adres ekler. Ardından ödemeyi tamamlar. +
                   # Sipariş detaylarını incelemek için siparişler sayfasına girer. +
                     # Ancak sipariş ettiği saatin rengi içine sinmediği için siparişi iptal eder."

    * User makes driver adjustments
    # Kullanıcı emulatör için gerekli ayarlamaları yapıp kullanıma hazır hale getirir.
    * User confirms to be on the homepage
    # Kullanıcı uygulamanın doğru bir şekilde açıldığını doğrulamak için site üzerindeki logoyu doğrular.
    * User clicks the button with description "Profile"
    # Kullanıcı querycart uygulamasının alt bar'ında bulunan "Profile" butonuna basar.
    * User clicks on the button with the "Sign Up" description
    # Kullanıcı "Kayıt Ol" açıklamasına sahip butona tıklar
    * User clicks on the button with the "*Use Email Instead" description
    # Kullanıcı "Bunun Yerine E-Mail Kullan" açıklamasına sahip düğmeye tıklar
    * User enters "Team159" into the name field
    # Kullanıcı name bölümüne adını yazar
    * The user enters "userdeneme1@abc.com" into the e-mail box.
    # Kullanıcı e-posta bölümüne "userdeneme@abc.com" mail adresini girer.
    * The user enters "asd.123456" into the password box.
    # Kullanıcı şifre bölümüne "asd.123456" mail adresini girer.
    * User clicks the "Sign Up" button
    # Kullanıcı "Kayıt Ol" açıklamasına sahip butona tıklar
    * User should be redirected to the Sign In page
    # Kullanıcı Giriş Yap sayfasına yönlendirilir
    * User enters the same email and password used during registration
    # Kullanıcı kayıt sırasında kullandığı telefon ve şifreyi giriş alanlarına yazar
    * User clicks on the "Sign In" button
    # Kullanıcı "Giriş Yap" butonuna tıklar
    * User should be redirected to the homepage
    # Kullanıcı ana sayfaya yönlendirilir
    * User clicks on the button with the "Profile" description
    # Kullanıcı ana sayfadaki "Profil" açıklamasına sahip butona tıklar
    * User verifies that the "Change Password" button is visible and active
    # Kullanıcı, Change Password düğmesinin görünür ve etkin olduğunu doğrular
    * User clicks on the button with the "Change Password" description
    # Kullanıcı ana sayfadaki "Change Password" açıklamasına sahip butona tıklar
    * User verifies that the "Change Password" button is visible and active
    # Kullanıcı, Change Password düğmesinin görünür ve etkin olduğunu doğrular
    * The user sees the old password, new password, and password checkboxes and tests whether they are active.
    # Kullanıcı eski şifre, yeni şifre ve şifre onay kutularını görüp aktif olduklarını test eder.
    * User verifies that the "Save Changes" button is visible and active
    # Kullanıcı, Save Changes düğmesinin görünür ve etkin olduğunu doğrular
    * The user enters information in all boxes
    # Kullanıcı bütün kutulara bilgilerini girer
    * User clicks on the button with the "Save Changes" description
    # Kullanıcı ana sayfadaki "Change Password" açıklamasına sahip butona tıklar
    * User confirms to be on the homepage
    # Kullanıcı uygulamanın doğru bir şekilde ilerlediğini doğrulamak için site üzerindeki logoyu doğrular.
    * User clicks the button with description "Home"
    # Kullanıcı ana sayfaya dönmek için "Home" butonuna tıklar
    * "Women Watch" Category Visibility and Functionality on Homepage
    # Kullanıcı ana sayfada "Women Watch" kategorisinin görünürlüğünü ve işlevselliğini kontrol eder
    * User clicks the button with description "Women Watch"
    # Kullanıcı "Women Watch" kategorisine girmek için butona tıklar
    * User adds both products to the wishlist
    # Kullanıcı her iki ürünü de favorilere ekler
    * User "1" times click the Back Key.
    # Kullanıcı bir kez geri tuşuna basar
    * User clicks the button with description "Wishlist"
    # Kullanıcı favoriler listesini görüntülemek için "Wishlist" butonuna tıklar
    * User waits "5" seconds
    # Kullanıcı 5 saniye bekler
    * User removes the expensive product from the wishlist
    # Kullanıcı pahalı olan ürünü favorilerden kaldırır
    * User clicks cheap product
    # Kullanıcı ucuz olan ürüne tıklar
    * User clicks the button with description "White"
    # Kullanıcı "Beyaz" renk seçeneğini seçer
    * User swipe the button with description "Add To Cart"
    # Kullanıcı "Sepete Ekle" butonunu kaydırır
    * User decides to purchase two units of the remaining product
    # Kullanıcı kalan üründen iki adet satın almaya karar verir
    * User clicks the button with description "Add To Cart"
    # Kullanıcı "Sepete Ekle" butonuna tıklar
    * User waits "5" seconds
    # Kullanıcı 5 saniye bekler (internet bağlantısı)
    * User clicks the Shopping Cart button
    # Kullanıcı alışveriş sepeti butonuna tıklar
    * User clicks the button with description "Proceed to Checkout"
    # Kullanıcı "Ödemeye Geç" butonuna tıklar
    * User clicks the button with description "Delivery"
    # Kullanıcı "Teslimat" butonuna tıklar
    * User clicks the button with description "Add"
    # Kullanıcı "Ekle" butonuna tıklar
    * User create an address
    # Kullanıcı yeni bir adres oluşturur
    * User clicks the first address
    # Kullanıcı ilk adresi seçer
    * User swipe the button with description "Save & Pay"
    # Kullanıcı "Kaydet ve Öde" butonunu kaydırır
    * User clicks the button with description "Save & Pay"
    # Kullanıcı "Kaydet ve Öde" butonuna tıklar
    * User verifies the button with description "Select Payment Method"
    # Kullanıcı "Ödeme Yöntemi Seç" butonunun görünür olduğunu doğrular
    * User clicks the button with description "Cash On Delivery"
    # Kullanıcı "Kapıda Ödeme" seçeneğini seçer
    * User clicks the button with description "Confirm Order"
    # Kullanıcı "Siparişi Onayla" butonuna tıklar
    * User waits "15" seconds
    # Kullanıcı 10 saniye bekler
    * Click on Go to order details
    # Kullanıcı sipariş detaylarına gitmek için tıklar
    * Click on last order
    # Kullanıcı son siparişe tıklar
    * Verify that "Thank You" text is visible
    # Kullanıcı "Teşekkürler" metninin görünür olduğunu doğrular
    * User "5" times click the Back Key.
    # Kullanıcı beş kez geri tuşuna basar
    * User clicks the button with description "Profile"
    # Kullanıcı "Profil" butonuna tıklar
    * User clicks the button with description "Order History"
    # Kullanıcı "Sipariş Geçmişi" butonuna tıklar
    * User clicks the order
    # Kullanıcı siparişe tıklar
    * User swipe the button with description "Cancel Order"
    # Kullanıcı "Siparişi İptal Et" butonunu kaydırır
    * User verifies the button with description "Cancel Order"
    # Kullanıcı "Siparişi İptal Et" butonunun görünür olduğunu doğrular
    * User clicks the button with description "Cancel Order"
    # Kullanıcı "Siparişi İptal Et" butonuna tıklar
    * User "3" times click the Back Key.
    # Kullanıcı üç kez geri tuşuna basar



  # BU testin amacı sitenin temel işlevlerinin doğru bir şekilde çalışmasını sağlamaktır, Asıl en önemlisi işlevlerden oluşan kusurun tespit edilmesidir