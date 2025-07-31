package Page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

import static utilities.Driver.getAppiumDriver;

public class SmokePage {
    public SmokePage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }
    public static AndroidDriver driver = (AndroidDriver) getAppiumDriver();

    //Genel Locator
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(1)")
    private WebElement searchButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\")")
    private WebElement searchBox;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(1)")
    private WebElement searchBoxClick;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(3)")
    private WebElement wishlistButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Classic Cotton T-Shirt\n" + "0 (0  Reviews)\n" + "$20.00\")")
    private WebElement wishProduct;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Classic Cotton T-Shirt\n" + "L | White\n" + "$20.00\n" + "1\")")
    private WebElement shoppingBasket;

    public void userClickSearchButton() {
        searchButton.click();
    }

    public void findAndClickSearch(String description) {
        Actions actions = new Actions(getAppiumDriver());
        searchBox.click();
        searchBox.sendKeys(description);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void clickWishlistButton() {
        wishlistButton.click();
        ReusableMethods.wait(1);
    }

    public void userSelectProductInWishlist() {
        wishProduct.click();
    }

    public void userVerifiesShoppingBasket() {
        shoppingBasket.isDisplayed();
    }


}
