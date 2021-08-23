package org.launchcode.Liftoff.Project.Restaurant.App.models;

import java.util.List;
import java.util.Objects;

@MappedSuperclass
public class Restaurant {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @Size(max = 100)
    private String name;
    private String restaurant;
    private String hours;
    private String address;
    private String phone;
    private String link;
    private String cuisine;

    public Restaurant(int aId, String aName, String aRestaurant,
                      String aHours, String aAddress, String aPhone, String aLink, String aCuisine) {
        this.id = aId;
        this.name = aName;
        this.restaurant = aRestaurant;
        this.hours = aHours;
        this.address = aAddress;
        this.phone = aPhone;
        this.link =  aLink;
        this.cuisine = aCuisine;
    }

    public Restaurant() { }

    public int getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getRestaurant() { return restaurant; }

    public void setRestaurant(String restaurant) { this.restaurant = restaurant; }

    public String getHours() { return hours; }

    public void setHours(String hours) { this.hours = hours; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getLink() { return link; }

    public void setLink(String link) { this.link = link; }

    public String getCuisine() { return cuisine; }

    public void setCuisine(String cuisine) { this.cuisine = cuisine; }

    // Validation //
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
