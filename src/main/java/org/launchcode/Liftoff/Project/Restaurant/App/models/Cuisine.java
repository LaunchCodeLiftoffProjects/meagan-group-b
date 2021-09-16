package org.launchcode.Liftoff.Project.Restaurant.App.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cuisine extends AbstractEntity{

    /*    @JoinColumn(name = "cuisine_id")*/
    @OneToMany(mappedBy = "cuisine")
    private List<Restaurant> restaurant = new ArrayList<>();

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

    @Override
    public String toString() {
        return name;
    }
}
