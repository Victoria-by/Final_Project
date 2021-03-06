package functional.pageobject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import functional.framework.BasePage;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class ComputersAndNetworksPage extends BasePage {
    private static final String COMPUTERS_AND_NETWORKS_TAB_LINK_XPATH_PATTERN =
            "//*[@class='catalog-navigation-list__aside-title' and contains(text(), '%s') " +
                    "and not (contains(text(), 'Комплектующие для'))]";
    private final ElementsCollection computersAndNetworksLinks =
            $$x("//*[@class = 'catalog-navigation-list__aside catalog-navigation-list__aside_active']" +
                    "/div[@class = 'catalog-navigation-list__aside-list']" +
                    "/div[contains(@class, 'catalog-navigation-list__aside-item')]" +
                    "/div[contains(@class, 'catalog-navigation-list__aside-title')]");
    private static final String NOTEBOOKS_COMPUTERS_MONITORS_LINK =
            "//*[contains(@class, 'catalog-navigation-list__aside-title')" +
                    " and contains(text(), ' Ноутбуки, компьютеры, мониторы')]";

    @Step("Get texts from computers and networks links")
    public List<String> getComputersAndNetworksLinks() {
        return computersAndNetworksLinks.shouldHave(CollectionCondition.sizeGreaterThan(0)).texts();
    }

    @Step("Click on tab {linkContains}")
    public AccessoriesPage clickOnComputersAndNetworksTabLink(String linkContains) {
        $x(format(COMPUTERS_AND_NETWORKS_TAB_LINK_XPATH_PATTERN, linkContains))
                .shouldBe(Condition.visible, ofSeconds(20)).click();
        return new AccessoriesPage();
    }

    @Step("Click on the first tab of section")
    public ComputersAndNetworksPage clickOnTheFirstTabOfSection() {
        $x(NOTEBOOKS_COMPUTERS_MONITORS_LINK).shouldBe(Condition.visible, ofSeconds(20)).click();
        return this;
    }
}
