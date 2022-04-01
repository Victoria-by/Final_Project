package functional.navigation;

import functional.pageobject.HomePage;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.open;
import static functional.util.PropertiesReader.getURL;

public class OnlinerNavigation {

    protected static final Logger LOG = LoggerFactory.getLogger(OnlinerNavigation.class);

    @Step("Navigate to Onliner home page")
    public static HomePage navigateToOnlinerHomePage() {
        HomePage homePage = new HomePage();
        try {
            open(getURL("baseUrl"));
        } catch (NullPointerException e) {
            LOG.error("No URL found in properties file");
        }
        return homePage;
    }
}
