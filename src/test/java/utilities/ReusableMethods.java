package utilities;

import io.appium.java_client.*;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import static java.time.Duration.ofMillis;
import static java.util.Collections.singletonList;
import static utilities.Driver.getAppiumDriver;

import io.appium.java_client.android.AndroidDriver;
import javax.sound.midi.InvalidMidiDataException;
import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class ReusableMethods {

    public static void apkYukle(){

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        options.setDeviceName(ConfigReader.getProperty("deviceName"));
        options.setPlatformVersion(ConfigReader.getProperty("version"));
// options.setApp(ConfigReader.getProperty("apk")); // Uncomment if using a local APK

        options.setAppPackage(ConfigReader.getProperty("appPackage"));
        options.setAppActivity(ConfigReader.getProperty("appActivity"));


    }
    public static void elementClick(WebElement elementName){
        var el1 = getAppiumDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\""+elementName+"\").instance(0)"));
        el1.click();
    }
    public static void koordinatTiklama(int xKoordinat, int yKoordinat, int bekleme, WebElement slider) throws InterruptedException {
        Point source = slider.getLocation();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(ofMillis(0),
                PointerInput.Origin.viewport(), source.x, source.y));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        sequence.addAction(new Pause(finger, ofMillis(600)));
        sequence.addAction(finger.createPointerMove(ofMillis(600),
                PointerInput.Origin.viewport(), source.x + 400, source.y));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

        getAppiumDriver().perform(singletonList(sequence));
           }

  //  static AndroidDriver<AndroidElement> driver=Driver.getAppiumDriver();
    public static void koordinatTiklamaMethodu(int x,int y) throws InterruptedException {
        TouchAction action=new TouchAction((PerformsTouchActions) getAppiumDriver());
        action.press(PointOption.point(x,y)).release().perform();
        Thread.sleep(1000);
    }

    public static void scrollWithUiScrollableAndClick(String elementText) {
        AndroidDriver driver = (AndroidDriver)  Driver.getAppiumDriver();
      //  driver.findElement(AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))");
        driver.findElement(By.xpath("//*[@text='" + elementText + "']")).click();

    }
    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver driver = (AndroidDriver)  getAppiumDriver();
     //   driver.findElement(AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))"));

    }

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot)Driver.getAppiumDriver();

        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    public static void ekranKaydirmaMethodu(int xPress,int yPress,int wait,int xMove,int yMove){
        TouchAction action=new TouchAction<>((PerformsTouchActions) getAppiumDriver());
        action.press(PointOption.point(xPress,yPress))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(xMove,yMove))
                .release()
                .perform();
    }
    public static void ekranKaydirma2(double percent){
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        params.put("percent", percent); // swipe % of the screen (for example, 0.10)
        // Define the swipe area (bounding box)
        params.put("left", 200);
        params.put("top", 200);
        params.put("width", 1440);
        params.put("height", 3120);


        driver.executeScript("mobile: swipeGesture", params);
    }

    public static void wait(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollWithUiScrollableContentDescClick(String elementText) {

        Driver.getAppiumDriver().findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().description(\"" + elementText + "\"));"
                )
        ).click();
    }
    public static void clickButtonByDescription(String description) {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        WebElement button = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().description(\"" + description + "\")"));
        button.click();
    }
    public static void scrollWithUiScrollableContentDesc(String elementText) {

        Driver.getAppiumDriver().findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().description(\"" + elementText + "\"));"
                )
        );
    }

    public static void scrollWithPartialContentDesc(String partialDesc) {
        Driver.getAppiumDriver().findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().descriptionContains(\"" + partialDesc + "\"));"
                )
        ).click();
    }


    public static List<String> getAllCategories() throws InvalidMidiDataException {
        List<String> allCategories = new ArrayList<>();
        boolean isEndOfList = false;

        while (!isEndOfList) {

            List<WebElement> visibleCategories = Driver.getAppiumDriver().findElements(By.xpath("(//android.view.View)[11]//android.view.View"));

            for (WebElement category : visibleCategories) {
                String categoryName = category.getAttribute("content-desc");

                if (categoryName != null && !categoryName.equals("null") && !categoryName.trim().isEmpty()) {
                    if (!allCategories.contains(categoryName)) {
                        allCategories.add(categoryName);
                    }
                }
            }

            OptionsMet.swipe(1188, 1162, 0, 1162);
            ReusableMethods.wait(1);

            List<WebElement> currentVisibleCategories = Driver.getAppiumDriver().findElements(By.xpath("(//android.view.View)[11]//android.view.View"));
            String currentCategoryName = currentVisibleCategories.get(currentVisibleCategories.size() - 1).getAttribute("content-desc");

            String lastCategory = allCategories.get(allCategories.size() - 1);

            if (currentCategoryName.equals(lastCategory)) {
                isEndOfList = true;
            }
        }
        return allCategories;
    }

    public static void selectCategory(String categoryNameVariable) {
        List<String> allCategories = new ArrayList<>();
        boolean categoryFound = false;
        boolean reachedEnd = false;

        while (!categoryFound) {

            List<WebElement> visibleCategories = Driver.getAppiumDriver().findElements(By.xpath("(//android.view.View)[11]//android.view.View"));

            for (WebElement category : visibleCategories) {
                String categoryName = category.getAttribute("content-desc");

                if (categoryName != null && !categoryName.equals("null") && !categoryName.trim().isEmpty()) {
                    if (!allCategories.contains(categoryName)) {
                        allCategories.add(categoryName);

                        if (categoryName.equals(categoryNameVariable)) {
                            categoryFound = true;
                            category.click();
                            break;
                        }
                    }
                }
            }

            if (categoryFound) break;

            if (reachedEnd) {
                try {
                    OptionsMet.swipe(0, 1162, 1188, 1162);
                } catch (InvalidMidiDataException e) {
                    throw new RuntimeException(e);
                }
                ReusableMethods.wait(1);

            } else {

                String lastVisibleCategory = visibleCategories.get(visibleCategories.size() - 1).getAttribute("content-desc");

                try {
                    OptionsMet.swipe(1188, 1162, 0, 1162);
                } catch (InvalidMidiDataException e) {
                    throw new RuntimeException(e);
                }
                ReusableMethods.wait(1);

                visibleCategories = Driver.getAppiumDriver().findElements(By.xpath("(//android.view.View)[11]//android.view.View"));

                String newLastVisibleCategory = visibleCategories.get(visibleCategories.size() - 1).getAttribute("content-desc");
                if (lastVisibleCategory.equals(newLastVisibleCategory)) {
                    reachedEnd = true;
                }
            }
        }
    }


    public static void swipe(int i, int i1, int i2, int i3, int i4) {

    }
}
