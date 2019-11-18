package ru.itmo.Lab4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.itmo.Lab4.model.Point;
import ru.itmo.Lab4.repositories.PointRepository;

@SpringBootApplication
@Slf4j
public class Lab4Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab4Application.class, args);
	}

}
