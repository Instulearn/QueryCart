package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US009 {

    @Given("The user is on the homepage")
    public void the_user_is_on_the_homepage() {

    }
    @Given("The {string} icon in the navbar is visible and clickable")
    public void the_icon_in_the_navbar_is_visible_and_clickable(String iconName) {

    }
    @When("The user clicks the {string} icon in the navbar")
    public void the_user_clicks_the_icon_in_the_navbar(String iconName){

    }

    @Then("The user should see the categories page or section")
    public void the_user_should_see_the_categories_page_or_section() {

    }

    @Given("The user is on the categories page or section")
    public void the_user_is_on_the_categories_page_or_section() {

    }

    @Then("The {string}, {string}, and {string} headings should be visible and clickable")
    public void the_headings_should_be_visible_and_clickable(String heading1, String heading2, String heading3){

    }

    @When("The user clicks on the {string} heading")
    public void the_user_clicks_on_the_heading(String category){

    }

    @Then("The {string} category products should be displayed")
    public void the_category_products_should_be_displayed(String category){

    }

    @Then("The filtering icons should be visible and active")
    public void the_filtering_icons_should_be_visible_and_active() {

    }
}
