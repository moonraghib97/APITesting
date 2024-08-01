# API Testing Project for Petstore3

This project is designed to test the Petstore3 API, specifically focusing on retrieving pet details by their ID. The API endpoint under test is available at [Petstore3 Swagger](https://petstore3.swagger.io/#/pet/getPetById).

## Table of Contents

- [Project Overview](#project-overview)
- [Setup and Installation](#setup-and-installation)
- [Running Tests](#running-tests)
- [Test Scenarios](#test-scenarios)
- [Contributors](#contributors)
- [Feedback](#feedback)

## Project Overview

The purpose of this project is to perform automated API testing using Cucumber and RestAssured. The main scenarios tested include:

1. Retrieving a pet by a valid ID.
2. Retrieving a pet by an invalid ID.

## Setup and Installation

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven
- An IDE such as IntelliJ IDEA

### Installation Steps

 **Clone the repository:**
   ```sh
   git clone https://github.com/your-username/api-testing-petstore3.git
```

## Running Tests
   - Open the project in IntelliJ IDEA.
   - Navigate to the GetPetById.feature file.
   - Right-click on the file and select Run Test

  
## Test Scenarios
### Test Scenarios

Feature: Get Pet By ID

Scenario: Find a pet by its id with a valid id
 - Given that I want to find a pet by its id
 - When I send a GET request with a valid id
 - Then I should receive a 200 status code response
 - And the response should contain the relevant pet

Scenario: Find a pet by its id with an invalid id
 - Given that I want to find a pet by its id
 - When I send a GET request with an invalid id
 - Then I should receive a 500 status code response
 - And I should receive a message "There was an error processing your request. It has been logged"

## Contributors

- Mamoon Raghib
- Irina Gall

## Feedback

We welcome your feedback! If you have any suggestions or find any issues, please feel free to open an issue on the GitHub repository or contact us directly.

