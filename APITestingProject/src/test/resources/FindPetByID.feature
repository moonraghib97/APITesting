Feature: Petstore API - Add New Pet

  As a user of the Petstore API
  I want to add a new pet to the store
  So that I can manage pets in the Petstore

  Scenario: Successfully add a new pet to the store
    Given I have a valid pet object
    When I send a POST request to add the pet
    Then I should receive a 200 OK status code
    And the response should contain the pet's ID
