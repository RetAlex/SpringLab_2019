package oleksii.epam.lab.spring2019.springdemoback.configs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "oleksii.epam.lab.spring2019.springdemoback.*")
public class SpringDemoBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoBackApplication.class, args);
	}

}
