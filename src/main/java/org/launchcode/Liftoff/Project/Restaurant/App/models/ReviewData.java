package org.launchcode.Liftoff.Project.Restaurant.App.models;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

public class ReviewData {

//    public static ArrayList<Review> findByColumnAndValue(String column, String value, Iterable<Review> allReviews) {
//
//        ArrayList<Review> results = new ArrayList<>();
//
//        if (value.toLowerCase().equals("all")){
//            return (ArrayList<Review>) allReviews;
//        }
//
//        if (column.equals("all")){
//            results = findByValue(value, allReviews);
//            return results;
//        }
//        for (Review review : allReviews) {
//
//            String aValue = getFieldValue(review, column);
//
//            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
//                results.add(review);
//            }
//        }
//
//        return results;
//    }
//
//    public static String getFieldValue(Restaurant restaurant, String fieldName){
//
//        String theValue;
//
//        if (fieldName.equals("name")) {
//            theValue = restaurant.getName();
//        } else if (fieldName.equals("cuisine")){
//            theValue = restaurant.getCuisine().getName();
//        } else if(fieldName.equals("city")){
//            theValue = restaurant.getCity();
//        } else if(fieldName.equals("state")){
//            theValue = restaurant.getState();
//        } else {
//            theValue = restaurant.getZipcode();
//        }
//
//        return theValue;
//    }

//    public static ArrayList<Review> findReviews(@RequestParam int restaurantId, Iterable<Review> allReviews) {
//
//        ArrayList<Review> results = new ArrayList<>();
//
//        for (Review review : allReviews) {
//
//            if (review.getRestaurant().equals(restaurantId)) {
//                results.add(review);
//            }
//        }
//    }

}

