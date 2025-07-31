package stepdefinitions;

import Page.TugbaPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class US025 {

    TugbaPage page = new TugbaPage();


    @When("buy a product and pay for it")
    public void buy_a_product_and_pay_for_it() {
      page.buyAProductAndPayForIt();
    }


    @When("manager ships the product")
    public void manager_ships_the_product() {
        manager_ships_the_product();
        ReusableMethods.wait(3);

    }

    @Then("Verify that Return Request Button is displayed")
    public void verify_that_return_request_button_is_displayed() {
       Assert.assertTrue(page.isReturnRequestButtonDisplayed());
    }
    @Then("Verify that the product has been sent")
    public void verify_that_the_product_has_been_sent() {
       Assert.assertTrue(page.returnTheProduct());

    }












    //CHROME ICIN STEPLER SONRA TEKRAR BAKILACAK
//
//    @When("switch to chrome")
//    public void switch_to_chrome_and_deliver_the_product() {
//
//        page.switchToChrome();
//
//    }
//
//    @When("As a user muss be {string} mail and {string} password Login.")
//    public void as_a_user_muss_be_mail_and_password_login(String email, String pass) {
//        ReusableMethods.wait(6);
//        page.getEmail().click();
//        page.getEmail().sendKeys(ConfigReader.getProperty(email));
//        page.getPassword().click();
//        page.getPassword().sendKeys(ConfigReader.getProperty(pass));
//        ReusableMethods.wait(1);
//        page.getSignIn().click();
//
//    }

}
