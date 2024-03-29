package org.launchcode.Liftoff.Project.Restaurant.App.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant extends AbstractEntity{

    @ManyToOne
    private Cuisine cuisine;

    @OneToMany
    @JoinColumn(name = "restaurant_id")
    private List<Review> review = new ArrayList<>();

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

    private String linkForRestaurant;

    private String minutesOpen;

    private String timeOfDayOpen;

    private String hoursOfOperationOpen;

    private String hoursOfOperationEnd;

    private String minutesEnd;

    private String timeOfDayEnd;

    public Restaurant(List<Review> review, String aName, String anAddress, String aCity, String aState,
                      String aZipcode, String aPhone, Cuisine aCuisine, String aLinkForRestaurant,
                      String aHoursOfOperationOpen, String aMinutesOpen, String aTimeOfDayOpen, String aHoursOfOperationEnd,
                      String aMinutesEnd, String aTimeOfDayEnd) {
        super();
        this.review = review;
        this.name = aName;
        this.address = anAddress;
        this.city = aCity;
        this.state = aState;
        this.zipcode = aZipcode;
        this.phone = aPhone;
        this.cuisine = aCuisine;
        this.linkForRestaurant = aLinkForRestaurant;
        this.hoursOfOperationOpen = aHoursOfOperationOpen;
        this.minutesOpen = aMinutesOpen;
        this.timeOfDayOpen = aTimeOfDayOpen;
        this.hoursOfOperationEnd = aHoursOfOperationEnd;
        this.minutesEnd = aMinutesEnd;
        this.timeOfDayEnd = aTimeOfDayEnd;

    }

    // Getters and Setters //

    public Restaurant() { }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

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

    public String getHoursOfOperationOpen() { return hoursOfOperationOpen; }

    public void setHoursOfOperationOpen(String hoursOfOperationOpen) { this.hoursOfOperationOpen = hoursOfOperationOpen; }

    public String getMinutesOpen() { return minutesOpen; }

    public void setMinutesOpen(String minutesOpen) { this.minutesOpen = minutesOpen; }

    public String getTimeOfDayOpen() { return timeOfDayOpen; }

    public void setTimeOfDayOpen(String timeOfDayOpen) { this.timeOfDayOpen = timeOfDayOpen; }

    public String getHoursOfOperationEnd() { return hoursOfOperationEnd; }

    public void setHoursOfOperationEnd(String hoursOfOperationEnd) { this.hoursOfOperationEnd = hoursOfOperationEnd; }

    public String getMinutesEnd() { return minutesEnd; }

    public void setMinutesEnd(String minutesEnd) { this.minutesEnd = minutesEnd; }

    public String getTimeOfDayEnd() { return timeOfDayEnd; }

    public void setTimeOfDayEnd(String timeOfDayEnd) { this.timeOfDayEnd = timeOfDayEnd; }

}
