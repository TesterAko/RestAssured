package de.Ekrem.TestsListicator;

import de.Ekrem.domain.ListEntry;
import de.Ekrem.helper.ListicatorRequestHelper;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestDeleteList {

    private ListEntry listEntry;
    private ListicatorRequestHelper listicatorRequestHelper;
    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "http://localhost:4567/listicator";

        listicatorRequestHelper = new ListicatorRequestHelper();

    }
    @Test
    public void deleteListTestAutomationWithRestAssured (){


        listicatorRequestHelper.deleteListEntrybyID(listEntry.getGuid());

        given()
                .auth()
                .basic("admin","password")
                .body(listEntry)
                .when()
                .delete("/lists/"+listEntry.getGuid())
                .then()
                .assertThat()
                .statusCode(204);
    }
}
