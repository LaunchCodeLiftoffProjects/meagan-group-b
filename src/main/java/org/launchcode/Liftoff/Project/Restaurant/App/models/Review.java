package org.launchcode.Liftoff.Project.Restaurant.App.models;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class Review extends AbstractEntity {

    @Size(max=500)
    private String comment;

    public Review(String aComment) {
        this.comment = aComment;
    }

    public Review() { }

    // Getters and Setters //


    public String getComment() { return comment; }

    public void setComment(String comment) { this.comment = comment; }
}
