package com.opencart.automation.stepdefinitions;

import com.opencart.automation.pages.ProductPage;
import com.opencart.automation.pages.SearchPage;
import io.cucumber.java.en.And;
import org.testng.Assert;

public class ProductSteps {

    private ProductPage productPage;

    @And("the user opens the product {string}")
    public void theUserOpensTheProduct(String productName) {
        SearchPage searchPage = new SearchPage();
        searchPage.openProduct(productName);

        productPage = new ProductPage();

        Assert.assertTrue(
                productPage.isProductPageDisplayed(productName),
                "Product page was not displayed: " + productName
        );
    }

    @And("the user adds the product to the cart from the product page")
    public void theUserAddsTheProductFromTheProductPage() {
        productPage.addProductToCart();
    }
}