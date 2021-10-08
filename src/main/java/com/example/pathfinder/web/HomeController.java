package com.example.pathfinder.web;

import com.example.pathfinder.service.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final PictureService pictureService;

    public HomeController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping("/")
    public String getIndexPage(Model model){
        model.addAttribute("pics", pictureService.findAllPics());
        return "index";
    }

    @GetMapping("/about")
    public String getAboutPage(){
        return "about";
    }
}
