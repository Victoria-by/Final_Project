package runner;

import functional.pageobject.AccessoriesPageTest;
import functional.pageobject.CatalogPageTest;
import functional.pageobject.ComputersAndNetworksPageTest;
import functional.pageobject.FoodPageTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CatalogPageTest.class,
        ComputersAndNetworksPageTest.class,
        FoodPageTest.class,
        AccessoriesPageTest.class,})
public class AllTestsSuite {
}
