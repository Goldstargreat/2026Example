package kr.ac.kopo.gnuyog._026example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@Controller
@RequestMapping("/exam13_02")
public class Chap13_02Controller
{
    @GetMapping
    public String showForm()
    {
        return "viewPage13_02form";
    }
    // @RequestBody는 폼의 input 태그의 name과 사용자가 입력된 값을 사용해서
    // 키와 값으로 구성된 json 형식의 Rest 문자열로 만듬
    @PostMapping
    @ResponseBody
    public String submit(@RequestBody HashMap<String, String> map)
    {
//        @PostMapping: /exam13_02로 POST 요청이 오면 이 메서드가 실행됨 (즉, HTML에서 $.ajax로 JSON을 전송했을 때)
//        @ResponseBody: 이 메서드의 반환값을 뷰 이름이 아니라, 응답 본문(body)에 그대로 담아서 클라이언트에게 보낸다는 뜻
//        (여기서는 문자열 그대로 응답)
//        @RequestBody HashMap<String, String> map: 클라이언트가 보낸 JSON 문자열
//        ({"name":"...","age":"...","email":"..."})을 스프링이
//        자동으로 HashMap<String, String> 객체로 변환(역직렬화)해서 map 매개변수에 담아줌.
//        JSON의 key가 Map의 key, JSON의 value가 Map의 value가 됨.
        System.out.println(map);
//        서버 콘솔에 전달받은 Map 내용을 출력합니다. 예: {name=홍길동, age=20, email=a@b.com}
        return "JSON 형식의 데이터 전송 성공";
//        클라이언트(AJAX의 success 콜백)로 이 문자열이 그대로 응답됩니다.
//            HTML 쪽 alert("success!\n" + data + ...)의 data가 바로 이 문자열입니다.
    }
}

