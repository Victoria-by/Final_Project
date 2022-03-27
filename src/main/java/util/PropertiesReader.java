package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertiesReader {

    public static URL getURL(String url) {
        try (InputStream input = new FileInputStream("src/main/resources/apps.properties")) {
            Properties appProps = new Properties();
            appProps.load(input);
            String urlAsString = appProps.getProperty(url);
            return new URL(urlAsString);
        } catch (IOException ex) {
            System.out.println("check apps.properties directory");
            ex.printStackTrace();
            return null;
        }
    }
}
