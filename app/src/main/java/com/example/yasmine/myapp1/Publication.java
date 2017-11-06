package com.example.yasmine.myapp1;

/**
 * Created by Firas on 07/11/2016.
 */

public class Publication {

    public String publisher;
    public String title ;
    public String type ;
    public String description;
    public String date ;
    public long lat ;
    public long lon ;
    public Publication(String publisher, String title, String type, String description, String date, long lat, long lon) {
        this.publisher = publisher;
        this.title = title;
        this.type = type;
        this.description = description;
        this.date = date;
        this.lat = lat;
        this.lon = lon;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLon() {
        return lon;
    }

    public void setLon(long lon) {
        this.lon = lon;
    }
}
