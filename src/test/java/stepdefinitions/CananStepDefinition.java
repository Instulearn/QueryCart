package stepdefinitions;

import Page.CananPage;
import io.cucumber.java.en.Given;
import org.junit.Assert;

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
        page.enterCardNumber("424242424242"); //BURAYI KONTROL ET
        page.enterExpiryDate("12/26");
        page.enterCVC("123");
        page.enterZIP("12345");
    }
    @Given("Verify that the Confirm Order button is visible and active")
    public void verify_that_the_confirm_order_button_is_visible_and_active() {
        Assert.assertTrue(page.isConfirmOrderButtonVisibleAndEnabled());
    }
        @Given("Click on the {string} button")
        public void click_on_the_button(String string) {
           page.clickConfirmOrderButton();
        }
    @Given("Click on Go to order details")
    public void click_on_go_to_order_details() {
        page.clickGoToOrderDetails();

    }
    @Given("Verify that Download Receipt button is visible")
    public void verify_that_download_receipt_button_is_visible() {
        Assert.assertTrue("Download Receipt button görünmüyor!", page.isDownloadReceiptVisible());
    }
    @Given("Click on Download Receipt")
    public void click_on_download_receipt() {
        page.clickDownloadReceipt();

    }
    @Given("Verify that Print Invoice button is visible")
    public void verify_that_print_invoice_button_is_visible() {
        Assert.assertTrue("Print Invoice button görünmüyor!", page.isPrintInvoiceVisible());

    }
    @Given("User clicks the 1st address")
    public void user_clicks_the_1st_address() {
        page.clickFirstAddress();
    }

}