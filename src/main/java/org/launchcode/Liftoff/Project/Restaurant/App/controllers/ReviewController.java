package org.launchcode.Liftoff.Project.Restaurant.App.controllers;

import org.launchcode.Liftoff.Project.Restaurant.App.data.CuisineRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.data.ReviewRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.models.Cuisine;
import org.launchcode.Liftoff.Project.Restaurant.App.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("review")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Add Review");
        model.addAttribute("review", reviewRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddReviewForm(Model model) {
        model.addAttribute("title", "Add Review");
        model.addAttribute(new Review());
        return "add-review";
    }

    @PostMapping("add")
    public String processAddReviewForm(@ModelAttribute @Valid Review newReview,
                                        Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cuisine");
            return "add-review";
        }

        reviewRepository.save(newReview);

        return "redirect:";
    }

    @GetMapping("view-review/{cuisineId}")
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