package com.aurosks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class KPacAppController {

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("redirect:/app/kpacs");
    }

    @GetMapping("/app/kpacs")
    public String kpac() {
        return "kpac";
    }

    @GetMapping("/app/sets")
    public String sets() {
        return "set";
    }

    @GetMapping("/app/set/{id}")
    public String setkpac(@PathVariable String id) {
        return "set_kpac";
    }
}
