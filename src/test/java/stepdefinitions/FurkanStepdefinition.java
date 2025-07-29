package stepdefinitions;

import Page.FurkanPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.OptionsMet;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class FurkanStepdefinition extends OptionsMet {

    FurkanPage furkancard = new FurkanPage();

    //Genel
    @Given("User verifies the button with description {string}")
    public void verify_button_visible_on_screen(String description) {
        ReusableMethods.wait(1);
        furkancard.checkButtonByDescription(description);
    }

    @Given("User swipe the button with description {string}")
    public void swipe_button_visible_on_screen(String description) {
        ReusableMethods.wait(1);
        furkancard.swipeButtonByDescription(description);
    }

    @Given("User {string} times click the Back Key.")
    public void user_click_the_back_key(String sayi) {
        furkancard.backfonksiyon(sayi);
    }

    @Given("User fast confirms to be on the homepage")
    public void user_confirms_to_be_on_the_homepage() {
        furkancard.LogoGorunurTest();
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

    //US14
    @When("{string} Category Visibility and Functionality on Homepage")
    public void user_checks_and_clicks_filter_button_in_junior(String button) {
        furkancard.swipeHorizontalButtonByDescription(button);
    }
    @When("Taps on the first product inside the Juniors category")
    public void tap_first_product_in_juniors_category(){
        ReusableMethods.wait(1); // Sayfanın yüklenmesini bekle
        furkancard.testFirstProductInJuniorsCategory();
    }
    @When("The user adds the first Juniors product to the cart")
    public void add_first_juniors_product_to_cart(){
        furkancard.testFirstProductInJuniorsAddToCart();
    }

    //US19
    @When("User clicks the Shopping Cart button")
    public void user_click_the_shopping_cart_button() {
        furkancard.clickShoppingCart();
    }
    @When("User create an address")
    public void user_create_an_adress() throws InterruptedException {
        furkancard.createAdress();
    }
    @When("User clicks the first address")
    public void address_click() throws InterruptedException {
        furkancard.addressClick();
    }
} 