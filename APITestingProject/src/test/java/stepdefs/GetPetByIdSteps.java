package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import tests.AppConfig;
import tests.Utils;

import static org.hamcrest.Matchers.*;

public class GetPetByIdSteps {

    private static String baseUri;
    private static String petEndpoint;
    private Response response;
    private int petId;

    static {
        baseUri = AppConfig.getBaseUri();
        petEndpoint = AppConfig.getPetEndpoint();
    }

    @Given("that I want to find a pet by its id")
    public void thatIWantToFindAPetByItsId() {
    }

    @When("I send a GET request with a valid id")
    public void iSendAGETRequestWithAValidId() {
        petId = 10;
        response = RestAssured
                .given()
                .spec(Utils.getPetByIdRequestSpec(baseUri, petEndpoint, petId))
                .when()
                .get();
    }

    @When("I send a GET request with an invalid id")
    public void iSendAGETRequestWithAnInvalidId() {
        petId = -1;
        response = RestAssured
                .given()
                .spec(Utils.getPetByIdRequestSpec(baseUri, petEndpoint, petId))
                .when()
                .get();
    }

    @Then("I should receive a {int} status code response")
    public void iShouldReceiveAStatusCodeResponse(int code) {
        response.then().statusCode(code);
    }

    @And("the response should contain the relevant pet")
    public void theResponseShouldContainTheRelevantPet() {
        response.then()
                .body("id", equalTo(petId))
                .body("name", not(emptyOrNullString()));
    }

    @And("I should receive a message {string}")
    public void iShouldReceiveAMessage(String message) {
        response.then().body("message", containsString(message));
    }
}
