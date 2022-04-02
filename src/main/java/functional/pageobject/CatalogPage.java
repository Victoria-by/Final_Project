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

public class CatalogPage extends BasePage {
    private final ElementsCollection catalogLinks =
            $$x("//*[@class = 'catalog-navigation-classifier__item ']");
    private static final String CATALOG_SECTION_LINK_XPATH_PATTERN =
            "//*[@class = 'catalog-navigation-classifier__item-title-wrapper' and contains(text(), '%s')]";

    @Step("Get texts from catalog links")
    public List<String> getCatalogLinks() {
        return catalogLinks.shouldHave(CollectionCondition.sizeGreaterThan(0)).texts();
    }

    @Step("Click on tab {linkContains}")
    public void clickOnCatalogSectionLink(String linkContains) {
        $x(format(CATALOG_SECTION_LINK_XPATH_PATTERN, linkContains))
                .shouldBe(Condition.visible, ofSeconds(20)).click();
    }
}
