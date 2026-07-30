package com.opencart.automation.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public boolean isHomePageLoaded() {
        return wait.until(
                ExpectedConditions.titleContains("Your Store")
        );
    }
}