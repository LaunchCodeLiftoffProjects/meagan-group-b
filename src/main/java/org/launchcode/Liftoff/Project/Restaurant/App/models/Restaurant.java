package org.launchcode.Liftoff.Project.Restaurant.App.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Restaurant extends AbstractEntity{

    @ManyToOne
    @NotNull(message = "Cuisine is required.")
    private Cuisine cuisine;

    @NotNull(message = "Name is required.")
    @Size(min=1, max=150)
    private String name;

    @NotNull(message = "Address is required.")
    private String address;

    @NotNull(message = "City is required.")
    private String city;

    @NotNull(message = "State is required.")
    private String state;

    @NotNull(message = "ZIP Code is required.")
    @Size(min=5)
    private String zipcode;

    @NotNull(message = "Phone number is required.")
    private String phone;

    @NotNull(message = "Link is required.")
    private String linkForRestaurant;

    @NotNull(message = "Hours is required.")
    private String openingTime;

    @NotNull(message = "Hours is required.")
    private String closingTime;

    public Restaurant(String aName, String anAddress, String aCity, String aState,
                      String aZipcode, String aPhone, Cuisine aCuisine, String aLinkForRestaurant,
                      String aOpeningTime, String aClosingTime) {
        super();
        this.name = aName;
        this.address = anAddress;
        this.city = aCity;
        this.state = aState;
        this.zipcode = aZipcode;
        this.phone = aPhone;
        this.cuisine = aCuisine;
        this.linkForRestaurant = aLinkForRestaurant;
        this.openingTime = aOpeningTime;
        this.closingTime = aClosingTime;
    }

    // Getters and Setters //

    public Restaurant() { }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public String getZipcode() { return zipcode; }

    public void setZipcode(String zipcode) { this.zipcode = zipcode; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public Cuisine getCuisine() { return cuisine; }

    public void setCuisine(Cuisine cuisine) { this.cuisine = cuisine; }

    public String getLinkForRestaurant() { return linkForRestaurant; }

    public void setLinkForRestaurant(String linkForRestaurant) { this.linkForRestaurant = linkForRestaurant; }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }
}
