package Page;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

import static utilities.Driver.getAppiumDriver;

public class E2EPage {
    public E2EPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }
    public static AndroidDriver driver = (AndroidDriver) getAppiumDriver();

    //Genel Locator
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(3)")
    private WebElement first;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(10)")
    private WebElement second;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(9)")
    private WebElement expensiveInWishlist;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Watch for Ladies Sports Watch Casual Watch\n" + "0 (0  Reviews)\n" + "$59.00\")")
    private WebElement clickCheapProductInWishlist;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(9)")
    private WebElement clickQuantity;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(12)")
    private WebElement shoppingBasket;



    public void addWhislist() {
        first.click();
        second.click();
    }

    public void removeExpensiveProductInWhislist() {
        expensiveInWishlist.click();
    }

    public void clickCheapProduct() {
        clickCheapProductInWishlist.click();
    }

    public void clickQuantityInWishlist() {
        clickQuantity.click();
    }

    public void clickOrder() {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(800, 880)).perform();
    }
}
