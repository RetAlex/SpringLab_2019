package oleksii.epam.lab.spring2019.springdemofront.configs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "oleksii.epam.lab.spring2019.springdemofront.*")
public class SpringDemoFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoFrontApplication.class, args);
	}

}
