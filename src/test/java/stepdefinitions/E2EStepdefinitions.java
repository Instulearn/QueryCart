package stepdefinitions;

import Page.E2EPage;
import Page.FurkanPage;
import Page.SmokePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.OptionsMet;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class E2EStepdefinitions extends OptionsMet {

    FurkanPage furkancard = new FurkanPage();
    SmokePage smokecard = new SmokePage();
    E2EPage card = new E2EPage();

    @Given("User adds both products to the wishlist")
    public void user_adds_both_products_to_the_wishlist() {
        card.addWhislist();
    }

    @Given("User removes the expensive product from the wishlist")
    public void user_removes_the_expensive_product_from_the_wishlist() {
        card.removeExpensiveProductInWhislist();
    }

    @Given("User clicks cheap product")
    public void user_clicks_cheap_product() {
        card.clickCheapProduct();
    }

    @Given("User decides to purchase two units of the remaining product")
    public void user_clicks_quantity() {
        card.clickQuantityInWishlist();
    }

    @Given("User clicks the order")
    public void user_clicks_order() {
        OptionsMet.touchDown(800,880);
    }


}