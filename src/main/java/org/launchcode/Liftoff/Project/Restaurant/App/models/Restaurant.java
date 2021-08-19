package org.launchcode.Liftoff.Project.Restaurant.App.models;

import javax.persistence.Entity;

@Entity
public class Restaurant extends Cuisine{

    private String address;

    private String linkForRestaurant;

    public Restaurant(String anAddress, String aLinkForRestaurant) {
        super();
        this.address = anAddress;
        this.linkForRestaurant = aLinkForRestaurant;
    }

    public Restaurant() { }

    // Getters and Setters //
    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getLinkForRestaurant() { return linkForRestaurant; }

    public void setLinkForRestaurant(String linkForRestaurant) { this.linkForRestaurant = linkForRestaurant; }


}
