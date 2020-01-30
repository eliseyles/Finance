package by.training.finance.controller.responcevalue;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class StringProperty {
    private static Properties properties;
    static {
        properties = new Properties();
        try {
            properties.load(new FileReader("./src/main/resources/controllerString.properties"));
        } catch (IOException e) {
            System.err.println("Internal Error: property file not found");
            //todo fix this catching
            //todo think about enum vs property file
        }
    }

    public static String getStringValue(String key){
        return properties.getProperty(key);
    }
}
