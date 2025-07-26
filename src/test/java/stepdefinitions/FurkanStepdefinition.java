package stepdefinitions;

import Page.FurkanPage;
import Page.LoginPage;
import Page.QueryCardPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import utilities.OptionsMet;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;

public class FurkanStepdefinition extends OptionsMet {

    FurkanPage furkancard = new FurkanPage();

    //Genel
    @Given("User verifies the button with description {string}")
    public void verify_button_visible_on_screen(String description) {
        ReusableMethods.wait(5);
        furkancard.checkButtonByDescription(description);
    }

    //US08
    @When("The user taps the \"Remember me\" checkbox")
    public void tap_remember_me_checkbox(){
        furkancard.tapcheckbox();
    }

    //US12
    @When("User verifies and click the first product in homepage.")
    public void first_product_in_homepage(){
        furkancard.testfirstproductinhomepage();
    }

    //US13
    @When("Men Category Visibility and Functionality on Homepage")
    public void homepage_men_category_display(){
        ReusableMethods.wait(1); // Sayfanın yüklenmesini bekle
        furkancard.verifyMenAndMenClothingVisible();
        furkancard.testMenAndMenClothingClickableAndActive();
    }
    @When("Taps on the first product inside the Men category")
    public void tap_first_product_in_men_category(){
        ReusableMethods.wait(1); // Sayfanın yüklenmesini bekle
        furkancard.testFirstProductInMenCategory();
    }
    @When("The user adds the first product to the cart")
    public void add_first_product_to_cart(){
        furkancard.testFirstProductAddToCart();
    }

    @When("User checks and clicks the filter button in Men category")
    public void user_checks_and_clicks_filter_button() {
        furkancard.verifyAndClickFilterButton();
    }

} 