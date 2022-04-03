package functional.framework.factory;

import com.codeborne.selenide.WebDriverProvider;
import functional.framework.drivertype.ChromeDriverCreator;
import functional.framework.drivertype.EdgeDriverCreator;
import functional.framework.drivertype.FirefoxDriverCreator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;

public class LocalWebDriverCreator implements WebDriverProvider {

    private static final Logger LOG = LoggerFactory.getLogger(LocalWebDriverCreator.class);

    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        String driverType = System.getProperty("driverType");
        switch (driverType) {
            case "MicrosoftEdge":
                LOG.info("Local connection, EdgeDriver was created");
                return new EdgeDriverCreator().create();
            case "firefox":
                LOG.info("Local connection, FirefoxDriver was created");
                return new FirefoxDriverCreator().create();
            default:
                LOG.info("Local connection, ChromeDriver was created");
                return new ChromeDriverCreator().create();
        }
    }
}
