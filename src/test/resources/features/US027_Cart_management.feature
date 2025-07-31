
  Feature: As a registered user, I want to have a cart on the site and I want to be able to manage these cart operations.

    Background: User opens the app
      Given User makes driver adjustments
          # Kullanıcı sürücü ayarlamalarını yapar


    Scenario: [TC_27.1] Testing whether the cart icon is visible and active on the home page
    # Ana sayfada sepet simgesinin görünür ve etkin olup olmadığının test edilmesi
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
      When User verifies that the cart button is visible and active
    # Kullanıcı, sepet butonunun düğmesinin görünür ve etkin olduğunu doğrular


    Scenario: [TC_27.2 -TC_27.3 -TC_27.4] On the Shopping Cart page, products added to the cart should be displayed and can be deleted
     # Alışveriş Sepeti sayfasında sepete eklenen ürünler görüntülenmeli ve silinebilmelidir.
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
      Then The user clicks on the product wants to add to cart.
    # Kullanıcı sepete eklemek istediği ürüne tıklar.
      Then The user confirms that the product in the cart is the product they selected
    # Kullanıcı, sepetteki ürünün seçtiği ürün olduğunu onaylar
      When The user swip on the button with the "Add To Cart" description
    # Kullanıcı ana sayfadaki "Add To Cart" açıklamasına sahip butona kadar ekranı kaydırır
      When User clicks on the button with the "S" description
    # Kullanıcı "S" bedeni seçebileceği ilgili açıklamaya sahip butona tıklar
      When User clicks on the button with the "Add To Cart" description
    # Kullanıcı ana sayfadaki "Add To Cart" açıklamasına sahip butona tıklar
      And User click the cart button on the page
    # Kullanıcı sayfadaki alışveriş sepeti düğmesine tıklar
      When User verifies that the "Remove" button is visible and active
    # Kullanıcı, Remove düğmesinin görünür ve etkin olduğunu doğrular
      When User clicks on the button with the "Remove" description
    # Kullanıcı ana sayfadaki "Remove" açıklamasına sahip butona tıklar
      When User verifies that the "Subtotal" button is visible and active
    # Kullanıcı, Subtotal düğmesinin görünür ve etkin olduğunu doğrular
      And User confirms that the subtotal amount is "$0.00" after the deletion.
    # Kullanıcı silme işleminden sonra ara toplam tutarının "$0.00" olduğunu doğrular.
      When User verifies that the "Go to Shopping" button is visible and active
    # Kullanıcı, Go to Shopping düğmesinin görünür ve etkin olduğunu doğrular




    # When User clicks on the button with the cart button
    # Kullanıcı, sepet butonunun bulunduğu butona tıklar



