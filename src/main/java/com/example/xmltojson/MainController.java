package com.example.xmltojson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/jsontoxml")
    public String jsontoxml(){
        return "jsontoxml";
    }

    @GetMapping("/xmltojson")
    public String xmltojson(){
        return "xmltojson";
    }

}
