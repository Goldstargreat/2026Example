package kr.ac.kopo.gnuyog._026example.domain;

import lombok.Data;

@Data
public class Person
{
    private String name;
    private int age;
    private String email;

    public Person()
    {

    } // 일단 비어있는 객체 생성

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    } // 만들면서 값 저장
}
