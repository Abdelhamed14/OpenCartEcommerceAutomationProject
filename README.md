# OpenCart E-commerce Automation Project

[![OpenCart UI Automation Tests](https://github.com/Abdelhamed14/OpenCartEcommerceAutomationProject/actions/workflows/ui-tests.yml/badge.svg)](https://github.com/Abdelhamed14/OpenCartEcommerceAutomationProject/actions/workflows/ui-tests.yml)

An end-to-end UI automation framework for testing an OpenCart e-commerce website using Java, Selenium WebDriver, Cucumber BDD, TestNG, Maven, Allure Report, and GitHub Actions.

## Project Overview

This project automates essential customer journeys within an OpenCart e-commerce application. It follows the Page Object Model design pattern and uses Cucumber to describe test scenarios in a clear, business-readable format.

Target website: [OpenCart Demo](https://tutorialsninja.com/demo/)

## Technologies and Tools

- Java 22
- Selenium WebDriver
- Cucumber BDD
- TestNG
- Maven
- Page Object Model
- Allure Report
- Git and GitHub
- GitHub Actions
- IntelliJ IDEA

## Automated Test Scenarios

- Verify the home page loads successfully
- Register a new customer account
- Log in using valid credentials
- Validate invalid login attempts
- Search for an existing product
- Search for a non-existing product
- Add a product to the shopping cart
- Verify the product inside the cart
- Remove a product from the cart
- Open and validate a product page
- Proceed to the checkout page

## Framework Features

- Cucumber feature files written in Gherkin
- Page Object Model architecture
- Reusable Selenium page methods
- Thread-safe WebDriver management
- Dynamic test data generation
- Cross-browser support
- Headless browser execution
- Automatic screenshots when scenarios fail
- Cucumber HTML and JSON reports
- Allure test reporting
- Continuous integration using GitHub Actions
- Test execution using Cucumber tags

## Project Structure

```text
OpenCartEcommerceAutomationProject
├── .github
│   └── workflows
│       └── ui-tests.yml
├── src
│   ├── main
│   │   └── java
│   │       └── com.opencart.automation
│   │           ├── factory
│   │           ├── pages
│   │           └── utils
│   └── test
│       ├── java
│       │   └── com.opencart.automation
│       │       ├── hooks
│       │       ├── runners
│       │       └── stepdefinitions
│       └── resources
│           ├── features
│           ├── allure.properties
│           └── config.properties
├── .gitignore
├── pom.xml
└── README.md
```

## Prerequisites

Make sure the following tools are installed:

- Java JDK 22
- Apache Maven
- Google Chrome, Microsoft Edge, or Mozilla Firefox
- Git

## Clone the Repository

```bash
git clone https://github.com/Abdelhamed14/OpenCartEcommerceAutomationProject.git
cd OpenCartEcommerceAutomationProject
```

## Run the Tests

Run all tests with the browser visible:

```bash
mvn clean test
```

Run all tests in headless mode:

```bash
mvn clean test -Dheadless=true
```

Run using a specific browser:

```bash
mvn clean test -Dbrowser=edge
```

Run scenarios using a Cucumber tag:

```bash
mvn clean test -Dcucumber.filter.tags="@smoke"
```

## Test Reports

### Cucumber Report

After running the tests, open:

```text
target/cucumber-reports/cucumber-report.html
```

### Allure Report

Generate and open the Allure report using:

```bash
mvn allure:serve
```

## Continuous Integration

The GitHub Actions workflow automatically:

1. Checks out the project.
2. Sets up Java 22.
3. runs the Cucumber tests in headless mode.
4. Uploads the Allure results.
5. Uploads the Cucumber and Surefire reports.

The workflow runs on:

- Pushes to the `main` branch
- Pull requests targeting `main`
- Manual execution using `workflow_dispatch`

## Author

**Abdelhamed Ahmed**

- GitHub: [@Abdelhamed14](https://github.com/Abdelhamed14)
