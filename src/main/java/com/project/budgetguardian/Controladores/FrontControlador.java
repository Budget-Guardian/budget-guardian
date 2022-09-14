package com.project.budgetguardian.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontControlador {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
