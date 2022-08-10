package com.tms.cucumber.steps;

import com.tms.cucumber.pages.LoginPage;
import com.tms.cucumber.context.ScenarioContext;
import com.tms.cucumber.pages.shared.NavigationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();
    NavigationPage navigationPage = new NavigationPage();
    ScenarioContext scenarioContext;

    public LoginSteps(ScenarioContext context) {
        scenarioContext = context;
    }
    @Given("the user visits the TMS website")
    public void theUserVisitsTheTMSWebsite() {
        loginPage.navigate(System.getProperty("LOGIN_URL"));
    }

    @When("the user inputs an account")
    public void theUserInputsAnAccount(List<Map<String, String>> table) {
        String username = table.get(0).get("username");
        String password = table.get(0).get("password");
        if (username!=null) loginPage.inputUsername(username);
        if (password!=null) loginPage.inputPassword(password);
        scenarioContext.setContext("username", username);
    }

    @And("the user clicks on Login button")
    public void theUserClicksOnLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Then("an error message {string} is displayed below password field")
    public void anErrorMessageIsDisplayedBelowPasswordField(String errorMessage) {

        assertThat(
                "Verify error message under password field",
                loginPage.RQR_MSG,
                equalTo(errorMessage)
        );

    }

    @Then("an error message {string} is displayed below username field")
    public void anErrorMessageIsDisplayedBelowUsernameField(String errorMessage) {

        assertThat(
                "Verify error message under username field",
                loginPage.RQR_MSG,
                equalTo(errorMessage)
        );

    }

    @Then("an error message {string} is displayed")
    public void anErrorMessageIsDisplayed(String errorMessage) {

        assertThat(
                "Verify error username or password message",
                loginPage.ERR_MSG,
                equalTo(errorMessage)
        );

    }

    @And("the user is logged into the system with admin account")
    public void theUserIsLoggedIntoTheSystemWithAdminAccount() {
        loginPage.loginWithDefaultAccount();
    }
}
