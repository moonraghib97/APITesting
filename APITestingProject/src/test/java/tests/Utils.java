package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojo.Pet;

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

    public static RequestSpecification postRequestSpecForPet(String baseUri, String endpoint, Pet pet) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setBasePath(endpoint)
                .addHeader("Content-Type", "application/json") // Ensure Content-Type header is set
                .setBody(pet)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification deleteRequestSpecForPet(String baseUri, String endpoint, int petId) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setBasePath(endpoint + "/{petId}")
                .addPathParam("petId", petId)
                .addHeader("Content-Type", "application/json") // Ensure Content-Type header is set
                .setContentType(ContentType.JSON)
                .build();
    }

}
