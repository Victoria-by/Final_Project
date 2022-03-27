package pageobject;

import com.codeborne.selenide.Condition;
import framework.BasePage;

import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class HomePage extends BasePage {
    private static final String NAVIGATION_LINK_XPATH_PATTERN =
            "//*[contains(@class, 'b-main-navigation__text') and contains(text(), '%s')]";

    public CatalogPage clickOnNavigationHeaderLink(String linkContains) {
        $x(String.format(NAVIGATION_LINK_XPATH_PATTERN, linkContains))
                .shouldBe(Condition.visible, ofSeconds(20)).click();
        return new CatalogPage();
    }
}
