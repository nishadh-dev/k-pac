package com.aurosks.controllers;

import com.aurosks.models.KPac;
import com.aurosks.repository.KPacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class KPacAppController {

    private final KPacRepository kPacRepository;

    @Autowired
    public KPacAppController(KPacRepository kPacRepository) {
        this.kPacRepository = kPacRepository;
    }
    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("redirect:/app/kpacs");
    }

    @GetMapping("/app/kpacs")
    public String kpac() {
        return "kpac";
    }

    @GetMapping("/app/sets")
    public ModelAndView sets() {
        List<KPac> kPacs = kPacRepository.listKPacs();
        return new ModelAndView("set","kPacs",kPacs);
    }

    @GetMapping("/app/set/{id}")
    public ModelAndView setkpac(@PathVariable String id) {
        return new ModelAndView("set_kpac","kpacId",id);
    }
}
