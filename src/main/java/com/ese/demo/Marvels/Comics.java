package com.ese.demo.Marvels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Comics {

    @SerializedName("available")
    @Expose
    private Integer available;
    @SerializedName("collectionURI")
    @Expose
    private String collectionURI;
    @SerializedName("Comic")
    @Expose
    private List<Comic> comic = null;
    @SerializedName("returned")
    @Expose
    private Integer returned;


    public Comics() {}

    public Comics(Integer available, String collectionURI, List<Comic> comic, Integer returned) {
        super();
        this.available = available;
        this.collectionURI = collectionURI;
        this.comic = comic;
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

    public List<Comic> getItems() {
        return comic;
    }

    public void setItems(List<Comic> items) {
        this.comic = items;
    }

    public Integer getReturned() {
        return returned;
    }

    public void setReturned(Integer returned) {
        this.returned = returned;
    }

}