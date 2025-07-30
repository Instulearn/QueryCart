package stepdefinitions;

import Page.FilizPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

import static utilities.Driver.getAppiumDriver;

public class US002_Stepdefinetions {
    FilizPage filizcard = new FilizPage();
    AndroidDriver driver = (AndroidDriver) getAppiumDriver();

    @Given("User verified the {string} button")
    public void user_verified_the_home_button(String description) {
        filizcard.verifiedButton(description);
    }

    @Given("user verified the shopping Cart button")
    public void user_verified_the_shopping_cart_button() {
        filizcard.verifiedShopping();
    }

    @Given("User click the {string} button")
    public void user_click_the_home_button(String description) {
        filizcard.clickButton(description);
    }

    @Given("user click the shopping Cart button")
    public void user_click_the_shopping_cart_button() {
        filizcard.clickShopping();
    }

    @Given("user click search button")
    public void user_click_search_button() {
        filizcard.clickSearch();
    }
}










