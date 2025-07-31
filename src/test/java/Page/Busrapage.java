package Page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static utilities.Driver.getAppiumDriver;
import static utilities.OptionsMet.KeyBack;

public class Busrapage {

    public Busrapage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }
    public static AndroidDriver driver = (AndroidDriver) getAppiumDriver();


    //US009

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Category\")")
    private WebElement kategoriButton;


    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Men\")")
    private WebElement MenButton;


    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Women\")")
    private WebElement WomenButton;


    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Juniors\")")
    private WebElement JuniorsButton;


    public void categorygorunum() {

        kategoriButton.isDisplayed();


     }


    public void categorytıklama() {
    kategoriButton.click();

    }

    public void men() {
 MenButton.isDisplayed();
 MenButton.click();
 KeyBack();
 WomenButton.isDisplayed();
 WomenButton.click();
 KeyBack();
 JuniorsButton.isDisplayed();
 JuniorsButton.click();
 KeyBack();
    }
}
