package kr.ac.kopo.gnuyog._026example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Ex02Controller {
    @RequestMapping(value = "exam02", method = RequestMethod.GET)
    public String requestMethod(){
        return "<h1>@RestController입니다.</h1>";
    }
}
