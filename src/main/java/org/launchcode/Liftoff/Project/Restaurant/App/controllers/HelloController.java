package org.launchcode.Liftoff.Project.Restaurant.App.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping
    @ResponseBody
    public String hello() {
        return "Hello, World!";
    }
    public String helloZach() { return "Hello, World!"; }
}
