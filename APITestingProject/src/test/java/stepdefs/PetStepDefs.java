package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PetStepDefs {
    @Given("I have a valid pet object")
    public void iHaveAValidPetObject() {
    }

    @When("I send a POST request to add the pet")
    public void iSendAPOSTRequestToAddThePet() {
    }

    @Then("I should receive a {int} OK status code")
    public void iShouldReceiveAOKStatusCode(int arg0) {
    }

    @And("the response should contain the pet's ID")
    public void theResponseShouldContainThePetSID() {
    }
}
