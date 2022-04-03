package functional.pageobject;

import com.codeborne.selenide.Condition;
import functional.framework.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class HomePage extends BasePage {
    private static final String NAVIGATION_LINK_XPATH_PATTERN =
            "//*[contains(@class, 'b-main-navigation__text') and contains(text(), '%s')]";

    private static final String SECTION_BUTTON_XPATH_PATTERN = "//*[contains(@class, 'project-navigation__sign')" +
            " and contains(text(), '%s')]";

    @Step("Click on header tab {linkContains}")
    public CatalogPage clickOnNavigationHeaderLink(String linkContains) {
        $x(format(NAVIGATION_LINK_XPATH_PATTERN, linkContains))
                .shouldBe(Condition.visible, ofSeconds(20)).click();
        return new CatalogPage();
    }

    @Step("Click on section tab {linkContains}")
    public void clickOnSectionButton(String linkContains) {
        $x(format(SECTION_BUTTON_XPATH_PATTERN, linkContains))
                .shouldBe(Condition.visible, ofSeconds(20)).click();
    }
}
