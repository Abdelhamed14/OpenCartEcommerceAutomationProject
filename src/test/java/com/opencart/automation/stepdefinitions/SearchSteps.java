package com.opencart.automation.stepdefinitions;

import com.opencart.automation.pages.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SearchSteps {

    private SearchPage searchPage;

    @When("the user searches for the product {string}")
    public void theUserSearchesForTheProduct(String productName) {
        searchPage = new SearchPage();
        searchPage.searchForProduct(productName);
    }

    @Then("the search results should display {string}")
    public void theSearchResultsShouldDisplay(
            String expectedProductName
    ) {
        Assert.assertTrue(
                searchPage.isProductDisplayed(expectedProductName),
                "Product was not displayed in search results: "
                        + expectedProductName
        );
    }

    @Then("a no products found message should be displayed")
    public void aNoProductsFoundMessageShouldBeDisplayed() {
        String actualMessage =
                searchPage.getNoProductsMessage();

        Assert.assertTrue(
                actualMessage.contains(
                        "There is no product that matches the search criteria."
                ),
                "Unexpected message displayed: " + actualMessage
        );
    }
}