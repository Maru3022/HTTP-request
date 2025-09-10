package net.javaguides.stringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatsController {

    private final StatsFetcher statsFetcher;

    @Autowired
    public StatsController(StatsFetcher statsFetcher) {
        this.statsFetcher = statsFetcher;
    }

    @GetMapping("/stats")
    public ResponseEntity<String> getStatsEndpoint() {
        try {
            String stats = statsFetcher.getStats();
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
