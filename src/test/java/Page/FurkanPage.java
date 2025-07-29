package Page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.ReusableMethods;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;
import static utilities.OptionsMet.KeyBack;

public class FurkanPage {
    public FurkanPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }
    public static AndroidDriver driver = (AndroidDriver) getAppiumDriver();


    //TODO ---------------------------------------------
    // BU BÖLÜM USER STORYLERE GÖRE LOCATOR İÇERMEKTEDİR
    // -------------------------------------------------

    //Genel Locator
    @AndroidFindBy(xpath = "(//android.widget.ImageView[1])[1]")
    private WebElement queryCardLogoElement;

    //US08
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ImageView")
    private WebElement rememberMeCheckBox;

    //US12
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Flower Print Foil T-shirt\n" + "0 (0  Reviews)\n" + "$65.00\")")
    private WebElement firstProductInHomePage;

    //US13
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Men\")")
    private WebElement menCategoryButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Men Clothing\")")
    private WebElement menClothingCategoryButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Adidas 3-Stripes Cushioned Crew Socks\n" + "0 (0  Reviews)\n" + "$15.00\"]")
    private WebElement firstProductInMenCategory;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Adidas 3-Stripes Cushioned Crew Socks\n" + "0 (0  Reviews)\n" + "$15.00\"]/android.widget.ImageView")
    private WebElement firstProductWhistlistButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Black\")")
    private WebElement firstProductPageBlackColorButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Add To Cart']")
    private WebElement addToCartButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(2)")
    private WebElement filterButton;

    //US14
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"(5-6 Years) Disney Mickey Mouse Pyjamas Boys T-shirt Shorts Set\n" + "0 (0  Reviews)\n" + "$15.00\")")
    private WebElement firstProductInJuniorsCategory;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(3)")
    private WebElement firstProductinJuniorsWhistlistButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Blue\")")
    private WebElement firstProductPageBlueColorButton;

    //US19
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(12)")
    private WebElement sepetButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Proceed to Checkout\")")
    private WebElement proceedToCheckout;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Delivery\")")
    private WebElement deliveryButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Pick Up\")")
    private WebElement pickUpButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Edit\")")
    private WebElement editButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Add\")")
    private WebElement addButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Order Summary\")")
    private WebElement orderSummaryButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement fullNameBox;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement eMailBox;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"+1201\")")
    private WebElement firstPhoneSelect;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(2)")
    private WebElement phoneBox;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Country\")")
    private WebElement countryButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\")")
    private WebElement countrySelectBox;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Turkey\")")
    private WebElement TurkeySelect;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"State\")")
    private WebElement stateButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"İzmir Province\")")
    private WebElement izmirButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"City\")")
    private WebElement cityButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Karşıyaka İlçesi\")")
    private WebElement kskButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(3)")
    private WebElement zipCode;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(4)")
    private WebElement streetAdress;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Add Address\")")
    private WebElement addAdressButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Furkan Detseli\n" + "+120105511967884\n" + "adres@furkan.com\n" + "Karşıyakaİlçesi,İzmirProvince,Turkey,35560\n" + "Cumhuriyet Mahallesi/Karşıyaka/İzmir\").instance(0)")
    private WebElement address;

    //TODO ---------------------------------------------
    // BU BÖLÜMDEN SONRASI FONKSİYONLAR İÇERMEKTEDİR
    // -------------------------------------------------


    // Genel Fonksiyonlar
    public void scrollDown() {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        try {
            int screenWidth = driver.manage().window().getSize().getWidth();
            int screenHeight = driver.manage().window().getSize().getHeight();
            int left = screenWidth / 4;
            int top = screenHeight / 4;
            int width = screenWidth / 2;
            int height = screenHeight / 2;

            java.util.Map<String, Object> params = new java.util.HashMap<>();
            params.put("left", left);
            params.put("top", top);
            params.put("width", width);
            params.put("height", height);
            params.put("direction", "down");
            params.put("percent", 0.7);
            driver.executeScript("mobile: scrollGesture", params);
        } catch (Exception e) {
            System.out.println("Yeni scrollDown fonksiyonu hata: " + e.getMessage());
        }
    }

    public void checkButtonByDescription(String description) {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        try {
            WebElement button = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"" + description + "\")"));

            assertTrue(description + " butonu görünür değil!", button.isDisplayed());
            System.out.println(description + " butonu görünür!");
        } catch (Exception e) {
            System.out.println(description + " butonu görünür değil: " + e.getMessage());
            throw e;
        }
    }

    public void swipeButtonByDescription(String description) {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        int maxScroll = 10;
        int count = 0;
        while (count < maxScroll) {
            try {
                WebElement button = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"" + description + "\")"));
                if (button.isDisplayed()) {
                    System.out.println(button +" bulundu!");
                    break;
                }
            } catch (Exception e) {
                // Buton görünmüyorsa scroll yap
                scrollDown();
                count++;
            }
        }
        if (count == maxScroll) {
            throw new RuntimeException("Add To Cart butonu bulunamadı!");
        }
    }

    public void swipeHorizontalButtonByDescription(String description) {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        int maxScroll = 20;
        int count = 0;
        while (count < maxScroll) {
            try {
                WebElement button = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"" + description + "\")"));
                if (button.isDisplayed()) {
                    System.out.println(button +" bulundu!");
                    break;
                }
            } catch (Exception e) {
                // Buton görünmüyorsa yatay scroll yap
                swipeHorizontal();
                count++;
            }
        }
        if (count == maxScroll) {
            throw new RuntimeException(description + " butonu bulunamadı!");
        }
    }

    public void swipeHorizontal() {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        try {
            int screenWidth = driver.manage().window().getSize().getWidth();
            
            // Y koordinatı 1300 olarak sabit, X koordinatları sol taraftan başlayarak
            int left = (int) (screenWidth * 0.2);
            int top = 1300;
            int width = (int) (screenWidth * 0.6);
            int height = 100;

            java.util.Map<String, Object> params = new java.util.HashMap<>();
            params.put("left", left);
            params.put("top", top);
            params.put("width", width);
            params.put("height", height);
            params.put("direction", "right");
            params.put("percent", 0.8);
            driver.executeScript("mobile: scrollGesture", params);
        } catch (Exception e) {
            System.out.println("Yatay swipe fonksiyonu hata: " + e.getMessage());
        }
    }

    public void backfonksiyon(String sayi) {
        int clickCount = Integer.parseInt(sayi);
        for (int i = 0; i < clickCount; i++) {
            KeyBack();
            ReusableMethods.wait(1); // Her geri tuşu arasında 1 saniye bekle
        }
    }

    public void LogoGorunurTest() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertTrue(queryCardLogoElement.isDisplayed());
        queryCardLogoElement.click();
    }

    //US08 Fonksiyonlar
    public void tapcheckbox() {
        try {
            assertTrue("Remember Me Checkbox görünür değil!", rememberMeCheckBox.isDisplayed());
            System.out.println("Remember Me Checkbox görünür!");
            rememberMeCheckBox.click();
        } catch (Exception e) {
            System.out.println("Remember Me Checkbox görünür değil: " + e.getMessage());
            throw e;
        }
    }

    //US12 Fonksiyonlar
    public void testfirstproductinhomepage() {
        try {
            assertTrue("Ürün görünür değil!", firstProductInHomePage.isDisplayed());
            System.out.println("Ürün görünür!");
            firstProductInHomePage.click();
        }catch (Exception e) {
            System.out.println("Ürün görünür değil: " + e.getMessage());
            throw e;
        }
    }

    //US13 Fonksiyonlar
    public void scrollToAddToCartButton() {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        int maxScroll = 10;
        int count = 0;
        while (count < maxScroll) {
            try {
                if (addToCartButton.isDisplayed()) {
                    System.out.println("Add To Cart butonu bulundu!");
                    break;
                }
            } catch (Exception e) {
                // Buton görünmüyorsa scroll yap
                scrollDown();
                count++;
            }
        }
        if (count == maxScroll) {
            throw new RuntimeException("Add To Cart butonu bulunamadı!");
        }
    }

    public void verifyMenAndMenClothingVisible() {
        try {
            assertTrue("Men kategorisi görünür değil!", menCategoryButton.isDisplayed());
            System.out.println("Men kategorisi görünür!");
            assertTrue("Men Clothing kategorisi görünür değil!", menClothingCategoryButton.isDisplayed());
            System.out.println("Men Clothing kategorisi görünür!");
        } catch (Exception e) {
            System.out.println("Men veya Men Clothing kategorisi görünür değil: " + e.getMessage());
            throw e;
        }
    }

    public void testMenAndMenClothingClickableAndActive() {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        try {
            // Men kategorisine tıkla
            menCategoryButton.click();
            System.out.println("Men kategorisine tıklandı!");
            ReusableMethods.wait(1);
            // Burada yeni sekmeye girildiğini kontrol edebilirsin (ör: başlık, ürün vs.)
            driver.navigate().back();
            System.out.println("Men kategorisinden geri çıkıldı!");
            ReusableMethods.wait(1);

            // Men Clothing kategorisine tıkla
            menClothingCategoryButton.click();
            System.out.println("Men Clothing kategorisine tıklandı!");
            ReusableMethods.wait(1);
            // Burada yeni sekmeye girildiğini kontrol edebilirsin (ör: başlık, ürün vs.)
            driver.navigate().back();
            System.out.println("Men Clothing kategorisinden geri çıkıldı!");
            ReusableMethods.wait(1);
        } catch (Exception e) {
            System.out.println("Men veya Men Clothing kategorisine tıklanamadı/aktiflik test edilemedi: " + e.getMessage());
            throw e;
        }

    }

    public void testFirstProductInMenCategory(){
        try {
            assertTrue("Ürün görünür değil!", firstProductInMenCategory.isDisplayed());
            System.out.println("Ürün görünür!");
            try {
                assertTrue("İstek Listesi görünür değil!", firstProductWhistlistButton.isDisplayed());
                System.out.println("İstek Listesi görünür!");
                firstProductWhistlistButton.click();
                System.out.println("İstek listesi butonuna tıklandı!");
                ReusableMethods.wait(1);
                firstProductWhistlistButton.click();
                System.out.println("İstek listesinden kaldırıldı!");
                firstProductInMenCategory.click();
                System.out.println("İlk Ürüne Tıklandı!");
            }catch (Exception e) {
                System.out.println("İstek Listesi görünür değil: " + e.getMessage());
                throw e;
            }
        } catch (Exception e) {
            System.out.println("Ürün görünür değil: " + e.getMessage());
            throw e;
        }

    }

    public void testFirstProductAddToCart(){
        try {
            assertTrue("Renk seçeneği görünür değil!", firstProductPageBlackColorButton.isDisplayed());
            System.out.println("Renk seçeneği görünür!");
            firstProductPageBlackColorButton.click();
            scrollToAddToCartButton();
            addToCartButton.click();
            System.out.println("Başarıyla sepete eklendi!");
        }catch (Exception e) {
            System.out.println("Renk seçeneği görünür değil: " + e.getMessage());
            throw e;
        }
    }

    public void verifyAndClickFilterButton() {
        try {
            assertTrue("Filtre butonu görünür değil!", filterButton.isDisplayed());
            assertTrue("Filtre butonu tıklanabilir değil!", filterButton.isEnabled());
            System.out.println("Filtre butonu görünür ve tıklanabilir!");
            filterButton.click();
            System.out.println("Filtre butonuna tıklandı!");
            // İsteğe bağlı: Filtre ekranı açıldı mı kontrolü eklenebilir
        } catch (Exception e) {
            System.out.println("Filtre butonu kontrol/tıklama hatası: " + e.getMessage());
            throw e;
        }
    }

    //US14 Fonksiyonlar
    public void testFirstProductInJuniorsCategory(){
        try {
            assertTrue("Ürün görünür değil!", firstProductInJuniorsCategory.isDisplayed());
            System.out.println("Ürün görünür!");
            try {
                assertTrue("İstek Listesi görünür değil!", firstProductinJuniorsWhistlistButton.isDisplayed());
                System.out.println("İstek Listesi görünür!");
                firstProductinJuniorsWhistlistButton.click();
                System.out.println("İstek listesi butonuna tıklandı!");
                ReusableMethods.wait(2);
                firstProductinJuniorsWhistlistButton.click();
                System.out.println("İstek listesinden kaldırıldı!");
                firstProductInJuniorsCategory.click();
                System.out.println("İlk Ürüne Tıklandı!");
            }catch (Exception e) {
                System.out.println("İstek Listesi görünür değil: " + e.getMessage());
                throw e;
            }
        } catch (Exception e) {
            System.out.println("Ürün görünür değil: " + e.getMessage());
            throw e;
        }

    }

    public void testFirstProductInJuniorsAddToCart(){
        try {
            assertTrue("Renk seçeneği görünür değil!", firstProductPageBlueColorButton.isDisplayed());
            System.out.println("Renk seçeneği görünür!");
            firstProductPageBlueColorButton.click();
            scrollToAddToCartButton();
            addToCartButton.click();
            System.out.println("Başarıyla sepete eklendi!");
        }catch (Exception e) {
            System.out.println("Renk seçeneği görünür değil: " + e.getMessage());
            throw e;
        }
    }

    //US19
    public void clickShoppingCart(){
        sepetButton.click();
    }

    public void createAdress() throws InterruptedException {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();

        fullNameBox.click();
        fullNameBox.sendKeys("Furkan Detseli");
        System.out.println("isim eklendi");
        eMailBox.click();
        eMailBox.sendKeys("adres@furkan.com");
        System.out.println("email eklendi");
        phoneBox.click();
        phoneBox.sendKeys("05511967884");
        System.out.println("numara eklendi");
        countryButton.click();
        countrySelectBox.click();
        countrySelectBox.sendKeys("Turkey");
        TurkeySelect.click();
        ReusableMethods.wait(1);
        stateButton.click();
        countrySelectBox.click();
        countrySelectBox.sendKeys("izmir");
        izmirButton.click();
        ReusableMethods.wait(1);
        cityButton.click();
        countrySelectBox.click();
        countrySelectBox.sendKeys("kar");
        kskButton.click();
        ReusableMethods.wait(1);
        zipCode.click();
        zipCode.sendKeys("35560");
        driver.hideKeyboard();
        swipeButtonByDescription("Add Address");
        streetAdress.click();
        zipCode.sendKeys("Cumhuriyet Mahallesi/Karşıyaka/İzmir");
        System.out.println("adres eklendi");
        driver.hideKeyboard();
        addAdressButton.click();
    }

    public void addressClick(){
        address.click();
    }
}
