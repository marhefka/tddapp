package com.training360.tdd;
import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("classpath:application-test.properties")
@TestInstance(Lifecycle.PER_CLASS)
public class UserApplicationRestAssuredAssertJTest {
    @LocalServerPort
    private int port;

    private String baseUrlGreeting;
    private String baseUrlFetchGreetings;

    @BeforeAll
    public void setUp() {
        baseUrlGreeting = "http://localhost:" + port + "/greeting";
        baseUrlFetchGreetings = "http://localhost:" + port + "/fetchGreetings";
    }

    @Test
    public void testGreetingWithName() {
        String name = "John";
        String response = given()
                .param("name", name)
                .when()
                .get(baseUrlGreeting)
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
                .get(baseUrlGreeting)
                .then()
                .statusCode(200)
                .extract()
                .asString();
        assertThat(response).isEqualTo("Hello, World!");
    }

    @Test
    public void testFetchAll() {
        String response = given()
                .when()
                .get(baseUrlFetchGreetings)
                .then()
                .statusCode(200)
                .extract()
                .asString();
//        assertThat(response).isEqualTo("Hello, World!");
    }
}
