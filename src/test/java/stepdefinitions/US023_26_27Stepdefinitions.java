package stepdefinitions;

import Page.KeremPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import jdk.jfr.Registered;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.OptionsMet;
import utilities.ReusableMethods;

import javax.sound.midi.InvalidMidiDataException;

import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;


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


    ///************ US027 *****************
    // US027.1

    @When("User verifies that the cart button is visible and active")
    public void user_verifies_that_the_cart_button_is_visible_and_active() {
        ReusableMethods.wait(2);
        assertTrue(keremPage.getHomePageCartButton().isDisplayed());
        assertTrue(keremPage.getHomePageCartButton().isEnabled());
        System.out.println("Kullanici AlışVeriş Sepeti butonunun görünür ve etkin olduğunu doğrular");
    }

    @Then("The user clicks on the product wants to add to cart.")
    public void the_user_clicks_on_the_product_wants_to_add_to_cart() {
        ReusableMethods.wait(2);
        keremPage.getAddToCartProduct().click();
        System.out.println("Kullanici ürünü sepete ekler");
    }

    @When("User clicks on the button with the cart button")
    public void user_clicks_on_the_button_with_the_cart_button() {
        ReusableMethods.wait(2);
        keremPage.getHomePageCartButton().click();
    }

    @Then("The user confirms that the product in the cart is the product they selected")
    public void the_user_confirms_that_the_product_in_the_cart_is_the_product_they_selected() {
        ReusableMethods.wait(2);
        assertTrue(keremPage.getProductInCart().getAttribute("content-desc").contains("Flower Print Foil"));
        System.out.println("Kullanici sepetteki ürünün seçtiği ürün olduğunu doğrular");
    }

    @When("The user swip on the button with the {string} description")
    public void the_user_clicks_on_the_button_with_the_description(String description) {
        ReusableMethods.wait(1);
        keremPage.scrollAndClickByDescription(description);
        System.out.println("Kullanici ekrani Add To Cart Butonuna kadar kaydırır");
    }

    @When("User click the cart button on the page")
    public void user_click_the_cart_button_on_the_page() {
        keremPage.getProductPageShoppingCartButton().click();
        System.out.println("Kullanici alış veriş sepeti butonuna tiklar");
    }

    @When("User confirms that the subtotal amount is {string} after the deletion.")
    public void user_confirms_that_the_subtotal_amount_is_after_the_deletion(String amount) {
        assertTrue(keremPage.getSubtotalAmount().getAttribute("content-desc").equals(amount));
        System.out.println("Kullanıcı silme işlemi sonrası sepet ara toplamının 0.00$ olduğunu doğrular");

    }


    // US020

    @When("The user sees the old password, new password, and password checkboxes and tests whether they are active.")
    public void the_user_sees_the_old_password_new_password_and_password_checkboxes_and_tests_whether_they_are_active() {
       ReusableMethods.wait(2);
        assertTrue(keremPage.getOldPasswordTextBox().isDisplayed());
        assertTrue(keremPage.getNewPasswordTextBox().isDisplayed());
        assertTrue(keremPage.getConfirmPasswordTextBox().isDisplayed());
        assertTrue(keremPage.getOldPasswordTextBox().isEnabled());
        assertTrue(keremPage.getNewPasswordTextBox().isEnabled());
        assertTrue(keremPage.getConfirmPasswordTextBox().isEnabled());
        System.out.println("Kullanıcı eski şifre, yeni şifre ve doğrulanan şifre kutularının görünür ve aktif olduğunu test eder");
    }

    @Then("The user enters information in all boxes")
    public void the_user_enters_information_in_all_boxes() {
        ReusableMethods.wait(1);
        keremPage.getOldPasswordTextBox().click();
        keremPage.getOldPasswordTextBox().sendKeys(registeredPassword);
        registeredPassword = registeredPassword + "1";
        keremPage.getNewPasswordTextBox().click();
        keremPage.getNewPasswordTextBox().sendKeys(registeredPassword);
        keremPage.getConfirmPasswordTextBox().click();
        keremPage.getConfirmPasswordTextBox().sendKeys(registeredPassword);
    }



    // US015
    @Then("User sees categories title on home page")
    public void user_sees_categories_title_on_home_page() {
        assertTrue(keremPage.getHomePageCategoriesTitle().isDisplayed());
        System.out.println("Kullanıcı ana sayfada Categories başlığını görür");
    }

    @Then("Women Category Visibility and Functionality on Homepage")
    public void women_category_visibility_and_functionality_on_homepage() throws InvalidMidiDataException {
        for (int i = 0; i < 9; i++) {
            OptionsMet.swipe(1260, 1280, 200, 1280);
            ReusableMethods.wait(1);
        }
        {
            for (int i = 0; i < 5; i++) {
                OptionsMet.swipe(300, 1280, 1260, 1280);
                ReusableMethods.wait(1);

            }

        }
        System.out.println("Kullanıcı categori başlığı altında gezinir");
    }

    @When("User verifies that the Filter button is displayed and active")
    public void user_verifies_that_the_filter_button_is_displayed_and_active() {
        ReusableMethods.wait(2);
        assertTrue(keremPage.getFilterButton().isDisplayed());
        assertTrue(keremPage.getFilterButton().isEnabled());
        System.out.println("Kullanıcı Filtreleme butonunun görüntülendiğini ve aktif olduğunu doğrular");
    }

    @Then("User on the Women page, sees the second product itself and the favorite button")
    public void user_on_the_women_page_sees_the_second_product_itself_and_the_favorite_button() {
       assertTrue(keremPage.getWomenPageSecondProduct().isDisplayed());
       assertTrue(keremPage.getWomenPageSecondProductFavoriteButton().isDisplayed());
        System.out.println("Kullanıcı Women sayfasında 2.ürünü ve ürünün kalp ikonunu görüntüler");
    }

    @Then("User clicks on second product to add to cart")
    public void user_clicks_on_second_product_to_add_to_cart() {
        keremPage.getWomenPageSecondProduct().click();
        System.out.println("Kullanıcı Women sayfasında 2.ürüne tıklar");
        ReusableMethods.wait(2);
    }

    @Then("User clicks on the Filter button")
    public void user_clicks_on_the_filter_button() {
        keremPage.getFilterButton().click();
        ReusableMethods.wait(1);
        System.out.println("Kullanıcı filtre butonuna tıklar");
    }

    @When("The user returns to the previous page")
    public void the_user_returns_to_the_previous_page() {
        getAppiumDriver().navigate().back();
        ReusableMethods.wait(2);
        System.out.println("Kullanıcı bir önceki sayfaya geri döner");
    }

    @When("User swip on the button with the {string} description")
    public void user_swip_on_the_button_with_the_description(String description) {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        int maxSwipes = 5;

        for (int i = 0; i < maxSwipes; i++) {
            try {
                WebElement element = driver.findElement(AppiumBy.accessibilityId(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                                + "new UiSelector().description(\"" + description + "\"))"));
                System.out.println("Element bulundu: " + description);
                return; // bulunduysa çık
            } catch (Exception e) {
                // daha kısa scroll yap
                ReusableMethods.swipe(600, 1200, 600, 1000, 500);
            }
        }
        System.out.println("Element bulunamadı: " + description);
    }

    @When("The user scrolls the screen slightly up")
    public void the_user_scrolls_the_screen_slightly_up() throws InvalidMidiDataException {
        OptionsMet.swipe(750,800,750,1400);
    }



}
