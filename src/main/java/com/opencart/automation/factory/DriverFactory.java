package com.opencart.automation.factory;

import com.opencart.automation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static void initializeDriver() {
        String browser = ConfigReader
                .getProperty("browser")
                .toLowerCase();

        boolean headless = Boolean.parseBoolean(
                ConfigReader.getProperty("headless")
        );

        WebDriver webDriver;

        switch (browser) {
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();

                if (headless) {
                    options.addArguments(
                            "--headless=new",
                            "--window-size=1920,1080"
                    );
                }

                webDriver = new ChromeDriver(options);
            }

            case "edge" -> {
                EdgeOptions options = new EdgeOptions();

                if (headless) {
                    options.addArguments(
                            "--headless=new",
                            "--window-size=1920,1080"
                    );
                }

                webDriver = new EdgeDriver(options);
            }

            case "firefox" -> {
                FirefoxOptions options = new FirefoxOptions();

                if (headless) {
                    options.addArguments("-headless");
                }

                webDriver = new FirefoxDriver(options);
            }

            default -> throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
            );
        }

        webDriver.manage()
                .timeouts()
                .pageLoadTimeout(Duration.ofSeconds(30));

        if (!headless) {
            webDriver.manage().window().maximize();
        }

        driver.set(webDriver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}