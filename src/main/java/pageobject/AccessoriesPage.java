package pageobject;

import framework.BasePage;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$x;

public class AccessoriesPage extends BasePage {
    private static final String PRODUCTS_DESCRIPTIONS_LINK =
            "//*[@class='catalog-navigation-list__aside-title' and contains(text(), 'Комплектующие') " +
                    "and not (contains(text(), 'Комплектующие для'))]//following-sibling::div//span" +
                    "//*[@class='catalog-navigation-list__dropdown-description']";
    private static final String PRODUCTS_NAMES_LINK =
            "//*[@class='catalog-navigation-list__aside-title' and contains(text(), 'Комплектующие') " +
                    "and not (contains(text(), 'Комплектующие для'))]//following-sibling::div" +
                    "[@class='catalog-navigation-list__dropdown']//span" +
                    "//*[contains(@class, 'catalog-navigation-list__dropdown-title')]";

    @Step("Get products names")
    public List<String> getProductsNames() {
        return $$x(PRODUCTS_NAMES_LINK).shouldHave(sizeGreaterThan(0)).texts();
    }

    @Step("Get products descriptions")
    public List<String> getProductsDescription() {
        return $$x(PRODUCTS_DESCRIPTIONS_LINK).shouldHave(sizeGreaterThan(0)).texts();
    }
}

