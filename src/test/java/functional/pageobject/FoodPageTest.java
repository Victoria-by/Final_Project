package functional.pageobject;

import functional.BaseTest;
import functional.navigation.OnlinerNavigation;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureListener;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(AllureListener.class)
@Feature("Search across FoodPage")
public class FoodPageTest extends BaseTest {

    private static FoodPage foodPage;
    private static final String NAME_SHOULD_BE_PRESENT = "Золотой Улей";

    @BeforeAll
    @Description("Navigate to Onliner and click on 'FarmProducts' tab")
    public static void navigateToOnlinerFindFarmProductsTabAndClick() {
        OnlinerNavigation.navigateToOnlinerHomePage()
                .clickOnNavigationHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Еда");
        foodPage = new FoodPage()
                .clickOnFoodPageTabLink("Фермерские продукты");
    }

    @Test
    @Tag("functional")
    @Disabled
    @Description("Test should be skipped")
    @Story("Search across FarmProducts tab elements")
    public void testProductsNamesContainsDefiniteName() {
        assertThat(foodPage.getProductsNames())
                .as("Products names don't contain definite name")
                .anyMatch(e -> e.contains(NAME_SHOULD_BE_PRESENT));
    }
}
