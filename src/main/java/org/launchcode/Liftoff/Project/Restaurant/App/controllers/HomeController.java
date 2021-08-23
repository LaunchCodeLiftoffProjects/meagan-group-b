package org.launchcode.Liftoff.Project.Restaurant.App.controllers;

import org.launchcode.Liftoff.Project.Restaurant.App.models.Cuisine;
import org.launchcode.Liftoff.Project.Restaurant.App.models.Restaurant;
import org.launchcode.Liftoff.Project.Restaurant.App.models.data.CuisineRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.models.data.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CuisineRepository cuisineRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "Add Restaurants");
        model.addAttribute("restaurants", restaurantRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddRestaurantForm(Model model) {
        model.addAttribute("title", "Add Restaurant");
        model.addAttribute(new Restaurant());
        model.addAttribute("restaurants", restaurantRepository.findAll());
        model.addAttribute("cuisine", cuisineRepository.findAll());
        return "add";
    }

    @PostMapping("add")
    public String processAddRestaurantForm(@ModelAttribute @Valid Restaurant newRestaurant,
                                    Errors errors, Model model, @RequestParam int restaurantId, @RequestParam String cuisine) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Restaurant");
            return "add";
        }

        Optional optRestaurant = restaurantRepository.findById(restaurantId);
        if (optRestaurant.isPresent()) {
            String restaurant = (String) optRestaurant.get();
            newRestaurant.setRestaurant(restaurant);
        }

        String cuisineObj = (String) cuisineRepository.findAllById(cuisine);
        newRestaurant.setCuisine(cuisineObj);

        restaurantRepository.save(newRestaurant);

        return "redirect:";
    }

    @GetMapping("view/{restaurantId}")
    public String displayViewRestaurant(Model model, @PathVariable int restaurantId)
    {
        Optional optRestaurant = restaurantRepository.findById(restaurantId);
        if (optRestaurant.isPresent()) {
            Restaurant restaurant = (Restaurant) optRestaurant.get();
            model.addAttribute("restaurant", restaurant);
            return "view";
        } else {
            return "redirect:../";
        }
    }

}
