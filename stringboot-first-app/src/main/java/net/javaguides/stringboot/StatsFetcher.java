package net.javaguides.stringboot;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

@Service // Аннотация Spring, отмечающая класс как сервисный компонент
public class StatsFetcher {

    // Клиент HTTP для выполнения сетевых запросов
    private final OkHttpClient client = new OkHttpClient();

    public String getStats() throws Exception {
        // Формирование HTTP-запроса с помощью билдера
        Request request = new Request.Builder()
                .url("https://www.example.com") // Целевой URL (требует замены на реальный)
                .get() // Указание GET-метода
                .addHeader("Requester-ID", "Meow") // Добавление кастомного заголовка
                .build();

        // Выполнение запроса с автоматическим закрытием ресурсов (try-with-resources)
        try (Response response = client.newCall(request).execute()) {
            // Проверка статус-кода ответа (не 2xx = ошибка)
            if (!response.isSuccessful()) {
                throw new Exception("Request failed with code: " + response.code());
            }
            // Обработка тела ответа
            if (response.body() != null) {
                return response.body().string(); // Возврат содержимого как строки
            } else {
                return "Response body is empty"; // Обработка пустого ответа
            }
        }
    }
}
