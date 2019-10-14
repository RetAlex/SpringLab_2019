package oleksii.epam.lab.spring2019.core.validation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ObjectToValidate {
    private int notNegativeNumber;
    private String notEmptyString;
}
