package org.launchcode.Liftoff.Project.Restaurant.App.controllers;

import org.launchcode.Liftoff.Project.Restaurant.App.data.CuisineRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.data.RestaurantRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.models.Restaurant;
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

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Add Restaurant");
        return "index";
    }

    @GetMapping("add")
    public String displayAddRestaurantForm(Model model) {
        model.addAttribute("title", "Add Restaurant");
        model.addAttribute(new Restaurant());
        model.addAttribute("cuisine", cuisineRepository.findAll());
        return "add-restaurant";
    }

    @PostMapping("add")
    public String processAddRestaurantForm(@ModelAttribute @Valid Restaurant newRestaurant,
                                           Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "add-restaurant";
        }

        restaurantRepository.save(newRestaurant);

        return "redirect:";
    }

    @GetMapping("view-restaurant/{restaurantId}")
    public String displayViewRestaurant(Model model, @PathVariable int restaurantId) {

        Optional optRestaurant = restaurantRepository.findById(restaurantId);
        if (optRestaurant.isPresent()) {
            Restaurant restaurant = (Restaurant) optRestaurant.get();
            model.addAttribute("restaurant", restaurant);
            return "view-restaurant";
        } else {
            return "redirect:../";
        }
    }
}
