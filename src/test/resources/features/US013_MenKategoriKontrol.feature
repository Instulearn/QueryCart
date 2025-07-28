@furkan
Feature: US013 Men Kategori Kontrolü
  Kayıtlı bir kullanici olarak ana sayfada Men menusune ait kategorileri ve urunleri gorebilmek istiyorum.

  Background:
    * User makes driver adjustments
    * User fast confirms to be on the homepage

  @furkan
  Scenario: Ana sayfa body bolumunde Men kategori penceresi ve alt kategorileri gorunur ve aktif olmalı
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * As a user, I want to use the Use email instead option to log in with my email and password.
    * As a user muss be "furkanCustomerMail" mail and "customerpassword" password Login
    * Men Category Visibility and Functionality on Homepage
    * User "1" times click the Back Key.

  @furkan
  Scenario: Men kategori sayfasındaki urunler uzerinde islemler (sepete ekleme, begenilenler listesine ekleme ve goruntuleme) yapilabilmeli.
    * User clicks the button with description "Men"
    * Taps on the first product inside the Men category
    * The user adds the first product to the cart
    * User "2" times click the Back Key.

  @furkan
  Scenario: Men Kategorisi içerisinde filtreleme ikonları gorunur ve aktif olmalı
    * User clicks the button with description "Men"
    * User checks and clicks the filter button in Men category
    * Driver turns off
