
  Feature: As a registered user, I would like to be able to see the categories and products of the Women menu on the home page.

    Background: User opens the app
      Given User makes driver adjustments

      @wip
    Scenario: Women category window and subcategories should be displayed in the body section of the home page.
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
      And User sees categories title on home page
    # Kullanıcı ana sayfada kategoriler başlığını görür
      Then Women Category Visibility and Functionality on Homepage
      When User verifies that the "Women" button is visible and active
    # Kullanıcı, Women düğmesinin görünür ve etkin olduğunu doğrular
      When User verifies that the "Women Clothing" button is visible and active
    # Kullanıcı, Women Clothing düğmesinin görünür ve etkin olduğunu doğrular
      When User verifies that the "Woman Dresses - Skirts" button is visible and active
    # Kullanıcı, Woman Dresses - Skirts düğmesinin görünür ve etkin olduğunu doğrular
      And User clicks on the button with the "Women" description
    # Kullanıcı "Giriş Yap" açıklamasına sahip butona tıklar
      And User verifies that the Filter button is displayed and active
    # Kullanıcı Filtre butonunu görüntülendiğini ve aktif olduğunu doğrular
      Then User on the Women page, sees the second product itself and the favorite button
    # Kadın sayfasındaki kullanıcı, ikinci ürünün kendisini ve favori düğmesini görür
      Then User clicks on the Filter button
    # Kullanıcı Filtre butonuna tıklar
      When User verifies that the "Sort By" button is visible and active
    # Kullanıcı, Sort By düğmesinin görünür ve etkin olduğunu doğrular
      When User verifies that the "Brands" button is visible and active
    # Kullanıcı, Brands düğmesinin görünür ve etkin olduğunu doğrular
      When User verifies that the "size" button is visible and active
    # Kullanıcı, size düğmesinin görünür ve etkin olduğunu doğrular
      When User verifies that the "color" button is visible and active
    # Kullanıcı, color düğmesinin görünür ve etkin olduğunu doğrular
      And The user returns to the previous page
    # Kullanıcı bir önceki sayfaya döner
      And User clicks on second product to add to cart
    # Kullanıcı sepete eklemek için 2. ürüne tıklar
      When The user swip on the button with the "Add To Cart" description
    # Kullanıcı ana sayfadaki "Add To Cart" açıklamasına sahip butona kadar ekranı kaydırır
      And The user scrolls the screen slightly up
    # Kullanıcı ekranı biraz yukarı kaydırır
      When User clicks on the button with the "Blue" description
    # Kullanıcı "Blue" rengi seçebileceği ilgili açıklamaya sahip butona tıklar
      When User clicks on the button with the "Add To Cart" description
    # Kullanıcı ana sayfadaki "Add To Cart" açıklamasına sahip butona tıklar
      And User click the cart button on the page
    # Kullanıcı sayfadaki alışveriş sepeti düğmesine tıklar
      And User confirms that the subtotal amount is "$120.00" after the deletion.
    # Kullanıcı silme işleminden sonra ara toplam tutarının "$0.00" olduğunu doğrular.