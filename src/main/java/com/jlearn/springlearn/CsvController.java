package com.jlearn.springlearn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CsvController {

    private final CsvService csvService;

    // Constructor injection for CsvService
    public CsvController(CsvService csvService) {
        this.csvService = csvService;
    }

    // Endpoint to read CSV data and return it as JSON (key-value pairs)
    @GetMapping("/read-csv")
    public List<Map<String, String>> readCsv() {
        try {
            return csvService.readCsv();  // Return the CSV data in key-value pairs
        } catch (Exception e) {
            // Handle the exception and return an error message in JSON format
            return List.of(Map.of("Error", e.getMessage()));
        }
    }

    // Endpoint to write data to CSV
    @GetMapping("/write-csv")
    public String writeCsv() {
        try {
            csvService.writeCsv();  // Write data to CSV file
            return "CSV file written successfully!";
        } catch (Exception e) {
            // Handle the error and return a proper message
            return "Error writing CSV file: " + e.getMessage();
        }
    }
}
