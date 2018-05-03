package com.ese.demo.Marvels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Events {

    @SerializedName("available")
    @Expose
    private Integer available;
    @SerializedName("collectionURI")
    @Expose
    private String collectionURI;
    @SerializedName("items")
    @Expose
    private List<Event> event = null;
    @SerializedName("returned")
    @Expose
    private Integer returned;


    public Events() {}


    public Events(Integer available, String collectionURI, List<Event> event, Integer returned) {
        super();
        this.available = available;
        this.collectionURI = collectionURI;
        this.event = event;
        this.returned = returned;
    }



    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<Event> getItems() {
        return event;
    }

    public void setItems(List<Event> items) {
        this.event = items;
    }

    public Integer getReturned() {
        return returned;
    }

    public void setReturned(Integer returned) {
        this.returned = returned;
    }

}