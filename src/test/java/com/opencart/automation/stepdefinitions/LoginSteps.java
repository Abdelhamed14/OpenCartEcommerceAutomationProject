package com.opencart.automation.stepdefinitions;

import com.opencart.automation.pages.AccountPage;
import com.opencart.automation.pages.LoginPage;
import com.opencart.automation.pages.RegistrationPage;
import com.opencart.automation.utils.TestDataGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {

    private static final String PASSWORD = "Test@12345";

    private String registeredEmail;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private AccountPage accountPage;

    @Given("a new user account has been created")
    public void aNewUserAccountHasBeenCreated() {
        registeredEmail =
                TestDataGenerator.generateUniqueEmail();

        registrationPage = new RegistrationPage();
        registrationPage.navigateToRegistrationPage();

        registrationPage.enterRegistrationDetails(
                "Test",
                "Automation",
                registeredEmail,
                "01012345678",
                PASSWORD
        );

        registrationPage.agreeToPrivacyPolicy();
        registrationPage.submitRegistration();

        Assert.assertEquals(
                registrationPage.getSuccessMessage(),
                "Your Account Has Been Created!",
                "Test account could not be created"
        );
    }

    @And("the user logs out of the account")
    public void theUserLogsOutOfTheAccount() {
        accountPage = new AccountPage();
        accountPage.logout();
    }

    @When("the user logs in using the newly registered credentials")
    public void theUserLogsInUsingTheNewlyRegisteredCredentials() {
        loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
        loginPage.login(registeredEmail, PASSWORD);
    }

    @Then("the user should be redirected to the account page")
    public void theUserShouldBeRedirectedToTheAccountPage() {
        accountPage = new AccountPage();

        Assert.assertTrue(
                accountPage.isAccountPageDisplayed(),
                "The user was not redirected to the account page"
        );
    }

    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        loginPage = new LoginPage();
        loginPage.navigateToLoginPage();
    }

    @When("the user logs in with email {string} and password {string}")
    public void theUserLogsInWithInvalidCredentials(
            String email,
            String password
    ) {
        loginPage.login(email, password);
    }

    @Then("a login warning message should be displayed")
    public void aLoginWarningMessageShouldBeDisplayed() {
        String actualMessage =
                loginPage.getWarningMessage();

        Assert.assertTrue(
                actualMessage.contains(
                        "Warning: No match for E-Mail Address and/or Password."
                ),
                "Expected login warning was not displayed. Actual message: "
                        + actualMessage
        );
    }
}