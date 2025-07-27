package stepdefinitions;

import Page.TugbaPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.OptionsMet;

public class US011 extends OptionsMet {

    TugbaPage tugbaPage = new TugbaPage();


    @Then("Verify that Wishlist button is displayed and enabled")
    public void verifyThatWishlistButtonIsDisplayed() {
       Assert.assertTrue(tugbaPage.isDisplayedAndEnabled(tugbaPage.getWishListButton()));

    }

    @And("User adds some products to wishlist")
    public void userAddsSomeProductsToWishlist() {
        tugbaPage.clickElement(tugbaPage.getAddWishList1());
        tugbaPage.clickElement(tugbaPage.getAddWishList2());
    }

    @And("Click Wishlist button")
    public void clickWishlistButton() {
        tugbaPage.clickElement(tugbaPage.getWishListButton());
    }

    @Then("verify that selected products are displayed in wishlist")
    public void verifyThatSelectedProductsAreDisplayedInWishlist() {

        Assert.assertTrue(tugbaPage.verifyWishlistProductsMatch());
    }
}
