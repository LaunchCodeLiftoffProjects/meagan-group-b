package org.launchcode.Liftoff.Project.Restaurant.App.models;

public class Cuisine extends Restaurant {

    private String cuisine;

    public Cuisine(String aCuisine) {
        this.cuisine = aCuisine;
    }

    public Cuisine() { }

    public String getCuisine() { return cuisine; }

    public void setCuisine(String cuisine) { this.cuisine = cuisine; }
}
