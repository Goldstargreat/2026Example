package kr.ac.kopo.gnuyog._026example.domain;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MemberIDValidator.class)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MemberId
{
    String message() default "중복된 메시지입니다.";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
