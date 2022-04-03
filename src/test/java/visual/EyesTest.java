package visual;

import functional.navigation.OnlinerNavigation;
import functional.pageobject.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class EyesTest extends BaseEyesTest {

    private final String appName = "Onliner";
    private static HomePage homePage;

    @BeforeEach
    public void navigateToFoodPage() {
        homePage = new HomePage();
        OnlinerNavigation.navigateToOnlinerHomePage();
    }

    @Test
    @Tag("Visual")
    @Description("Test header and catalog sections view")
    @Story("Tracking changes on the CatalogPage")
    public void testHeaderAndCatalogSectionsView() {
        eyes.open(getWebDriver(), appName, "Header and catalog view");
        homePage.clickOnNavigationHeaderLink("Каталог");
        eyes.checkWindow("Home Page Catalog");
    }

    @Test
    @Tag("Visual")
    @Description("Test CatalogPage section 'Coffee'")
    @Story("Tracking changes after pushing button Coffee")
    public void testCatalogSectionCoffeeView() {
        eyes.open(getWebDriver(), appName, "Coffee tab view");
        homePage.clickOnSectionButton("Кофе");
        eyes.checkWindow("Home Page Coffee");
    }

    @AfterEach
    public void closeEyes() {
        eyes.close();
    }
}
