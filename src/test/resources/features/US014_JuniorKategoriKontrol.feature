@furkan
Feature: US014 Junior Kategori Kontrolü
  Kayıtlı bir kullanici olarak ana sayfada Juniors menusune ait kategorileri ve urunleri gorebilmek istiyorum.

  Background:
    * User makes driver adjustments
    * User fast confirms to be on the homepage

  @furkan
  Scenario: Ana sayfa body bolumunde Juniors kategori penceresi ve alt kategorileri goruntulenmeli.
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * As a user, I want to use the Use email instead option to log in with my email and password.
    * As a user muss be "furkanCustomerMail" mail and "customerpassword" password Login
    * "Juniors" Category Visibility and Functionality on Homepage
    * "Juniors Clothing" Category Visibility and Functionality on Homepage
    * User clicks the button with description "Juniors"
    * User "1" times click the Back Key.

  @furkan
  Scenario: Juniors kategori sayfasındaki urunler uzerinde islemler (sepete ekleme, begenilenler listesine ekleme ve goruntuleme) yapilabilmeli.
    * "Juniors" Category Visibility and Functionality on Homepage
    * User clicks the button with description "Juniors"
    * Taps on the first product inside the Juniors category
    * The user adds the first Juniors product to the cart
    * User "2" times click the Back Key.

  @furkan
  Scenario: Filtreleme ikonları gorunur ve aktif olmalı
    * "Juniors" Category Visibility and Functionality on Homepage
    * User clicks the button with description "Juniors"
    * User checks and clicks the filter button in Men category
    * Driver turns off
