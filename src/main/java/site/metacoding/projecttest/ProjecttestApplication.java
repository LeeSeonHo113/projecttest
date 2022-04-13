package site.metacoding.projecttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ProjecttestApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjecttestApplication.class, args);
	}
}