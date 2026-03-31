package kr.ac.kopo.gnuyog._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Calendar;

@Controller
public class Chap05_02Controller {
    @GetMapping("/chap05_02/{name}/{birthyear}")
    public String requestMethod(@PathVariable("name") String name, @PathVariable("birthyear") int birthyear, Model model) {
        Calendar calendar = Calendar.getInstance();
        int nowYear = calendar.get(Calendar.YEAR);
        int age = nowYear - birthyear;

        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "viewPage05_02";
    }
}
