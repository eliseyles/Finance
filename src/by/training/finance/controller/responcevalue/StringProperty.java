package by.training.finance.controller.responcevalue;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class StringProperty {
    private static Properties properties;
    static {
        properties = new Properties();
        try {
            properties.load(new FileReader("src/by/training/finance/controller/responcevalue/controllerString.properties"));
        } catch (IOException ignored) {
        }
    }

    public static String getStringValue(String key){
        return properties.getProperty(key);
    }
}
