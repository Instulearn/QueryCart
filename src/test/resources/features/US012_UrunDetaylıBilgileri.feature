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

  @furkan
  Scenario: Details butonuna tıklandıgında Product Details baslıgı ve urune ait bilgiler goruntulenmeli
    * User verifies and click the first product in homepage.

  @furkan
  Scenario: Videos butonuna tıklandıgında Product Videos baslıgı ve urune ait videolar goruntulenmeli
    * User verifies and click the first product in homepage.

  @furkan
  Scenario: Review butonuna tıklandıgında Review baslıgı ve urune ait degerlendirmeler goruntulenmeli
    * User verifies and click the first product in homepage.

  @furkan
  Scenario: Shipping&Return butonuna tıklandıgında Shipping&Return baslıgı ve urune ait kargo ve iade kosulları goruntulenmeli
    * User verifies and click the first product in homepage.

