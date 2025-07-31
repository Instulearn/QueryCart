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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.ReusableMethods;

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

    //US 25 CODES AND METHODS

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Flower Print Foil T-shirt\n" +
            "0 (0  Reviews)\n" +
            "$65.00\")")
    private WebElement firstProduct;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"L\")")
    private WebElement largeSize;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Add To Cart\")") //Buna ulasmak icin swipe gerekiyor
    private WebElement addToCartButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(12)")
    private WebElement goToCart;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Proceed to Checkout\")")
    private WebElement proceedToCheckoutButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Elif\n" +
            "+1201123\n" +
            "DevollDistrict,Albania,20000\n" +
            "werrtz\")")
    private WebElement selectAddress;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Save & Pay\")")
    private WebElement saveAndPay;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Stripe\")")
    private WebElement stripe;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Confirm Order\")")
    private WebElement confirmOrder;

    //Canan hnm'dan

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement cardNumberInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement monthYearInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(2)")
    private WebElement CVCinput;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(3)")
    private WebElement ZIPinput;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"confirmBtn\")")
    private WebElement confirmButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Go to order details\")") //Burada siparisimi pending olarak görüyorum(Geri gidip manager olmaliyim)
    private WebElement orderDetailsButonu;

    //Canan hnm locate bitti


    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Order History\")")
    private WebElement orderHistory;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"#2905251262\n" + // pending yerine delivered yapilacak ürünü sec
            "01:20 PM, 29-05-2025\n" +
            "Info: \n" +
            "1 Product\n" +
            "Delivery Status: \n" +
            "Pending\n" +
            "Payment Status: \n" +
            "Unpaid\n" +
            "Total: \n" +
            "$76.30\")")
    private WebElement SelectProductFordelivery;



    public void buyAProductAndPayForIt(){

        firstProduct.click();
        ReusableMethods.wait(1);
        largeSize.click();
        swipeUpTo(By.xpath("//android.widget.ImageView[@content-desc=\"Add To Cart\"]"));
        addToCartButton.click();
        ReusableMethods.wait(1);
        goToCart.click();
        proceedToCheckoutButton.click();
        selectAddress.click();
        swipeUpTo(By.xpath("//android.view.View[@content-desc=\"Save & Pay\"]"));
        saveAndPay.click();
        ReusableMethods.wait(4);
        stripe.click();
        confirmOrder.click();
        ReusableMethods.wait(8);
        cardNumberInput.click();
        cardNumberInput.sendKeys("4242424242424242");
        monthYearInput.sendKeys("0426");
        CVCinput.sendKeys("123");
        ZIPinput.sendKeys("12345");
        ReusableMethods.wait(1);
        confirmButton.click();
        ReusableMethods.wait(6);
        orderDetailsButonu.click();
        ReusableMethods.wait(2);
    }

    // URUN IADE LOCATELERI VE KODLARI

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Delivered')]")
    private List<WebElement> selectReturnProduct;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Return Request\"]")
    private WebElement returnRequestButton;


    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(1)")
    private WebElement clickTheReturnProduct;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ImageView[1]/android.view.View")
    private WebElement returnReasonField;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Other\")")
    private WebElement otherReason;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\")")
    private WebElement returnNote;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Request Return\"])[2]")
    private WebElement requestReturn;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"#3107251374\n" +
            "09:55 AM, 31-07-2025\n" +
            "Info: \n" +
            "1 Product\n" +
            "Return Status: \n" +
            "Pending\n" +
            "Total: \n" +
            "$67.00\"]")
    private WebElement returnProduct;

    public boolean isReturnRequestButtonDisplayed(){

        swipeUpTo(By.xpath("(//android.widget.ImageView[contains(@content-desc, 'Delivered')])[1]"));
        selectReturnProduct.get(0).click();
        swipeUpTo(By.xpath("//android.view.View[@content-desc=\"Return Request\"]"));
        ReusableMethods.wait(3);
        return returnRequestButton.isDisplayed() & returnRequestButton.isEnabled();

    }

    public boolean returnTheProduct(){
        returnRequestButton.click();
        ReusableMethods.wait(1);
        clickTheReturnProduct.click();
        ReusableMethods.wait(2);
        returnReasonField.click();
        ReusableMethods.wait(2);
        otherReason.click();
        ReusableMethods.wait(1);
        returnNote.click();
        ReusableMethods.wait(1);
        returnNote.sendKeys("Das Produkt ist leider zu Groß und passt mir nicht gut :)");
        ReusableMethods.wait(1);
        swipeUpTo(By.xpath("(//android.view.View[@content-desc=\"Request Return\"])[2]"));
        ReusableMethods.wait(1);
        requestReturn.click();
        ReusableMethods.wait(1);

        return returnProduct.isDisplayed();
    }



//CHROME ICIN KODLAR (DAHA SONRA DENE)


//    //Buraya kadar
//
//    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(0)")
//    private WebElement backButton2;

//    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Profile\")")
//    private WebElement profile;
//
//    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Logout\")")
//    private WebElement logout;

    // click profile // sign in // use email Instead // email (bu alani temizlemek gerekebilir) // pass(bu alani temizlemek gerekebilir) //sign In
    //emailField.clear();  // Eski maili temizler
    //profile tikla

    //    QueryCardPage card = new QueryCardPage();


//
//    public void switchToChrome(){
//
//        ReusableMethods.wait(3);
//        Driver.startActivity("com.android.chrome", "com.google.android.apps.chrome.Main", false);
//
//        //Ekstra chrome degisince
//        new WebDriverWait(driver, Duration.ofSeconds(15))
//                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"com.android.chrome:id/search_box_text\"]")));
//        ReusableMethods.wait(3);
//        chromeSearch1.click();
//        ReusableMethods.wait(3);
//        chromeSearch2.sendKeys("https://querycart.com/#/home");
//        ReusableMethods.wait(1);
//        goToAddress.click();
//    }

//    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"formEmail\"]")
//    private WebElement email;
//
//    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"formPassword\"]")
//    private WebElement password;
//
//    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Sign In\"]")
//    private WebElement signIn;
//
//    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.android.chrome:id/search_box_text\"]")
//    private WebElement chromeSearch1;
//
//    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.android.chrome:id/url_bar\"]")
//    private WebElement chromeSearch2;
//
//    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.android.chrome:id/line_1\" and @text=\"QueryCart - Shop Smarter, Live Better\"]")
//    private WebElement goToAddress;
//
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Dashboard\"]")
//    private WebElement dashboard;
//
//    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"\uF036\"]")
//    private WebElement wayForOnlineOrders;
//
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Overview\"]")
//    private WebElement onlineOrders;
//
//    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"\uF00D\"]")
//    private WebElement x;
//
//    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"\uE078\"])[1]")
//    private WebElement action;
//
//    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"\uE050 Accept\"]")
//    private WebElement accept;
//
//    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Yes, Accept it!\"]")
//    private WebElement yesAcceptIt;


//    public void manager_ships_the_product() {
//
//        profile.click();
//        ReusableMethods.wait(1);
//        wayForOnlineOrders.click();
//        ReusableMethods.wait(1);
//        onlineOrders.click();
//        x.click();
//        ReusableMethods.wait(1);
//        swipeRight();
//        ReusableMethods.wait(1);
//        action.click();
//        accept.click();
//        yesAcceptIt.click();
//    }

//    public void swipeRight(){
//        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        var start = new Point(1341, 2000);
//        var end = new Point (180, 2000);
//        var swipe = new Sequence(finger, 1);
//        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                PointerInput.Origin.viewport(), start.getX(), start.getY()));
//        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//                PointerInput.Origin.viewport(), end.getX(), end.getY()));
//        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        driver.perform(Arrays.asList(swipe));
//    }



}