package de.Ekrem.helper;

import de.Ekrem.domain.ListEntry;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ListicatorRequestHelper {
    public ListicatorRequestHelper() {

        RestAssured.baseURI = "http://localhost:4567/listicator";
    }

    public void createListEntry(ListEntry listEntry) {
        Response response = given()//Body gegeben
                .auth()//bei Post List brauchen wir Authentifizierung, deswegen wird es deklariert
                .basic("admin", "password")//Username+Passwort
                .body(listEntry)
                .when()
                .post("/lists");

        response.then().assertThat().statusCode(201);

    }

    public void deleteListEntrybyID(String guid){
        given()//Body gegeben
                .auth()//bei Post List brauchen wir Authentifizierung, deswegen wird es deklariert
                .basic("admin","password")//Username+Passwort
                //Body hat die JSOn Liste
                .when()
                .delete("/lists/"+ guid)
                //GUID Parameter hinter URI quasi "http://localhost:4567/listicator/lists/aktuelleGUI"
                .then()
                .assertThat()
                .statusCode(204);//204 für delete success
    }

    public ListEntry getListEntry(String guid){
        Response response = given()//Body gegeben
                .auth()//bei Post List brauchen wir Authentifizierung, deswegen wird es deklariert
                .basic("admin","password")//Username+Passwort
                //Body hat die JSOn Liste
                .when()
                .get("/lists/"+ guid);
                //GUID Parameter hinter URI quasi "http://localhost:4567/listicator/lists/aktuelleGUI"

        response.then().assertThat().statusCode(200);

        return response.getBody().as(ListEntry.class);
    }
}
