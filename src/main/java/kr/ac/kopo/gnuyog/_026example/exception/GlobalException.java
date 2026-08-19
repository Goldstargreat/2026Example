package kr.ac.kopo.gnuyog._026example.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 전역 예외처리가 필요할 때 사용하는 방법
// 이 클래스는 특정 컨트롤러 하나가 아니라, 여러 컨트롤러에 공통으로 적용되는 전역 예외 처리기라는 뜻.
@ControllerAdvice(basePackages = {"kr.ac.kopo.gnuyog"})
// 적용 범위를 제한하는 옵션. kr.ac.kopo.gnuyog 패키지(및 그 하위 패키지) 안에 있는 컨트롤러에게만 이 처리기가 적용됨.
// (이 옵션이 없으면 프로젝트 전체 모든 컨트롤러에 적용됨)
public class GlobalException
{
    @ExceptionHandler(RuntimeException.class)
    // RuntimeException 및 그를 상속한 모든 하위 클래스를 다 잡아냄.
    // 즉 UserException이 RuntimeException을 상속했다면, 이 핸들러도 UserException을 잡을 수 있음.
    public String handlerException(Exception ex, Model model)
            // 매개변수 타입이 Exception ex로 되어있는데,
    // 이는 단지 조금 더 넓게 잡으려는 선언일 뿐이고 실제로는 RuntimeException(또는 그 하위)만 여기로 들어옴.
    {
        model.addAttribute("data1", "GlobalException 처리 메시지입니다.");
        model.addAttribute("data2", ex);
        return "viewPage11_01";
    }
}
