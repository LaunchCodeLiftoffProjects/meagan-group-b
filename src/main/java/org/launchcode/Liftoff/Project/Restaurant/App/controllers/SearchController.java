package org.launchcode.Liftoff.Project.Restaurant.App.controllers;

import org.launchcode.Liftoff.Project.Restaurant.App.data.RestaurantRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.models.Restaurant;
import org.launchcode.Liftoff.Project.Restaurant.App.models.RestaurantData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import static org.launchcode.Liftoff.Project.Restaurant.App.controllers.ListController.columnChoices;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Restaurant> restaurants;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            restaurants = restaurantRepository.findAll();
        } else {
            restaurants = RestaurantData.findByColumnAndValue(searchType, searchTerm, restaurantRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Restaurants with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("restaurants", restaurants);

        return "search";
    }
}
