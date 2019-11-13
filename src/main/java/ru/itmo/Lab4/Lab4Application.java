package ru.itmo.Lab4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.itmo.Lab4.data.Point;
import ru.itmo.Lab4.repositories.PointRepository;

@SpringBootApplication
@Slf4j
public class Lab4Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab4Application.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(PointRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Point(1, 1, 1, true)));
			log.info("Preloading " + repository.save(new Point(1, 10, 1, false)));
		};
	}

}
