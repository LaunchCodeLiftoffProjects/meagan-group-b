package org.launchcode.Liftoff.Project.Restaurant.App.models;

import java.util.ArrayList;

public class ReviewData {

    public static ArrayList<Review> findByColumnAndValue(String column, String value, Iterable<Review> allReviews) {

        ArrayList<Review> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Review>) allReviews;
        }

        if (column.equals("all")){
            results = findByValue(value, allReviews);
            return results;
        }

        for (Review review : allReviews) {

            String aValue = getFieldValue(review, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(review);
            }
        }

        return results;
    }

    public static String getFieldValue(Review review, String fieldName){

        Restaurant theValue = null;

        if (fieldName.equals("restaurant")) {
            theValue = review.getRestaurant();
        }

        return theValue.getName();
    }

    public static ArrayList<Review> findByValue(String value, Iterable<Review> allReviews) {

        String lower_val = value.toLowerCase();

        ArrayList<Review> results = new ArrayList<>();

        for (Review review : allReviews) {

            if (review.getRestaurant().getName().toLowerCase().contains(lower_val)) {
                results.add(review);
            }

        }

        return results;
    }

}

