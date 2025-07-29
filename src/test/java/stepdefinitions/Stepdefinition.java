package stepdefinitions;

import Page.QueryCardPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.OptionsMet;
import utilities.ReusableMethods;


import javax.sound.midi.InvalidMidiDataException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static Page.QueryCardPage.driver;
import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;
import static utilities.Driver.quitAppiumDriver;

public class Stepdefinition extends OptionsMet {
    QueryCardPage card = new QueryCardPage();
    Actions actions = new Actions(getAppiumDriver());


    static String categoryName;
    static String popularBrandName;
    static String productName;

    @Given("User makes driver adjustments")
    public void user_makes_driver_adjustments() {
        getAppiumDriver();
    }

    @Given("User confirms to be on the homepage")
    public void user_confirms_to_be_on_the_homepage() {
        card.LogoGorunurTest();
    }

    @Given("User clicks the button with description {string}")
    public void user_clicks_the_button_with_description(String description) {
        ReusableMethods.wait(1);
        clickButtonByDescription(description);
    }

    @Given("User clicks the button {string} and sendKeys {string}")
    public void user_clicks_the_button_and_send_keys(String elementName, String text) {
        card.phoneTextBoxClickAndSendKeys(text);
        // Telefon numarası alanından sonra Tab ile şifre alanına geç
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("Wise123*").perform();
        ReusableMethods.wait(1);
        // Şifre alanından sonra Tab ile "remember me" checkbox'ına geç
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.SPACE).perform();
        actions.sendKeys(Keys.ENTER).perform();

    }

    @Given("User clicks the button {string}")
    public void user_clicks_the_button(String elementName) {
        card.signInLoginClick();
        ReusableMethods.wait(1);
        hideKeyboard();
        ReusableMethods.wait(2);

    }

    @Given("Verifies username {string} in dashboard")
    public void verifies_username_in_dashboard(String userName) {
        ReusableMethods.wait(1);
        VerifyElementText(userName);
    }

    /***US 11   **/
    @Given("As a user muss be {string} phone and {string} password Login")
    public void as_a_user_muss_be_phone_and_password_login(String phoneNumber, String password) {
        card.Login(phoneNumber, password);
    }

    @Given("User clicks the button with itemName {string} and {string} and {string} added WishList")
    public void user_clicks_the_button_with_item_name_and_and_added_wish_list(String itemName, String reviews, String price) {
        xPathElementClick(itemName, reviews, price);
    }


    @Given("Driver turns off")
    public void driver_turns_off() {
        quitAppiumDriver();
    }

    @Given("Toaster is displayed")
    public void toast_is_displayed() {
        card.wishListToast();

    }

    @Given("User confirms that categories appear on the screen")
    public void user_confirms_that_categories_appear_on_the_screen() {
        // for (int i = 0; i <categoriesMen.size(); i++) {
        //  assertTrue(categoriesMen.get(i).);
        //  }
    }

    @Given("User clicks phone number textbox and {string} phone number")
    public void user_clicks_phone_number_textbox_and_phone_number(String phoneNumber) {
        card.ForgetPasswordPhoneBox(phoneNumber);
    }

    @Given("User clicks NewPasswordTextBox and confirmPasswordTextBox {string}")
    public void user_clicks_new_password_text_box_and_confirm_password_text_box(String newPassword) {
        card.NewPassword(newPassword);
    }

    @Given("User clicks tap coordinates {int}, {int}")
    public void user_clicks_tap_coordinates(Integer x, Integer y) {
        ReusableMethods.wait(1);
        OptionsMet.touchDown(x, y);
        ReusableMethods.wait(1);
    }

    @Given("User swipe to screen coordinates {int}, {int}, {int}, {int}")
    public void user_swipe_to_screen_coordinates(Integer x, Integer y, Integer endX, Integer endY) throws InvalidMidiDataException {
        OptionsMet.swipe(x, y, endX, endY);
        ReusableMethods.wait(2);
    }


    @Given("Verify all the categories are visible under the Categories heading.")
    public void verify_all_the_categories_are_visible_under_the_categories_heading() throws InvalidMidiDataException {

        List<String> expectedCategoryNames = new ArrayList<>(Arrays.asList("Men", "Men Clothing", "Men T-Shirt", "Men Shorts",
                "Men Coat", "Men Suit", "Men Shoes", "Men Sneakers", "Men Classic Shoes", "Men Boots",
                "Men Casual Shoes", "Men Accessories", "Men Bags", "Men Socks", "Men Watch", "Women", "Women Clothing",
                "Woman Dresses - Skirts", "Woman T-shirt", "Woman Trousers", "Woman Coat", "Women Shoes",
                "Women Casual Shoes", "Women Classic Shoes", "Women's Boots", "Women Sneakers", "Women Accessories",
                "Women Bags", "Women Watch", "Women Jewelry", "Juniors", "Juniors Clothing", "Girl Clothes",
                "Juniors Sleepwear", "Boy Clothes", "Baby Clothes", "Juniors Shoes", "Girl Shoes",
                "Boy Shoes", "Juniors Accessories", "Juniors Bags", "Juniors Hat & Beres", "Toys"));

        List<String> actualCategoryNames = ReusableMethods.getAllCategories();

        for (int i = 0; i < actualCategoryNames.size(); i++) {
            Assert.assertEquals(expectedCategoryNames.get(i), actualCategoryNames.get(i));
        }
    }

    @Given("Select {string} category.")
    public void select_category(String assignedCategoryName) {
        categoryName = assignedCategoryName;
        ReusableMethods.selectCategory(categoryName);
    }

    @Given("Verify that the product listing for the selected category is displayed.")
    public void verify_that_the_product_listing_for_the_selected_category_is_displayed() {
        Assert.assertTrue(card.PageTitle.isDisplayed());
        Assert.assertEquals("Category names are not equals!", categoryName, card.PageTitle.getAttribute("content-desc"));

    }

    @Given("Select {string} from the category.")
    public void select_from_the_category(String expectedProductName) {
        productName = expectedProductName;
        ReusableMethods.scrollWithPartialContentDesc(expectedProductName);
    }

    @Given("Verify that the product details page for the selected product is displayed.")
    public void verify_that_the_product_details_page_for_the_selected_product_is_displayed() {

        ReusableMethods.wait(2);
        if (card.productName == null) {
            throw new AssertionError("Element 'card.productName' bulunamadı!");
        }

        String actual = card.productName.getAttribute("content-desc");

        if (actual == null) {
            throw new AssertionError("Elementin content-desc attribute'u null!");
        }

        if (productName == null) {
            throw new AssertionError("Beklenen ürün adı (productName) null!");
        }

        System.out.println("Content Description: " + actual);
        System.out.println("Expected Product Name: " + productName);

        Assert.assertTrue(actual.contains(productName));
    }

    @When("On the page that opens, click on the white heart sign in the upper right corner of the products.")
    public void onThePageThatOpensClickOnTheWhiteHeartSignInTheUpperRightCornerOfTheProducts() {
        card.whiteHeart.click();
        //ReusableMethods.wait(3);
        assertTrue(card.addedWish.getAttribute("content-desc").contains("Add"));

    }

    @When("On the page that opens, click on the red heart sign in the upper right corner of the products.")
    public void onThePageThatOpensClickOnTheRedHeartSignInTheUpperRightCornerOfTheProducts() {
        card.whiteHeart.click();
        WebDriverWait wait = new WebDriverWait(Driver.getAppiumDriver(), Duration.ofSeconds(5));
        WebElement toast = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.view.View[contains(@content-desc, 'Removed')]")
        ));
        assertTrue(toast.isDisplayed());
    }

    @When("User see Wishlist title and wishlist item quantity")
    public void userSeeWishlistTitleAndWishlistItemQuantity() {
        VerifyElementText("Wishlist");
        ReusableMethods.wait(2);
        assertTrue(card.wishquant.isDisplayed());
        assertTrue(card.wishquant.getAttribute("content-desc").contains("1  Products"));

        String wishQuantityText = card.wishquant.getAttribute("content-desc");
        System.out.println("Wishlist Item Quantity when added: " + wishQuantityText);

    }

    @When("User see Wishlist title and wishlist item quantity when wishlist is empty")
    public void userSeeWishlistTitleAndWishlistItemQuantityWhenWishlistIsEmpty() {

        assertTrue(card.wishquant.isDisplayed());
        assertTrue(card.wishquant.getAttribute("content-desc").contains("0  Products"));

        String wishQuantityText = card.wishquant.getAttribute("content-desc");
        System.out.println("Wishlist Item Quantity when wishlist is empty: " + wishQuantityText);

    }

    @Given("Switching from Query Cart application to Google Chrome")
    public void switching_from_query_cart_application_to_google_chrome() {
        ReusableMethods.wait(3);
        Driver.startActivity("com.android.chrome", "com.google.android.apps.chrome.Main", false);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.chrome:id/search_box_text")));

        /*
        Uygulama switch yapiyoruz ve Chrome'a geciyoruz.
         */





    }

    @Given("Go to the Query Cart url and log in with admin information")
    public void go_to_the_query_cart_url_and_log_in_with_admin_information() {
        card.googleSearchToQueryCart();
        ReusableMethods.wait(5);
        card.signInFromUrl();
        /*
        Chrome uzerinden QueryCart url'ine gidiyoruz ve admin bilgileri ile giris yapiyoruz
         */
        // Driver.terminateChrome();
        driver.terminateApp("com.android.chrome");
        driver.activateApp("com.wise.querycart");
    }

    @Given("Returns to the Query Cart app as the user")
    public void returns_to_the_query_cart_app_as_the_user() {
        if (((AndroidDriver) Driver.getAppiumDriver()).isAppInstalled("com.android.chrome")) {
            ((AndroidDriver) Driver.getAppiumDriver()).terminateApp("com.android.chrome");
        }

        Driver.startActivity("com.wise.querycart", "com.wise.querycart.MainActivity", false);

        ReusableMethods.wait(5);
        /*
        Tekrar QueryCart app'e donuyoruz
         */
    }


    }



