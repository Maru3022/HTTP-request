package net.javaguides.stringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@Service
@SpringBootApplication // Добавлено для указания, что это Spring Boot Application
public class StringbootFirstAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(StringbootFirstAppApplication.class, args);
    }
}
