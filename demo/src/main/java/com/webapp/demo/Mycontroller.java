package com.webapp.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class Mycontroller {
    @GetMapping("")
    String home() {
        return "home";
    }
    @GetMapping("about")
    String aboutUs() {
        return "aboutUs";
    }
    @GetMapping("contact")
    String contact() {
        return "contact";
    }


}

