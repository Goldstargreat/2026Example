package kr.ac.kopo.gnuyog._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex08Controller {

    @GetMapping("/exam08")
    public ModelAndView requestMethod() {

        // ModelAndView 객체 생성
        ModelAndView modelView = new ModelAndView();

        // 데이터 저장
        modelView.addObject("title1", "ModelAndView 연습");
        modelView.addObject("title2",
                "ModelAndView는 addObject()와 setViewName()를 사용");

        // 이동할 뷰 페이지 지정
        modelView.setViewName("viewPage");

        // ModelAndView 객체 반환
        return modelView;
    }
}