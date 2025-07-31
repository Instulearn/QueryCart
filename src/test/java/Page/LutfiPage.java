package Page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;

public class LutfiPage {
    public LutfiPage(){
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);

    }

    public static AndroidDriver driver = (AndroidDriver) getAppiumDriver();

    //US08 Locator
    //Giriş yapma zorunluluğu
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"This field is required\"])[1]")
    private WebElement requiredNameElement;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"This field is required\"])[2]")
    private WebElement requiredPhoneElement;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Passord is required\"]")
    private WebElement requiredPasswordElement;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Error\n" +
            "The phone field must be at least 7 characters.\"]")
    private WebElement wrongPhoneSignUpAlertElement;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]")
    private WebElement nameSignupTextBoxElement;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]")
    private WebElement phoneSignUpTextBoxElement;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[3]")
    private WebElement passwordSignUpTextBoxElement;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"*Use Email Instead\"]")
    private WebElement phoneToEmailButtonForSignUp;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Password is short\")")
    private WebElement wrongPasswordAlertElement;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Sign In\").instance(0)")
    private WebElement singInPageControlElement;




    public void requiredInformationSignUpTest() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertTrue(requiredNameElement.isDisplayed());
        assertTrue(requiredPhoneElement.isDisplayed());
        assertTrue(requiredPasswordElement.isDisplayed());

    }

    public void incompletePhoneNumberSignUp(String trialCorrectFirstname, String trialCorrectPassword, String incompletePhoneNumber) {

        Actions actions = new Actions(getAppiumDriver());

    }






}
