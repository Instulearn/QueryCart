@furkan
Feature: US012 Urun Detaylı Bilgileri
  Bir kullanıcı olarak sayfada sectigim urun ile ilgili detaylı bilgilere ulasabilmek istiyorum

  Background:
    * User makes driver adjustments
    * User fast confirms to be on the homepage

  @furkan
  Scenario: Anasayfadan secilen urun sayfasına gecilebilmeli
    * User verifies and click the first product in homepage.
    * User "1" times click the Back Key.

  @furkan
  Scenario: Urun sayfasına gecildiginde Details,Videos,Review,Shipping&Return baslıkları görünür ve aktif olmalı
    * User verifies and click the first product in homepage.
    * User swipe the button with description "Details"
    * User verifies the button with description "Details"
    * User verifies the button with description "Videos"
    * User verifies the button with description "Review"
    * User verifies the button with description "Shipping & Return"
    * User "1" times click the Back Key.

  @furkan
  Scenario: Details butonuna tıklandıgında Product Details baslıgı ve urune ait bilgiler goruntulenmeli
    * User verifies and click the first product in homepage.
    * User swipe the button with description "Details"
    * User clicks the button with description "Details"
    * User verifies the button with description "Product Details"
    * User "1" times click the Back Key.

  @furkan
  Scenario: Videos butonuna tıklandıgında Product Videos baslıgı ve urune ait videolar goruntulenmeli
    * User verifies and click the first product in homepage.
    * User swipe the button with description "Videos"
    * User clicks the button with description "Videos"
    * User verifies the button with description "Product Videos"
    * User "1" times click the Back Key.

  @furkan
  Scenario: Review butonuna tıklandıgında Review baslıgı ve urune ait degerlendirmeler goruntulenmeli
    * User verifies and click the first product in homepage.
    * User swipe the button with description "Review"
    * User clicks the button with description "Review"
    * User verifies the button with description "Product Reviews"
    * User "1" times click the Back Key.

  @furkan
  Scenario: Shipping&Return butonuna tıklandıgında Shipping&Return baslıgı ve urune ait kargo ve iade kosulları goruntulenmeli
    * User verifies and click the first product in homepage.
    * User swipe the button with description "Shipping & Return"
    * User clicks the button with description "Shipping & Return"
    * User verifies the button with description "Shipping & Return"
    * Driver turns off


