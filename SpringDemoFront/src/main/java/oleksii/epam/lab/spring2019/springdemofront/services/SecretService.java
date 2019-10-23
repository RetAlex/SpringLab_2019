package oleksii.epam.lab.spring2019.springdemofront.services;

import oleksii.epam.lab.spring2019.springdemofront.dto.Secret;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SecretService {
    @Value("${demoFront.url.back}")
    private String backPrefix;
    public Secret getSecret(String username){
        RestTemplate restTemplate = new RestTemplateBuilder()
                .defaultHeader("username", username)
                .build();
        try {
            var answer = restTemplate.getForEntity(backPrefix + "/secret", Secret.class);
            return answer.getBody();
        } catch (Exception e){

        }
        return new Secret();
    }

    public Secret sendSecret(Secret secret){
        RestTemplate restTemplate = new RestTemplate();
        var answer = restTemplate.postForEntity(backPrefix+"/secret", secret, Secret.class);
        return answer.getBody();
    }
}
