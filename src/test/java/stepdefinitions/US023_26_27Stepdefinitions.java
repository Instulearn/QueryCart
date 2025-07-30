package stepdefinitions;

import Page.KeremPage;
import io.cucumber.java.en.*;
import jdk.jfr.Registered;
import lombok.Getter;
import org.junit.Assert;
import utilities.OptionsMet;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;



public class US023_26_27Stepdefinitions extends OptionsMet {

    KeremPage keremPage = new KeremPage();
    String registeredEmail;
    String registeredPassword;



    ///************ US023 *****************
    // US023.1
    @Then("Then The {string} header should be visible on the page")
    public void then_the_header_should_be_visible_on_the_page(String title) {
        assertTrue(keremPage.getHomepageMostPopularTitle().isDisplayed());
        System.out.println("Kullanıcı 'Most Popular' basligini gorur");
    }

    @Then("Each product has a favorite heart icon on the top right corner")
    public void each_product_has_a_favorite_heart_icon_on_the_top_right_corner() {
        ReusableMethods.wait(4);
        assertTrue(keremPage.getHomepageBirinciUrunFavoriButonu().isDisplayed());
        assertTrue(keremPage.getHomepageIkinciUrunFavoriButonu().isDisplayed());
        System.out.println("Kullanıcı sayfada gorunen 2 urunun sag ust kosesinde kalp ikonu oldugunu dogrular");
    }

    @Then("Favorite icons must be clickable")
    public void favorite_icons_must_be_clickable() {
        ReusableMethods.wait(4);
        assertTrue(keremPage.getHomepageBirinciUrunFavoriButonu().isEnabled());
        assertTrue(keremPage.getHomepageIkinciUrunFavoriButonu().isEnabled());
        System.out.println("Kullanıcı sayfada gorunen 2 urunun sag ust kosesinde kalp ikonu aktif oldugunu dogrular");
    }


    // US023.2
    @When("User clicks on the button with the {string} description")
    public void user_clicks_on_the_button_with_the_description(String description) {
        ReusableMethods.wait(2);
        keremPage.clickByDescription(description);
        System.out.println("Kullanıcı " + description +" butonuna (yazisina) tiklar");
    }

    @When("User enters {string} into the name field")
    public void user_enters_into_the_name_field(String name) {
        ReusableMethods.wait(2);
        keremPage.getSignupNameTextBox().click();
        keremPage.getSignupNameTextBox().sendKeys(name);
        System.out.println("Kullanici isim kutusuna gecerli bir isim girer");
    }

    @Then("User should be redirected to the Sign In page")
    public void user_should_be_redirected_to_the_sign_ın_page() {
        ReusableMethods.wait(3);
        assertTrue(keremPage.getSigninText().isDisplayed());
        System.out.println("Kullanici basarili kayit yaparak Sign In sayfasinda oldugunu dogrular");
    }

    @Then("User should be redirected to the homepage")
    public void user_should_be_redirected_to_the_homepage() {
        ReusableMethods.wait(3);
        assertTrue(keremPage.getHomePageQueryCartText().isDisplayed());
        System.out.println("Kullanici basarili bir sekilde sign in yaptigini dogrular");
    }

    @When("The user enters {string} into the e-mail box.")
    public void the_user_enters_into_the_e_mail_box(String email) {
        ReusableMethods.wait(2);
        email = KeremPage.generateUniqueEmail();
        keremPage.getSignupEmailTextBox().click();
        keremPage.getSignupEmailTextBox().sendKeys(email);
        registeredEmail = email;

        System.out.println("Kullanici kayıtta kullandigi "+registeredEmail+" adresini sign in sayfasinda mail kutusuna girer");
    }

    @When("The user enters {string} into the password box.")
    public void the_user_enters_into_the_password_box(String password) {
        ReusableMethods.wait(1);
        keremPage.getSignupPasswordTextBox().click();
        keremPage.getSignupPasswordTextBox().sendKeys(password);
        registeredPassword = password;
        System.out.println("Kullanici kayıtta kullandigi "+registeredPassword+" sifresini sign in sayfasinda mail kutusuna girer");
    }

    @When("User enters the same email and password used during registration")
    public void user_enters_the_same_phone_number_and_password_used_during_registration() {
        ReusableMethods.wait(2);
        keremPage.getSigninEmailTextBox().click();
        keremPage.getSigninEmailTextBox().sendKeys(registeredEmail);
        ReusableMethods.wait(1);
        keremPage.getSigninPasswordTextBox().click();
        keremPage.getSigninPasswordTextBox().sendKeys(registeredPassword);
        System.out.println("Kullanici yukarida kullandigi mail ve sifreyi ilgili kutulara girer");
    }

    @When("User clicks on the {string} button")
    public void user_clicks_on_the_button(String button) {
        ReusableMethods.wait(1);
        keremPage.getSigninButton().click();
        System.out.println("Kullanici sign in butonuna tiklar");
    }

    @When("User clicks the {string} button")
    public void user_clicks_the_button(String button2) {
        ReusableMethods.wait(1);
        keremPage.getSingupButton().click();
        System.out.println("Kullanici sign up butonuna tiklar");

    }


    ///************ US026 *****************
    // US026.1
    @Then("User enters {string} address and {string} password")
    public void user_enters_address_and_password(String emailKey, String passwordKey) {
        ReusableMethods.wait(2);
        keremPage.loginWithValidCredentials(emailKey,passwordKey);
        System.out.println("Kullanici gecerli bir mail ve sifre girer");
    }

    @When("User verifies that the {string} button is visible and active")
    public void user_verifies_that_the_button_is_visible_and_active(String description) {
        ReusableMethods.wait(2);
        keremPage.visibleAndActiveByDescription(description);
        System.out.println("Kullanici " +description+" butonunu gorur ve aktif oldugunu dogrular");
    }

    @When("User sees Wishlist title and wishlist quantity")
    public void user_sees_wishlist_title_and_wishlist_quantity() {
        ReusableMethods.wait(2);
        assertTrue(keremPage.getWishlistPageWishlistTitle().isDisplayed());
        assertTrue(keremPage.getItemQuantityText().isDisplayed());
        assertTrue(keremPage.getItemQuantityText().getAttribute("content-desc").contains("1  Products"));
        System.out.println("Kullanici Wishlist sayfasindaki basligi ve urun miktarini gorur");
        System.out.println("Listede 1 urun oldugunu dogrular");
    }

    @Then("The user clicks on the red heart sign in the upper right corner of the products on the page that opens.")
    public void the_user_clicks_on_the_red_heart_sign_in_the_upper_right_corner_of_the_products_on_the_page_that_opens() {
        ReusableMethods.wait(1);
        keremPage.getWishlistPageProductFavoriteButton().click();
        System.out.println("Kullanici Favori olarak ekledigi urunun kalp ikonuna tiklar ve listeden kaldirir");
    }

    @Then("The user confirms that there are no products left in the product quantity.")
    public void the_user_confirms_that_there_are_no_products_left_in_the_product_quantity() {
        ReusableMethods.wait(3);
        assertTrue(keremPage.getItemQuantityText().getAttribute("content-desc").contains("0  Products"));
        System.out.println("Listede 0 urun oldugunu dogrular");
    }



}
