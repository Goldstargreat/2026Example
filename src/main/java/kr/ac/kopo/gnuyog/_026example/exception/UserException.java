package kr.ac.kopo.gnuyog._026example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "찾을 수 없습니다.")
public class UserException extends RuntimeException
{   // 단축키 alt + insert
    public UserException(String msg)
    {
        super(msg);
        System.out.println(msg);
    }
}
