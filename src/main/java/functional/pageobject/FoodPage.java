package functional.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class FoodPage {

    private final String FOOD_PAGE_TAB_LINK_XPATH_PATTERN =
            "//*[@class = 'catalog-navigation-list__aside-title' and contains(text(), '%s')]";
    private final ElementsCollection productsNamesLink =
            $$x("//*[@class='catalog-navigation-list__aside-title'" +
                    " and contains(text(), 'Фермерские продукты')]" +
                    "//following-sibling::div[@class='catalog-navigation-list__dropdown']" +
                    "//span//*[contains(@class, 'catalog-navigation-list__dropdown-title')]");

    @Step("Click on tab {linkContains}")
    public FoodPage clickOnFoodPageTabLink(String linkContains) {
        $x(format(FOOD_PAGE_TAB_LINK_XPATH_PATTERN, linkContains))
                .shouldBe(Condition.visible, ofSeconds(20)).click();
        return this;
    }

    @Step("Get products names")
    public List<String> getProductsNames() {
        return productsNamesLink.shouldHave(sizeGreaterThan(0)).texts();
    }
}
