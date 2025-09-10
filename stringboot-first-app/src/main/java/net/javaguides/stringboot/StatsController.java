package net.javaguides.stringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Аннотация, объявляющая класс REST-контроллером. Все методы возвращают данные в формате JSON/XML
public class StatsController {

    private final StatsFetcher statsFetcher;

    @Autowired // Внедрение зависимости через конструктор (рекомендуемый способ в Spring)
    public StatsController(StatsFetcher statsFetcher) {
        this.statsFetcher = statsFetcher;
    }

    @GetMapping("/stats") // Обрабатывает GET-запросы по эндпоинту /stats
    public ResponseEntity<String> getStatsEndpoint() {
        try {
            String stats = statsFetcher.getStats(); // Получение статистики через сервис
            return ResponseEntity.ok(stats); // Возврат успешного ответа с кодом 200
        } catch (Exception e) {
            // В случае ошибки возвращаем статус 500 и текст ошибки
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
