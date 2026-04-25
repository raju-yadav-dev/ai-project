package com.example.chatbot.update;

import java.io.InputStream;
import java.util.Properties;

/**
 * Loads the current app version from the bundled version.properties file.
 */
public final class VersionProperties {
    private static final String RESOURCE_PATH = "/version.properties";

    private VersionProperties() {
    }

    public static String getCurrentVersion() {
        Properties props = new Properties();
        try (InputStream input = VersionProperties.class.getResourceAsStream(RESOURCE_PATH)) {
            if (input != null) {
                props.load(input);
                String value = props.getProperty("version", "0.0.0");
                return value.trim();
            }
        } catch (Exception ex) {
            // Ignore and fall back to default.
        }
        return "0.0.0";
    }
}
