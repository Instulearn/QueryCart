package Page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.*;

import static utilities.Driver.getAppiumDriver;

@Getter
public class TugbaPage {

    public TugbaPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }
    public static AndroidDriver driver = (AndroidDriver) getAppiumDriver();

    //US_010 icin locate ve methodlar

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Most Popular\")")
    private WebElement mostPopularTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"See All\")")
    private WebElement seeAllButton;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Reviews') and not(contains(@content-desc, 'Most Popular')) and not(contains(@content-desc, 'Products Found'))]")
    private List<WebElement> productsList;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(0)")
    private WebElement backButton;

    private By lastProduct = AppiumBy.androidUIAutomator("new UiSelector().description(\"The Children's Place Baby Girls' and Toddler Short Sleeve Everyday Dresses\n" +
            "0 (0  Reviews)\n" +
            "$29.00\")");

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Products Found')]")
    private  WebElement productsFoundText;

    public boolean isMostPopularTitleDisplayed(){
        return mostPopularTitle.isDisplayed();
    }

    public void swipeUp() {
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var start = new Point(584, 1705);
        var end = new Point(596, 906);
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));

    }

    //Bu method elementi bulana kadar swipe yapar
    public void swipeUpTo(By by) {
        List<WebElement> elementList = driver.findElements(by); //Burada sadece bir elementin locate'i var, excp. atmasin diye liste atiyoruz
        while (elementList.isEmpty()) { //o element liste eklenmedikce while döngüsü devam etsin
            swipeUp();
            elementList = driver.findElements(by); //elementi ekleyince while'dan cikacak ve swipe bitecek
        }

    }

    //Son ürüne kadar swipe yaparak bütün ürünleri benzersiz olarak sete ekleyen method
    public boolean allProductSize() {
        Set<String> uniqueProducts = new HashSet<>();
        while (true) {
            List<WebElement> visibleProducts = driver.findElements(
                    AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Reviews') and not(contains(@content-desc, 'Most Popular')) and not(contains(@content-desc, 'Products Found'))]")
            );

            for (WebElement product: visibleProducts){
                uniqueProducts.add(product.getAttribute("content-desc"));
            }

            if (!driver.findElements(lastProduct).isEmpty()) {
                break;
            }
            swipeUp();
        }
        // Ürün sayısı kontrolü
        String text = productsFoundText.getAttribute("content-desc");
        text = text.replaceAll("\\D", "");

        return Integer.parseInt(text) == uniqueProducts.size();
    }

// US 011 Locate ve methodlari

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Wishlist\")")
    private WebElement wishListButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(2)")
    private WebElement addWishList1;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(9)")
    private WebElement addWishList2;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Flower Print Foil T-shirt\n" +
            "0 (0  Reviews)\n" +
            "$65.00\")")
    private WebElement product1;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Floral Print Midi Dress\n" +
            "0 (0  Reviews)\n" +
            "$100.00\")")
    private WebElement product2;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Flower Print Foil T-shirt\n" +
            "0 (0  Reviews)\n" +
            "$65.00\")")
    private WebElement product1OnWishList;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Floral Print Midi Dress\n" +
            "0 (0  Reviews)\n" +
            "$100.00\")")
    private WebElement product2OnWishList;





    public boolean isDisplayedAndEnabled(WebElement element){
        return element.isDisplayed() & element.isEnabled();
    }

    public void clickElement(WebElement element){
       element.click();
    }

    public boolean verifyWishlistProductsMatch(){

        String productOnPage1 = product1.getAttribute("content-desc");
        String productOnPage2 = product2.getAttribute("content-desc");
        String productOnWishlistPage1 = product1OnWishList.getAttribute("content-desc");
        String productOnWishlistPage2 = product2OnWishList.getAttribute("content-desc");

        return productOnPage1.equals(productOnWishlistPage1)&productOnPage2.equals(productOnWishlistPage2);

    }



}