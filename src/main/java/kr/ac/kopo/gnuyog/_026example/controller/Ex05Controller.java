package kr.ac.kopo.gnuyog._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/home")

public class Ex05Controller {
    @GetMapping("/exam05")
    public String requestMapping(){
        return "view05";
    }
}
