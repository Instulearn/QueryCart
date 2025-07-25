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

public class FurkanPage {
    public FurkanPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }
    public static AndroidDriver driver = (AndroidDriver) getAppiumDriver();

    //TODO ---------------------------------------------
    // BU BÖLÜM USER STORYLERE GÖRE LOCATOR İÇERMEKTEDİR
    // -------------------------------------------------

    //US08
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ImageView")
    private WebElement rememberMeCheckBox;

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

    //TODO ---------------------------------------------
    // BU BÖLÜMDEN SONRASI FONKSİYONLAR İÇERMEKTEDİR
    // -------------------------------------------------

    // Genel Fonksiyonlar
    public void scrollDown() {
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


    //US13 Fonksiyonlar
    public void scrollToAddToCartButton() {
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
                ReusableMethods.wait(2);
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


}
