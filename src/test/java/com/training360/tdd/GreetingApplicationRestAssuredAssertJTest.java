package com.training360.tdd;
import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("classpath:application-test.properties")
@TestInstance(Lifecycle.PER_CLASS)
public class GreetingApplicationRestAssuredAssertJTest {
    private final int PORT = 8081; // TODO should be configurable

    private String baseUrl;

    @BeforeAll
    public void setUp() {
        baseUrl = "http://localhost:" + PORT + "/greeting";
    }

    @Test
    public void testGreetingWithName() {
        String name = "John";
        String response = given()
                .param("name", name)
                .when()
                .get(baseUrl)
                .then()
                .statusCode(200)
                .extract()
                .asString();
        assertThat(response).isEqualTo("Hello, " + name + "!");
    }

    @Test
    public void testGreetingWithoutName() {
        String response = given()
                .when()
                .get(baseUrl)
                .then()
                .statusCode(200)
                .extract()
                .asString();
        assertThat(response).isEqualTo("Hello, World!");
    }
}
