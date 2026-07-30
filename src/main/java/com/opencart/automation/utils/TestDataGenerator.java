package com.opencart.automation.utils;

import java.util.UUID;

public final class TestDataGenerator {

    private TestDataGenerator() {
    }

    public static String generateUniqueEmail() {
        String uniqueValue = UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 10);

        return "testuser_" + uniqueValue + "@example.com";
    }
}