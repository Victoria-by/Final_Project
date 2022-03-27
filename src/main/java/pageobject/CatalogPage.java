package pageobject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import framework.BasePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class CatalogPage extends BasePage {
    private static final String TAB_LIST_CATALOG_LINK = "//*[@class = 'catalog-navigation-classifier__item ']";
    private static final String COMPUTERS_NETWORKS_LINK =
            "//*[@class = 'catalog-navigation-classifier__item-title-wrapper' and contains(text(), '%s')]";

    public static List<String> catalogLinks() {
        return $$x(TAB_LIST_CATALOG_LINK).shouldHave(CollectionCondition.sizeGreaterThan(0)).texts();
    }

    public ComputersAndNetworksPage clickOnNavigationCatalogTabLink(String linkContains) {
        $x(String.format(COMPUTERS_NETWORKS_LINK, linkContains))
                .shouldBe(Condition.visible, ofSeconds(20)).click();
        return new ComputersAndNetworksPage();
    }
}
