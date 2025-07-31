package stepdefinitions;

import Page.FurkanPage;
import Page.LutfiPage;
import io.cucumber.java.en.Given;
import utilities.OptionsMet;

public class LutfiStepDefinition extends OptionsMet {

    LutfiPage lutficard = new LutfiPage();

    @Given("User is warned that the firstname, phone and password fields cannot be left blank")
    public void user_is_warned_that_the_firstname_phone_and_password_fields_cannot_be_left_blank() {
        lutficard.requiredInformationSignUpTest();

    }

    @Given("User enters {string} and {string} , but their {string} is incomplete.")
    public void user_enters_and_but_their_is_incomplete(String trialCorrectFirstname, String trialCorrectPassword, String incompletePhoneNumber) {

    }
    @Given("The user is warned with an error message.")
    public void the_user_is_warned_with_an_error_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("User want to use email to sign up.")
    public void user_want_to_use_email_to_sign_up() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("When a valid e-mail address is entered, an incorrect e-mail address warning should not appear")
    public void when_a_valid_e_mail_address_is_entered_an_incorrect_e_mail_address_warning_should_not_appear() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("User enters {int} digits password without password digit alert")
    public void user_enters_digits_password_without_password_digit_alert(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("User validate the page is Sign In Page.")
    public void user_validate_the_page_is_sign_ın_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    //US 015
    @Given("Women Category Visibility and Functionality on Homepage")
    public void women_category_visibility_and_functionality_on_homepage() {


    }

    @Given("Taps on the first product inside the Women category")
    public void taps_on_the_first_product_inside_the_women_category() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("User checks and clicks the filter button in Women category")
    public void user_checks_and_clicks_the_filter_button_in_women_category() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }





}
