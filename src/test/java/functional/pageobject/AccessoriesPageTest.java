package functional.pageobject;

import io.qameta.allure.Description;
import listeners.AllureListener;
import functional.navigation.OnlinerNavigation;
import functional.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(AllureListener.class)
public class AccessoriesPageTest extends BaseTest {
    private static AccessoriesPage accessoriesPage;

    @BeforeAll
    @Description("Navigate to Onliner and click on 'Accessories' tab")
    public static void navigateToOnlinerFindAccessoriesTabAndClick() {
        accessoriesPage = OnlinerNavigation.navigateToOnlinerHomePage()
                .clickOnNavigationHeaderLink("Каталог")
                .clickOnNavigationCatalogTabLink("Компьютеры")
                .clickOnNavigationComputersAndNetworksTabLink("Комплектующие");
    }

    @Test
    @Description("Test all elements contain name")
    public void testAllElementsContainName() {
        assertThat(accessoriesPage.getProductsNames())
                .as("Not all products contain name")
                .allMatch(e -> !e.isEmpty());
    }

    @Test
    @Description("Test all elements contain quantity")
    public void testAllElementsContainQuantity() {
        assertThat(accessoriesPage.getProductsDescription())
                .as("Not all products contain quantity")
                .allMatch(e -> e.contains("товар"));
    }

    @Test
    @Description("Test all elements contain price")
    public void testAllElementsContainPrice() {
        assertThat(accessoriesPage.getProductsDescription())
                .as("Not all products contain price")
                .allMatch(e -> e.contains("р."));
    }

    @Test
    @Description("Test should be failed")
    public void testShouldBeFailed() {
        assertThat(accessoriesPage.getProductsDescription())
                .as("Not all products contain price")
                .noneMatch(e -> e.contains("р."));
    }
}
