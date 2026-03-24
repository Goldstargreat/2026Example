package kr.ac.kopo.gnuyog._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex08Controller {
    @GetMapping("/exam08")
    public ModelAndView requestMethod(){
        ModelAndView modeView = new ModelAndView();
        modeView.addObject("title1", "ModelAndView 연습");
        modeView.addObject("title2", "ModelAndView는 addObject()와 setViewName()를 사용");
        modeView.setViewName("view06_1");
        return modeView;
    }
}
