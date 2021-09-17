package org.launchcode.Liftoff.Project.Restaurant.App.controllers;

import org.launchcode.Liftoff.Project.Restaurant.App.data.CuisineRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.data.RestaurantRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.models.Restaurant;
import org.launchcode.Liftoff.Project.Restaurant.App.models.RestaurantData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping("list")
public class ListController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CuisineRepository cuisineRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {

        columnChoices.put("all", "All");
        columnChoices.put("city", "City");
        columnChoices.put("state", "State");
        columnChoices.put("zipcode", "Zipcode");

    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("view all","View All");
        model.addAttribute("restaurants",restaurantRepository.findAll());
        model.addAttribute("cuisines", cuisineRepository.findAll());

        return "list";
    }

    @RequestMapping("restaurants")
    public String listRestaurantsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Restaurant> restaurants = null;
        if (column.toLowerCase().equals("all")) {
            restaurants = restaurantRepository.findAll();
            model.addAttribute("title","All Restaurants");
        } else if (column.toLowerCase().equals("cuisine")) {
            restaurants = RestaurantData.findByColumnAndValue(column, value, restaurantRepository.findAll());
            model.addAttribute("title", "Restaurants with " + value + " cuisine" );
        }

        model.addAttribute("restaurants", restaurants);
        return "list-restaurants";
    }





}
