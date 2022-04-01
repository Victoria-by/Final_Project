package pageobject;

import com.codeborne.selenide.ElementsCollection;
import framework.BasePage;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$x;

public class AccessoriesPage extends BasePage {
    private final ElementsCollection productsNamesLink =
            $$x("//*[@class='catalog-navigation-list__aside-title' and contains(text(), 'Комплектующие') " +
                    "and not (contains(text(), 'Комплектующие для'))]//following-sibling::div" +
                    "[@class='catalog-navigation-list__dropdown']//span" +
                    "//*[contains(@class, 'catalog-navigation-list__dropdown-title')]");
    private final ElementsCollection productsDescriptionLink =
            $$x("//*[@class='catalog-navigation-list__aside-title' and contains(text(), 'Комплектующие') " +
                    "and not (contains(text(), 'Комплектующие для'))]//following-sibling::div//span" +
                    "//*[@class='catalog-navigation-list__dropdown-description']");

    @Step("Get products names")
    public List<String> getProductsNames() {
        return productsNamesLink.shouldHave(sizeGreaterThan(0)).texts();
    }

    @Step("Get products descriptions")
    public List<String> getProductsDescription() {
        return productsDescriptionLink.shouldHave(sizeGreaterThan(0)).texts();
    }
}

