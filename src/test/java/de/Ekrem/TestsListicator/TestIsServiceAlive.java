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
    @Test//hier TestNG Annotationsframework nutzen!!!
    /**
     * org.testng.annotations.Test ist ein Annotation-Typ,
     * der in TestNG, einem Test-Framework für Java, verwendet wird.
     * Das andere ist Junit ein anderer Framework!
     *
     * Test NG bietet erweiterte Funktionen wie Gruppierung von Tests!
     * Bei TestNG können mehrere Tests parallel laufen!
     * TestNG ermöglicht Abhängigkeiten zwischen Tests festzulegen!
     */
    public void isServiceAliveTest() {

                given()//was ist gegeben? Bspw. Queryparam, Authentifizierung
               .when()//wenn - dann
                        .get("/heartbeat")
               .then()
                    .assertThat()
                        //vergleiche es
                        .statusCode(200);
       //wenn heartbeat im Uri gegeben ist gebe Statuscode 200 aus
    }
}
