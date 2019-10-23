package oleksii.epam.lab.spring2019.springdemoback._configs;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "oleksii.epam.lab.spring2019.springdemoback.*")
@EnableJpaRepositories(basePackages = "oleksii.epam.lab.spring2019.springdemoback.*")
public class DatabaseConfig {
}
