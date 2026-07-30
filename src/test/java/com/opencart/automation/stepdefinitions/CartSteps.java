package com.opencart.automation.stepdefinitions;

import com.opencart.automation.pages.SearchPage;
import com.opencart.automation.pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CartSteps {

    private SearchPage searchPage;
    private ShoppingCartPage shoppingCartPage;

    @And("the user adds {string} to the shopping cart")
    public void theUserAddsProductToTheShoppingCart(
            String productName
    ) {
        searchPage = new SearchPage();
        searchPage.addProductToCart(productName);
    }

    @Then("an add to cart success message should be displayed for {string}")
    public void anAddToCartSuccessMessageShouldBeDisplayed(
            String productName
    ) {
        String actualMessage =
                searchPage.getAddToCartSuccessMessage();

        Assert.assertTrue(
                actualMessage.contains("Success:")
                        && actualMessage.contains(productName)
                        && actualMessage.contains("shopping cart"),
                "Unexpected add to cart message: " + actualMessage
        );
    }

    @And("the shopping cart should contain {string}")
    public void theShoppingCartShouldContain(
            String expectedItemCount
    ) {
        Assert.assertTrue(
                searchPage.doesCartContain(expectedItemCount),
                "Shopping cart does not contain: "
                        + expectedItemCount
        );
    }

    @And("the user opens the shopping cart page")
    public void theUserOpensTheShoppingCartPage() {
        shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.openShoppingCartPage();
    }

    @Then("{string} should be displayed in the shopping cart")
    public void productShouldBeDisplayedInTheShoppingCart(
            String productName
    ) {
        Assert.assertTrue(
                shoppingCartPage.isProductDisplayed(productName),
                "Product was not displayed in shopping cart: "
                        + productName
        );
    }

    @When("the user removes {string} from the shopping cart")
    public void theUserRemovesProductFromTheShoppingCart(
            String productName
    ) {
        shoppingCartPage.removeProduct(productName);
    }

    @Then("the shopping cart should be empty")
    public void theShoppingCartShouldBeEmpty() {
        Assert.assertTrue(
                shoppingCartPage.isCartEmpty(),
                "Shopping cart was not empty"
        );
    }
}