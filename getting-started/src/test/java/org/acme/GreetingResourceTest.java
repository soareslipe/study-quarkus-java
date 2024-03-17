package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.UUID;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));
    }

    @Test
    void testGreetingEndpoint() {
        String uuid = UUID.randomUUID().toString();
        given()
        .pathParam("name", uuid)
        .when().get("/hello/greeting/{name}")
        .then()
        .statusCode(200)
        .body(is("Hello " + uuid));
    }

}