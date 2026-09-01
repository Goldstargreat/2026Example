package kr.ac.kopo.gnuyog._026example.controller;

import kr.ac.kopo.gnuyog._026example.domain.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam13_04")
public class Chap13_04Controller
{
    @GetMapping
    public Person showJsonType()
    {
        Person person = new Person();
        person.setName("PolyPark");
        person.setAge(30);
        person.setEmail("polykim@kopo.ac.kr");
        System.out.println(person);
        return person;
    }
}


