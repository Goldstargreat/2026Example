package kr.ac.kopo.gnuyog._026example.domain;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator
{
    @Override
    public boolean supports(Class<?> clazz)
    {
          return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        Person person = (Person) target;
        String name = person.getName();
        int age = person.getAge();
        String email = person.getEmail();

        if (name == null || name.trim().isEmpty())
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "이름을 입력하세요.");
        if (age <= 0)
            errors.rejectValue("age", null, "나이를 입력하세요.");
        if (email == null || email.trim().isEmpty())
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", null, "이메일을 입력하세요.");
    }
}