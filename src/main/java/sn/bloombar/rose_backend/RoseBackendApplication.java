package sn.bloombar.rose_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("sn.bloombar.rose_backend.repository")
public class RoseBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoseBackendApplication.class, args);
	}

}
