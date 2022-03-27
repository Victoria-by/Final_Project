package framework.factory;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.PropertiesReader;

import javax.annotation.Nonnull;
import java.net.URL;

public class RemoteWebDriverCreator implements WebDriverProvider {

    @Override
    public RemoteWebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String driverType = System.getProperty("driverType");
        capabilities.setBrowserName(driverType);
        capabilities.setCapability("os", "Windows");
        capabilities.setCapability("os_version", "10");
        URL gridURL = PropertiesReader.getURL("gridUrl");
        return new RemoteWebDriver(gridURL, capabilities);
    }
}
