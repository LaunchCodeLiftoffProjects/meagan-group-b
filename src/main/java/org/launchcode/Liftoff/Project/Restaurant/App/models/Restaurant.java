package org.launchcode.Liftoff.Project.Restaurant.App.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Restaurant extends AbstractEntity{

    @NotNull
    @Size(min=1, max=150)
    private String name;

    @NotNull
    @Size(min=1, max=150)
    private String address;

    @NotNull
    @Size(min=1, max=50)
    private String city;

    @NotNull
    @Size(min=1, max=50)
    private String state;

    @NotNull
    @Size(min=5, max=10)
    private String zipcode;

    @Size(min=1, max=11)
    private String phone;

    private String hoursOfOperation;
    private String linkForRestaurant;

    @NotNull
    @Size(min=1, max=150)
    private String cuisine;

    public Restaurant(String aName, String anAddress, String aCity, String aState, String aZipcode, String aPhone, String aHoursOfOperation, String aLinkForRestaurant,
                      String aCuisine) {
        super();
        this.name = aName;
        this.address = anAddress;
        this.city = aCity;
        this.state = aState;
        this.zipcode = aZipcode;
        this.phone = aPhone;
        this.hoursOfOperation = aHoursOfOperation;
        this.linkForRestaurant = aLinkForRestaurant;
        this.cuisine = aCuisine;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getHoursOfOperation() { return hoursOfOperation; }

    public void setHoursOfOperation(String hoursOfOperation) { this.hoursOfOperation = hoursOfOperation; }

    public String getLinkForRestaurant() { return linkForRestaurant; }

    public void setLinkForRestaurant(String linkForRestaurant) { this.linkForRestaurant = linkForRestaurant; }

    public String getCuisine() { return cuisine; }

    public void setCuisine(String cuisine) { this.cuisine = cuisine; }
}
