package de.Ekrem.TestsListicator;

import io.restassured.RestAssured;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class TestIsServiceAlive {

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "http://localhost:4567/listicator";
    }
    @Test
    public void isServiceAliveTest() {

                given()
               .when()
                        .get("/heartbeat")
               .then()
                    .assertThat()

                        .statusCode(200);
    }
}
