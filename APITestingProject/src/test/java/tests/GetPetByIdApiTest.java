package tests;

import org.junit.jupiter.api.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.response.Response;

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


}
