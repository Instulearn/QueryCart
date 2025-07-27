package stepdefinitions;

import Page.TugbaPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.OptionsMet;

public class US010 extends OptionsMet {
    TugbaPage tugbaPage = new TugbaPage();


    @Then("The user verifies that the Most Popular title is visible on the homepage")
    public void theUserChecksIfTheMostPopularTitleIsVisibleOnTheHomepage() {
        Assert.assertTrue( tugbaPage.isMostPopularTitleDisplayed());
    }

    @Then("The user verifies that the See All button is visible and enabled")
    public void theUserVerifiesThatTheSeeAllButtonIsVisibleAndEnabled() {
        OptionsMet.clickAndVerify(tugbaPage.getSeeAllButton());
    }

    @And("List Current products under Most Popular")
    public void listCurrentProductsUnderMostPopular() {
        Assert.assertTrue(tugbaPage.allProductSize());

    }

    @Then("Click the back button")
    public void verifyThatPressingTheBackButtonReturnsToTheHomePage() {
        OptionsMet.clickAndVerify(tugbaPage.getBackButton());
    }
}
