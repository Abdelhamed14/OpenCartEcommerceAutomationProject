package com.opencart.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends BasePage {

    private final By shoppingCartLink =
            By.cssSelector("a[title='Shopping Cart']");

    private final By emptyCartMessage =
            By.xpath(
                    "//div[@id='content']//p"
                            + "[contains(text(),'Your shopping cart is empty!')]"
            );

    private final By checkoutButton =
            By.xpath(
                    "//div[@id='content']//a"
                            + "[contains(@class,'btn-primary')"
                            + " and normalize-space()='Checkout']"
            );

    public void openShoppingCartPage() {
        try {
            click(shoppingCartLink);
        } catch (ElementClickInterceptedException exception) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    waitForElementToBeVisible(shoppingCartLink)
            );
        }

        wait.until(
                ExpectedConditions.urlContains(
                        "route=checkout/cart"
                )
        );
    }

    public boolean isProductDisplayed(String productName) {
        By productLink = By.xpath(
                "//div[@id='content']"
                        + "//div[contains(@class,'table-responsive')]"
                        + "//a[normalize-space()='"
                        + productName
                        + "']"
        );

        return waitForElementToBeVisible(
                productLink
        ).isDisplayed();
    }

    public void removeProduct(String productName) {
        By productRow = By.xpath(
                "//div[@id='content']//tr"
                        + "[.//a[normalize-space()='"
                        + productName
                        + "']]"
        );

        By removeButton = By.xpath(
                "//div[@id='content']//tr"
                        + "[.//a[normalize-space()='"
                        + productName
                        + "']]"
                        + "//button[contains(@onclick,'cart.remove')]"
        );

        click(removeButton);

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        productRow
                )
        );
    }

    public boolean isCartEmpty() {
        return waitForElementToBeVisible(
                emptyCartMessage
        ).isDisplayed();
    }

    public void proceedToCheckout() {
        click(checkoutButton);
    }
}