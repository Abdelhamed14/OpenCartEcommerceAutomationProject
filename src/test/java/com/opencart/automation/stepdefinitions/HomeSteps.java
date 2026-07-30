package com.opencart.automation.stepdefinitions;

import com.opencart.automation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class HomeSteps {

    private HomePage homePage;

    @Given("the user is on the OpenCart home page")
    public void theUserIsOnTheOpenCartHomePage() {
        homePage = new HomePage();

        Assert.assertTrue(
                homePage.isHomePageLoaded(),
                "OpenCart home page did not load successfully"
        );
    }

    @Then("the page title should contain {string}")
    public void thePageTitleShouldContain(String expectedTitle) {
        String actualTitle = homePage.getPageTitle();

        Assert.assertTrue(
                actualTitle.contains(expectedTitle),
                "Expected title to contain: " + expectedTitle
                        + ", but actual title was: " + actualTitle
        );
    }
}