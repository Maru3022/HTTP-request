package net.javaguides.stringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@Service // Аннотация Spring, указывающая что класс является сервисным компонентом (логика приложения)
@SpringBootApplication // Комбинированная аннотация, включающая:
                       // - @Configuration: класс содержит конфигурацию Spring
                       // - @EnableAutoConfiguration: автоматическая настройка Spring Boot
                       // - @ComponentScan: сканирование компонентов в текущем пакете и его подпакетах
public class StringbootFirstAppApplication {

    // Главный метод, точка входа в приложение
    public static void main(String[] args) {
        // Запускает Spring Boot приложение
        SpringApplication.run(StringbootFirstAppApplication.class, args);
    }
}
