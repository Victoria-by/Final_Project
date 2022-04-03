package rest_api.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.commons.collections4.MapUtils;
import org.apache.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequestUtils {
    private GetRequestUtils() {
    }

    @Step("Make GET request and get response body")
    public static ResponseBody makeRequestAndGetResponseBody(String endpoint, Map<String, Object> headers,
                                                             Map<String, Object> params) {
        Response response = given()
                .headers(MapUtils.emptyIfNull(headers))
                .params(MapUtils.emptyIfNull(params))
                .when()
                .get(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
        Allure.attachment("response", response.prettyPrint());
        return response.getBody();
    }
}
