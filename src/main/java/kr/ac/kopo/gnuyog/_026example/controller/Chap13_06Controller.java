package kr.ac.kopo.gnuyog._026example.controller;

import kr.ac.kopo.gnuyog._026example.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
// 이 클래스가 스프링 MVC의 컨트롤러임을 선언합니다. 요청을 받아서 뷰(View, 여기서는 HTML)를 반환하는 역할을 합니다.
@RequestMapping("/exam13_06")
// → 이 컨트롤러의 모든 메서드가 공통으로 /exam13_06 경로 아래에서 동작하도록 기본 URL을 설정합니다.
public class Chap13_06Controller
{
   @GetMapping
   public String showForm(@ModelAttribute Person person)
   {
       return "viewPage13_06form";
   }
   // @GetMapping → /exam13_06으로 GET 요청이 오면 이 메서드가 실행됩니다.
    //@ModelAttribute Person person → 빈 Person 객체를 자동 생성해서 모델에 담아줍니다(폼 초기 화면용, 보통 값은 비어있음).
    //return "viewPage13_06form"; → viewPage13_06form.html(입력 폼 화면)을 뷰로 반환합니다.
    //즉, 이 메서드는 처음 폼 화면을 보여주는 역할입니다.
   // @RequestBody는 폼의 input 태그의 name과 사용자가 입력된 값을 사용해서
   // 키와 값으로 구성된 json 형식의 Rest 문자열로 만듬
   @PutMapping
   // @PutMapping → PUT 요청 처리 (주로 데이터 전체 수정/업데이트)
    public String submit(@ModelAttribute Person person, Model model)
   {
       //@PutMapping → /exam13_06으로 PUT 요청이 오면 실행됩니다.
       // (HTML 폼은 기본적으로 GET/POST만 지원하므로, 폼에서 hidden 필드로 _method=put을 보내고
       // 스프링의 HiddenHttpMethodFilter가 이를 PUT으로 변환해줘야 동작합니다.)
      // @ModelAttribute Person person → 폼에서 입력한 name, age, email 값이 자동으로
       // Person 객체의 필드에 바인딩됩니다(setter 이용).
      // Model model → 뷰(HTML)에 전달할 데이터를 담는 객체.
       model.addAttribute("data1", "@PutMapping 적용하기");
       // → "data1"이라는 이름(키)으로, "@PutMapping 적용하기"라는 문자열 값을 모델에 담습니다.
       model.addAttribute("data2", person);
       // → "data2"라는 이름(키)으로, 사용자가 폼에 입력한 값이 담긴 person 객체를 모델에 담습니다.
       return "viewPage13_06result";
   }
}
