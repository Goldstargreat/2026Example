package kr.ac.kopo.gnuyog._026example.controller;

import kr.ac.kopo.gnuyog._026example.domain.Member3;
import kr.ac.kopo.gnuyog._026example.repository.Member3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// JPA 첫번째 예제
@Controller
// "이 클래스는 웹 요청을 처리하는 컨트롤러"라는 뜻이에요. 메서드가 반환하는 문자열은 화면(뷰) 이름으로 해석돼요.
@RequestMapping("/exam14_01")
// 이 컨트롤러의 모든 주소는 /exam14_01로 시작해요.
public class Chap14_01Controller
{
    @Autowired
    Member3Repository repository;
    // @Autowired는 스프링이 만들어둔 Member3Repository 구현체를 자동으로 넣어달라는 뜻이에요(의존성 주입).
    // 그래서 new로 직접 만들지 않아도 repository를 바로 쓸 수 있어요.

    // 메서드 ① 목록 화면: GET /exam14_01
    @GetMapping
    // 경로를 안 적었으니 클래스의 기본 주소 /exam14_01로 GET 요청이 오면 실행돼요.
    public String viewHomePage(Model model)
    // Model은 컨트롤러에서 화면으로 데이터를 넘기는 가방 역할이에요.
    {
        Iterable<Member3> memberList = repository.findAll();
        // member3 테이블의 모든 행을 조회해서 Member3 객체들의 묶음으로 받아요.
        model.addAttribute("memberList", memberList);
        return "viewPage02";
    }
    // 메서드 ② 입력 폼 화면: GET /exam14_01/new
    @GetMapping("/new")
    public String newInputMember3(Model model)
    {
        Member3 member3 = new Member3();
        // /exam14_01/new로 접속하면 실행돼요. 비어있는 Member3 객체를 하나 만들어요.
        model.addAttribute("member", member3);
        return "viewPage02_new";
    }
    // 메서드 ③ 저장 처리: POST /exam14_01/insert
    @PostMapping("/insert")
    public String insertMember3(@ModelAttribute("member") Member3 member3)
    {
        repository.save(member3);
        return "redirect:/exam14_01";
    }
}
