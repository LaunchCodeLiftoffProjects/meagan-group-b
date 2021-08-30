package org.launchcode.Liftoff.Project.Restaurant.App.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cuisine extends AbstractEntity{


    @NotNull
    @Size(min=3, max=150)
    private String name;

    public Cuisine(String aName) {
        super();
        this.name = aName;
    }

    public Cuisine() { }

    // Getters and Setters //

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
