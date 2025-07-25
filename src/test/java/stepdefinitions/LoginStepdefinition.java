package stepdefinitions;

import Page.LoginPage;
import io.cucumber.java.en.When;

public class LoginStepdefinition {
    LoginPage login = new LoginPage();

    //US08
    @When("As a user, I want to use the Use email instead option to log in with my email and password.")
    public void switchToEmailLogin() {
        login.emailInsteadClick();
    }

    @When("As a user muss be {string} mail and {string} password Login")
    public void as_a_user_muss_be_mail_and_password_login(String mailAdress, String password) {
        login.mailLogin(mailAdress, password);
    }
}
