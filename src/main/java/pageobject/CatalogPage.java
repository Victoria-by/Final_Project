package pageobject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import framework.BasePage;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class CatalogPage extends BasePage {
    private static final String TAB_LIST_CATALOG_LINK = "//*[@class = 'catalog-navigation-classifier__item ']";
    private static final String COMPUTERS_NETWORKS_LINK_XPATH_PATTERN =
            "//*[@class = 'catalog-navigation-classifier__item-title-wrapper' and contains(text(), '%s')]";

    @Step("Get texts from catalog links")
    public List<String> getCatalogLinks() {
        return $$x(TAB_LIST_CATALOG_LINK).shouldHave(CollectionCondition.sizeGreaterThan(0)).texts();
    }

    @Step("Click on tab {linkContains}")
    public ComputersAndNetworksPage clickOnNavigationCatalogTabLink(String linkContains) {
        $x(format(COMPUTERS_NETWORKS_LINK_XPATH_PATTERN, linkContains))
                .shouldBe(Condition.visible, ofSeconds(20)).click();
        return new ComputersAndNetworksPage();
    }
}
