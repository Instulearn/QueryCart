package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.NoSuchSessionException;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;


public class             Driver {
    private Driver() {
    }

    private static AppiumDriver driver;

    public static AppiumDriver getAppiumDriver() {


        /*  Gercek cihaz icin url "http:0.0.0.0:4723/wd/hub";
             Emilator cihaz icin url "http:127.0.0.1:4723/wd/hub";
         *******   Driver null olduğunda telefonumuza ait özellikleri hazırlarız
         */
        if (driver == null) {
            switch (ConfigReader.getProperty("platformName")) {
                case "Android":
                    UiAutomator2Options options = new UiAutomator2Options();
                    options.setPlatformName("Android").setAutomationName("UiAutomator2");
                    options.setApp(System.getProperty("user.dir") + ConfigReader.getProperty("apk"));
                    options.setAppPackage("com.wise.querycart");
                    options.setAppActivity("com.wise.querycart.MainActivity");
                    options.setUdid("emulator-5554");
                    options.setNoReset(false);
                    options.autoGrantPermissions();
                    options.setNewCommandTimeout(Duration.ofSeconds(20));
                    try {
                        driver = new AndroidDriver(
                                new URL("http://0.0.0.0:4723"), options
                        );
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    } catch (NoSuchSessionException e){
                        System.out.println("No session exception occurred: " + e.getMessage());
                        Driver.quitAppiumDriver(); // Mevcut driver oturumunu kapat
                        Driver.getAppiumDriver(); // Yeni driver başlat
                    }


                    break;
                case "IOS":

                    break;
                default:
                    throw new RuntimeException("Desteklenmeyen Platform");
            }
        }

        /*
         * Her test basinda uygulamanin sifirlanmasini ve en bastan olmasini saglar.
         * NoReset=true olursa uygulama kaldigi noktadan devam eder
         */

        return driver;
    }
    public static void startActivity(String appPackage, String appActivity, boolean noReset) {
        if (getAppiumDriver() instanceof AndroidDriver) {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android").setAutomationName("UiAutomator2");
            options.setAppPackage(appPackage);
            options.setAppActivity(appActivity);
            options.setNoReset(noReset); // noReset ayarı
            options.setUdid("emulator-5554");

            try {
                // Mevcut sürücüyle yeni bir aktivite başlatılıyor
                ((AndroidDriver) getAppiumDriver()).startActivity(
                        new io.appium.java_client.android.Activity(appPackage, appActivity)
                );
            } catch (Exception e) {
                throw new RuntimeException("Aktivite başlatılamadı: " + e.getMessage());
            }
        } else {
            throw new UnsupportedOperationException("Bu özellik yalnızca Android cihazlar için geçerlidir.");
        }
    }

    public static void terminateChrome() {
        if (driver != null) {
            try {
                ((AndroidDriver) driver).terminateApp("com.android.chrome");
            } catch (Exception e) {
                System.out.println("Chrome kapatılamadı: " + e.getMessage());
            }
        }
    }

    public static void quitAppiumDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
