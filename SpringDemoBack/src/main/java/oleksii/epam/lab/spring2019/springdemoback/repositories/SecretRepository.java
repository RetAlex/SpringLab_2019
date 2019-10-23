package oleksii.epam.lab.spring2019.springdemoback.repositories;

import oleksii.epam.lab.spring2019.springdemoback.entities.Secret;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecretRepository extends JpaRepository<Secret, String> {
}
