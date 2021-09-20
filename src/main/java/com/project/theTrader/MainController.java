package com.project.theTrader;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    @GetMapping("")
    public String getMainPage(Model model) {
        return "home";
    }

    // Add only views to reference 

    // @GetMapping("/player")
    // public String getPlayerPage() {
    //     return "player";
    // }

    @GetMapping("/crew")
    public String getCrewPage() {
        return "crew";
    }

    @GetMapping("/spacecraft")
    public String getSpacecraftPage() {
        return "spacecraft";
    }
}

