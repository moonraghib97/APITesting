package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Pet;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

public class GetPetByIdApiTestWithPojo {
    private static String baseUri;
    private static String petEndpoint;

    @BeforeAll
    public static void setup() {
        baseUri = AppConfig.getBaseUri();
        petEndpoint = AppConfig.getPetEndpoint();
    }

    @Test
    public void testGetPetById() {
        int petId = 10;

        Pet pet = RestAssured
                .given()
                .spec(Utils.getPetByIdRequestSpec(baseUri, petEndpoint, petId))
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .as(Pet.class);

        assertEquals(petId, pet.getId());
        assertNotNull(pet.getName());
        assertFalse(pet.getName().isEmpty());
    }

    @Test
    @DisplayName("expect 500 Error processing request when searching for an invalid id")
    public void testGetPetByInvalidId() {
        int invalidPetId = -1;

        RestAssured
                .given()
                .spec(Utils.getPetByIdRequestSpec(baseUri, petEndpoint, invalidPetId))
                .when()
                .get()
                .then()
                .statusCode(500)
                .body("message", containsString("There was an error processing your request. It has been logged"));
    }
}
