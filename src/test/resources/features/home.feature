@smoke @home
Feature: OpenCart Home Page

  Scenario: Verify that the home page loads successfully
    Given the user is on the OpenCart home page
    Then the page title should contain "Your Store"