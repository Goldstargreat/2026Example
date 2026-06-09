package kr.ac.kopo.gnuyog._026example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class Chap10_01Controller
{
    @GetMapping("/exam10_01/exam01")
    public String requestMethod(Model model)
    {
        return "viewPage10_01";
    }

    @GetMapping("/exam10_01/admin/main")
    public String requestMethod2(Model model)
    {
        model.addAttribute("viewName", "adminPage.html");
        return "adminPage";
    }

    @GetMapping("/exam10_01/manager/main")
    public String requestMethod3(Model model)
    {
        model.addAttribute("viewName", "managerPage.html");
        return "managerPage";
    }

    @GetMapping("/exam10_01/member/main")
    public String requestMethod4(Model model)
    {
        model.addAttribute("viewName", "memberPage.html");
        return "memberPage";
    }

    @GetMapping("/home/main")
    public String requestMethod5(Model model)
    {
        model.addAttribute("viewName", "home.html");
        return "homePage";
    }

    @GetMapping("/exam02")
    public String requestMethod6(Model model)
    {
        return "redirect:/member/user";
    }

    @GetMapping("/member/user")
    public String requestMethod7(Authentication authentication, Model model)
    {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String userName = userDetails.getUsername();
        String password = userDetails.getPassword();

        model.addAttribute("username", userName);
        model.addAttribute("password", password);
        model.addAttribute("uri", "/member/user");
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        for(GrantedAuthority item : authorities)
        {
            model.addAttribute("role", item + " ");
        }
        return "memberPage";
    }
}