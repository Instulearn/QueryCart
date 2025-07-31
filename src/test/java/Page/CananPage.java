package Page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

import static utilities.Driver.getAppiumDriver;

public class CananPage {

    public CananPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }

    public static AndroidDriver driver = (AndroidDriver) getAppiumDriver();

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Profile\")")
    private WebElement profileButtonC;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Edit Profile\")")
    private WebElement editProfileButonu;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement fullNameInputC;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement mailInputC;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(2)")
    private WebElement phoneInputC;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Save Changes\")")
    private WebElement saveChangesButonu;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Logout\")")
    private WebElement logoutButonuC;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Select Payment Method\")")
    private WebElement selectPaymentMethodBasligi;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Stripe\")")
    private WebElement stripeButonu;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Confirm Order\")")
    private WebElement confirmOrderButonu;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement cardNumberInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement monthYearInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(2)")
    private WebElement CVCinput;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(3)")
    private WebElement ZIPinput;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"confirmBtn\")")
    private WebElement ConfirmB;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Go to order details\")")
    private WebElement orderDetailsButonu;

    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Delivery Status\")")
    public List<WebElement> allOrderCards;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Thank You\")")
    public WebElement thankyouText;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"canan\n" +
            "+1201444242344\n" +
            "canan@gmail.com\n" +
            "Toronto,Ontario,Canada,11111111111\n" +
            "fghjjj\")")


    private WebElement CananAdress;

    public void clickFirstAddress() {
        CananAdress.click();
    }

    public WebElement getLogoutButonu() {
        return logoutButonuC;
    }

    public void clickProfileButton() {
        profileButtonC.click();
    }

    public WebElement getEditProfileButton() {
        return editProfileButonu;
    }

    public WebElement getFullNameInput() {
        return fullNameInputC;
    }

    public WebElement getEmailInput() {
        return mailInputC;
    }

    public WebElement getPhoneInput() {
        return phoneInputC;
    }

    public void clickSaveChangesButton() {
        saveChangesButonu.click();
    }

    public void clickConfirmButonu() {
        ConfirmB.click();
    }

    public boolean isFullNameEditable() {
        return fullNameInputC.isEnabled();
    }

    public boolean isEmailEditable() {
        return mailInputC.isEnabled();
    }

    public boolean isPhoneEditable() {
        return phoneInputC.isEnabled();
    }

    public boolean isSaveChangesButtonVisibleAndEnabled() {
        return saveChangesButonu.isDisplayed() && saveChangesButonu.isEnabled();

    }

    public WebElement getSelectPaymentMethodTitle() {
        return selectPaymentMethodBasligi;
    }

    public WebElement getStripeButton() {
        return stripeButonu;
    }

    public void clickStripeButton() {
        stripeButonu.click();
    }

    public void enterCardNumber(String cardNumber) {
        cardNumberInput.clear();
        cardNumberInput.sendKeys(cardNumber);
    }

    public void enterExpiryDate(String date) {
        monthYearInput.clear();
        monthYearInput.sendKeys(date);
    }

    public void enterCVC(String cvc) {
        CVCinput.clear();
        CVCinput.sendKeys(cvc);
    }

    public void enterZIP(String zip) {
        ZIPinput.clear();
        ZIPinput.sendKeys(zip);
    }

    public boolean isConfirmOrderButtonVisibleAndEnabled() {
        return confirmOrderButonu.isDisplayed() && confirmOrderButonu.isEnabled();
    }

    public void clickConfirmOrderButton() {
        confirmOrderButonu.click();
    }

    public void clickGoToOrderDetails() {
        orderDetailsButonu.click();
    }

}
