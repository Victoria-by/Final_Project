package pajeobject;

import navigation.OnlinerNavigation;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobject.CatalogPage;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CatalogPageTest {
    private static final List<String> SECTIONS_LIST = Arrays.asList("Электроника", "Компьютеры и сети", "Бытовая техника",
            "Стройка и ремонт", "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам", "Работа и офис", "Еда");
    private static CatalogPage catalogpage = new CatalogPage();

    @BeforeClass
    public static void navigateToOnlinerClickOnCatalogLink() {
        catalogpage = OnlinerNavigation.navigateToOnlinerHomePage()
                .clickOnNavigationHeaderLink("Каталог");
    }

    @Test
    public void testPageSectionsTitlesContainSectionList() {
        List<String> sectionsTitles = catalogpage.catalogLinks();
        assertThat(isPageSectionsTitlesContainSectionList(sectionsTitles))
                .as("Page sections don't contain section list")
                .isTrue();
    }

    public boolean isPageSectionsTitlesContainSectionList(List<String> sectionsTitles) {
        return sectionsTitles.containsAll(SECTIONS_LIST);
    }
}
