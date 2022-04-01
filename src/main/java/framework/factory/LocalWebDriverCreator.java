package framework.factory;

import com.codeborne.selenide.WebDriverProvider;
import framework.drivertype.ChromeDriverCreator;
import framework.drivertype.FirefoxDriverCreator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

public class LocalWebDriverCreator implements WebDriverProvider {

    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        String driverType = System.getProperty("driverType");
        switch (driverType) {
            case "firefox":
                // не смогла по-другому поднять firefox, таким способом поднимает только локально
                // удаленно SessionNotCreatedException, я не поняла, как решить эту проблему
                System.setProperty("webdriver.firefox.bin", "C:\\Users\\HUAWEI\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
                System.out.println("SOS");
                return new FirefoxDriverCreator().create();
            default:
                return new ChromeDriverCreator().create();
        }
    }
}
