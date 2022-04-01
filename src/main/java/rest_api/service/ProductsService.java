package rest_api.service;

import io.qameta.allure.Step;
import rest_api.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static rest_api.utils.GetRequestUtils.makeRequestAndGetResponseBody;
import static rest_api.utils.ResponseBodyUtils.getListStringByJsonPath;
import static rest_api.utils.ResponseBodyUtils.getObjectsByJsonPath;
import static util.PropertiesReader.getProperty;

public class ProductsService {

    @Step("Get products")
    public List<Product> getProducts() {
        return getObjectsByJsonPath(makeRequestAndGetResponseBody(getProperty("endPoint"), null, null),
                "products", Product.class);
    }

    @Step("Get name prefixes")
    public List<String> getNamePrefixes() {
        Map<String, Object> params = new HashMap<>();
        params.put("sushi_typ[0]", "roll");
        params.put("sushi_typ[operation]", "union");
        return getListStringByJsonPath(makeRequestAndGetResponseBody(getProperty("endPoint"), null, params),
                "products.name_prefix");
    }
}
