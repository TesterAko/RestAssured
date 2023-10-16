package de.Ekrem.GoogleBooksSearch;


import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class TestGoogleBooksSearch {


    @Test
    public void testGoogleBooksSearchForTestAutomation() {
        given()
                .queryParam("q", "Testautomatisierung")
                .when()
                .get("https://www.googleapis.com/books/v1/volumes")
                .then()
                .assertThat()
                .statusCode(200)
                .body("kind", equalTo("books#volumes"));


    }
}
