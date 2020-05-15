package framework.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyTool {
    private static final String RESOURCES_PATH = "src\\main\\resources\\";
    private static Properties properties;

    private static void readProperties() {
        if (properties == null) {
            properties = new Properties();
        }
        try {
            properties.load(new FileReader(new File(RESOURCES_PATH, "Cookies.properties")));
        } catch (IOException ex) {
        }
    }

    public static String getData(String data) {
        initializeProperties();
        return properties.getProperty(data);
    }

    private static void initializeProperties() {
        if (properties == null) {
            readProperties();
        }
    }
}