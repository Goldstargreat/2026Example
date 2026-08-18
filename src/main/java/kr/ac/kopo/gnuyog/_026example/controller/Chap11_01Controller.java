package kr.ac.kopo.gnuyog._026example.controller;

import kr.ac.kopo.gnuyog._026example.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/exam11_01")
public class Chap11_01Controller
{
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "URI 요청이 잘못되었습니다.")
    @GetMapping("/exam01")
    public void requestMethod01()
    {
        System.out.println(new IllegalArgumentException("요청에 실패했습니다.").getMessage());
    }

    @GetMapping("/exam02")
    public void requestMethod02() throws Exception
    {
        throw new Exception(new UserException("UserException 메시지입니다."));
    }

    @GetMapping("/exam03")
    public void requestMethod03()
    {
        throw new UserException("UserException @ExceptionHandler 예제 메시지입니다.");
    }

    @ExceptionHandler(UserException.class)
    public String handlerException(UserException ex, Model model)
    {
        model.addAttribute("data1", ex.getMessage());
        model.addAttribute("data2", ex);
        return "viewPage11_01";
    }

    @GetMapping("/exam04")
    public void requestMethod04()
    {
        throw new UserException("UserException @ControllerAdvice 예제 메시지입니다. ");
    }
}