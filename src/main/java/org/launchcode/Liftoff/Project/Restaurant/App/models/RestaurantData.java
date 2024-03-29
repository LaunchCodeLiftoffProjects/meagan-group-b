package org.launchcode.Liftoff.Project.Restaurant.App.models;

import java.util.ArrayList;

public class RestaurantData {

    public static ArrayList<Restaurant> findByColumnAndValue(String column, String value, Iterable<Restaurant> allRestaurants) {

        ArrayList<Restaurant> results = new ArrayList<>();

        if (value.equalsIgnoreCase("all")){
            return (ArrayList<Restaurant>) allRestaurants;
        }

        if (column.equals("all")){
            results = findByValue(value, allRestaurants);
            return results;
        }
        for (Restaurant restaurant : allRestaurants) {

            String aValue = getFieldValue(restaurant, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(restaurant);
            }
        }

        return results;
    }

    public static String getFieldValue(Restaurant restaurant, String fieldName){

        String theValue;

        if (fieldName.equals("name")) {
            theValue = restaurant.getName();
        } else if (fieldName.equals("cuisine")){
            theValue = restaurant.getCuisine().getName();
        } else if(fieldName.equals("city")){
            theValue = restaurant.getCity();
        } else if(fieldName.equals("state")){
            theValue = restaurant.getState();
        } else {
            theValue = restaurant.getZipcode();
        }

        return theValue;
    }

    public static ArrayList<Restaurant> findByValue(String value, Iterable<Restaurant> allRestaurants) {

        String lower_val = value.toLowerCase();

        ArrayList<Restaurant> results = new ArrayList<>();

        for (Restaurant restaurant : allRestaurants) {

            if (restaurant.getName().toLowerCase().contains(lower_val)) {
                results.add(restaurant);
            } else if (restaurant.getAddress().toLowerCase().contains(lower_val)) {
                results.add(restaurant);
            } else if (restaurant.getCity().toLowerCase().contains(lower_val)) {
                results.add(restaurant);
            } else if (restaurant.getCuisine().getName().toLowerCase().contains(lower_val)) {
                results.add(restaurant);
            } else if (restaurant.getState().toLowerCase().contains(lower_val)) {
                results.add(restaurant);
            }

        }

        return results;
    }
}
