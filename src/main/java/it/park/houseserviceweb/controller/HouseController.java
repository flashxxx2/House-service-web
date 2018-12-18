package it.park.houseserviceweb.controller;

import it.park.houseserviceweb.service.HouseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HouseController {
    private final HouseService service;

    public HouseController(HouseService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("Houses",service.getAll());
        return "index";

    }

    @PostMapping
    public String index(Model model , @RequestParam int id,@RequestParam int price, @RequestParam String district,@RequestParam int area, @RequestParam int rooms ) {
       service.add(id,price,district,area,rooms);
       model.addAttribute("Houses",service.getAll());
        return "index";
    }
}
