package functional.framework.factory;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.net.URL;

import static util.PropertiesReader.*;

public class RemoteWebDriverCreator implements WebDriverProvider {

    private static final Logger LOG = LoggerFactory.getLogger(RemoteWebDriverCreator.class);

    @Nonnull
    @Override
    public RemoteWebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String driverType = System.getProperty("driverType");
        LOG.info("Remote connection, driverType: " + driverType);
        if (driverType != null) {
            capabilities.setBrowserName(driverType);
        } else {
            capabilities.setBrowserName(getConfigProperty("driverType"));
        }
        capabilities.setCapability("os", "Windows");
        capabilities.setCapability("os_version", "10");
        URL gridURL = getConfigURL("gridUrl");
        return new RemoteWebDriver(gridURL, capabilities);
    }
}
