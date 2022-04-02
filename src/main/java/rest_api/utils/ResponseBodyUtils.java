package rest_api.utils;

import io.qameta.allure.Step;
import io.restassured.response.ResponseBody;

import java.util.List;

public class ResponseBodyUtils {
    private ResponseBodyUtils() {

    }

    @Step("Get objects by jsonPath")
    public static <T> List<T> getObjectsByJsonPath(ResponseBody responseBody, String jsonPath, Class<T> genericType) {
        return responseBody
                .jsonPath()
                .getList(jsonPath, genericType);
    }

    @Step("Get list string by jsonPath")
    public static List<String> getListStringByJsonPath(ResponseBody responseBody, String jsonPath) {
        return responseBody
                .jsonPath()
                .getList(jsonPath);
    }
}