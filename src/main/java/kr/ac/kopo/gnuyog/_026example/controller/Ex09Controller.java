package kr.ac.kopo.gnuyog._026example.controller;

import kr.ac.kopo.gnuyog._026example.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ex09Controller {
    @GetMapping("/member")
    public String requestForm() {
        return "SignUp";
    }

    @PostMapping("/member")
    public String requestFormResult(Member member, Model model) {
        model.addAttribute("member", member);
        return "SignUpResult";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
//        binder.setAllowedFields("id", "city", "sex");
        binder.setDisallowedFields("passwd", "city");
    }
}