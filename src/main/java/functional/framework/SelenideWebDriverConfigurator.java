package functional.framework;

import com.codeborne.selenide.Configuration;
import functional.framework.factory.LocalWebDriverCreator;
import functional.framework.factory.RemoteWebDriverCreator;

public class SelenideWebDriverConfigurator {

    public void configure() {
        String remoteDriver = System.getProperty("isRemote");
        if (remoteDriver.equals("true")) {
            Configuration.browser = RemoteWebDriverCreator.class.getName();
            return;
        }
        Configuration.browser = LocalWebDriverCreator.class.getName();
    }
}
