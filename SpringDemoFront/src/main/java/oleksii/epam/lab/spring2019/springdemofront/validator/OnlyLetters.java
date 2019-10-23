package oleksii.epam.lab.spring2019.springdemofront.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = OnlyLettersValidator.class)
public @interface OnlyLetters {
    String message() default "{secret.invalid}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
