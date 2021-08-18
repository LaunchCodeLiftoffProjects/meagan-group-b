package org.launchcode.Liftoff.Project.Restaurant.App.models;

import java.util.Objects;

public class Restaurant {

    private int id;

    private String name;

    private String address;

    private String linkForRestaurant;

    public Restaurant(String aName, String anAddress, String aLinkForRestaurant) {
        this.name = aName;
        this.address = anAddress;
        this.linkForRestaurant = aLinkForRestaurant;
    }

    public Restaurant() { }

    // Getters and Setters //
    public int getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getLinkForRestaurant() { return linkForRestaurant; }

    public void setLinkForRestaurant(String linkForRestaurant) { this.linkForRestaurant = linkForRestaurant; }

    //Validation//
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant restaurant = (Restaurant) o;
        return id == restaurant.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
