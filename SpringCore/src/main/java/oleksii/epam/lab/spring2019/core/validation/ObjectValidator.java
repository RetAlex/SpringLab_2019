package oleksii.epam.lab.spring2019.core.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ObjectValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(ObjectToValidate.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(!supports(target.getClass())) throw new RuntimeException("Invalid class was passed to validator");
        ObjectToValidate objectToValidate = (ObjectToValidate) target;
        if(objectToValidate.getNotEmptyString() == null || objectToValidate.getNotEmptyString().isEmpty()) errors.rejectValue("notEmptyString", "not.empty.string.is.empty");
        if(objectToValidate.getNotNegativeNumber()<0) errors.rejectValue("notNegativeNumber", "not.negative.number.is.negative");
    }
}
