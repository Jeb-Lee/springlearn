package com.jlearn.springlearn;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CsvService {

    // Method to read data from a CSV file and return it as a list of maps (key-value pairs)
    public List<Map<String, String>> readCsv() throws Exception {
        List<Map<String, String>> result = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("data.csv"))) {
            List<String[]> rows = reader.readAll();

            // First row is the header
            String[] headers = rows.get(0);

            // Process the rest of the rows
            for (int i = 1; i < rows.size(); i++) {
                String[] row = rows.get(i);
                Map<String, String> rowMap = new HashMap<>();
                for (int j = 0; j < headers.length; j++) {
                    rowMap.put(headers[j], row[j]);
                }
                result.add(rowMap);
            }
        }
        return result;  // Return the list of maps (JSON-like structure)
    }

    // Method to write data to a CSV file
    public void writeCsv() throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter("output.csv"))) {
            // Write header row
            String[] header = {"Name", "Age", "Sex"};
            writer.writeNext(header);

            // Write some example rows (you can modify this to accept dynamic data)
            String[] row1 = {"Alice", "30", "Female"};
            writer.writeNext(row1);

            String[] row2 = {"Bob", "25", "Male"};
            writer.writeNext(row2);

            System.out.println("Data written to CSV file.");
        }
    }
}
