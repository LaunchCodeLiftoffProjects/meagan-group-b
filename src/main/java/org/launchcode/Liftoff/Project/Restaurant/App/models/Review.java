package org.launchcode.Liftoff.Project.Restaurant.App.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Review extends AbstractEntity {

    @ManyToOne
    private Restaurant restaurant;

    @NotNull(message = "Username is required.")
    private String name;

    @NotNull(message = "Date is required.")
    private String date;

    @Size(max=500)
    private String comment;

    @NotNull(message = "Rating is required.")
    private Integer rating;

    public Review(Restaurant restaurant, String name, String date, String comment, Integer rating) {
        super();
        this.restaurant = restaurant;
        this.name = name;
        this.date = date;
        this.comment = comment;
        this.rating = rating;
    }

    public Review() { }

    // Getters and Setters //

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

}
