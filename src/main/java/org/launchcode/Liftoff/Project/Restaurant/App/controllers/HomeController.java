package org.launchcode.Liftoff.Project.Restaurant.App.controllers;

import org.launchcode.Liftoff.Project.Restaurant.App.data.CuisineRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.data.RestaurantRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.data.ReviewRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.models.Restaurant;
import org.launchcode.Liftoff.Project.Restaurant.App.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CuisineRepository cuisineRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @RequestMapping("")
    public String displayHomePage() {
        return "HomePage";
    }

    @GetMapping("view/{restaurantId}")
    public String displayViewRestaurant(Model model, @PathVariable int restaurantId) {

        Optional optRestaurant = restaurantRepository.findById(restaurantId);
        if (optRestaurant.isPresent()) {
            Restaurant restaurant = (Restaurant) optRestaurant.get();
            model.addAttribute("restaurant", restaurant);

            return "view";
        } else {
            return "redirect:../";
        }
    }

    @GetMapping("view-review/{reviewId}")
    public String displayViewReview(Model model, @PathVariable int reviewId) {

        Optional optReview = reviewRepository.findById(reviewId);
        if (optReview.isPresent()) {
            Review review = (Review) optReview.get();
            model.addAttribute("review", review);
            return "view-review";
        } else {
            return "redirect:../";
        }
    }

}
