package de.Ekrem.TestsListicator.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ListEntry {

    String guid;
    String title;
    String description;

    public ListEntry(String guid, String title, String description) {
        this.guid = guid;
        this.title = title;
        this.description = description;
    }

    public ListEntry (){

    }
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
