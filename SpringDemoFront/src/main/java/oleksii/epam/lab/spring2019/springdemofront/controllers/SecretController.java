package oleksii.epam.lab.spring2019.springdemofront.controllers;

import oleksii.epam.lab.spring2019.springdemofront.dto.Secret;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class SecretController {
    @Value("${demoFront.url.back}")
    private String backPrefix;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/secret")
    public String renderSecretPage(){
        RestTemplate restTemplate = new RestTemplateBuilder()
                .defaultHeader("special-header", "special-value")
                .build();
        var answer = restTemplate.getForEntity(backPrefix+"/secret", Secret.class);
        assert answer.getBody()!=null;
        System.out.println("Answer got: "+answer.getBody().getSecret());
        return "secret";
    }
}
