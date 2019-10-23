package oleksii.epam.lab.spring2019.springdemoback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Secret {
    private String secret;

    public Secret() {
    }
}
