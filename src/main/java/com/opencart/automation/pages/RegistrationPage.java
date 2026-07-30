package com.opencart.automation.pages;

import org.openqa.selenium.By;

public class RegistrationPage extends BasePage {

    private final By myAccountMenu =
            By.xpath("//span[contains(text(),'My Account')]");

    private final By registerLink =
            By.linkText("Register");

    private final By firstNameInput =
            By.id("input-firstname");

    private final By lastNameInput =
            By.id("input-lastname");

    private final By emailInput =
            By.id("input-email");

    private final By telephoneInput =
            By.id("input-telephone");

    private final By passwordInput =
            By.id("input-password");

    private final By confirmPasswordInput =
            By.id("input-confirm");

    private final By privacyPolicyCheckbox =
            By.name("agree");

    private final By continueButton =
            By.cssSelector("input[type='submit'][value='Continue']");

    private final By successMessage =
            By.cssSelector("#content h1");

    public void navigateToRegistrationPage() {
        click(myAccountMenu);
        click(registerLink);
        waitForElementToBeVisible(firstNameInput);
    }

    public void enterRegistrationDetails(
            String firstName,
            String lastName,
            String email,
            String telephone,
            String password
    ) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(emailInput, email);
        type(telephoneInput, telephone);
        type(passwordInput, password);
        type(confirmPasswordInput, password);
    }

    public void agreeToPrivacyPolicy() {
        click(privacyPolicyCheckbox);
    }

    public void submitRegistration() {
        click(continueButton);
    }

    public String getSuccessMessage() {
        return getText(successMessage);
    }
}