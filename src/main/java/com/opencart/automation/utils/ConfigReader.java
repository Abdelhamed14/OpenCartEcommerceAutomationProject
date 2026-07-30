package com.opencart.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream =
                     ConfigReader.class.getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (inputStream == null) {
                throw new IllegalStateException(
                        "config.properties file was not found"
                );
            }

            properties.load(inputStream);

        } catch (IOException exception) {
            throw new RuntimeException(
                    "Failed to load config.properties",
                    exception
            );
        }
    }

    private ConfigReader() {
    }

    public static String getProperty(String key) {
        String value = System.getProperty(
                key,
                properties.getProperty(key)
        );

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "Property not found: " + key
            );
        }

        return value.trim();
    }
}