package oleksii.epam.lab.spring2019.springdemoback.controllers;

import oleksii.epam.lab.spring2019.springdemoback.entities.Secret;
import oleksii.epam.lab.spring2019.springdemoback.services.SecretService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SecretController {
    private final SecretService secretService;

    public SecretController(SecretService secretService) {
        this.secretService = secretService;
    }

    @GetMapping("/secret")
    public Secret getSecret(@RequestHeader(value = "username", required = false) String username, HttpServletRequest request){

        Secret secret = secretService.getSecret(username);
        return secret;
    }

    @PostMapping("/secret")
    public Secret saveSecret(@RequestBody Secret secret){
        return secretService.saveSecret(secret);
    }
}
