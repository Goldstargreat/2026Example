package kr.ac.kopo.gnuyog._026example.domain;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MemberIDValidator implements ConstraintValidator<MemberId, String>
{
    @Override
    public void initialize(MemberId constraintAnnotaion)
    {
        ConstraintValidator.super.initialize(constraintAnnotaion);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext)
    {
        if(s.equals("admin"))
        {
            return false;
        }
        return true;
    }
}



