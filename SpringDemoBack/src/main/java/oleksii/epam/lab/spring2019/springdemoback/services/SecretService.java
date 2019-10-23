package oleksii.epam.lab.spring2019.springdemoback.services;

import oleksii.epam.lab.spring2019.springdemoback.entities.Secret;
import oleksii.epam.lab.spring2019.springdemoback.repositories.SecretRepository;
import org.springframework.stereotype.Service;

@Service
public class SecretService {
    private final SecretRepository secretRepository;

    public SecretService(SecretRepository secretRepository) {
        this.secretRepository = secretRepository;
    }

    public Secret saveSecret(Secret secret){
        return secretRepository.save(secret);
    }

    public Secret getSecret(String username){
        var one = secretRepository.findById(username);
        if (one.isEmpty()) throw new NotFounSecretException();
        return one.get();
    }
}
