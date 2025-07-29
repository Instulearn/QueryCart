package stepdefinitions;

import Page.KeremPage;
import io.cucumber.java.en.*;
import jdk.jfr.Registered;
import lombok.Getter;
import org.junit.Assert;
import utilities.OptionsMet;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;



public class US023_26_27Stepdefinitions extends OptionsMet {
    KeremPage keremPage = new KeremPage();

    String registeredEmail;
    String registeredPassword;

    // US023.1
    @Then("Then The {string} header should be visible on the page")
    public void then_the_header_should_be_visible_on_the_page(String title) {
        assertTrue(keremPage.getHomepageMostPopularTitle().isDisplayed());
    }

    @Then("Each product has a favorite heart icon on the top right corner")
    public void each_product_has_a_favorite_heart_icon_on_the_top_right_corner() {
        ReusableMethods.wait(4);
        assertTrue(keremPage.getHomepageBirinciUrunFavoriButonu().isDisplayed());
        assertTrue(keremPage.getHomepageIkinciUrunFavoriButonu().isDisplayed());
    }

    @Then("Favorite icons must be clickable")
    public void favorite_icons_must_be_clickable() {
        ReusableMethods.wait(4);
        assertTrue(keremPage.getHomepageBirinciUrunFavoriButonu().isEnabled());
        assertTrue(keremPage.getHomepageIkinciUrunFavoriButonu().isEnabled());
    }


    // US023.2
    @When("User clicks on the button with the {string} description")
    public void user_clicks_on_the_button_with_the_description(String description) {
        ReusableMethods.wait(2);
        keremPage.clickByDescription(description);
    }

    @When("User enters {string} into the name field")
    public void user_enters_into_the_name_field(String name) {
        ReusableMethods.wait(2);
        keremPage.getSignupNameTextBox().click();
        keremPage.getSignupNameTextBox().sendKeys(name);
    }

    @Then("User should be redirected to the Sign In page")
    public void user_should_be_redirected_to_the_sign_ın_page() {
        ReusableMethods.wait(3);
        assertTrue(keremPage.getSigninText().isDisplayed());
    }

    @Then("User should be redirected to the homepage")
    public void user_should_be_redirected_to_the_homepage() {
        ReusableMethods.wait(3);
        assertTrue(keremPage.getHomePageQueryCartText().isDisplayed());
    }

    @When("The user enters {string} into the e-mail box.")
    public void the_user_enters_into_the_e_mail_box(String email) {
        ReusableMethods.wait(1);
        keremPage.getSignupEmailTextBox().click();
        keremPage.getSignupEmailTextBox().sendKeys(email);
        registeredEmail = email;
    }

    @When("The user enters {string} into the password box.")
    public void the_user_enters_into_the_password_box(String password) {
        ReusableMethods.wait(1);
        keremPage.getSignupPasswordTextBox().click();
        keremPage.getSignupPasswordTextBox().sendKeys(password);
        registeredPassword = password;
    }

    @When("User enters the same email and password used during registration")
    public void user_enters_the_same_phone_number_and_password_used_during_registration() {
        ReusableMethods.wait(2);
        keremPage.getSigninEmailTextBox().click();
        keremPage.getSigninEmailTextBox().sendKeys(registeredEmail);
        ReusableMethods.wait(1);
        keremPage.getSigninPasswordTextBox().click();
        keremPage.getSigninPasswordTextBox().sendKeys(registeredPassword);
    }

    @When("User clicks on the {string} button")
    public void user_clicks_on_the_button(String button) {
        ReusableMethods.wait(1);
        keremPage.getSigninButton().click();
    }

    @When("User clicks the {string} button")
    public void user_clicks_the_button(String button) {
        ReusableMethods.wait(1);
        keremPage.getSingupButton().click();

    }




}
