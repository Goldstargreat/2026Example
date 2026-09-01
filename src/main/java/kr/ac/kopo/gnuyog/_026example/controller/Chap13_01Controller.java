package kr.ac.kopo.gnuyog._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam13_01")
public class Chap13_01Controller
{
   @GetMapping
   public String showForm()
   {
       return "viewPage13_form";
   }
   // @RequestBody는 폼의 input 태그의 name과 사용자가 입력 된 값을 사용해서
   // 키와 값으로 구성된 json 형식의 Rest 문자열로 만듬
   @PostMapping
    public String submit(@RequestBody String param, Model model)
   {
       model.addAttribute("data1", "@RequestBody로 정보 받기");
       model.addAttribute("data2", param);
       return "viewPage13_result";
   }
}
