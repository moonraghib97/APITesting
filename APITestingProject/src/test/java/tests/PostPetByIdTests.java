package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Category;
import pojo.Pet;
import pojo.TagsItem;
import tests.AppConfig;
import tests.Utils;

import java.util.Collections;

public class PostPetByIdTests {
    private static Response response;
    private static Pet pet;
    private static final String BASE_URI = AppConfig.getBaseUri();
    private static final String POST_PATH = AppConfig.getPetEndpoint();
    private static Integer petId;

    @BeforeAll
    public static void beforeAll() {
        // Create a new pet
        Pet newPet = new Pet();
        newPet.setId(9999);
        newPet.setName("moon");
        newPet.setCategory(new Category(1, "Dogs"));
        newPet.setPhotoUrls(Collections.singletonList("string"));
        newPet.setTags(Collections.singletonList(new TagsItem(0, "string")));
        newPet.setStatus("available");

        response = RestAssured
                .given(Utils.postRequestSpecForPet(BASE_URI, POST_PATH, newPet))
                .when()
                .post();
        pet = response.getBody().as(Pet.class);
        petId = pet.getId();
    }

    @Test
    @DisplayName("Validate the response body")
    void validateResponseBody() {
        MatcherAssert.assertThat(pet.getName(), Matchers.is("moon"));
        MatcherAssert.assertThat(pet.getCategory().getName(), Matchers.is("Dogs"));
        MatcherAssert.assertThat(pet.getStatus(), Matchers.is("available"));
    }

    @Test
    @DisplayName("Validate the response status code")
    void validateResponseStatusCode() {
        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(200));
    }

    @Test
    @DisplayName("Validate the pet ID in the response")
    void validatePetIdInResponse() {
        MatcherAssert.assertThat(petId, Matchers.is(9999));
    }

    /*@AfterAll
    public static void afterAll() {
        // Delete the pet created during the test
        RestAssured
                .given(Utils.deleteRequestSpecForPet(BASE_URI, POST_PATH, petId))
                .when()
                .delete();
    }*/
}