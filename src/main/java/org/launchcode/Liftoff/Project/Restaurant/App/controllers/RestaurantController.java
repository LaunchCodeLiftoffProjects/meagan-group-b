package org.launchcode.Liftoff.Project.Restaurant.App.controllers;

import org.launchcode.Liftoff.Project.Restaurant.App.data.CuisineRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.data.RestaurantRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.data.ReviewRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.models.Cuisine;
import org.launchcode.Liftoff.Project.Restaurant.App.models.Restaurant;
import org.launchcode.Liftoff.Project.Restaurant.App.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CuisineRepository cuisineRepository;

    @Autowired
    private ReviewRepository reviewRepository;


    @GetMapping("")
    public String displayAddRestaurantForm(Model model) {
        model.addAttribute("title", "Add Restaurant");
        model.addAttribute(new Restaurant());
        model.addAttribute("cuisines", cuisineRepository.findAll());
        return "add-restaurant";
    }

    @PostMapping("")
    public String processAddRestaurantForm(@ModelAttribute @Valid Restaurant newRestaurant,
                                           Errors errors, Model model, @RequestParam int cuisineId) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Restaurant");
            model.addAttribute("cuisines", cuisineRepository.findAll());
            return "add-restaurant";
        }

        Optional optCuisine = cuisineRepository.findById(cuisineId);
        if (optCuisine.isPresent()) {
            Cuisine cuisine = (Cuisine) optCuisine.get();
            newRestaurant.setCuisine(cuisine);
        }


        restaurantRepository.save(newRestaurant);

        return "redirect:";
    }

}
