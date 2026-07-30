package com.opencart.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    private final By checkoutHeading =
            By.cssSelector("#content h1");

    public boolean isCheckoutPageDisplayed() {
        return wait.until(
                ExpectedConditions.textToBePresentInElementLocated(
                        checkoutHeading,
                        "Checkout"
                )
        );
    }
}