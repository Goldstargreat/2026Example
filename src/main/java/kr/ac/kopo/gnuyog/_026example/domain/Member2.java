package kr.ac.kopo.gnuyog._026example.domain;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Member2
{
    @MemberId
    private String memberId;

    @Size(min = 4, max =10, message = "비밀번호는 4 ~ 10자 이내의 문자열로 입력해주세요.")
    private String passwd;
}