package stepdefinitions;

import Page.QueryCardPage;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.OptionsMet;
import utilities.ReusableMethods;

import static Page.QueryCardPage.driver;
import static utilities.Driver.getAppiumDriver;

public class US003_Stepdefinitions extends OptionsMet {

    QueryCardPage card = new QueryCardPage();
    Actions actions = new Actions(getAppiumDriver());

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
        card.getProduct1().click();
    }

    @When("I select size {string}")
    public void selectSize(String size) {
        ReusableMethods.wait(3);
        WebElement element = driver.findElement(AppiumBy.accessibilityId(size));
        Assert.assertTrue(element.isDisplayed());
        element.click();

    }

    @When("I select color {string}")
    public void selectColor(String color) {
    }

    @When("I enter quantity {int}")
    public void enterQuantity(int quantity) {
        ReusableMethods.wait(3);
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.ImageView[2]"));
        Assert.assertTrue(element.isDisplayed());
        for (int i=1; i<quantity; i++){
            element.click();
        }
    }

    @Then("the selections should be accepted")
    public void verifySelections() {
        ReusableMethods.wait(3);
        ReusableMethods.scrollWithUiScrollableContentDesc("Add To Cart");
        Assert.assertTrue(card.getAddToCartButton().isDisplayed());
    }

    @When("I tap the \"Add to Cart\" button")
    public void tapAddToCart() {
        card.getAddToCartButton().click();
        ReusableMethods.wait(2);
    }

    @Then("the product should be added to my cart")
    public void verifyCartAddition() {
        card.getCartButton().click();
        ReusableMethods.wait(2);
        VerifyElementText("Shopping Cart");
    }


}
