package pajeobject;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CatalogPageTest.class,
        ComputersAndNetworksPageTest.class,
        AccessoriesPageTest.class})
public class AllTests extends BaseTest{
}