package org.launchcode.Liftoff.Project.Restaurant.App.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Cuisine {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=150)
    private String name;

    public Cuisine(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Cuisine() { }

    // Getters and Setters //

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Validation//
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuisine cuisine = (Cuisine) o;
        return id == cuisine.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
