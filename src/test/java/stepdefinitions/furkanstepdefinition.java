package stepdefinitions;

import Page.FurkanPage;
import Page.LoginPage;
import Page.QueryCardPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.OptionsMet;
import utilities.ReusableMethods;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;

public class furkanstepdefinition extends OptionsMet {
    
    QueryCardPage card = new QueryCardPage();
    FurkanPage furkancard = new FurkanPage();
    LoginPage login = new LoginPage();
    Actions actions = new Actions(getAppiumDriver());

    @When("As a user, I want to use the Use email instead option to log in with my email and password.")
    public void switchToEmailLogin() {
        login.emailInsteadClick();
    }

    @When("As a user muss be {string} mail and {string} password Login")
    public void as_a_user_muss_be_mail_and_password_login(String mailAdress, String password) {
        login.mailLogin(mailAdress, password);
    }

    @When("Verifies username {string} in profile")
    public void verifies_username_in_profile(String username) {
        //furkancard.verifiesusername(username);
    }

    @Then("User should be redirected to password reset page")
    public void user_should_be_redirected_to_password_reset_page() {
        ReusableMethods.wait(3);
        // Şifre sıfırlama sayfasının yüklendiğini doğrula
        WebDriverWait wait = new WebDriverWait(Driver.getAppiumDriver(), Duration.ofSeconds(10));
        boolean isPasswordResetPage = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.view.View[contains(@content-desc, 'Reset Password') or contains(@content-desc, 'Şifre Sıfırla')]")
        )).isDisplayed();
        
        Assert.assertTrue("Şifre sıfırlama sayfası yüklenmedi", isPasswordResetPage);
        System.out.println("Şifre sıfırlama sayfasına başarıyla yönlendirildi");
    }
    
    @When("User enters valid phone number {string}")
    public void user_enters_valid_phone_number(String phoneNumber) {
        card.phoneTextBoxClickAndSendKeys(phoneNumber);
        ReusableMethods.wait(1);
        System.out.println("Geçerli telefon numarası girildi: " + phoneNumber);
    }
    
    @When("User enters valid password {string}")
    public void user_enters_valid_password(String password) {
        // Şifre alanına geç ve şifreyi gir
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(password).perform();
        ReusableMethods.wait(1);
        System.out.println("Geçerli şifre girildi");
    }
    
    @When("User clicks login button")
    public void user_clicks_login_button() {
        card.signInLoginClick();
        ReusableMethods.wait(2);
        hideKeyboard();
        System.out.println("Giriş butonuna tıklandı");
    }
    
    @Then("User should see error message for invalid credentials")
    public void user_should_see_error_message_for_invalid_credentials() {
        ReusableMethods.wait(2);
        // Hata mesajının görüntülendiğini doğrula
        WebDriverWait wait = new WebDriverWait(Driver.getAppiumDriver(), Duration.ofSeconds(5));
        boolean isErrorMessageDisplayed = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.view.View[contains(@content-desc, 'Invalid') or contains(@content-desc, 'Hatalı') or contains(@content-desc, 'Error')]")
        )).isDisplayed();
        
        Assert.assertTrue("Hata mesajı görüntülenmedi", isErrorMessageDisplayed);
        System.out.println("Geçersiz kimlik bilgileri için hata mesajı görüntülendi");
    }
    
    @Then("User should remain on login page")
    public void user_should_remain_on_login_page() {
        ReusableMethods.wait(2);
        // Giriş sayfasında kaldığını doğrula - getter metodlarını kullan
        boolean isLoginPage = card.getPhoneTextBox().isDisplayed() && card.getPasswordTextBox().isDisplayed();
        Assert.assertTrue("Kullanıcı giriş sayfasında kalmadı", isLoginPage);
        System.out.println("Kullanıcı giriş sayfasında kaldı");
    }
    
    @When("User clicks on remember me checkbox")
    public void user_clicks_on_remember_me_checkbox() {
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.SPACE).perform();
        ReusableMethods.wait(1);
        System.out.println("Beni hatırla checkbox'ına tıklandı");
    }
    
    @Then("Remember me checkbox should be checked")
    public void remember_me_checkbox_should_be_checked() {
        // Checkbox'ın işaretlendiğini doğrula
        boolean isChecked = card.getRememberMeCheckBox().isSelected();
        Assert.assertTrue("Beni hatırla checkbox'ı işaretlenmedi", isChecked);
        System.out.println("Beni hatırla checkbox'ı işaretlendi");
    }
    
    @When("User clicks on show password icon")
    public void user_clicks_on_show_password_icon() {
        // Şifre göster/gizle ikonu için genel bir tıklama işlemi
        // Bu özellik QueryCardPage'de tanımlı değilse, genel bir yaklaşım kullan
        try {
            // Şifre alanının yanındaki göz ikonuna tıkla
            WebDriverWait wait = new WebDriverWait(Driver.getAppiumDriver(), Duration.ofSeconds(5));
            WebElement showPasswordIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.ImageView[contains(@content-desc, 'Show') or contains(@content-desc, 'Göster')]")
            ));
            showPasswordIcon.click();
            System.out.println("Şifre göster/gizle ikonuna tıklandı");
        } catch (Exception e) {
            System.out.println("Şifre göster/gizle ikonu bulunamadı: " + e.getMessage());
        }
        ReusableMethods.wait(1);
    }
    
    @Then("Password should be visible")
    public void password_should_be_visible() {
        // Şifrenin görünür olduğunu doğrula
        String passwordType = card.getPasswordTextBox().getAttribute("password");
        Assert.assertFalse("Şifre gizli kaldı", "true".equals(passwordType));
        System.out.println("Şifre görünür hale getirildi");
    }
    
    @Then("Password should be hidden")
    public void password_should_be_hidden() {
        // Şifrenin gizli olduğunu doğrula
        String passwordType = card.getPasswordTextBox().getAttribute("password");
        Assert.assertTrue("Şifre görünür kaldı", "true".equals(passwordType));
        System.out.println("Şifre gizli hale getirildi");
    }


    //US13 İçin
    @When("Men Category Visibility and Functionality on Homepage")
    public void homepage_men_category_display(){
        ReusableMethods.wait(1); // Sayfanın yüklenmesini bekle
        furkancard.verifyMenAndMenClothingVisible();
        furkancard.testMenAndMenClothingClickableAndActive();
    }
    @When("Taps on the first product inside the Men category")
    public void tap_first_product_in_men_category(){
        ReusableMethods.wait(1); // Sayfanın yüklenmesini bekle
        furkancard.testFirstProductInMenCategory();
    }
    @When("The user adds the first product to the cart")
    public void add_first_product_to_cart(){
        furkancard.testFirstProductAddToCart();
    }

    @When("User checks and clicks the filter button in Men category")
    public void user_checks_and_clicks_filter_button() {
        furkancard.verifyAndClickFilterButton();
    }

} 