package pajeobject;

import navigation.OnlinerNavigation;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobject.AccessoriesPage;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccessoriesPageTest {

    private static AccessoriesPage accessoriesPage = new AccessoriesPage();

    @BeforeClass
    public static void navigateToOnlinerFindAccessoriesTabAndClick() {
        accessoriesPage = OnlinerNavigation.navigateToOnlinerHomePage()
                .clickOnNavigationHeaderLink("Каталог")
                .clickOnNavigationCatalogTabLink("Компьютеры")
                .clickOnNavigationComputersAndNetworksTabLink("Комплектующие");
    }

    @Test
    public void testAllElementsContainName() {
        List<String> productsNames = accessoriesPage.findProductsNames();
        assertThat(!isCollectionContainsNull(productsNames))
                .as("Not all products contain name")
                .isTrue();
    }

    @Test
    public void testAllElementsContainQuantity() {
        List<String> descriptions = accessoriesPage.findProductsDescription();
        assertThat(isDescriptionContainsWord(descriptions, "товар"))
                .as("Not all products contain quantity")
                .isTrue();
    }

    @Test
    public void testAllElementsContainPrice() {
        List<String> descriptions = accessoriesPage.findProductsDescription();
        assertThat(isDescriptionContainsWord(descriptions, " р."))
                .as("Not all products contain price")
                .isTrue();
    }

    public boolean isCollectionContainsNull(List<String> strings) {
        return strings.stream().anyMatch(e -> e.contains("null"));
    }

    public boolean isDescriptionContainsWord(List<String> descriptions, String word) {
        return descriptions.stream().allMatch(e -> e.contains(word));
    }
}
