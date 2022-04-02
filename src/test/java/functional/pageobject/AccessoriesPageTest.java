package functional.pageobject;

import functional.BaseTest;
import functional.navigation.OnlinerNavigation;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureListener;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(AllureListener.class)
@Feature("Search across AccessoriesPage")
public class AccessoriesPageTest extends BaseTest {

    private static AccessoriesPage accessoriesPage;

    @BeforeAll
    @Description("Navigate to Onliner and click on 'Accessories' tab")
    public static void navigateToOnlinerFindAccessoriesTabAndClick() {
        OnlinerNavigation.navigateToOnlinerHomePage()
                .clickOnNavigationHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры");
        accessoriesPage = new ComputersAndNetworksPage()
                .clickOnComputersAndNetworksTabLink("Комплектующие");
    }

    @Test
    @Description("Test all elements contain name")
    @Story("Search across AccessoriesPage tab elements")
    public void testAllElementsContainName() {
        assertThat(accessoriesPage.getProductsNames())
                .as("Not all products contain name")
                .allMatch(e -> !e.isEmpty());
    }

    @Test
    @Description("Test all elements contain quantity")
    @Story("Search across AccessoriesPage tab elements")
    public void testAllElementsContainQuantity() {
        assertThat(accessoriesPage.getProductsDescription())
                .as("Not all products contain quantity")
                .allMatch(e -> e.contains("товар"));
    }

    @Test
    @Description("Test all elements contain price")
    @Story("Search across AccessoriesPage tab elements")
    public void testAllElementsContainPrice() {
        assertThat(accessoriesPage.getProductsDescription())
                .as("Not all products contain price")
                .allMatch(e -> e.contains("р."));
    }

    @Test
    @Description("Test should be failed")
 //   @Story("Search across AccessoriesPage tab elements")
    public void testNoElementsContainPrice() {
        assertThat(accessoriesPage.getProductsDescription())
                .as("Not all products contain price")
                .noneMatch(e -> e.contains("р."));
    }
}
