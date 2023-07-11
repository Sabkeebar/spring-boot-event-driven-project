package springbootproject.basedomainservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication

@EnableJpaRepositories
public class BasedomainServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BasedomainServiceApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

	}
}
