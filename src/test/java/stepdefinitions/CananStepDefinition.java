package stepdefinitions;

import Page.CananPage;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

import static utilities.Driver.getAppiumDriver;

public class CananStepDefinition {

    CananPage page = new CananPage();

    @Given("User clicks on {string} button")
    public void user_clicks_on_button(String string) {
        page.clickProfileButton();
    }

    @Given("Verify that the {string} link is visible and active on the Dashboard page")
    public void verify_that_the_link_is_visible_and_active_on_the_dashboard_page(String string) {
        {
            Assert.assertTrue(page.getEditProfileButton().isDisplayed());
            Assert.assertTrue(page.getEditProfileButton().isEnabled());
        }
    }

    @Given("Click on the {string} link")
    public void click_on_the_link(String string) {
        page.getEditProfileButton().click();
    }

    @Given("Verify that {string}, {string}, and {string} fields are editable")
    public void verify_that_and_fields_are_editable(String fullName, String email, String phone) {
        Assert.assertTrue(page.isFullNameEditable());
        Assert.assertTrue(page.isEmailEditable());
        Assert.assertTrue(page.isPhoneEditable());
    }

    @Given("Enter new valid values into Full Name, Email, and Phone fields")
    public void enter_new_valid_values_into_full_name_email_and_phone_fields() {
        page.getFullNameInput().clear();
        page.getFullNameInput().sendKeys("canan_ozgursoy");

        page.getEmailInput().clear();
        page.getEmailInput().sendKeys("canan_ozgursoy.user@querycart.com");

        page.getPhoneInput().clear();
        page.getPhoneInput().sendKeys("65435673490");
    }

    @Given("Verify that the {string} button is visible and active")
    public void verify_that_the_button_is_visible_and_active(String string) {
        Assert.assertTrue(page.isSaveChangesButtonVisibleAndEnabled());
    }

    @Given("Click the {string} button")
    public void click_the_button(String string) {
        page.clickSaveChangesButton();
    }

    @Given("User verifies the buttonn with description {string}")
    public void user_verifies_the_buttonn_with_description(String string) {
        Assert.assertTrue(page.getLogoutButonu().isDisplayed());
    }

    @Given("User clicks the button withh description {string}")
    public void user_clicks_the_button_withh_description(String string) {
        page.getLogoutButonu().click();
    }

    @Given("Verify that the {string} title is visible")
    public void verify_that_button_is_visible(String expectedTitle) {
        Assert.assertTrue(page.getSelectPaymentMethodTitle().isDisplayed());
        Assert.assertEquals(expectedTitle, page.getSelectPaymentMethodTitle().getText());
    }

    @Given("Select {string} as the payment method")
    public void select_as_the_payment_method(String method) {
        if (method.equalsIgnoreCase("Stripe")) {
            page.clickStripeButton();
        }
    }

    @Given("Enter valid card number, expiry date,CVC and ZIP")
    public void enter_valid_card_number_expiry_date_cvc_and_zip() {
        ReusableMethods.wait(2);
        page.enterCardNumber("4242424242424242"); //BURAYI KONTROL ET
        page.enterExpiryDate("12/26");
        page.enterCVC("123");
        page.enterZIP("12345");
    }

    @Given("Click on the Confirm Order button")
    public void click_on_the_confirm_order_button() {
        page.clickConfirmOrderButton();
    }

    @Given("Click on the Confirm button")
    public void click_on_the_confirm_button() {
        page.clickConfirmButonu();
        ReusableMethods.wait(2);

    }
    @Given("Click on Go to order details")
    public void click_on_go_to_order_details() {
        WebDriverWait wait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().description(\"Go to order details\")")
        ));
        element.click();
    }

    @Given("User clicks the 1st address")
    public void user_clicks_the_1st_address() {
        page.clickFirstAddress();
    }

    @Given("Click on last order")
    public void click_on_last_order() {
       page.allOrderCards.get(0).click();
    }
    @Given("Verify that {string} text is visible")
    public void verify_that_text_is_visible(String string) {

        Assert.assertTrue(page.thankyouText.isDisplayed());
     }
}