package com.opencart.automation.stepdefinitions;

import com.opencart.automation.pages.CheckoutPage;
import com.opencart.automation.pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CheckoutSteps {

    private CheckoutPage checkoutPage;

    @And("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        ShoppingCartPage shoppingCartPage =
                new ShoppingCartPage();

        shoppingCartPage.proceedToCheckout();
        checkoutPage = new CheckoutPage();
    }

    @Then("the checkout page should be displayed")
    public void theCheckoutPageShouldBeDisplayed() {
        Assert.assertTrue(
                checkoutPage.isCheckoutPageDisplayed(),
                "Checkout page was not displayed"
        );
    }
}