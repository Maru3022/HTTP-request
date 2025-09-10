package net.javaguides.stringboot;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

@Service
public class StatsFetcher {

    private final OkHttpClient client = new OkHttpClient();

    public String getStats() throws Exception {
        Request request = new Request.Builder()
                .url("https://www.example.com") // **ОБЯЗАТЕЛЬНО: ЗАМЕНИТЕ ЭТО НА РЕАЛЬНЫЙ URL!**
                .get()
                .addHeader("Requester-ID", "Meow")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new Exception("Request failed with code: " + response.code());
            }
            if (response.body() != null) {
                return response.body().string();
            } else {
                return "Response body is empty";
            }
        }
    }
}
