package org.launchcode.Liftoff.Project.Restaurant.App.controllers;

//import org.launchcode.Liftoff.Project.Restaurant.App.data.CuisineRepository;
//import org.launchcode.Liftoff.Project.Restaurant.App.data.RestaurantRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.data.CuisineRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.data.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping(value ="list")
public class ListController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CuisineRepository cuisineRepository;

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("view all","View All");
        model.addAttribute("cuisine",cuisineRepository.findAll());

        return "list";
    }
}
