package com.opencart.automation.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By myAccountMenu =
            By.xpath("//span[contains(text(),'My Account')]");

    private final By loginLink =
            By.linkText("Login");

    private final By emailInput =
            By.id("input-email");

    private final By passwordInput =
            By.id("input-password");

    private final By loginButton =
            By.cssSelector("input[type='submit'][value='Login']");

    private final By warningMessage =
            By.cssSelector(".alert-danger");

    public void navigateToLoginPage() {
        click(myAccountMenu);
        click(loginLink);
        waitForElementToBeVisible(emailInput);
    }

    public void login(String email, String password) {
        type(emailInput, email);
        type(passwordInput, password);
        click(loginButton);
    }

    public String getWarningMessage() {
        return getText(warningMessage);
    }
}