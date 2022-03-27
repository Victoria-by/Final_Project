package pajeobject;

import navigation.OnlinerNavigation;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobject.ComputersAndNetworksPage;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ComputersAndNetworksPageTest {
    private static final List<String> TITLES_OF_ASIDE_LIST = Arrays.asList("Ноутбуки,компьютеры, мониторы",
            "Комплектующие", "Хранение данных", "Сетевое оборудование");
    private static ComputersAndNetworksPage computersAndNetworksPage = new ComputersAndNetworksPage();

    @BeforeClass
    public static void navigateToOnlinerFindComputersAndNetworksTabAndClick() {
        computersAndNetworksPage = OnlinerNavigation.navigateToOnlinerHomePage()
                .clickOnNavigationHeaderLink("Каталог")
                .clickOnNavigationCatalogTabLink("Компьютеры");
        computersAndNetworksPage.mouseOver();
    }

    @Test
    public void testSectionContainsTabsList() {
        List<String> computersAndNetworksLinks = computersAndNetworksPage.computersAndNetworksLinks();
        assertThat(isPageSectionsTitlesContainSectionList(computersAndNetworksLinks))
                .as("Page sections don't contain section list")
                .isTrue();
    }

    public boolean isPageSectionsTitlesContainSectionList(List<String> sectionsTitles) {
        return TITLES_OF_ASIDE_LIST.stream().anyMatch(sectionsTitles::contains);
    }
}
