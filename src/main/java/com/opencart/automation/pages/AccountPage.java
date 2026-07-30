package com.opencart.automation.pages;

import org.openqa.selenium.By;

public class AccountPage extends BasePage {

    private final By myAccountMenu =
            By.xpath("//span[contains(text(),'My Account')]");

    private final By logoutLink =
            By.linkText("Logout");

    private final By accountHeading =
            By.xpath("//div[@id='content']/h2[text()='My Account']");

    public void logout() {
        click(myAccountMenu);
        click(logoutLink);
    }

    public boolean isAccountPageDisplayed() {
        return waitForElementToBeVisible(
                accountHeading
        ).isDisplayed();
    }
}