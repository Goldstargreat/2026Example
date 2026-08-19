package kr.ac.kopo.gnuyog._026example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "찾을 수 없습니다.")
public class UserException extends RuntimeException
    // UserException은 RuntimeException의 자손 클라스. 그래서 throws 선언 없이도 던질 수 있었던 것.
{   // 단축키 alt + insert
    public UserException(String msg)
    {
        super(msg); // 부모(RuntimeException)의 생성자를 호출해서 메시지를 저장.
        System.out.println(msg); // 객체를 new로 만드는 순간 콘솔에 메시지가 찍힌다.
        // throw 되기도 전, 그냥 new UserException(...) 하는 그 순간에 실행.
    }
}
