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

import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }
    public static AndroidDriver driver= (AndroidDriver) getAppiumDriver();

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
}
