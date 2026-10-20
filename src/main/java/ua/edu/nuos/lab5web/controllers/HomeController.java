package ua.edu.nuos.lab5web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

    @GetMapping("/")
    public String home() {
        return "redirect:/company";
    }
}
