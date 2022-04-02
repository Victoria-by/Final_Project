package functional.framework.factory;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.URL;

import static functional.util.PropertiesReader.*;

public class RemoteWebDriverCreator implements WebDriverProvider {

    @Nonnull
    @Override
    public RemoteWebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String driverType = System.getProperty("driverType");
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
