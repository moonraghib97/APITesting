Feature: Get Pet By ID

  @HappyPath
  Scenario: Find a pet by its id with a valid id
    Given that I want to find a pet by its id
    When I send a GET request with a valid id
    Then I should receive a 200 status code response
    And the response should contain the relevant pet

  @SadPath
  Scenario: Find a pet by its id with an invalid id
    Given that I want to find a pet by its id
    When I send a GET request with an invalid id
    Then I should receive a 500 status code response
    And I should receive a message "There was an error processing your request. It has been logged"
