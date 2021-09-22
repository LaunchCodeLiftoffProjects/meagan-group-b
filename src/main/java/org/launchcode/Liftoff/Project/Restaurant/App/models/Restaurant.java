package org.launchcode.Liftoff.Project.Restaurant.App.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Restaurant extends AbstractEntity{

    @ManyToOne
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

    private String minutes;

    private String timeOfDay;

    private String hoursOfOperation;

    private String hoursOfOperationEnd;

    private String minutesEnd;

    private String timeOfDayEnd;

    public Restaurant(Cuisine cuisine, String name, String address, String city, String state, String zipcode, String phone,
                      String linkForRestaurant, String minutes, String timeOfDay, String hoursOfOperation,
                      String hoursOfOperationEnd, String minutesEnd, String timeOfDayEnd) {
        this.cuisine = cuisine;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phone = phone;
        this.linkForRestaurant = linkForRestaurant;
        this.minutes = minutes;
        this.timeOfDay = timeOfDay;
        this.hoursOfOperation = hoursOfOperation;
        this.hoursOfOperationEnd = hoursOfOperationEnd;
        this.minutesEnd = minutesEnd;
        this.timeOfDayEnd = timeOfDayEnd;
    }

    public Restaurant() { }



    // Getters and Setters //

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

    public String getHoursOfOperation() {
        return hoursOfOperation;
    }

    public void setHoursOfOperation(String hoursOfOperation) { this.hoursOfOperation = hoursOfOperation; }

    public String getMinutes() { return minutes; }

    public void setMinutes(String minutes) { this.minutes = minutes; }

    public String getTimeOfDay() { return timeOfDay; }

    public void setTimeOfDay(String timeOfDay) { this.timeOfDay = timeOfDay; }

    public String getHoursOfOperationEnd() { return hoursOfOperationEnd; }

    public void setHoursOfOperationEnd(String hoursOfOperationEnd) { this.hoursOfOperationEnd = hoursOfOperationEnd; }

    public String getMinutesEnd() { return minutesEnd; }

    public void setMinutesEnd(String minutesEnd) { this.minutesEnd = minutesEnd; }

    public String getTimeOfDayEnd() { return timeOfDayEnd; }

    public void setTimeOfDayEnd(String timeOfDayEnd) { this.timeOfDayEnd = timeOfDayEnd; }

}
