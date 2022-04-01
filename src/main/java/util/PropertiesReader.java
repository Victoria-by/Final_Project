package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertiesReader {
    protected static final Logger LOG = LoggerFactory.getLogger(PropertiesReader.class);

    public static URL getURL(String url) {
        try (InputStream input = new FileInputStream("src/main/resources/apps.properties")) {
            Properties appProps = new Properties();
            appProps.load(input);
            String urlAsString = appProps.getProperty(url);
            return new URL(urlAsString);
        } catch (IOException ex) {
            LOG.error("Check directory to the properties file");
            ex.printStackTrace();
            return null;
        }
    }

    public static String getProperty(String property){
        try (InputStream input = new FileInputStream("src/main/resources/apps.properties")) {
            Properties appProps = new Properties();
            appProps.load(input);
            return appProps.getProperty(property);
        } catch (IOException ex) {
            LOG.error("Check directory to the properties file");
            ex.printStackTrace();
            return null;
        }
    }
}
