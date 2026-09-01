package kr.ac.kopo.gnuyog._026example.controller;

import kr.ac.kopo.gnuyog._026example.domain.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/exam13_05")
public class Chap13_05Controller
{
    @GetMapping
    public List<Person> showJsonTypeData()
    {
        List<Person> personList = new ArrayList<Person>();

        Person person1 = new Person("PolyPark", 20, "Polypark@naver.com");
        Person person2 = new Person("HongGilDong", 25, "hong@naver.com");
        Person person3 = new Person("KimChulSu", 30, "kim@naver.com");

        ArrayList<Person> arrayList = new ArrayList<Person>();
        arrayList.add(person1);
        arrayList.add(person2);
        arrayList.add(person3);
        System.out.println(arrayList);

        return arrayList;
    }
}