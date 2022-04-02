package functional.framework;

import com.codeborne.selenide.Configuration;
import functional.framework.factory.LocalWebDriverCreator;
import functional.framework.factory.RemoteWebDriverCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelenideWebDriverConfigurator {

    private static final Logger LOG = LoggerFactory.getLogger(SelenideWebDriverConfigurator.class);

    public void configure() {
        String remoteDriver = System.getProperty("isRemote");
        if (remoteDriver.equals("true")) {
            Configuration.browser = RemoteWebDriverCreator.class.getName();
            LOG.info("Remote connection");
            return;
        }
        LOG.info("Local connection");
        Configuration.browser = LocalWebDriverCreator.class.getName();
    }
}
