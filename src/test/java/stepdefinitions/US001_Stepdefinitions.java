package stepdefinitions;

import Page.FilizPage;
import Page.FurkanPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;

public class US001_Stepdefinitions{

    FilizPage filizcard = new FilizPage();

        public static AndroidDriver driver = (AndroidDriver) getAppiumDriver();

        @Given("the app is installed and launched")
        public void the_app_is_installed_and_launched() {
            // Bu step genelde test runner tarafından halledilir.
            // Uygulama zaten açılmış varsayılır. Gerekirse kontrol yapılabilir.
            Assert.assertNotNull("Driver başlatılamadı!", getAppiumDriver());
        }

        public void LogoGorunurTest() {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            assertTrue(equals(filizcard.GetQueryCardLogoElement.isDisplayed()));
            filizcard.GetQueryCardLogoElement.click();
        }


    }
