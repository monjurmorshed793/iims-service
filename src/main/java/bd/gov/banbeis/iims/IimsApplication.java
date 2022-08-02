package bd.gov.banbeis.iims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class IimsApplication {

	public static void main(String[] args) {
		SpringApplication.run(IimsApplication.class, args);
	}

}
