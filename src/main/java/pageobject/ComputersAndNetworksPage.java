package pageobject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import framework.BasePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;

public class ComputersAndNetworksPage extends BasePage {
    private static final String ACCESSORIES_LINK_XPATH_PATTERN =
            "//*[@class='catalog-navigation-list__aside-title' and contains(text(), '%s') and not (contains(text(), 'Комплектующие для'))]";
    private static final String TABS_LIST_COMPUTERS_NETWORKS_LINK =
            "//*[@class = 'catalog-navigation-list__aside catalog-navigation-list__aside_active']/div[@class = 'catalog-navigation-list__aside-list']/div[contains(@class, 'catalog-navigation-list__aside-item')]/div[contains(@class, 'catalog-navigation-list__aside-title')]";
    private static final String NOTEBOOKS_COMPUTERS_MONITORS_LINK =
            "//*[contains(@class, 'catalog-navigation-list__aside-title') and contains(text(), ' Ноутбуки, компьютеры, мониторы')]";

    public List<String> computersAndNetworksLinks() {
        return $$x(TABS_LIST_COMPUTERS_NETWORKS_LINK).shouldHave(CollectionCondition.sizeGreaterThan(0)).texts();
    }

    public AccessoriesPage clickOnNavigationComputersAndNetworksTabLink(String linkContains) {
        $x(String.format(ACCESSORIES_LINK_XPATH_PATTERN, linkContains))
                .shouldBe(Condition.visible, ofSeconds(20)).click();
        return new AccessoriesPage();
    }

    public void mouseOver() {
        $x(NOTEBOOKS_COMPUTERS_MONITORS_LINK).shouldBe(Condition.visible, ofSeconds(20)).click();
    }
}
