package Page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static utilities.Driver.getAppiumDriver;
import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;
import static utilities.OptionsMet.KeyBack;
public class FilizPage {
    public FilizPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }
    public static AndroidDriver driver = (AndroidDriver) getAppiumDriver();

   //U001

    @AndroidFindBy(uiAutomator ="new UiSelector().className(\"android.widget.ScrollView\")")

    private WebElement HomePage;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[1])[1]")
    public WebElement GetQueryCardLogoElement;

    //002
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home\")")
    private WebElement homeButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Category\")")
    private WebElement kategoriButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Wishlist\")")
    private WebElement wishlistButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Profile\")")
    private WebElement profileLink;



   //U002

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home\")")
    private WebElement getqueryCartHomelink;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Category\")")
     private WebElement getQueryCartCategorylink;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(18)")
    private WebElement getQueryCartcartlink;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Wishlist\")")
    private WebElement getQueryCartWishlistlink;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Profile\")")
    private WebElement getQueryCartprofillink;

    //linlerin aktifligi
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ScrollView\")")
    private WebElement QueryCartHomelinkaktif;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(3)")
    private WebElement QueryCartCategorylinkaktif;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(3)")
    private WebElement QueryCartcartlinkaktif;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(5)")
    private WebElement QueryCartWishlistlinkaktif;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(3)")
    private WebElement QueryCartprofillinkaktif;
    @AndroidFindBy(xpath = "(//android.widget.ImageView[1])[2]")
    private WebElement searchBoxElement;

    public void verifiedButton(String description) {
        WebElement button = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"" + description + "\")"));
        button.isDisplayed();
        System.out.println(description + " buton gözüküyor!");
    }

    public void verifiedShopping() {
        getQueryCartcartlink.isDisplayed();


    }

    public void clickButton(String description) {
        WebElement button = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"" + description + "\")"));
        button.click();
        System.out.println(description + " buton gözüküyor!");
    }

    public void clickShopping() {
        getQueryCartcartlink.click();
    }

    public void clickSearch() {

        searchBoxElement.click();


    }


}
