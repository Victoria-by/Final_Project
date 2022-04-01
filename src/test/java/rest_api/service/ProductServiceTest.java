package rest_api.service;


import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import rest_api.model.Product;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductServiceTest {
    private final ProductsService productsService = new ProductsService();

    @Test
    @Description("Test products names are not empty")
    public void testProductNamesAreNotEmpty() {
        assertThat(productsService.getProducts())
                .as("Not every product has name")
                .noneMatch(element -> element.getName().isEmpty());
    }

    @Test
    @Description("Test products names of type 'Rolls' contain prefix 'Rolls'")
    public void testProductNamesOfTypeRollsContainsPrefixRolls() {
        assertThat(productsService.getNamePrefixes())
                .as("Not every name_prefix contains text 'Роллы' ")
                .allMatch(element -> element.contains("Роллы"));
    }
}
