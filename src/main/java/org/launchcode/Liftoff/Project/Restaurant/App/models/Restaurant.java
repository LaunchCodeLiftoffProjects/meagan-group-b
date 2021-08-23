package org.launchcode.Liftoff.Project.Restaurant.App.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Restaurant extends AbstractEntity{

    @NotNull
    @Size(min=3, max=150)
    private String name;

    private String address;

    private String linkForRestaurant;

    public Restaurant(String aName, String anAddress, String aLinkForRestaurant) {
        super();
        this.name = aName;
        this.address = anAddress;
        this.linkForRestaurant = aLinkForRestaurant;
    }

    public Restaurant() { }

    // Getters and Setters //

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getLinkForRestaurant() { return linkForRestaurant; }

    public void setLinkForRestaurant(String linkForRestaurant) { this.linkForRestaurant = linkForRestaurant; }


}
