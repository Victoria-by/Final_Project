package functional.pageobject;

import io.qameta.allure.Description;
import listeners.AllureListener;
import functional.navigation.OnlinerNavigation;
import functional.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(AllureListener.class)
public class ComputersAndNetworksPageTest extends BaseTest {
    private static final List<String> TITLES_OF_ASIDE_LIST = Arrays.asList("Ноутбуки, компьютеры, мониторы",
            "Комплектующие", "Хранение данных", "Сетевое оборудование");
    private static ComputersAndNetworksPage computersAndNetworksPage;

    @BeforeAll
    @Description("Navigate to Onliner and click on 'Computers and Networks' tab tab")
    public static void navigateToOnlinerFindComputersAndNetworksTabAndClick() {
        computersAndNetworksPage =  OnlinerNavigation.navigateToOnlinerHomePage()
                .clickOnNavigationHeaderLink("Каталог")
                .clickOnNavigationCatalogTabLink("Компьютеры")
                .mouseOver();
    }

    @Test
    @Description("Test section contains tab list")
    public void testSectionContainsTabsList() {
        assertThat(computersAndNetworksPage.getComputersAndNetworksLinks())
                .as("Page sections don't contain section list")
                .containsAll(TITLES_OF_ASIDE_LIST);
    }
}
