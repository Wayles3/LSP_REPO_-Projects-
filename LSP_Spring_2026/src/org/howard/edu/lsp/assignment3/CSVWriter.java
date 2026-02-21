package org.howard.edu.lsp.assignment3;

import java.io.File; // This was the missing import
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Handles writing product data to a CSV file.
 */
public class CSVWriter {
    /**
     * Writes the list of products to the specified path.
     * @param products The list of transformed products.
     * @param filePath The relative path for the output file.
     */
    public void write(List<Product> products, String filePath) {
        if (products == null) return;

        try (PrintWriter writer = new PrintWriter(new File(filePath))) {
            writer.println("ProductID,Name,Price,Category"); // Header
            for (Product p : products) {
                writer.printf("%s,%s,%.2f,%s%n", 
                              p.getId(), p.getName(), p.getPrice(), p.getCategory());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Could not write to " + filePath);
        }
    }
}