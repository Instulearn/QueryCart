@furkan
Feature: US012 Urun Detaylı Bilgileri
  Bir kullanıcı olarak sayfada sectigim urun ile ilgili detaylı bilgilere ulasabilmek istiyorum

  Background:
    * User makes driver adjustments
    * User confirms to be on the homepage

  @furkan
  Scenario: Anasayfadan secilen urun sayfasına gecilebilmeli
    * User verifies and click the first product in homepage.

  @furkan
  Scenario: Urun sayfasına gecildiginde Details,Videos,Review,Shipping&Return baslıkları görünür ve aktif olmalı
    * User verifies and click the first product in homepage.
    * User swipe the button with description "Details"
    * User verifies the button with description "Details"
    * User verifies the button with description "Videos"
    * User verifies the button with description "Review"
    * User verifies the button with description "Shipping & Return"

  @furkan
  Scenario: Details butonuna tıklandıgında Product Details baslıgı ve urune ait bilgiler goruntulenmeli
    * User verifies and click the first product in homepage.
    * User swipe the button with description "Details"
    * User clicks the button with description "Details"
    * User verifies the button with description "Product Details"

  @furkan
  Scenario: Videos butonuna tıklandıgında Product Videos baslıgı ve urune ait videolar goruntulenmeli
    * User verifies and click the first product in homepage.
    * User swipe the button with description "Videos"
    * User clicks the button with description "Videos"
    * User verifies the button with description "Product Videos"

  @furkan
  Scenario: Review butonuna tıklandıgında Review baslıgı ve urune ait degerlendirmeler goruntulenmeli
    * User verifies and click the first product in homepage.
    * User swipe the button with description "Review"
    * User clicks the button with description "Review"
    * User verifies the button with description "Product Reviews"

  @furkan
  Scenario: Shipping&Return butonuna tıklandıgında Shipping&Return baslıgı ve urune ait kargo ve iade kosulları goruntulenmeli
    * User verifies and click the first product in homepage.
    * User swipe the button with description "Shipping & Return"
    * User clicks the button with description "Shipping & Return"
    * User verifies the button with description "Shipping & Return"


