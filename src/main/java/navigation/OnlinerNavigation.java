package navigation;

import pageobject.HomePage;
import util.PropertiesReader;

import static com.codeborne.selenide.Selenide.open;

public class OnlinerNavigation {

    public static HomePage navigateToOnlinerHomePage() {
        open(PropertiesReader.getURL("baseUrl"));
        return new HomePage();
    }
}
