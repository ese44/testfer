package com.ese.demo.Marvels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Stories {

    @SerializedName("available")
    @Expose
    private Integer available;
    @SerializedName("collectionURI")
    @Expose
    private String collectionURI;
    @SerializedName("story")
    @Expose
    private List<Story> story = null;
    @SerializedName("returned")
    @Expose
    private Integer returned;




    public Stories() {}


    public Stories(Integer available, String collectionURI, List<Story> story, Integer returned) {
        super();
        this.available = available;
        this.collectionURI = collectionURI;
        this.story = story;
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

    public List<Story> getStory() {
        return story;
    }

    public void setStory(List<Story> story) {
        this.story = story;
    }

    public Integer getReturned() {
        return returned;
    }

    public void setReturned(Integer returned) {
        this.returned = returned;
    }

}