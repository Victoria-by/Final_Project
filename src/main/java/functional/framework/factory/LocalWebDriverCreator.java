package functional.framework.factory;

import com.codeborne.selenide.WebDriverProvider;
import functional.framework.drivertype.ChromeDriverCreator;
import functional.framework.drivertype.EdgeDriverCreator;
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
            case "edge":
                LOG.info("EdgeDriver was created");
                return new EdgeDriverCreator().create();
            default:
                LOG.info("ChromeDriver was created");
                return new ChromeDriverCreator().create();
        }
    }
}
