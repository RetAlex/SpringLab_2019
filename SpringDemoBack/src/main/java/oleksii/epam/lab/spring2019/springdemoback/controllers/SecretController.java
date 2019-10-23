package oleksii.epam.lab.spring2019.springdemoback.controllers;

import oleksii.epam.lab.spring2019.springdemoback.dto.Secret;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecretController {
    @GetMapping("/secret")
    public Secret getSecret(){
        return new Secret("secret");
    }

}
