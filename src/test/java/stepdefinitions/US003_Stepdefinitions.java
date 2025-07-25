package stepdefinitions;

import Page.QueryCardPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.OptionsMet;
import utilities.ReusableMethods;
import java.util.List;

import static Page.QueryCardPage.driver;
import static utilities.Driver.getAppiumDriver;

public class US003_Stepdefinitions extends OptionsMet {

    QueryCardPage card = new QueryCardPage();
    Actions actions = new Actions(getAppiumDriver());


    static String categoryName;
    static String popularBrandName;
    static String productName;

    @Given("the app is launched")
    public void launchApp() {
        card.LogoGorunurTest();
    }

    @Given("I am not logged in")
    public void ensureGuestUser() {
        // Check login state or skip login screen
        ReusableMethods.wait(3);
        clickButtonByDescription("Profile");
        Assert.assertTrue(card.getSignInLoginButton().isDisplayed());
    }

    @When("I navigate to the homepage")
    public void navigateToHomepage() {
        VerifyElementText("Home");
        clickButtonByDescription("Home");
    }

    @Then("I should see a list of products with name, image, price, and features")
    public void verifyProductList() {
        ReusableMethods.wait(3);
       // ReusableMethods.ekranKaydirma2(0.50);
        VerifyElementText("Flower Print Foil T-shirt\n0 (0  Reviews)\n$65.00");
    }

    @Given("I am on the product detail page")
    public void openProductDetail() {
    }

    @When("I select size {string}")
    public void selectSize(String size) {
    }

    @When("I select color {string}")
    public void selectColor(String color) {
    }

    @When("I enter quantity {string}")
    public void enterQuantity(String quantity) {
    }

    @Then("the selections should be accepted")
    public void verifySelections() {
    }

    @When("I tap the \"Add to Cart\" button")
    public void tapAddToCart() {
    }

    @Then("the product should be added to my cart")
    public void verifyCartAddition() {
    }


}
