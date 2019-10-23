package oleksii.epam.lab.spring2019.springdemofront.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/*
    Для коректної роботи необхідно було імплементувати інший інтерфейс (Не Validator, а ConstraintValidator)
    та використовувати @Constraint(validatedBy = OnlyLettersValidator.class) замість @Verified.
    Окрім того треба щоб аннотація мала відповідні поля (
        String message() default "Invalid secret";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    ), message мусить містити опис помилки якщо isValid в ConstraintValidator-а поверне false.
    Message може бути ключем який буде використаний для інтернаціоналізації (i18n)
 */
public class OnlyLettersValidator implements ConstraintValidator<OnlyLetters, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
