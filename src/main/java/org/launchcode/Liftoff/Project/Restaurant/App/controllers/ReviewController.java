package org.launchcode.Liftoff.Project.Restaurant.App.controllers;

import org.launchcode.Liftoff.Project.Restaurant.App.data.CuisineRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.data.RestaurantRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.data.ReviewRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Optional;

@Controller
@RequestMapping("review")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;


    @GetMapping("")
    public String displayAddReviewForm(Model model) {
        model.addAttribute("title", "Add Review");
        model.addAttribute(new Review());
        model.addAttribute("restaurants", restaurantRepository.findAll());
        return "add-review";
    }

    @PostMapping("")
    public String processAddReviewForm(@ModelAttribute @Valid Review newReview,
                                        Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Review");
            model.addAttribute("restaurants", restaurantRepository.findAll());
            return "add-review";
        }

        reviewRepository.save(newReview);

        return "redirect:";
    }

    @RequestMapping("reviews")
    public String listReviewsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {

        Iterable<Review> reviews = reviewRepository.findAll();
        if (column.toLowerCase().equals("all")) {
            model.addAttribute("title", "All Reviews");
            model.addAttribute("reviews", reviews);
        } else {
            reviews = ReviewData.findByColumnAndValue(column, value, reviewRepository.findAll());
            model.addAttribute("title", "Reviews for " + value);

        }

        model.addAttribute("reviews", reviews);
        return "view-reviews";
    }

}
