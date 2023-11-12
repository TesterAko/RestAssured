package de.Ekrem.TestsListicator;

import de.Ekrem.TestsListicator.domain.ListEntry;
import de.Ekrem.TestsListicator.helper.ListicatorRequestHelper;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestCreateList {

    private ListEntry listEntry;
    private ListEntry createdListEntry;
    private ListicatorRequestHelper listicatorRequestHelper;


    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "http://localhost:4567/listicator";

        listicatorRequestHelper = new ListicatorRequestHelper();
    }
    @Test
    public void createListTestAutomationWithRestAssured() {
        listEntry = new ListEntry("10","Testautomatisierung", "Testen mit Testautomatisierung");

        listicatorRequestHelper.createListEntry(listEntry);

        createdListEntry = listicatorRequestHelper.getListEntry(listEntry.getGuid());


        assertThat(createdListEntry.getDescription(), equalTo(listEntry.getDescription()));

        //listicatorRequestHelper.deleteListEntrybyID(listEntry.getGuid());

    }
}
