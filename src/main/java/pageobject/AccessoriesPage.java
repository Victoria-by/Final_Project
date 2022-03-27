package pageobject;

import com.codeborne.selenide.CollectionCondition;
import framework.BasePage;

import java.util.List;

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

    public List<String> findProductsNames() {
        return $$x(PRODUCTS_NAMES_LINK).shouldHave(CollectionCondition.sizeGreaterThan(0)).texts();
    }

    public List<String> findProductsDescription() {
        return $$x(PRODUCTS_DESCRIPTIONS_LINK).shouldHave(CollectionCondition.sizeGreaterThan(0)).texts();
    }
}

