package com.opencart.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends BasePage {

    private final By searchInput =
            By.name("search");

    private final By searchButton =
            By.cssSelector("#search button");

    private final By productNames =
            By.cssSelector(".product-thumb h4 a");

    private final By noProductsMessage =
            By.xpath(
                    "//div[@id='content']//p[contains(text(),"
                            + "'There is no product that matches')]"
            );

    private final By successMessage =
            By.cssSelector(".alert-success");

    private final By cartTotal =
            By.id("cart-total");

    public void searchForProduct(String productName) {
        type(searchInput, productName);
        click(searchButton);
    }

    public boolean isProductDisplayed(String expectedProductName) {
        return wait.until(webDriver -> {
            List<WebElement> products =
                    webDriver.findElements(productNames);

            return products.stream()
                    .anyMatch(product ->
                            product.getText()
                                    .contains(expectedProductName)
                    );
        });
    }

    public String getNoProductsMessage() {
        return getText(noProductsMessage);
    }

    public void openProduct(String productName) {
        By productLink = By.xpath(
                "//div[contains(@class,'product-thumb')]"
                        + "//h4/a[normalize-space()='"
                        + productName
                        + "']"
        );

        click(productLink);
    }

    public void addProductToCart(String productName) {
        By addToCartButton = By.xpath(
                "//div[contains(@class,'product-thumb')]"
                        + "[.//h4/a[normalize-space()='"
                        + productName
                        + "']]"
                        + "//button[contains(@onclick,'cart.add')]"
        );

        click(addToCartButton);

        wait.until(
                ExpectedConditions.textToBePresentInElementLocated(
                        successMessage,
                        productName
                )
        );
    }

    public String getAddToCartSuccessMessage() {
        return getText(successMessage);
    }

    public boolean doesCartContain(String expectedItemCount) {
        return wait.until(
                ExpectedConditions.textToBePresentInElementLocated(
                        cartTotal,
                        expectedItemCount
                )
        );
    }
}