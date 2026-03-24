package kr.ac.kopo.gnuyog._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ex06_01Controller {
    @GetMapping("/exam06_1")
    public String requestMethod(Model model){
        model.addAttribute("title1", "Model 유형 연습1");
        model.addAttribute("title2", "문자열 값 또는 객체 참조값 전달 가능");
        return "view06_1";
    }
}
