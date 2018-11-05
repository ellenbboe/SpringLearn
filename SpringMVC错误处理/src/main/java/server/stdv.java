package server;

import beans.student;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class stdv implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return student.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "name", "required.name","Field name is required.");
    }
    }

