Feature: Smoke Test, temel işlevlerin doğru çalışıp çalışmadığını hızlıca kontrol etmek için yapılan bir testtir.

  @smoke
  Scenario: Kritik sorunları erken tespit etmek için kullanılır.

    * User makes driver adjustments
    # Kullanıcı emulatör için gerekli ayarlamaları yapıp kullanıma hazır hale getirir.
    * User confirms to be on the homepage
    # Kullanıcı uygulamanın doğru bir şekilde açıldığını doğrulamak için site üzerindeki logoyu doğrular.
    * User clicks the button with description "Profile"
    # Kullanıcı querycart uygulamasının alt bar'ında bulunan "Profile" butonuna basar.
    * User clicks the button with description "Sign In"
    # Kullanıcı "Sign In" butonuna basarak giriş yapma ekranına yönlendirilir.
    * As a user, I want to use the Use email instead option to log in with my email and password.
    # Kullanıcı giriş yapma ekranında bulunan Use email instead butonuna email ile giriş yapmak için tıklar
    * As a user muss be "furkanCustomerMail" mail and "customerpassword" password Login
    # Kullanıcı giriş yapma ekranında bulunan phoneTextbox'a daha önce siteye kayıt olduğu telefon numarasını ve passwordTextbox'a şifresini girer.
    * User confirms to be on the homepage
    # Kullanıcı uygulamanın doğru bir şekilde açıldığını doğrulamak için site üzerindeki logoyu doğrular.
    * User click search button
    # Ardından kullanıcı arama yapabilmek için home page'deki üst bar'da bulunan büyteç butonuna basar.
    * User types "Classic Cotton" in searchTextBox
    # Kullanıcı searchTextBox'a ürün adını girerek hem textbox'ın çalıştığını kontrol eder hemde aradığı ürünün bulunmasında yardımcı olur.
    * User waits "3" seconds
    # Kullanıcı aradığı ürünün gelmesi için 3 saniye bekler (internet problemi)
    * User "2" times click the Back Key.
    # Kullanıcı ürünü favorilere ekledikten sonra geri tuşuna 2 kez basarak arama sayfasına yeniden yönlendirilir
    * User clicks the button with description "Wishlist"
    # Kullanıcı ürünü wish liste eklemesinden sonra querycart uygulamasının alt bar'ında bulunan "Wishlist" butona tıklar
    * User waits "5" seconds
    # Kullanıcı aradığı ürünün gelmesi için 5 saniye bekler (internet problemi)
    * User selects the Classic Cotton T-Shirt product on the Wishlist page
    # Kullanıcı gösterilen favori ürünlerden Classic Cotton T-Shirt seçerek ürün sayfasına ulaşır.
    * User clicks the button with description "L"
    # Kullanıcı ona uygun olan bedeni seçer
    * User clicks the button with description "White"
    # Kullanıcı ona uygun olan rengi seçer
    * User swipe the button with description "Add To Cart"
    # Kullanıcı sepete ekleme işlemini yapmak için kaydırma işlemini yapar
    * User clicks the button with description "Add To Cart"
    # Kullanıcı kaydırma işleminden sonra Add To Cart butonuna basar
    * User clicks the Shopping Cart button
    # Kullanıcı ürünü sepete ekledikten sonra sepet butonuna basarak sepet sayfasına erişir
    * User waits "3" seconds
    # Kullanıcı aradığı ürünün gelmesi için 3 saniye bekler (internet problemi)
    * The user verifies that there are items in the shopping basket
    # Kullanıcı sepette ürün olduğunu doğrular bu sayede sepet fonksiyonun düzgün bir şekilde çalışıp çalışmadığını doğrular


  # BU testin amacı sitenin temel işlevlerinin doğru bir şekilde çalışmasını sağlamaktır, Asıl en önemlisi işlevlerden oluşan kusurun tespit edilmesidir