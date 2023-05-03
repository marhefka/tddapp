package com.training360.tdd;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.*;

public class UserSteps {

    private CucumberTestContext CONTEXT = CucumberTestContext.CONTEXT;

    @LocalServerPort
    private int port;
    private String name;
    private String response;

    @When("I request the greeting endpoint with name {string}")
    public void i_request_the_greeting_endpoint_with_name(String name) {
        this.name = name;
        RestAssured.baseURI = "http://localhost:" + port;
        response = RestAssured.given()
                .param("name", name)
                .get("/greeting")
                .getBody().asString();
    }

    @Then("the response should be {string}")
    public void the_response_should_be(String expectedResponse) {
        assertThat(response).isEqualTo(expectedResponse);
    }
}
