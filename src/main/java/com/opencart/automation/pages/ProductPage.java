package com.opencart.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;

public class ProductPage extends BasePage {

    private final By productHeading =
            By.cssSelector("#content h1");

    private final By deliveryDateInput =
            By.cssSelector("input[id^='input-option']");

    private final By addToCartButton =
            By.id("button-cart");

    private final By successMessage =
            By.cssSelector(".alert-success");

    public boolean isProductPageDisplayed(String productName) {
        return wait.until(
                ExpectedConditions.textToBePresentInElementLocated(
                        productHeading,
                        productName
                )
        );
    }

    public void addProductToCart() {
        WebElement deliveryDate =
                waitForElementToBeVisible(deliveryDateInput);

        String currentDate =
                deliveryDate.getAttribute("value");

        if (currentDate == null || currentDate.isBlank()) {
            String futureDate = LocalDate.now()
                    .plusDays(7)
                    .toString();

            type(deliveryDateInput, futureDate);
        }

        click(addToCartButton);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        successMessage
                )
        );
    }
}