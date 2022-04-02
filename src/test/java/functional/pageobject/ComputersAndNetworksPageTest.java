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

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(AllureListener.class)
@Feature("Search across ComputersAndNetworksPage")
public class ComputersAndNetworksPageTest extends BaseTest {

    private static final List<String> COMPUTERS_AND_NETWORKS_TABS_LIST = Arrays.asList("Ноутбуки, компьютеры, мониторы",
            "Комплектующие", "Хранение данных", "Сетевое оборудование");
    private static ComputersAndNetworksPage computersAndNetworksPage;

    @BeforeAll
    @Description("Navigate to Onliner and click on 'Computers and Networks' tab tab")
    public static void navigateToOnlinerFindComputersAndNetworksTabAndClick() {
        OnlinerNavigation.navigateToOnlinerHomePage()
                .clickOnNavigationHeaderLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры");
        computersAndNetworksPage = new ComputersAndNetworksPage()
                .clickOnTheFirstTabOfSection();
    }

    @Test
    @Description("Test section contains tab list")
    @Story("Search across ComputersAndNetworks tabs")
    public void testSectionContainsTabsList() {
        assertThat(computersAndNetworksPage.getComputersAndNetworksLinks())
                .as("Page sections don't contain section list")
                .containsAll(COMPUTERS_AND_NETWORKS_TABS_LIST);
    }
}
