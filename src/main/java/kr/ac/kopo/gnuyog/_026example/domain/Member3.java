package kr.ac.kopo.gnuyog._026example.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

// JPA 실습에 사용되는 Member(Member3)
@Entity // 이 클래스는 DB 테이블과 연결된다. 클래스 이름 Member3가 테이블(member3)이 됩니다.
@Data
public class Member3
{
    @Id // 이 필드가 기본키(PK) 라는 뜻이에요.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 기본키 값을 직접 넣지 않고 DB가 자동으로 증가시켜요. IDENTITY는 MySQL의 AUTO_INCREMENT 방식이에요.
    private int id;
    private String name;
    private int age;
    private String email;
    // 각각 테이블의 컬럼이 돼요: id(번호), name(이름), age(나이), email(이메일).
}
