package org.howard.edu.lsp.assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Handles reading product data from a CSV file.
 */
public class CSVReader {
    /**
     * Reads products from the specified path.
     * @param filePath The relative path to the input file.
     * @return A list of Product objects.
     */
    public List<Product> read(String filePath) {
        List<Product> products = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            if (scanner.hasNextLine()) scanner.nextLine(); // Skip header
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                
                if (parts.length == 4) {
                    try {
                        String id = parts[0];
                        String name = parts[1];
                        // This is where the error was happening
                        double price = Double.parseDouble(parts[2].trim()); 
                        String category = parts[3];
                        
                        products.add(new Product(id, name, price, category));
                    } catch (NumberFormatException e) {
                        // Log the error and skip this row instead of crashing
                        System.err.println("Skipping invalid row (bad price): " + line);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Input file not found at " + filePath);
        }
        return products;
    }
}