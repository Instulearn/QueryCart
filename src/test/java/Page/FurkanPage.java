package Page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;

public class FurkanPage {
    public FurkanPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }
    public static AndroidDriver driver= (AndroidDriver) getAppiumDriver();

    @AndroidFindBy(xpath = "(//android.widget.ImageView[1])[1]")
    private WebElement queryCardLogoElement;
    @AndroidFindBy(xpath = "(//android.widget.ImageView[1])[2]")
    private WebElement searchBoxElement;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Sign In\").instance(1)")
    private WebElement signInLoginButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"*Use Email Instead\")")
    private WebElement phonetoMailButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement phoneTextBox;
    @AndroidFindBy(accessibility = "See All")
    private WebElement seeAllIconElement;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement passwordTextBox;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(2)")
    private WebElement rememberMeCheckBox;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(4)")
    private WebElement addWishListToast;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(9)")
    private List<WebElement> categories;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\")")
    private WebElement forgotPssPhoneBox;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement newPasswordBox;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement confirmPasswordBox;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Add\n" +
            "    Added to Wishlist\"]")
    public WebElement addedWish;



    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Remove\n" + "    Removed from Wishlist\"]")
    public WebElement removedWish;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(2)")
    public WebElement whiteHeart;

    @AndroidFindBy(xpath = "(//*[@index='2'])[1]")
    public WebElement wishquant;


    public void LogoGorunurTest() {

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertTrue(queryCardLogoElement.isDisplayed());
        queryCardLogoElement.click();
    }

    public void Login(String phoneNumber, String password) {
        Actions actions = new Actions(getAppiumDriver());
        phoneTextBoxClickAndSendKeys(ConfigReader.getProperty(phoneNumber));
        // Telefon numarası alanından sonra Tab ile şifre alanına geç
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(ConfigReader.getProperty(password)).perform();
        ReusableMethods.wait(1);
        // Şifre alanından sonra Tab ile "remember me" checkbox'ına geç
        actions.sendKeys(Keys.TAB).perform();
        signInLoginClick();
    }

    public void mailLogin(String mail, String password) {
        Actions actions = new Actions(getAppiumDriver());
        phoneTextBoxClickAndSendKeys(ConfigReader.getProperty(mail));
        // Mail alanından sonra Tab ile şifre alanına geç
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(ConfigReader.getProperty(password)).perform();
        ReusableMethods.wait(1);
        // Şifre alanından sonra Tab ile "remember me" checkbox'ına geç
        actions.sendKeys(Keys.TAB).perform();
        signInLoginClick();
    }

    public void SearchBoxGorunurlukClickTest() {
        assertTrue(searchBoxElement.isDisplayed());
        searchBoxElement.click();
    }

    public void emailInsteadClick() {
        assertTrue(phonetoMailButton.isDisplayed());
        phonetoMailButton.click();
    }

    public void phoneTextBoxClickAndSendKeys(String phoneNumber) {
        assertTrue(phoneTextBox.isDisplayed());
        phoneTextBox.click();
        phoneTextBox.sendKeys(phoneNumber);
    }

    public void signInLoginClick() {
        assertTrue(signInLoginButton.isDisplayed());
        signInLoginButton.click();
    }

    public void wishListToast() {
        System.out.println(addWishListToast.getText());
        assertTrue(addWishListToast.isDisplayed());
    }

    public void ForgetPasswordPhoneBox(String phoneNumber) {
        assertTrue(forgotPssPhoneBox.isDisplayed());
        assertTrue(forgotPssPhoneBox.isEnabled());
        forgotPssPhoneBox.click();
        forgotPssPhoneBox.sendKeys(phoneNumber);

    }

    public void NewPassword(String newPassword) {
        assertTrue(newPasswordBox.isDisplayed());
        assertTrue(newPasswordBox.isEnabled());
        newPasswordBox.click();
        newPasswordBox.sendKeys(newPassword);
        assertTrue(confirmPasswordBox.isDisplayed());
        assertTrue(confirmPasswordBox.isEnabled());
        confirmPasswordBox.click();
        confirmPasswordBox.sendKeys(newPassword);

    }



    @FindBy(xpath = "(//android.view.View)[6]")
    public WebElement PageTitle;

    @FindBy(xpath = "(//android.view.View)[10]")
    public WebElement productName;

    @FindBy(xpath = "(//*[@class='android.widget.ImageView'])[3]")
    public WebElement removepopup;




    @AndroidFindBy(id = "com.android.chrome:id/search_box_text")
    private WebElement googleSearchBox;

    @AndroidFindBy(id = "com.android.chrome:id/line_2")
    private WebElement googleSearchClick;

    // QueryCart url Locateleri

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Log In\"]")
    private WebElement queryCardUrlLogin;

    @AndroidFindBy(uiAutomator = ("new UiSelector().resourceId(\"formEmail\")"))
    private WebElement qcUrlEmailTextBox;

    @AndroidFindBy(uiAutomator = ("new UiSelector().resourceId(\"formPassword\")"))
    private WebElement qcUrlPasswordTextBox;

    @AndroidFindBy(xpath = ("//android.widget.Button[@text=\"Sign In\"]"))
    private WebElement qcUrlSigninButton;

    public void googleSearchToQueryCart(){

        ReusableMethods.wait(6);
        // assertTrue(googleSearchBox.isEnabled());
        googleSearchBox.sendKeys("querycart.com/#/home");


        assertTrue(googleSearchClick.isEnabled());
        googleSearchClick.click();

    }

    public void signInFromUrl(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(queryCardUrlLogin));

        assertTrue(queryCardUrlLogin.isEnabled());
        queryCardUrlLogin.click();
        ReusableMethods.wait(2);

        assertTrue(qcUrlEmailTextBox.isEnabled());
        qcUrlEmailTextBox.click();
        qcUrlEmailTextBox.sendKeys("elifkesen.manager@querycart.com");

        assertTrue(qcUrlPasswordTextBox.isEnabled());
        qcUrlPasswordTextBox.click();
        qcUrlPasswordTextBox.sendKeys("Query.05042025");

        // assertTrue(qcUrlSigninButton.isEnabled());
        // qcUrlSigninButton.click();
    }
//android.view.View[@content-desc="*Use Email Instead"]
}
