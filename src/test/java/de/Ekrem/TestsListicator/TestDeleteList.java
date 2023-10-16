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
        RestAssured.baseURI = "http://localhost:4567/listicator";//Vorbedingung Hauptressource

        listicatorRequestHelper = new ListicatorRequestHelper();

    }
    @Test
    public void deleteListTestAutomationWithRestAssured (){
        //Json Eingaben//es löscht immer die unteren eingaben!! nur ein Löschvorgang möglich nicht im Thread also ganzes!


        listicatorRequestHelper.deleteListEntrybyID(listEntry.getGuid());

        given()//Body gegeben
                .auth()//bei Post List brauchen wir Authentifizierung, deswegen wird es deklariert
                .basic("admin","password")//Username+Passwort
                .body(listEntry)
                //Body hat die JSOn Liste
                .when()
                .delete("/lists/"+listEntry.getGuid())
                //GUID Parameter hinter URI quasi "http://localhost:4567/listicator/lists/aktuelleGUI"
                .then()
                .assertThat()
                .statusCode(204);//204 für delete success
    }
}
