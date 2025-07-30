package stepdefinitions;

import Page.LoginPage;
import io.cucumber.java.en.When;
import utilities.ReusableMethods;

public class LoginStepdefinition {
    LoginPage login = new LoginPage();

    @When("As a user, I want to use the Use email instead option to log in with my email and password.")
    public void switchToEmailLogin() {
        login.emailInsteadClick();
    }

    @When("As a Manager, I want to use the Use email instead option to log in with my email and password.")
    public void switchToManagerMailLogin() {
        login.emailInsteadClick();
    }

    @When("As a user muss be {string} mail and {string} password Login")
    public void as_a_user_muss_be_mail_and_password_login(String mailAdress, String password) {
        login.mailLogin(mailAdress, password);
        ReusableMethods.wait(3);
    }
    @When("As a manager muss be {string} mail and {string} password Login")
    public void as_a_manager_muss_be_mail_and_password_login(String mailAdress, String password) {
        login.mailLogin(mailAdress, password);
    }
}
