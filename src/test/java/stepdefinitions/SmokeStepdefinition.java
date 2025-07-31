package stepdefinitions;

import Page.FurkanPage;
import Page.SmokePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.OptionsMet;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class SmokeStepdefinition extends OptionsMet {

    FurkanPage furkancard = new FurkanPage();
    SmokePage card = new SmokePage();

    @Given("User waits {string} seconds")
    public void user_waits_seconds(String description) {
        int clickCount = Integer.parseInt(description);
        ReusableMethods.wait(clickCount);
    }

    @Given("User click search button")
    public void user_click_search_button() {
        card.userClickSearchButton();
    }

    @Given("User types {string} in searchTextBox")
    public void user_types_in_searchTextBox(String description) {
        card.findAndClickSearch(description);
    }

    @Given("User clicks the fav button of the product for adding it to the wishlist")
    public void fav_button_product() {
        card.clickWishlistButton();
    }

    @Given("User selects the Classic Cotton T-Shirt product on the Wishlist page")
    public void user_select_product_in_wishlist() {
        card.userSelectProductInWishlist();
    }

    @Given("The user verifies that there are items in the shopping basket")
    public void user_verifies_are_items_in_shopping_basket() {
        card.userVerifiesShoppingBasket();
    }

}