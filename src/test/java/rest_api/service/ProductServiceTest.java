package rest_api.service;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
@Tag("Rest")
public class ProductServiceTest {

    protected static final Logger LOG = LoggerFactory.getLogger(ProductServiceTest.class);
    private final ProductsService productsService = new ProductsService();

    @Test
    @Description("Test products names are not empty")
    @Story("Search across products of SushiVesla products")
    public void testProductNamesAreNotEmpty() {
        assertThat(productsService.getProducts())
                .as("Not every product has name")
                .noneMatch(element -> element.getName().isEmpty());
        LOG.info(productsService.getProducts().toString());
    }

    @Test
    @Description("Test products names of type 'Роллы' contain prefix 'Роллы'")
    @Story("Search across products of SushiVesla products")
    public void testProductNamesOfTypeRollsContainsPrefixRolls() {
        assertThat(productsService.getNamePrefixes())
                .as("Not every name_prefix contains text 'Роллы' ")
                .allMatch(element -> element.contains("Роллы"));
        LOG.info(productsService.getNamePrefixes().toString());
    }
}
