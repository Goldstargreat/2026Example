package kr.ac.kopo.gnuyog._026example.controller;

import kr.ac.kopo.gnuyog._026example.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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
        // 반환 타입이 void이고 @ResponseStatus가 붙어있으니,
        // "이 메서드가 정상적으로 끝나면 무조건 지정된 상태코드로 응답해라"라는 규칙을 적용함
    }

    @GetMapping("/exam02")
    public void requestMethod02() throws Exception // 이 메서드가 예외를 밖으로 던질 수 있다고 선언
    {
        throw new Exception(new UserException("UserException 메시지입니다."));
        // Exception의 생성자 중 Exception(Throwable cause)를 사용. 즉 UserException을 원인(cause)으로 감싼 새로운 Exception을 만들어서 던짐.
        // Exception(Throwable cause) 생성자는 내부적으로 message = cause.toString()으로 설정하기 때문에,
        // 이 Exception의 메시지는 UserException의 toString() 결과가 됨.
    }

    @GetMapping("/exam03")
    public void requestMethod03()  // 이번엔 UserException을 직접(감싸지 않고) 던짐.
    {
        throw new UserException("UserException @ExceptionHandler 예제 메시지입니다.");
    }

//    @ExceptionHandler(UserException.class)
//    public String handlerException(UserException ex, Model model)
    // 매개변수로 실제 잡힌 예외 객체(ex)와 Model을 받음.
//    {
//        model.addAttribute("data1", ex.getMessage());
//        model.addAttribute("data2", ex.toString);
//        return "viewPage11_01";
//    }

    @GetMapping("/exam04")
    public void requestMethod04()
    {
        throw new UserException("UserException @ControllerAdvice 예제 메시지입니다. ");
    }
}