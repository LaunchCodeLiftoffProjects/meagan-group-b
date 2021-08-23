package org.launchcode.Liftoff.Project.Restaurant.App.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Cuisine extends AbstractEntity{


    @NotNull
    @Size(min=3, max=150)
    private String cuisine;

    public Cuisine(String aCuisine) {
        super();
        this.cuisine = aCuisine;
    }

    public Cuisine() { }

    // Getters and Setters //

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

}
