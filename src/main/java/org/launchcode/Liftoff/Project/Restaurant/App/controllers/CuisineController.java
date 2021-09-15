package org.launchcode.Liftoff.Project.Restaurant.App.controllers;

import org.launchcode.Liftoff.Project.Restaurant.App.data.CuisineRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.models.Cuisine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("cuisine")
public class CuisineController {

    @Autowired
    private CuisineRepository cuisineRepository;

    @GetMapping("")

    public String displayAddCuisineForm(Model model) {
        model.addAttribute("title", "Add Cuisine");
        model.addAttribute(new Cuisine());
        return "add-cuisine";
    }

    @PostMapping("")
    public String processAddCuisineForm(@ModelAttribute @Valid Cuisine newCuisine,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cuisine");
            return "add-cuisine";
        }

        cuisineRepository.save(newCuisine);

        return "redirect:";
    }

    @GetMapping("view/{cuisineId}")
    public String displayViewCuisine(Model model, @PathVariable int cuisineId) {

        Optional optCuisine = cuisineRepository.findById(cuisineId);
        if (optCuisine.isPresent()) {
            Cuisine cuisine = (Cuisine) optCuisine.get();
            model.addAttribute("cuisine", cuisine);
            return "view-cuisine";
        } else {
            return "redirect:../";
        }
    }
}
