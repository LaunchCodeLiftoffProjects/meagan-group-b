package org.launchcode.Liftoff.Project.Restaurant.App.controllers;

import org.launchcode.Liftoff.Project.Restaurant.App.models.Restaurant;
import org.launchcode.Liftoff.Project.Restaurant.App.models.RestaurantData;
import org.launchcode.Liftoff.Project.Restaurant.App.models.data.CuisineRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.models.data.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CuisineRepository cuisineRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {

        columnChoices.put("all", "All");
        columnChoices.put("restaurants", "Restaurant");
        columnChoices.put("cuisine", "Cuisine");

    }

    @RequestMapping("")
    public String list(Model model) {

        model.addAttribute("restaurants", restaurantRepository.findAll());
        model.addAttribute("cuisine", cuisineRepository.findAll());
        return "list";
    }

    @RequestMapping(value = "jobs")
    public String listRestaurantsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Restaurant> restaurant;
        if (column.toLowerCase().equals("all")){
            restaurant = restaurantRepository.findAll();
            model.addAttribute("title", "All Restaurants");
        } else {
            restaurant = RestaurantData.findByColumnAndValue(column, value, restaurantRepository.findAll());
            model.addAttribute("title", "Restaurants with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("restaurants", restaurant);

        return "list-restaurants";
    }
}
