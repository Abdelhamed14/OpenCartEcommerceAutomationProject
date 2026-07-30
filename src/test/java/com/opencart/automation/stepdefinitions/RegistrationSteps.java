package com.opencart.automation.stepdefinitions;

import com.opencart.automation.pages.RegistrationPage;
import com.opencart.automation.utils.TestDataGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RegistrationSteps {

    private RegistrationPage registrationPage;

    @Given("the user navigates to the registration page")
    public void theUserNavigatesToTheRegistrationPage() {
        registrationPage = new RegistrationPage();
        registrationPage.navigateToRegistrationPage();
    }

    @When("the user enters valid registration details")
    public void theUserEntersValidRegistrationDetails() {
        String uniqueEmail =
                TestDataGenerator.generateUniqueEmail();

        registrationPage.enterRegistrationDetails(
                "Test",
                "Automation",
                uniqueEmail,
                "01012345678",
                "Test@12345"
        );
    }

    @And("the user agrees to the privacy policy")
    public void theUserAgreesToThePrivacyPolicy() {
        registrationPage.agreeToPrivacyPolicy();
    }

    @And("the user submits the registration form")
    public void theUserSubmitsTheRegistrationForm() {
        registrationPage.submitRegistration();
    }

    @Then("the account should be created successfully")
    public void theAccountShouldBeCreatedSuccessfully() {
        String expectedMessage =
                "Your Account Has Been Created!";

        String actualMessage =
                registrationPage.getSuccessMessage();

        Assert.assertEquals(
                actualMessage,
                expectedMessage,
                "Account registration was not successful"
        );
    }
}