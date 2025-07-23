package Hooks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import org.junit.After;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.Driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class hooks {
/*
        @Before
        public void setUp() {
            Driver.getAppiumDriver();  // Her senaryo öncesi Appium session başlatılır
        }

        @After
        public void tearDown() {
            Driver.quitAppiumDriver(); // Her senaryo sonrası session sonlandırılır
        }

 */
@After
public void tearDown() {
    try {
        AndroidDriver driver = (AndroidDriver) Driver.getAppiumDriver();
        if (driver != null) {
            // Chrome'u arka plandan zorla kapat
            driver.executeScript("mobile: shell", Map.of(
                    "command", "am",
                    "args", List.of("force-stop", "com.android.chrome")
            ));
        } Thread.sleep(2000); // Uygulamanın gerçekten kapanması için bekleme
    } catch (Exception e) {
        System.out.println("Chrome kapatma sırasında hata: " + e.getMessage());
    } finally {
        // Appium driver'ı kapat
        Driver.quitAppiumDriver();
    }
}
/*
    @After
    public void tearDown() {
        AppiumDriver driver = Driver.getAppiumDriver();
        if (driver instanceof AndroidDriver) {
            AndroidDriver androidDriver = (AndroidDriver) driver;

            // Chrome’u zorla durdur
            try {
                androidDriver.executeScript("mobile: shell", Map.of(
                        "command", "am",
                        "args", List.of("force-stop", "com.android.chrome")
                ));
                System.out.println("Chrome zorla durduruldu.");
            } catch (Exception e) {
                System.out.println("Chrome force-stop başarısız: " + e.getMessage());
            }
        }
        Driver.quitAppiumDriver(); // Appium oturumu tamamen sonlandırılır
    }

 */
    }




