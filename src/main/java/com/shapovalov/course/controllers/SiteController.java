package com.shapovalov.course.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

@Controller
public class SiteController {
    @GetMapping("/")
    public String getMainPage(Model model) {
        Iterable<Client> guests = clientRepository.findAll();
        model.addAttribute('guests', guests);

        return "system templates/white at start";
    }

}
