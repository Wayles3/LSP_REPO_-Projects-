package org.howard.edu.lsp.assignment2; // Required package structure [cite: 30]

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

    public static void main(String[] args) {
        // Required file paths using relative paths [cite: 12, 19, 8]
        String inputFilePath = "data/products.csv";
        String outputFilePath = "data/transformed_products.csv";

        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        // Use try-with-resources for automatic file closing
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

            // Step 1: Extract - Read and write header [cite: 13, 19]
            String header = br.readLine();
            bw.write("ProductID,Name,Price,Category,PriceRange");
            bw.newLine();

            String line;
            while ((line = br.readLine()) != null) {
                // Skip blank lines [cite: 23]
                if (line.trim().isEmpty()) {
                    rowsRead++; 
                    rowsSkipped++;
                    continue;
                }

                rowsRead++; // Non-header lines encountered [cite: 28]
                
                // Trim whitespace around fields [cite: 21]
                String[] fields = line.split(",");

                // Rule: Row must contain exactly four comma-separated fields [cite: 23]
                if (fields.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                try {
                    String productID = fields[0].trim();
                    String name = fields[1].trim();
                    String priceStr = fields[2].trim();
                    String category = fields[3].trim();
                    String originalCategory = category;

                    // Validate numeric types - Skip if unparseable [cite: 23]
                    Integer.parseInt(productID);
                    double price = Double.parseDouble(priceStr);

                    // --- TRANSFORMATIONS (Apply in exact order) [cite: 14] ---

                    // 1. Convert names to UPPERCASE [cite: 15]
                    name = name.toUpperCase();

                    // 2. 10% discount for Electronics [cite: 15]
                    if (originalCategory.equals("Electronics")) {
                        price *= 0.90;
                    }

                    // Round-half-up to exactly 2 decimal places [cite: 21]
                    BigDecimal bd = BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_UP);
                    double finalPrice = bd.doubleValue();

                    // 3. Premium Electronics Check [cite: 16]
                    // Based on final rounded price > 500 and original category [cite: 21]
                    if (finalPrice > 500.00 && originalCategory.equals("Electronics")) {
                        category = "Premium Electronics";
                    }

                    // 4. Determine PriceRange [cite: 17]
                    String priceRange;
                    if (finalPrice <= 10.00) priceRange = "Low";
                    else if (finalPrice <= 100.00) priceRange = "Medium";
                    else if (finalPrice <= 500.00) priceRange = "High";
                    else priceRange = "Premium";

                    // --- LOAD ---
                    // Write with exactly two decimal places [cite: 21]
                    String formattedPrice = String.format("%.2f", finalPrice);
                    bw.write(productID + "," + name + "," + formattedPrice + "," + category + "," + priceRange);
                    bw.newLine();
                    
                    rowsTransformed++;

                } catch (NumberFormatException e) {
                    // Skip if ProductID or Price cannot be parsed [cite: 23]
                    rowsSkipped++;
                }
            }

            // Run Summary [cite: 28]
            System.out.println("Number of rows read: " + rowsRead);
            System.out.println("Number of rows transformed: " + rowsTransformed);
            System.out.println("Number of rows skipped: " + rowsSkipped);
            System.out.println("Output file path: " + outputFilePath);

        } catch (FileNotFoundException e) {
            // Case C: Missing input file handling [cite: 25, 46]
            System.out.println("Error: Missing input file (data/products.csv)");
        } catch (IOException e) {
            System.out.println("An error occurred during processing: " + e.getMessage());
        }
    }
}