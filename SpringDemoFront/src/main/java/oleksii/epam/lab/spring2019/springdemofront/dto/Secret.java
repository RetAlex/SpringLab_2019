package oleksii.epam.lab.spring2019.springdemofront.dto;

import lombok.Data;
import oleksii.epam.lab.spring2019.springdemofront.validator.OnlyLetters;

@Data
public class Secret {
    private String username;
    @OnlyLetters
    private String secret;

    public Secret() {
    }

    public Secret(String username, String secret) {
        this.username = username;
        this.secret = secret;
    }
}
