package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
    public static RequestSpecification getPetByIdRequestSpec(String baseUri, String endpoint, int petId) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setBasePath(endpoint + "/{petId}")
                .addPathParam("petId", petId)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification getPetByIdRequestSpec(String baseUri, String endpoint, String apiKey, int petId) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setBasePath(endpoint + "/{petId}")
                .addHeader("api_key", apiKey)
                .addPathParam("petId", petId)
                .setContentType(ContentType.JSON)
                .build();
    }

}
