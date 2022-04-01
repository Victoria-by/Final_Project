package runner;

import org.junit.platform.suite.api.SelectClasses;
import functional.pageobject.AccessoriesPageTest;
import functional.pageobject.CatalogPageTest;
import functional.pageobject.ComputersAndNetworksPageTest;
import rest_api.service.ProductServiceTest;

@SelectClasses({
        CatalogPageTest.class,
        ComputersAndNetworksPageTest.class,
        AccessoriesPageTest.class,
        ProductServiceTest.class})
public class AllTests {
}