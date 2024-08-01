package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class GetPetByIdApiTest {


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

            Response response = RestAssured
                    .given()
                    .spec(Utils.getPetByIdRequestSpec(baseUri, petEndpoint, petId))
                    .when()
                    .get()
                    .then()
                    .statusCode(200)
                    .body("id", equalTo(petId))
                    .body("name", not(emptyOrNullString()))
                    .extract().response();

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
