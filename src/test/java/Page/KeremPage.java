package Page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.ReusableMethods;


import static utilities.Driver.getAppiumDriver;

@Getter
public class KeremPage {

    public KeremPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }

    public static AndroidDriver driver = (AndroidDriver) getAppiumDriver();

    // Anasayfa Locator
    @AndroidFindBy(xpath = "(//*[@class='android.widget.ImageView'])[3]")
    private WebElement homepageBirinciUrunFavoriButonu;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.ImageView'])[10]")
    private WebElement homepageIkinciUrunFavoriButonu;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.ImageView'])[2]")
    private WebElement homepageMostPopularTitle;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.ImageView'])[1]")
    private WebElement homePageQueryCartText;



    //Sing Up Page Locator'lar
    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    private WebElement signupNameTextBox;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[3]")
    private WebElement signupPasswordTextBox;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    private WebElement signupEmailTextBox;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Sign Up\").instance(1)")
    private WebElement singupButton;



    //Sing In Page Locator'lar
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Sign In\").instance(0)")
    private WebElement signinText;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Sign In\").instance(1)")
    private WebElement signinButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement signinEmailTextBox;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement signinPasswordTextBox;



    //Wishlist Locator'lar
    @AndroidFindBy(xpath = "(//*[@class='android.view.View'])[4]")
    private WebElement wishlistPageWishlistTitle;

    @AndroidFindBy(xpath = "(//*[@index='2'])[1]")
    private WebElement itemQuantityText;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(2)")
    private WebElement wishlistPageProductFavoriteButton;



    // METHODLAR
    // Descriptiona gore tiklama yapar
    public void clickByDescription (String description) {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        WebElement button = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"" + description + "\")"));
        button.click();
        ReusableMethods.wait(3);
    }

    // Her Sign Up'da yeni bir mail uretir
    public static String generateUniqueEmail() {
        return "user" + System.currentTimeMillis() + "@query.com";
    }


    // Gecerli mail ve sifre ile login olma
    public void loginWithValidCredentials (String email, String password) {
        String validMail = ConfigReader.getProperty(email);
        String validPassword = ConfigReader.getProperty(password);
        signinEmailTextBox.click();
        signinEmailTextBox.sendKeys(validMail);
        signinPasswordTextBox.click();
        signinPasswordTextBox.sendKeys(validPassword);
    }

    // Descriptiona gore gorunurluk ve aktiflik testi yapar
    public void visibleAndActiveByDescription (String description) {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        WebElement button = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"" + description + "\")"));
        Assert.assertTrue(button.isDisplayed());
        Assert.assertTrue(button.isEnabled());
        System.out.println("Kullanıcı "+description+" butonunun aktif ve gorunebilir oldugunu dogrular");
        ReusableMethods.wait(2);
    }

}









