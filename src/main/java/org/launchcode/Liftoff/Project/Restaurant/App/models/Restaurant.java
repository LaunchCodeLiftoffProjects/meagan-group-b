package org.launchcode.Liftoff.Project.Restaurant.App.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Restaurant extends AbstractEntity{

    @ManyToOne
    private Cuisine cuisine;

    @NotNull
    @Size(min=1, max=150)
    private String name;

    @NotNull
    private String address;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @NotNull
    @Size(min=5)
    private String zipcode;

    @NotNull
    private String phone;

    @NotNull
    private String linkForRestaurant;

    private String hoursOfOperation;

    private String minutes;

    private String timeOfDay;

    private String hoursOfOperationEnd;

    private String minutesEnd;

    private String timeOfDayEnd;

    public Restaurant(String aName, String anAddress, String aCity, String aState,
                      String aZipcode, String aPhone, Cuisine aCuisine, String aLinkForRestaurant,
                      String aHoursOfOperation, String aMinutes, String aTimeOfDay, String aHoursOfOperationEnd,
                      String aMinutesEnd, String aTimeOfDayEnd) {
        super();
        this.name = aName;
        this.address = anAddress;
        this.city = aCity;
        this.state = aState;
        this.zipcode = aZipcode;
        this.phone = aPhone;
        this.cuisine = aCuisine;
        this.linkForRestaurant = aLinkForRestaurant;
        this.hoursOfOperation = aHoursOfOperation;
        this.minutes = aMinutes;
        this.timeOfDay = aTimeOfDay;
        this.hoursOfOperationEnd = aHoursOfOperationEnd;
        this.minutesEnd = aMinutesEnd;
        this.timeOfDayEnd = aTimeOfDayEnd;
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

    public String getHoursOfOperation() { return hoursOfOperation; }

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
