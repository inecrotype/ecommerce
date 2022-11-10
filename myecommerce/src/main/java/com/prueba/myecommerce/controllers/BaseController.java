package com.prueba.myecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BaseController {
    @GetMapping(value = "/")
    public String index(Model model) {
        String saludo = "Prueba Bitech";
        model.addAttribute("saludo", saludo);
        return "index";
    }
}
