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
@Feature("Search across CatalogPage")
public class CatalogPageTest extends BaseTest {

    private static final List<String> SECTIONS_LIST = Arrays.asList("Электроника", "Компьютеры и сети", "Бытовая техника",
            "Стройка и ремонт", "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам", "Работа и офис", "Еда");
    private static CatalogPage catalogpage;

    @BeforeAll
    @Description("Navigate to Onliner and click on 'Catalog' tab")
    public static void navigateToOnlinerClickOnCatalogLink() {
        catalogpage = OnlinerNavigation.navigateToOnlinerHomePage()
                .clickOnNavigationHeaderLink("Каталог");
    }

    @Test
    @Description("Test sections contain definite values")
    @Story("Search across CatalogPage sections")
    public void testPageSectionsContainSectionList() {
        assertThat(catalogpage.getCatalogLinks())
                .as("Page sections don't contain section list")
                .containsAll(SECTIONS_LIST);
    }
}
